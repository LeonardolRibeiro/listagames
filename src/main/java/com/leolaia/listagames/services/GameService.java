package com.leolaia.listagames.services;


import com.leolaia.listagames.dto.GameDto;
import com.leolaia.listagames.dto.GameMinDto;
import com.leolaia.listagames.entities.Game;
import com.leolaia.listagames.projections.GameMinProjection;
import com.leolaia.listagames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;


    @Transactional(readOnly = true)
    public GameDto findById(Long id){
        Game game = gameRepository.findById(id).get();
        return new GameDto(game);
    }

    @Transactional(readOnly = true)
    public List<GameMinDto> findByList(Long listId){
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        return games.stream().map(x -> new GameMinDto(x)).toList();
    }
    @Transactional(readOnly = true)
    public List<GameMinDto> findAll(){
        List<Game> games = gameRepository.findAll();
        return games.stream().map(x -> new GameMinDto(x)).toList();
    }


}
