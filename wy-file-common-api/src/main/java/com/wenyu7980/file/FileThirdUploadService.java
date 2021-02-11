package com.wenyu7980.file;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileThirdUploadService {
    /**
     * 流式上传
     * @param bucketName
     * @param objectName
     * @param inputStream
     */
    void putObject(String bucketName, String objectName, InputStream inputStream);

    /**
     * 获取上传预签名地址
     * @param bucketName
     * @param objectName
     * @param timeout 秒，最大1天
     * @return
     */
    String getUploadPresignedUrl(String bucketName, String objectName, long timeout);
}
