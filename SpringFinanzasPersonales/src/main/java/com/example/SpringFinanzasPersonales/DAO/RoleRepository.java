package com.example.SpringFinanzasPersonales.DAO;

import com.example.SpringFinanzasPersonales.models.Rol;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface RoleRepository extends JpaRepository<Rol, Long>{
}
