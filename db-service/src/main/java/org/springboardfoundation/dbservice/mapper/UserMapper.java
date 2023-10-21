package org.springboardfoundation.dbservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import org.springboardfoundation.common.dto.users.UserDto;
import org.springboardfoundation.dbservice.entity.User;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {
    UserDto map(User user);

    @Mapping(source = "mobileNumber", target = "mobileNumber")
    User map(UserDto userDto, String mobileNumber);

    User map(@MappingTarget User user, UserDto userDto);
}