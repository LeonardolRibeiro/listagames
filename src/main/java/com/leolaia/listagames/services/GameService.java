package com.leolaia.listagames.services;


import com.leolaia.listagames.dto.GameMinDto;
import com.leolaia.listagames.entities.Game;
import com.leolaia.listagames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDto> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDto(x)).toList();
    }


}
