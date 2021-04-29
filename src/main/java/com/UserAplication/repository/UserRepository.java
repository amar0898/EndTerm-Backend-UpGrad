package com.UserAplication.repository;

import com.UserAplication.model.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserData,Integer> {

    //public UserDetails findUserDetailsByName(String name);

    @Query("SELECT u FROM UserData u WHERE u.name LIKE %?1%")
    public List<UserData> findAllByName(String keyword);
}
