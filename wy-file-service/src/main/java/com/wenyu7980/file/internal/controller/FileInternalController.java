package com.wenyu7980.file.internal.controller;

import com.wenyu7980.authentication.context.model.ContextUtils;
import com.wenyu7980.common.exceptions.code500.SystemException;
import com.wenyu7980.file.api.domain.FileInternal;
import com.wenyu7980.file.api.service.FileInternalService;
import com.wenyu7980.file.internal.handler.FileInternalHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@Api(tags = "文件管理（内部）")
@RestController
@RequestMapping("internal/files")
public class FileInternalController implements FileInternalService {
    @Autowired
    private FileInternalHandler fileInternalHandler;

    @Override
    @PostMapping(value = "files")
    public FileInternal upload(
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
    @GetMapping("{id}/auth")
    public boolean check(String id) {
        return fileInternalHandler.check(id, ContextUtils.userId());
    }
}
