package com.boompodcast.levels;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LevelsDao extends JpaRepository<Levels, Integer> {

}
