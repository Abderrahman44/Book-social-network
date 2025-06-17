package com.abderahman.booknetwork.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface TokenRepo extends JpaRepository<Token, Integer> {

    Optional<Token> findByToken(String token);

}
