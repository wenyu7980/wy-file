package com.wenyu7980.file.api;

import org.springframework.cloud.openfeign.FeignClient;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-file", path = "internal", contextId = "wy-file")
public interface FileInternalService {
}
