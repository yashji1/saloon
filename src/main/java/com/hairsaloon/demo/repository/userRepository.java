package com.hairsaloon.demo.repository;

import com.hairsaloon.demo.modals.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<User,Long> {

}
