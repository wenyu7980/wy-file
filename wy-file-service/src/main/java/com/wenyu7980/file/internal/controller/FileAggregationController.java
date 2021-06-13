package com.wenyu7980.file.internal.controller;

import com.wenyu7980.aggregation.annotation.AggregationMethod;
import com.wenyu7980.file.aggregation.FileAggregation;
import com.wenyu7980.file.internal.handler.FileAggregationHandler;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@Api(tags = "文件管理（内部）")
@RestController
@RequestMapping("aggregation/files")
public class FileAggregationController {
    @Autowired
    private FileAggregationHandler fileAggregationHandler;

    @GetMapping("{id}")
    @AggregationMethod
    public FileAggregation getFile(@PathVariable("id") String id) {
        return fileAggregationHandler.getFile(id);
    }
}
