package com.BurgueraCallesArnau.s05t02n01.repository;

import com.BurgueraCallesArnau.s05t02n01.model.domain.Player;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlayerRepository extends MongoRepository<Player, ObjectId> {
    Optional<Player> findByEmail(String email);
}
