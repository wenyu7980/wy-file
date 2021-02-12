package com.wenyu7980.file.api;

import com.wenyu7980.file.domain.FileDomain;
import io.swagger.annotations.ApiParam;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-file", path = "internal", contextId = "wy-file")
public interface FileInternalService {
    @PostMapping(value = "files")
    FileDomain upload(@ApiParam("是否公开") @RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @ApiParam("bucket名称") @RequestParam(required = false) String bucketName,
      @RequestParam("file") MultipartFile file);

    @GetMapping("files/{id}")
    FileDomain getFile(@PathVariable("id") String id);
}
