package com.dh.jpatest.test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dh.jpatest.test.dao.UserJpaDao;
import com.dh.jpatest.test.service.UserService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl implements UserService {
	@Autowired
	private UserJpaDao userJpaDao;

	//@Transactional
	public void updateData(String name, String address) {
		System.out.println("jjsja");
		userJpaDao.updateData(name, address);

	}

}
