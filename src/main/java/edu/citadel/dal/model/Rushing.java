package edu.citadel.dal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "rushing")
public class Rushing {
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
    @Column(name="attempts")
    private int attempts;
    @Column(name="yards")
    private int yards;
    @Column(name="touchdowns")
    private int touchdowns;
    @Column(name="fumbles")
    private int fumbles;
}
