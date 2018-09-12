package com.dh.jpatest.test.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.dh.jpatest.test.UserAggVO;
import com.dh.jpatest.test.entity.User;

import pub.DataConvert;

@Repository
public class UserDao {
	@Autowired // ÷ÿµ„
	private EntityManager entityManager;
	public void getUser() {
		StringBuilder sb = new StringBuilder();
		sb.append("select b.name as namess, a.name as name  from user a inner join Orders b on a.id=b.user_id");
		Query query = entityManager.createNativeQuery(sb.toString());
		List<Object> list = query.getResultList();
		for (Object user : list) {
			System.out.println(user);
		}
		DataConvert<UserAggVO> temp = new DataConvert<UserAggVO>();
		try {
			List<UserAggVO> list11 = temp.changeData(list, UserAggVO.class);
			
			for (UserAggVO user : list11) {
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		
//		Query query1 = entityManager.createNativeQuery(sb.toString(),User.class);
//		List<User> list1 = query1.getResultList();
//		for (User user : list1) {
//			System.out.println(user);
//		}
	}

}
