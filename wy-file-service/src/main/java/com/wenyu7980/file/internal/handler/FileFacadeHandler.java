package com.wenyu7980.file.internal.handler;

import com.wenyu7980.file.api.domain.File;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileFacadeHandler {
    /**
     *
     * @param bucketName
     * @param originalFilename
     * @param publicFlag
     * @param inputStream
     * @return
     */
    File upload(String bucketName, String originalFilename, boolean publicFlag, InputStream inputStream);

    /**
     * 检查
     * @param id
     * @param userId
     * @return
     */
    boolean check(String id, String userId);
}
