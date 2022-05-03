package edu.citadel.dal.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tourism")

public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="rating")
    private Float rating;
    @Column(name="numofreviews")
    private Integer numofreviews;
    @Column(name="address")
    private String address;
    @Column(name="sundayhours")
    private String sundayhours;
    @Column(name="mondayhours")
    private String mondayhours;
    @Column(name="tuesdayhours")
    private String tuesdayhours;
    @Column(name="wednesdayhours")
    private String wednesdayhours;
    @Column(name="thursdayhours")
    private String thursdayhours;
    @Column(name="fridayhours")
    private String fridayhours;
    @Column(name="saturdayhours")
    private String saturdayhours;
    @Column(name="type")
    private String type;
    @Column(name="subtype")
    private String subtype;
    @Column(name="subtype2")
    private String subtype2;
    @Column(name="subtype3")
    private String subtype3;
    @Column(name="pricelevel")
    private String pricelevel;
    @Column(name="averagetime")
    private String averagetime;

    public Place() {

    }

    public Place(Integer id, String name, Float rating, Integer numofreviews, String address, String mondayhours, String tuesdayhours,
                 String wednesdayhours, String thursdayhours, String fridayhours, String saturdayhours, String type, String subtype,
                 String subtype2, String subtype3, String pricelevel, String averagetime) {
        super();
        this.id = id;
        this.name = name;
        this.rating = rating;
        this.numofreviews = numofreviews;
        this.address = address;
        this.mondayhours = mondayhours;
        this.tuesdayhours = tuesdayhours;
        this.wednesdayhours = wednesdayhours;
        this.thursdayhours = thursdayhours;
        this.fridayhours = fridayhours;
        this.saturdayhours = saturdayhours;
        this.type = type;
        this.subtype = subtype;
        this.subtype2 = subtype2;
        this.subtype3 = subtype3;
        this.pricelevel = pricelevel;
        this.averagetime = averagetime;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }

    public Integer getNumOfReviews() {
        return numofreviews;
    }
    public void setNumOfReviews(Integer numofreviews) {
        this.numofreviews = numofreviews;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

    public String getSundayHours() {
        return sundayhours;
    }
    public void setSundayHours(String sundayhours) {
        this.sundayhours = sundayhours;
    }

    public String getMondayHours() {
        return mondayhours;
    }
    public void setMondayHours(String mondayhours) {
        this.mondayhours = mondayhours;
    }

    public String getTuesdayHours() {
        return tuesdayhours;
    }
    public void setTuesdayHours(String tuesdayhours) {
        this.tuesdayhours = tuesdayhours;
    }

    public String getWednesdayHours() {
        return wednesdayhours;
    }
    public void setWednesdayHours(String wednesdayhours) {
        this.wednesdayhours = wednesdayhours;
    }

    public String getThursdayHours() {
        return thursdayhours;
    }
    public void setThursdayHours(String thursdayhours) {
        this.thursdayhours = thursdayhours;
    }

    public String getFridayHours() {
        return fridayhours;
    }
    public void setFridayHours(String fridayhours) {
        this.fridayhours = fridayhours;
    }

    public String getSaturdayHours() {
        return saturdayhours;
    }
    public void setSaturdayHours(String saturdayhours) {
        this.saturdayhours = saturdayhours;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subtype;
    }
    public void setSubType(String subtype) {
        this.subtype = subtype;
    }

    public String getSubType2() {
        return subtype2;
    }
    public void setSubType2(String subtype2) {
        this.subtype2 = subtype2;
    }

    public String getSubType3() {
        return subtype3;
    }
    public void setSubType3(String subtype3) {
        this.subtype3 = subtype3;
    }

    public String getPriceLevel() {
        return pricelevel;
    }
    public void setPriceLevel(String pricelevel) {
        this.pricelevel = pricelevel;
    }

    public String getAverageTime() {
        return averagetime;
    }
    public void setAverageTime(String averagetime) {
        this.averagetime = averagetime;
    }
}
