package com.BurgueraCallesArnau.s05t02n01.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.DBRef;

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

    /*@ManyToOne
    @JoinColumn(name = "player_Id")
    @JsonBackReference//If i don't do this Circular reference in JSON serialization*/
    @DBRef
    private Player player;

}
