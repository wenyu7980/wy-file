package com.wenyu7980.file.repository;

import com.wenyu7980.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 *
 * @author wenyu
 */
@Repository
public interface FileRepo extends JpaRepository<FileEntity, String> {
    /**
     * 获取pending
     * @param pending
     * @param dateTime
     * @return
     */
    List<FileEntity> findByPendingFlagAndPendingDeadlineGreaterThan(boolean pending, LocalDateTime dateTime);
}
