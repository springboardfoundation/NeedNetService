package org.springboardfoundation.usersservice.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.entity.User;

@Mapper
public interface UserMapper {
	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);

	UserDto map(User user);

	User map(UserDto userDto);
}
