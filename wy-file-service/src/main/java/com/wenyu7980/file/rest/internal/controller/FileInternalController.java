package com.wenyu7980.file.rest.internal.controller;

import com.wenyu7980.common.exceptions.code500.SystemException;
import com.wenyu7980.file.api.FileInternalService;
import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.rest.internal.handler.FileInternalHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 *
 * @author wenyu
 */
@Api(tags = "文件管理（内部）")
@RestController
@RequestMapping("internal/files")
public class FileInternalController implements FileInternalService {
    @Autowired
    private FileInternalHandler fileInternalHandler;

    @Override
    @PostMapping(value = "files")
    public FileDomain upload(
      @ApiParam("是否公开") @RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @ApiParam("bucket名称") @RequestParam(required = false) String bucketName,
      @RequestParam("file") MultipartFile file) {
        try {
            return fileInternalHandler
              .upload(bucketName, file.getOriginalFilename(), publicFlag, file.getInputStream());
        } catch (IOException exception) {
            throw new SystemException("文件上传系统异常");
        }
    }

    @Override
    public FileDomain getFile(String id) {
        return fileInternalHandler.getFileDomain(id);
    }
}
