package edu.citadel.dal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "players")
public class Players {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String lastName;
    @Column(name="team")
    private String team;
    @Column(name="position")
    private String position;
    @Column(name="games_played")
    private int gamesPlayed;
}
