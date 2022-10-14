package org.springboardfoundation.usersservice.service.impl;
import org.springboardfoundation.usersservice.dto.UserDto;
import org.springboardfoundation.usersservice.entity.User;
import org.springboardfoundation.usersservice.mapper.UserMapper;
import org.springboardfoundation.usersservice.repositories.UserRepositoy;
import org.springboardfoundation.usersservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springboardfoundation.usersservice.utiliy.Utility;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepositoy userRepositoy;

	@Override
	public UserDto saveUser(UserDto userDto) {
		// copy all data into new user object pass that to save
		User user = UserMapper.MAPPER.map(userDto);

        String x=Utility.utilitymethod();
		user.setUserIdentifier((x.replace("-","")));

		userRepositoy.save(user);
		// before return copy all data into userdto and return
		return UserMapper.MAPPER.map(user);
	}
}
