package com.sq2.api.repository;

import com.sq2.api.ententies.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
