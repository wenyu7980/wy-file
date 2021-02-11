package com.wenyu7980.file.repository;

import com.wenyu7980.file.entity.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author wenyu
 */
@Repository
public interface FileRepo extends JpaRepository<FileEntity, String> {
}
