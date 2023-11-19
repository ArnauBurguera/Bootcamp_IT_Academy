package com.BurgueraCallesArnau.s05t02n01.model.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "games")
public class Game {

    //Doesn't need Id 'cause every Game is instantly associated to a player
    private int dice1;
    private int dice2;
    private boolean won;

}
