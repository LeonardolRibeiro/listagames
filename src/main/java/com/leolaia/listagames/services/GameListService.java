package com.leolaia.listagames.services;


import com.leolaia.listagames.dto.GameListDto;
import com.leolaia.listagames.entities.GameList;
import com.leolaia.listagames.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(x -> new GameListDto(x)).toList();
    }


}
