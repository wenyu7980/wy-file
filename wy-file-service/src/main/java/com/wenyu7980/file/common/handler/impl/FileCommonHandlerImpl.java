package com.wenyu7980.file.common.handler.impl;

import com.wenyu7980.file.common.domain.FileUploadUrl;
import com.wenyu7980.file.common.handler.FileCommonHandler;
import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.domain.FileDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author wenyu
 */
@Component
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = RuntimeException.class)
public class FileCommonHandlerImpl implements FileCommonHandler {
    @Autowired
    private FileComponent fileComponent;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public FileDomain upload(String bucketName, String originalFilename, InputStream inputStream, boolean publicFlag) {
        return fileComponent.upload(bucketName, originalFilename, inputStream, publicFlag);
    }

    @Override
    public void download(String id, HttpServletResponse response) throws IOException {
        fileComponent.download(id, response);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public FileUploadUrl getUploadUrl(String bucketName, boolean publicFlag) {
        return fileComponent.getUploadUrl(bucketName, publicFlag);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public FileDomain name(String id, String filename) {
        return fileComponent.name(id, filename);
    }
}
