package com.cafeLaLoma.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cafeLaLoma.demo.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long>{

}
