package edu.citadel.dal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "defense")
public class Defense {
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
    @Column(name="tackles")
    private double tackles;
    @Column(name="sacks")
    private double sacks;
    @Column(name="tackles_for_loss")
    private double tfl;
    @Column(name="interceptions")
    private int interceptions;
    @Column(name="forced_fumbles")
    private int ff;
}
