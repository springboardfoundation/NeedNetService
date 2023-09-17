package org.springboardfoundation.common.dto.file;

import java.net.URI;
import java.util.Date;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileInfoDto {
    private String assetId;
    private String title;
    private String name;
    private URI url;
    private String originalFileName;
    private String contentType;
    private String size;
    private Date createdDate;
    private Date lastModifiedDate;
    private UploadStatus status;
}