package com.navneet.ipldashboard.repository;

import com.navneet.ipldashboard.model.Match;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchRepository extends CrudRepository<Match, Long> {

    List<Match> getByTeam1OrTeam2orderByDateDesc(String teamName1,String teamName2);


}
