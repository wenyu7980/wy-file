package com.wenyu7980.file.component;

import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.rest.common.domain.FileUploadUrl;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;

/**
 *
 * @author wenyu
 */
public interface FileComponent {
    /**
     * 文件名
     *
     * @param bucketName
     * @param filename
     * @param inputStream
     * @param publicFlag
     * @return
     */
    FileDomain upload(String bucketName, String filename, InputStream inputStream, boolean publicFlag);

    /**
     * 下载
     * @param id
     * @param response
     */
    void download(String id, HttpServletResponse response) throws IOException;

    /**
     * 获取上传url
     * @return
     * @param bucketName
     * @param filename
     * @param publicFlag
     */
    FileUploadUrl getUploadUrl(String bucketName, String filename, boolean publicFlag);
}
