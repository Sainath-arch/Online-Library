package com.example.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    @Query(value="select id from user_details u where u.student_name=?1 and u.password = ?2",nativeQuery = true)
    public int findUser(String name, String password);
}
