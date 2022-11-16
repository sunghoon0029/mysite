package com.bitacademy.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.UserVo;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public void join(UserVo userVo) {
		userRepository.insert(userVo);
	}

	public UserVo findUser(UserVo userVo) {
		return userRepository.findByEmailAndPassword(userVo.getEmail(), userVo.getPassword());
	}
	
	public UserVo findUser(Long no) {
		return userRepository.findByNo(no);
	}

	public void updateUser(UserVo userVo) {
		userRepository.update(userVo);
	}
}
