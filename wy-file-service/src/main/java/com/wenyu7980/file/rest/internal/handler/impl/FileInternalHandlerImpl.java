package com.wenyu7980.file.rest.internal.handler.impl;

import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.rest.internal.handler.FileInternalHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
@Component
public class FileInternalHandlerImpl implements FileInternalHandler {
    @Autowired
    private FileComponent fileComponent;

    @Override
    public FileDomain upload(String bucketName, String originalFilename, boolean publicFlag, InputStream inputStream) {
        return fileComponent.upload(bucketName, originalFilename, inputStream, publicFlag);
    }

    @Override
    public FileDomain getFile(String id) {
        return fileComponent.getFileDomain(id);
    }
}
