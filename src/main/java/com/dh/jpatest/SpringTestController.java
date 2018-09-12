package com.dh.jpatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dh.jpatest.test.dao.UserDao;
import com.dh.jpatest.test.dao.UserJpaDao;
import com.dh.jpatest.test.service.UserService;

@Controller
@RequestMapping("/hello")
public class SpringTestController {
	
	@Autowired
	private UserJpaDao userJpaDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/dh")
	@ResponseBody
	@Transactional
	public String hello() {
	System.out.println("½øÀ´ÁË");
//		System.out.println(userDao.findById(1));
//		System.out.println(userDao.count());
//		System.out.println(userDao.findByName("2"));
//		System.out.println(userDao.findOne(1));
//		System.out.println(userDao.findByNameAndId("3", 3));
		System.out.println(userJpaDao.findUserByAddress("json"));
		
//		User user=new User();
//		
//		user.setAddress("·É·É");
//		user.setId(70);
//		userDao.save(user);
		
		userService.updateData("2", "ppn");
		
		userDao.getUser();
		
		
		return "home";
	}
}