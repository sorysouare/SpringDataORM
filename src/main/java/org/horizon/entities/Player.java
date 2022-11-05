package org.horizon.entities;

import javax.persistence.*;
import java.io.Serializable;
@Entity
public class Player implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPlayer;
    @Column(length = 50)
    private String name;
    @ManyToOne
    @JoinColumn(name = "idTeam")
    private Team team;

    public Player() {
    }

    public Player(Long idPlayer, String name, Team team) {
        this.idPlayer = idPlayer;
        this.name = name;
        this.team = team;
    }

    public Long getIdPlayer() {
        return idPlayer;
    }

    public void setIdPlayer(Long idPlayer) {
        this.idPlayer = idPlayer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
