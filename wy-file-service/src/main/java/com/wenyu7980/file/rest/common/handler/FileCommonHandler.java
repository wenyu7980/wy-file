package com.wenyu7980.file.rest.common.handler;

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
     * @exception IOException
     */
    void download(String id, HttpServletResponse response) throws IOException;
}
