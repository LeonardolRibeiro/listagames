package com.leolaia.listagames.controllers;

import com.leolaia.listagames.dto.GameListDto;
import com.leolaia.listagames.dto.GameMinDto;
import com.leolaia.listagames.dto.ReplacementDto;
import com.leolaia.listagames.services.GameListService;
import com.leolaia.listagames.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
    @Autowired
    private GameListService gameListService;
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDto> findAll(){
        return gameListService.findAll();
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDto> findByList(@PathVariable Long listId){
        return gameService.findByList(listId);
    }

    @PostMapping(value = "/{listId}/replacement")
    public void replace(@PathVariable Long listId, @RequestBody ReplacementDto body){
        gameListService.replace(listId, body.getSourceIndex(), body.getDestinationIndex());
    }
}
