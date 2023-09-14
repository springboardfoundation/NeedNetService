package org.springbordfoundation.db.respositories;

import org.springbordfoundation.db.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepositoy extends JpaRepository<FileInfo, Long> {
}