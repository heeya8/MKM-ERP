package com.mkm.erp.domain.bi.service;

import com.mkm.erp.domain.bi.dto.request.TeamRequest;
import com.mkm.erp.domain.bi.dto.response.ResponseDto;
import com.mkm.erp.domain.bi.dto.response.TeamResponse;
import com.mkm.erp.domain.bi.entity.Team;
import com.mkm.erp.domain.bi.exception.ResourceNotFoundException;
import com.mkm.erp.domain.bi.repository.TeamRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {

    private final TeamRepository teamRepository;

    public ResponseDto<TeamResponse> getTeams(String name, int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Team> teamPage;

        if (name != null && !name.trim().isEmpty()) {
            // name으로 검색
            teamPage = teamRepository.findByNameContainingIgnoreCase(name, pageable);
        } else {
            // 전체 검색
            teamPage = teamRepository.findAll(pageable);
        }

        return new ResponseDto<>(
                teamPage.getContent().stream()
                        .map(team -> new TeamResponse(
                                team.getId(),
                                team.getName(),
                                team.getLead(),
                                team.getActive(),
                                team.getCreatedAt()
                        ))
                        .collect(Collectors.toList()),
                teamPage.getNumber() + 1,
                teamPage.getSize(),
                teamPage.getTotalElements(),
                teamPage.getTotalPages(),
                teamPage.isLast()
        );
    }

    @Transactional
    public TeamResponse createTeam(TeamRequest request) {
        Team team = new Team(request);
        teamRepository.save(team);
        return new TeamResponse(team.getId(), team.getName(), team.getLead(), team.getActive(), team.getCreatedAt());
    }

    @Transactional
    public TeamResponse updateTeam(Long id, TeamRequest request) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("팀을 찾을 수 없습니다. ID: " + id));

        team.setName(request.getName());
        team.setLead(request.getLead());
        team.setActive(request.getActive());

        teamRepository.save(team);

        return new TeamResponse(team.getId(), team.getName(), team.getLead(), team.getActive(), team.getCreatedAt());
    }

    @Transactional
    public void deleteTeam(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException("팀을 찾을 수 없습니다. ID: " + id);
        }
    }
}
