package com.BurgueraCallesArnau.s05t02n01.model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int dice1;
    private int dice2;
    private boolean won;
    private ObjectId playerId;

}
