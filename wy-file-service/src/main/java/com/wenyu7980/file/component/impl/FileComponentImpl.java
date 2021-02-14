package com.wenyu7980.file.component.impl;

import com.wenyu7980.common.authentication.util.AuthenticationUtils;
import com.wenyu7980.common.exceptions.code400.code401.InsufficientException;
import com.wenyu7980.file.FileThirdDownloadService;
import com.wenyu7980.file.FileThirdUploadService;
import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.entity.FileEntity;
import com.wenyu7980.file.property.FileProperty;
import com.wenyu7980.file.rest.common.domain.FileUploadUrl;
import com.wenyu7980.file.service.FileCheckService;
import com.wenyu7980.file.service.FileService;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author wenyu
 */
@Component
public class FileComponentImpl implements FileComponent {
    @Autowired
    private FileProperty fileProperty;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileThirdUploadService fileThirdUploadService;
    @Autowired
    private FileThirdDownloadService fileThirdDownloadService;
    @Autowired
    private FileCheckService fileCheckService;

    @Override
    public FileDomain upload(String bucketName, String filename, InputStream inputStream, boolean publicFlag) {
        FileDomain fileDomain = new FileDomain();
        if (!fileProperty.getCandidateBuckets().contains(bucketName)) {
            bucketName = this.fileProperty.getDefaultBucket();
        }
        FileEntity entity = fileService.save(new FileEntity(filename, bucketName, publicFlag));
        fileThirdUploadService.putObject(bucketName, entity.getId(), inputStream);
        fileCheckService.register(entity.getId(), AuthenticationUtils.userId(), this.fileProperty.getPutTimeout());
        String path = fileThirdDownloadService
          .getDownloadPresignedUrl(bucketName, entity.getId(), this.fileProperty.getPutTimeout());
        fileDomain.setId(entity.getId());
        fileDomain.setFileName(filename);
        fileDomain.setPath(path);
        return fileDomain;
    }

    @Override
    public void download(String id, HttpServletResponse response) throws IOException {
        FileEntity entity = fileService.findById(id);
        if (!fileCheckService.check(id, AuthenticationUtils.userId())) {
            throw new InsufficientException("文件权限不足");
        }
        IOUtils.copy(fileThirdDownloadService.getObject(entity.getBucketName(), id), response.getOutputStream());
    }

    @Override
    public FileUploadUrl getUploadUrl(String bucketName, String filename, boolean publicFlag) {
        if (!fileProperty.getCandidateBuckets().contains(bucketName)) {
            bucketName = this.fileProperty.getDefaultBucket();
        }
        FileEntity entity = fileService
          .save(new FileEntity(bucketName, filename, publicFlag, this.fileProperty.getPutTimeout()));
        fileCheckService.register(entity.getId(), AuthenticationUtils.userId(), this.fileProperty.getPutTimeout());
        FileUploadUrl url = new FileUploadUrl();
        url.setId(entity.getId());
        url.setPath(
          fileThirdUploadService.getUploadPresignedUrl(bucketName, entity.getId(), this.fileProperty.getPutTimeout()));
        return url;
    }

    @Override
    public FileDomain getFileDomain(String id) {
        FileEntity entity = fileService.findById(id);
        fileCheckService.register(entity.getId(), AuthenticationUtils.userId(), this.fileProperty.getGetTimeout());
        FileDomain domain = new FileDomain();
        domain.setPath(fileThirdDownloadService
          .getDownloadPresignedUrl(entity.getBucketName(), entity.getId(), this.fileProperty.getGetTimeout()));
        domain.setFileName(entity.getFilename());
        domain.setId(entity.getId());
        return domain;
    }
}
