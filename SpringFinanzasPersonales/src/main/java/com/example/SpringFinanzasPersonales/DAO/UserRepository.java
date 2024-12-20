package com.example.SpringFinanzasPersonales.DAO;

import com.example.SpringFinanzasPersonales.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long >{
}
