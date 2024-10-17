package com.mkm.erp.domain.bi.repository;
import com.mkm.erp.domain.bi.entity.Team;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Page<Team> findAllByIdOrderByModifiedAtDesc(Long id, Pageable pageable);
    Optional<Team> findById(Long id);
}

