package com.leolaia.listagames.repositories;

import com.leolaia.listagames.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
