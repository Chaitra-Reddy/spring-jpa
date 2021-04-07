package com.mindtree.Login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mindtree.Login.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	@Query("select u from User u where u.name=?1 and u.password=?2")
	User findUser(String name,String password);
}
