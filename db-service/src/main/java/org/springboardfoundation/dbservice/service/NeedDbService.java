package org.springboardfoundation.dbservice.service;

import org.springboardfoundation.common.dto.need.NeedDto;

public interface NeedDbService {
    NeedDto saveNeed(NeedDto needDto, String userIdentifier);

}