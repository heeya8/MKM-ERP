package com.mkm.erp.domain.bi.controller;

import com.mkm.erp.domain.bi.dto.request.TeamRequest;
import com.mkm.erp.domain.bi.dto.response.TeamResponse;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.service.TeamService;
import com.mkm.erp.domain.common.annotation.Auth;
import com.mkm.erp.domain.common.dto.AuthUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/information")
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/teams")
    public ResponseEntity<ResponseDto<TeamResponse>> getTeams(
            @Auth AuthUser authUser,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return ResponseEntity.ok(teamService.getTeams(page, size));
    }

    @PostMapping("/teams")
    public ResponseEntity<TeamResponse> createTeam(@RequestBody TeamRequest request) {
        TeamResponse teamResponse = teamService.createTeam(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(teamResponse);
    }

    @PatchMapping("/teams/{id}")
    public ResponseEntity<TeamResponse> updateTeam(@PathVariable Long id, @RequestBody TeamRequest request) {
        return ResponseEntity.ok(teamService.updateTeam(id, request));
    }

    @DeleteMapping("/teams/{id}")
    public ResponseEntity<Void> deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
        return ResponseEntity.noContent().build();
    }
}
