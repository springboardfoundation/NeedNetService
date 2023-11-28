package org.springboardfoundation.client.need;

import org.springboardfoundation.common.dto.need.NeedDto;

public interface NeedWebService {
    NeedDto getNeed(String needId);

    NeedDto saveNeed(NeedDto needDto, String userId);

    NeedDto updateNeed(NeedDto needDto, String userId);
}