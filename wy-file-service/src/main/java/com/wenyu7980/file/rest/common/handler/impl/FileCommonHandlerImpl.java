package com.wenyu7980.file.rest.common.handler.impl;

import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.api.domain.FileInternal;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.rest.common.domain.FileUploadUrl;
import com.wenyu7980.file.rest.common.handler.FileCommonHandler;
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
    public FileDomain upload(String bucketName, String originalFilename, InputStream inputStream, boolean publicFlag) {
        return fileComponent.upload(bucketName, originalFilename, inputStream, publicFlag);
    }

    @Override
    public void download(String id, HttpServletResponse response) throws IOException {
        fileComponent.download(id, response);
    }

    @Override
    public FileUploadUrl getUploadUrl(String bucketName, String filename, boolean publicFlag) {
        return fileComponent.getUploadUrl(bucketName, filename, publicFlag);
    }
}
