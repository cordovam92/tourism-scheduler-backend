package edu.citadel.dal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "receiving")
public class Receiving {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;
    @Column(name="f_name")
    private String firstName;
    @Column(name="l_name")
    private String lastName;
    @Column(name="pos")
    private String position;
    @Column(name="receptions")
    private int receptions;
    @Column(name="targets")
    private int targets;
    @Column(name="yards")
    private int yards;
    @Column(name="touchdowns")
    private int touchdowns;
    @Column(name="fumbles")
    private int fumbles;
}
