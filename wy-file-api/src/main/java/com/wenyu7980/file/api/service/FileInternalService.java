package com.wenyu7980.file.api.service;

import com.wenyu7980.file.api.domain.FileInternal;
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
    /**
     * 上传文件
     * @param publicFlag
     * @param bucketName
     * @param file
     * @return
     */
    @PostMapping(value = "files")
    FileInternal upload(@RequestParam(name = "publicFlag", defaultValue = "false") boolean publicFlag,
      @RequestParam(required = false) String bucketName, @RequestParam("file") MultipartFile file);

    /**
     * 校验权限
     * @param id
     * @return
     */
    @GetMapping("{id}/auth")
    boolean check(@PathVariable String id);
}
