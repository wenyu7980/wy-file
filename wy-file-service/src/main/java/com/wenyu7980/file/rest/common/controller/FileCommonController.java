package com.wenyu7980.file.rest.common.controller;

import com.wenyu7980.file.domain.FileDomain;
import com.wenyu7980.file.rest.common.domain.FileUploadUrl;
import com.wenyu7980.file.rest.common.handler.FileCommonHandler;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author wenyu
 */
@Api(tags = "文件管理（通用）")
@RestController
@RequestMapping("common/files")
public class FileCommonController {
    @Autowired
    private FileCommonHandler fileCommonHandler;

    @ApiOperation("上传文件")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileDomain upload(
      @ApiParam("是否公开") @RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @ApiParam("bucket名称") @RequestParam(required = false) String bucketName, @RequestParam("file") MultipartFile file)
      throws IOException {
        return fileCommonHandler.upload(bucketName, file.getOriginalFilename(), file.getInputStream(), publicFlag);
    }

    @ApiOperation("下载文件")
    @GetMapping("{id}")
    public void download(@PathVariable("id") String id, HttpServletResponse response) throws IOException {
        fileCommonHandler.download(id, response);
    }

    @ApiOperation("上传url")
    @GetMapping("upload")
    public FileUploadUrl getUploadUrl(
      @ApiParam("是否公开") @RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @ApiParam("bucket名称") @RequestParam(required = false) String bucketName,
      @ApiParam("文件名") @RequestParam String filename) {
        return fileCommonHandler.getUploadUrl(bucketName, filename, publicFlag);
    }
}
