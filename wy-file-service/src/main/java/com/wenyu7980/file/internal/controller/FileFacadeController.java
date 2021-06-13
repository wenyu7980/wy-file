package com.wenyu7980.file.internal.controller;

import com.wenyu7980.authentication.context.model.ContextUtils;
import com.wenyu7980.common.exceptions.code500.SystemException;
import com.wenyu7980.file.api.domain.File;
import com.wenyu7980.file.api.service.FileFacade;
import com.wenyu7980.file.internal.handler.FileFacadeHandler;
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
@RequestMapping("files")
public class FileFacadeController implements FileFacade {
    @Autowired
    private FileFacadeHandler fileFacadeHandler;

    @Override
    @PostMapping()
    public File upload(@ApiParam("是否公开") @RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @ApiParam("bucket名称") @RequestParam(required = false) String bucketName,
      @RequestParam("file") MultipartFile file) {
        try {
            return fileFacadeHandler
              .upload(bucketName, file.getOriginalFilename(), publicFlag, file.getInputStream());
        } catch (IOException exception) {
            throw new SystemException("文件上传系统异常");
        }
    }

    @Override
    @GetMapping("{id}/auth")
    public boolean check(String id) {
        return fileFacadeHandler.check(id, ContextUtils.userId());
    }
}
