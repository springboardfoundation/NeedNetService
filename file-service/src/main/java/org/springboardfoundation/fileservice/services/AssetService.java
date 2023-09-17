package org.springboardfoundation.fileservice.services;


import org.springboardfoundation.common.dto.file.FileInfoDto;
import org.springframework.web.multipart.MultipartFile;

public interface AssetService {

    FileInfoDto upload(String needId, MultipartFile multipartFile, String assetId);

    FileInfoDto download(String assetId);

    FileInfoDto fetchAssetInfo(String assetId);
    
}