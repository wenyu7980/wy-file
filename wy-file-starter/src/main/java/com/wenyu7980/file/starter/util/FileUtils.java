package com.wenyu7980.file.starter.util;

import com.wenyu7980.file.api.domain.FileInternal;
import com.wenyu7980.file.api.service.FileInternalService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author wenyu
 */
@Component
public class FileUtils {
    private static FileInternalService fileInternalService;

    @Autowired
    private FileUtils(FileInternalService fileInternalService) {
        FileUtils.fileInternalService = fileInternalService;
    }

    public static boolean checkFileId(String id) {
        return fileInternalService.check(id);
    }

    public static FileInternal upload(String fileName, InputStream inputStream) {
        return upload(fileName, inputStream, null, false);
    }

    public static FileInternal upload(String fileName, InputStream inputStream, boolean publicFlag) {
        return upload(fileName, inputStream, null, publicFlag);
    }

    public static FileInternal upload(String fileName, InputStream inputStream, String bucketName) {
        return upload(fileName, inputStream, bucketName, false);
    }

    public static FileInternal upload(String fileName, InputStream inputStream, String bucketName, boolean publicFlag) {
        FileItemFactory factory = new DiskFileItemFactory();
        FileItem item = factory.createItem("file", MediaType.ALL_VALUE, true, fileName);
        try (OutputStream os = item.getOutputStream()) {
            IOUtils.copy(inputStream, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        return fileInternalService.upload(publicFlag, bucketName, new CommonsMultipartFile(item));
    }
}
