package org.springboardfoundation.fileservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import org.springboardfoundation.common.dto.file.FileInfoDto;
import org.springboardfoundation.common.utiliy.UriHelperUtils;
import org.springbordfoundation.db.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.net.URI;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = { URI.class,
	UriHelperUtils.class })
public interface FileInfoMapper {

    FileInfoMapper MAPPER = Mappers.getMapper(FileInfoMapper.class);

    @Mapping(target = "url", source = "urlArg")
    FileInfoDto map(URI urlArg, FileInfo fileInfo);

    @Mapping(target = "url", expression = "java(UriHelperUtils.getUrlStringFromUri(urlArg))")
    FileInfo map(URI urlArg, String validity, FileInfoDto fileInfoDto);

    @Mapping(target = "status", constant = "INITIATED")
    @Mapping(target = "name", expression = "java(multipartFile.getName())")
    @Mapping(target = "originalFileName", expression = "java(multipartFile.getOriginalFilename())")
    @Mapping(target = "contentType", expression = "java(multipartFile.getContentType())")
    @Mapping(target = "fileSize", expression = "java(multipartFile.getSize())")
    FileInfo create(String assetId, MultipartFile multipartFile, long ttl);
}