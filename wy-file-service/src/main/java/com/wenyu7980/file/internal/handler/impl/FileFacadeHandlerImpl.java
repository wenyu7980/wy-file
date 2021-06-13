package com.wenyu7980.file.internal.handler.impl;

import com.wenyu7980.file.api.domain.File;
import com.wenyu7980.file.component.FileComponent;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.internal.handler.FileFacadeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
@Component
public class FileFacadeHandlerImpl implements FileFacadeHandler {
    @Autowired
    private FileComponent fileComponent;

    @Override
    public File upload(String bucketName, String originalFilename, boolean publicFlag,
      InputStream inputStream) {
        FileDomain fileDomain = fileComponent.upload(bucketName, originalFilename, inputStream, publicFlag);
        File internal = new File();
        internal.setFileName(fileDomain.getFileName());
        internal.setId(fileDomain.getId());
        return internal;
    }

    @Override
    public boolean check(String id, String userId) {
        return fileComponent.check(id, userId);
    }
}
