package com.wenyu7980.file;

import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileThirdDownloadService {
    /**
     * 流式下载
     * @param bucketName
     * @param objectName
     * @return
     */
    InputStream getObject(String bucketName, String objectName);

    /**
     * 获取下载预签名地址
     * @param bucketName
     * @param objectName
     * @param timeout 秒，最大1天
     * @return
     */
    String getDownloadPresignedUrl(String bucketName, String objectName, long timeout);
}
