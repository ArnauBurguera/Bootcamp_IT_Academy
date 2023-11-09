package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer> {
    Optional<Player> findByEmail(String email);
}
