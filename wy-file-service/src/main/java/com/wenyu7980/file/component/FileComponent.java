package com.wenyu7980.file.component;

import com.wenyu7980.file.domain.FileDomain;

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
}
