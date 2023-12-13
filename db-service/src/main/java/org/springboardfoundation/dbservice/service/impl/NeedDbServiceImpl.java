package org.springboardfoundation.dbservice.service.impl;

import lombok.RequiredArgsConstructor;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.dbservice.mapper.NeedMapper;
import org.springboardfoundation.dbservice.respositories.NeedRepository;
import org.springboardfoundation.dbservice.respositories.UserRepository;
import org.springboardfoundation.dbservice.service.NeedDbService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NeedDbServiceImpl implements NeedDbService {

    private final NeedMapper mapper;
    private final UserRepository userRepository;
    private final NeedRepository needRepository;

    @Override
    public NeedDto saveNeed(NeedDto needDto, String userIdentifier) {
        return mapper.map(
            mapper.map(needDto, userRepository.findByUserIdentifier(userIdentifier).orElseThrow())
        );
    }
}