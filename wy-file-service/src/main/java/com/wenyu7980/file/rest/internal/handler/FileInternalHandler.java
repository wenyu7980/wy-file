package com.wenyu7980.file.rest.internal.handler;

import com.wenyu7980.file.domain.FileDomain;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileInternalHandler {
    /**
     *
     * @param bucketName
     * @param originalFilename
     * @param publicFlag
     * @param inputStream
     * @return
     */
    FileDomain upload(String bucketName, String originalFilename, boolean publicFlag, InputStream inputStream);

    /**
     * 获取
     * @param id
     * @return
     */
    FileDomain getFile(String id);
}
