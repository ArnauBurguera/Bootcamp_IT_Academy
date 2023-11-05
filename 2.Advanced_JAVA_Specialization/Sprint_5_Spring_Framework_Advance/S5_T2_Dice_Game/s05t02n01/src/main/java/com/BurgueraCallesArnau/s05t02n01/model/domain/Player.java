package com.BurgueraCallesArnau.s05t02n01.model.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Date registrationDate;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Game> games;

    public Player(String name){
        this.name = name;
        this.games = new ArrayList<>();
    }
    public void addGame(Game game) {
        games.add(game);
        game.setPlayer(this);
    }

    public void removeGame(Game game) {
        games.remove(game);
    }
}
