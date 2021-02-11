package com.wenyu7980.file;

/**
 *
 * @author wenyu
 */
public interface FileThirdEventCallback {
    /**
     * 上传成功
     * @param bucketName
     * @param objectName
     */
    void putObject(String bucketName, String objectName);
}
