package org.springboardfoundation.fileservice.services;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.file.FileInfoDto;
import org.springboardfoundation.common.utiliy.UriHelperUtils;
import org.springboardfoundation.common.utiliy.Utility;
import org.springboardfoundation.fileservice.configuration.AssetProperties;
import org.springboardfoundation.fileservice.mapper.FileInfoMapper;
import org.springbordfoundation.db.entity.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class AssetServiceImpl implements AssetService {

    // private final FileInfoRepositoy fileRepo;
    private final AssetProperties configuration;
    private final FilesStorageService storageService;

    @Override
    public FileInfoDto upload(String needId, MultipartFile multipartFile, String assetId) {
	FileInfoMapper fileInfoMapper = FileInfoMapper.MAPPER;
	assetId = StringUtils.hasLength(assetId) ? assetId : Utility.generateUUID();
	// FileInfo fileInfo = fileRepo.save(fileInfoMapper.create(assetId, multipartFile, configuration.getTtl()));
    FileInfo fileInfo = new FileInfo();
	storageService.save(multipartFile);
	return fileInfoMapper.map(UriHelperUtils.createUriFrom(configuration.getAssetBasePath(), assetId), fileInfo);
    }

    @Override
    public FileInfoDto download(String assetId) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public FileInfoDto fetchAssetInfo(String assetId) {
	// TODO Auto-generated method stub
	return null;
    }

}