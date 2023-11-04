package com.BurgueraCallesArnau.s05t02n01.service;

import com.BurgueraCallesArnau.s05t02n01.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
}
