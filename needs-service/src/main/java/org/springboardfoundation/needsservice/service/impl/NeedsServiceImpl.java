package org.springboardfoundation.needsservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.client.need.NeedWebService;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.common.dto.need.NeedStatus;
import org.springboardfoundation.needsservice.service.NeedsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NeedsServiceImpl implements NeedsService {
    private final NeedWebService needWebService;

    @Override
    public NeedDto create(NeedDto need, String userId) {
        return needWebService.saveNeed(need, userId);
    }

    @Override
    public NeedDto getNeed(String needId) {
        return needWebService.getNeed(needId);
    }

    @Override
    public List<NeedDto> getUserNeedIds(String userId, int start, int size) {
        return null;
    }

    @Override
    public List<String> getUserNeedIds(String userId, NeedStatus needStatus) {
        return null;
    }

    @Override
    public NeedDto publish(String needId) {
        return null;
    }
}