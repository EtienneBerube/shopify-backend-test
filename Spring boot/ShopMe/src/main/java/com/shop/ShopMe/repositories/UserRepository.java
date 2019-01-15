package com.shop.ShopMe.repositories;

import com.shop.ShopMe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
