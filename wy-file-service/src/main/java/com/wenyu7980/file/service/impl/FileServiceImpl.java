package com.wenyu7980.file.service.impl;

import com.wenyu7980.common.exceptions.code404.NotFoundException;
import com.wenyu7980.file.entity.FileEntity;
import com.wenyu7980.file.repository.FileRepo;
import com.wenyu7980.file.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author wenyu
 */
@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileRepo fileRepo;

    @Override
    public FileEntity save(FileEntity fileEntity) {
        return fileRepo.save(fileEntity);
    }

    @Override
    public FileEntity findById(String id) {
        return fileRepo.findById(id).orElseThrow(() -> new NotFoundException("文件{0}不存在", id));
    }

    @Override
    public List<FileEntity> findByPending(LocalDateTime dateTime) {
        return fileRepo.findByPendingFlagAndPendingDeadlineGreaterThan(true, dateTime);
    }
}
