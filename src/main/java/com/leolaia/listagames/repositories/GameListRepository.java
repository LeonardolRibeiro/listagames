package com.leolaia.listagames.repositories;

import com.leolaia.listagames.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
