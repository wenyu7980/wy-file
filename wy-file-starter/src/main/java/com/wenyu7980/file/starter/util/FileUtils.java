package com.wenyu7980.file.starter.util;

import com.wenyu7980.file.api.domain.File;
import com.wenyu7980.file.api.service.FileFacade;
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
    private static FileFacade fileFacade;

    @Autowired
    private FileUtils(FileFacade fileFacade) {
        FileUtils.fileFacade = fileFacade;
    }

    public static boolean checkFileId(String id) {
        return fileFacade.check(id);
    }

    public static File upload(String fileName, InputStream inputStream) {
        return upload(fileName, inputStream, null, false);
    }

    public static File upload(String fileName, InputStream inputStream, boolean publicFlag) {
        return upload(fileName, inputStream, null, publicFlag);
    }

    public static File upload(String fileName, InputStream inputStream, String bucketName) {
        return upload(fileName, inputStream, bucketName, false);
    }

    public static File upload(String fileName, InputStream inputStream, String bucketName, boolean publicFlag) {
        FileItemFactory factory = new DiskFileItemFactory();
        FileItem item = factory.createItem("file", MediaType.ALL_VALUE, true, fileName);
        try (OutputStream os = item.getOutputStream()) {
            IOUtils.copy(inputStream, os);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid file: " + e, e);
        }
        return fileFacade.upload(publicFlag, bucketName, new CommonsMultipartFile(item));
    }
}
