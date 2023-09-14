package org.springboardfoundation.fileservice.web.controller;

import org.springboardfoundation.common.dto.file.FileInfoDto;
import org.springboardfoundation.common.web.BaseController;
import org.springboardfoundation.fileservice.services.AssetService;
import org.springboardfoundation.fileservice.web.ApiConstants;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/*
 * Ref: https://spring.io/guides/gs/uploading-files/
 */

@Slf4j
@RestController
@RequestMapping(ApiConstants.BASE_PATH)
@RequiredArgsConstructor
public class FileServiceController extends BaseController {

    private final AssetService assetService;

    @PostMapping(value = ApiConstants.UPLOAD_PATH, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity upload(@RequestParam(ApiConstants.FILE_PARAM) MultipartFile file,
	    @RequestParam(value = ApiConstants.NEEDID_PARAM, required = false) String needId,
	    @RequestParam(value = ApiConstants.ASSETID_PARAM, required = false) String assetId) {

	log.info("Upload file: {}, assetId: {}", file.getName(), assetId);
	
	FileInfoDto fileDto = assetService.upload(needId, file, assetId);
	ResponseEntity created = created(fileDto.getUrl(), fileDto);
	
	log.info("[{}] Upload file response: {}", created);
	return created;
    }

}