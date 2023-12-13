package org.springboardfoundation.dbservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springboardfoundation.common.dto.need.NeedDto;
import org.springboardfoundation.dbservice.entity.Need;
import org.springboardfoundation.dbservice.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface NeedMapper {
    NeedDto map(Need user);

    Need map(NeedDto userDto, User user);
}