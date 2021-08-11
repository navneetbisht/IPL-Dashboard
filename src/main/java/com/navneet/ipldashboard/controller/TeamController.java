package com.navneet.ipldashboard.controller;

import com.navneet.ipldashboard.model.Team;
import com.navneet.ipldashboard.repository.MatchRepository;
import com.navneet.ipldashboard.repository.TeamRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {

    private TeamRepository teamRepository;
    private MatchRepository matchRepository;

    private TeamController(TeamRepository teamRepository, MatchRepository matchRepository) {

        this.teamRepository = teamRepository;
        this.matchRepository = matchRepository;
    }

    @GetMapping("/team/{teamName}")
    public Team getTeam(@PathVariable String teamName) {
        Team team = this.teamRepository.findByTeamName(teamName);
        Pageable pageable = PageRequest.of(0, 4);
        team.setMatches(matchRepository.getByTeam1OrTeam2orderByDateDesc(teamName, teamName, pageable));

        return team;

    }
}
