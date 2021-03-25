package com.wenyu7980.file.common.handler;

import com.wenyu7980.file.common.domain.FileUploadUrl;
import com.wenyu7980.file.domain.FileDomain;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileCommonHandler {
    /**
     * 文件上传
     *
     * @param bucketName
     * @param originalFilename
     * @param inputStream
     * @param publicFlag
     * @return
     */
    FileDomain upload(String bucketName, String originalFilename, InputStream inputStream, boolean publicFlag);

    /**
     * 下载
     * @param id
     * @param response
     * @exception IOException 文件上传异常
     */
    void download(String id, HttpServletResponse response) throws IOException;

    /**
     * 获取上传地址
     * @return
     * @param bucketName
     * @param publicFlag
     */
    FileUploadUrl getUploadUrl(String bucketName, boolean publicFlag);

    /**
     * 文件名
     * @param id
     * @param filename
     * @return
     */
    FileDomain name(String id, String filename);
}
