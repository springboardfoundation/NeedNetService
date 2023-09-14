package org.springboardfoundation.needsservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springboardfoundation.common.dto.users.UserDto;
import org.springbordfoundation.db.entity.User;

@Mapper
public interface NeedsMapper {
	NeedsMapper MAPPER = Mappers.getMapper(NeedsMapper.class);

	UserDto map(User user);

	@Mapping(source = "mobileNumber", target = "mobileNumber")
	User map(UserDto userDto, String mobileNumber);

}