package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {



	@Query("SELECT u FROM User u LEFT JOIN FETCH u.orders WHERE u.id = :id")
	User findUserWithOrders(@Param("id") Long id);

	User getUserByid(Long id);

	

}
