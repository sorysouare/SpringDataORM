package org.horizon.dao;

import org.horizon.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    @Query("select t from Team t where t.name like :x")
    public List<Team> getTeamsByName(@Param("x") String name);
}
