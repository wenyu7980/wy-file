package com.wenyu7980.file.rest.internal.handler.impl;

import com.wenyu7980.file.api.domain.FileInternal;
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
    public FileInternal upload(String bucketName, String originalFilename, boolean publicFlag,
      InputStream inputStream) {
        FileDomain fileDomain = fileComponent.upload(bucketName, originalFilename, inputStream, publicFlag);
        FileInternal internal = new FileInternal();
        internal.setFileName(fileDomain.getFileName());
        internal.setId(fileDomain.getId());
        return internal;
    }

    @Override
    public boolean check(String id, String userId) {
        return fileComponent.check(id, userId);
    }
}
