package com.BurgueraCallesArnau.s05t02n01.model.domain;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DBRef;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "games")
public class Game {
    @Id
    private ObjectId id;
    private int dice1;
    private int dice2;
    private boolean won;

    /*@DBRef
    @JsonBackReference//If i don't do this Circular reference in JSON serialization
    private Player player;*/

    public Game(int dice1, int dice2, Boolean won){
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.won = won;
    }
}
