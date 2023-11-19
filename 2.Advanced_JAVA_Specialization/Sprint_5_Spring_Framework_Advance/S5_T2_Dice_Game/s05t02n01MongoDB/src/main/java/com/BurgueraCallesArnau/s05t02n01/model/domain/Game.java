package com.BurgueraCallesArnau.s05t02n01.model.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "games")
public class Game {//Doesn't need Id 'cause every Game is instantly associated to a player
 /*   @Id
    private ObjectId id;*/
    private int dice1;
    private int dice2;
    private boolean won;

    /*@DBRef
    @JsonBackReference//If i don't do this Circular reference in JSON serialization
    private Player player;*/

   /* public Game(int dice1, int dice2, Boolean won){
        this.dice1 = dice1;
        this.dice2 = dice2;
        this.won = won;
    }*/
}
