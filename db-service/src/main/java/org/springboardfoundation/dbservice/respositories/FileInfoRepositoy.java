package org.springboardfoundation.dbservice.respositories;

import org.springboardfoundation.dbservice.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepositoy extends JpaRepository<FileInfo, Long> {
}