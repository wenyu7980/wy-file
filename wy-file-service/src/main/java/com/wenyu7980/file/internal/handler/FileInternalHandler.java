package com.wenyu7980.file.internal.handler;

import com.wenyu7980.file.api.domain.FileInternal;

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
    FileInternal upload(String bucketName, String originalFilename, boolean publicFlag, InputStream inputStream);

    /**
     * 检查
     * @param id
     * @param userId
     * @return
     */
    boolean check(String id, String userId);
}
