package com.leolaia.listagames.services;


import com.leolaia.listagames.dto.GameListDto;
import com.leolaia.listagames.entities.GameList;
import com.leolaia.listagames.projections.GameMinProjection;
import com.leolaia.listagames.repositories.GameListRepository;
import com.leolaia.listagames.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDto> findAll(){
        List<GameList> games = gameListRepository.findAll();
        return games.stream().map(x -> new GameListDto(x)).toList();
    }
    @Transactional
    public void replace(Long listId, int sourceIndex, int destinationIndex){
        List<GameMinProjection> games = gameRepository.searchByList(listId);
        GameMinProjection movedGame = games.remove(sourceIndex);
        games.add(destinationIndex, movedGame);

        int initialIndex = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int finalIndex = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = initialIndex; i <= finalIndex; i++){
            gameListRepository.updateBelongingPosition(listId, games.get(i).getId(), i);
        }
    }
    
}
