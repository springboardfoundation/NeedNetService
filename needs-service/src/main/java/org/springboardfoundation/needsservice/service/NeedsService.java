package org.springboardfoundation.needsservice.service;

import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.common.dto.need.NeedStatus;

import java.util.List;

public interface NeedsService {

    NeedDto create(NeedDto need, String userId);

    NeedDto getNeed(String needId);

    List<NeedDto> getUserNeedIds(String userId, int start, int size);

    List<String> getUserNeedIds(String userId, NeedStatus needStatus);

    NeedDto publish(String needId);

}