package com.example.Diego_bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.Diego_bookstore.domain.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {
private final UserRepository repository;

@Autowired
public UserDetailService(UserRepository userRepository) {
this.repository = userRepository;
}

@Override
public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException {
	com.example.Diego_bookstore.domain.User curruser = repository.findByUsername(username);
	UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPasswordHash(),
			AuthorityUtils.createAuthorityList(curruser.getRole()));
	return user;
	}
} 