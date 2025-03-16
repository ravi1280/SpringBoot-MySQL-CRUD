package com.example.demo.repo;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM USER WHERE ID = ?1",nativeQuery = true)
    User getUserByUserId(String userId);

    @Query(value = "SELECT * FROM USER WHERE ID = ?1 AND NAME = ?2",nativeQuery = true)
    User getUserByUserIdAndName(String id,String name);

}
