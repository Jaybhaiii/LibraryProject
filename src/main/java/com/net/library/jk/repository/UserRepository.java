package com.net.library.jk.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.net.library.jk.entity.User;
@Repository
public interface UserRepository extends CrudRepository<User,Integer>
{

}
