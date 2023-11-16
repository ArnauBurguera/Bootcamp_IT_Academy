package com.BurgueraCallesArnau.s05t02n01.model.domain;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "players")
public class Player implements UserDetails {
    @Id
    private String id;
    private String name;
    private Date registrationDate;
    private List<Game> games;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Player(String name){
        this.name = name;
        this.games = new ArrayList<>();
    }
    public void addGame(Game game) {
        games.add(game);
        game.setPlayer(this);
    }

    public void deleteAllGames(){
        games.clear();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
