package org.springboardfoundation.dbservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springboardfoundation.common.dto.file.UploadStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "fileinfo")
@EntityListeners(AuditingEntityListener.class)
public class FileInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Version
    private long version;

    @Column(unique = true)
    private String assetId;
    @Column
    private String title;
    @Column
    private String name;
    @Column
    private String location;
    @Column
    private String url;
    @Column
    private String originalFileName;
    @Column
    private String contentType;
    @Column
    private long fileSize;
    @Column
    private long ttl;
    @Column
    private boolean hasExpired;
    @Column
    private UploadStatus status;

    @CreatedDate
    @Builder.Default
    private Date createdDate = new Date();
    @LastModifiedDate
    @Builder.Default
    private Date lastModifiedDate = new Date();
}