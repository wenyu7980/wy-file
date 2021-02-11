package com.wenyu7980.file.service;

import com.wenyu7980.file.entity.FileEntity;

/**
 *
 * @author wenyu
 */
public interface FileService {
    /**
     * 保存
     * @param fileEntity
     * @return
     */
    FileEntity save(FileEntity fileEntity);

    /**
     * 查询
     * @param id
     * @return
     */
    FileEntity findById(String id);
}
