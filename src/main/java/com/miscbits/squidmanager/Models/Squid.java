package com.miscbits.squidmanager.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Squid {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer legs;
    private String color;
    private Boolean camouflage;
    private Boolean venomous;
    private Boolean poisonous;
    private String name;
    private Double ink;
    private Integer age;
    private Double cuteLevel;

    public Squid(Long id, Integer legs, String color, Boolean camouflage, Boolean venomous, Boolean poisonous, String name, Double ink, Integer age, Double cuteLevel) {
        this.id = id;
        this.legs = legs;
        this.color = color;
        this.camouflage = camouflage;
        this.venomous = venomous;
        this.poisonous = poisonous;
        this.name = name;
        this.ink = ink;
        this.age = age;
        this.cuteLevel = cuteLevel;
    }

    public Squid(Integer legs, String color, Boolean camouflage, Boolean venomous, Boolean poisonous, String name, Double ink, Integer age, Double cuteLevel) {
        this.legs = legs;
        this.color = color;
        this.camouflage = camouflage;
        this.venomous = venomous;
        this.poisonous = poisonous;
        this.name = name;
        this.ink = ink;
        this.age = age;
        this.cuteLevel = cuteLevel;
    }

    public Squid(){
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLegs() {
        return legs;
    }

    public void setLegs(Integer legs) {
        this.legs = legs;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Boolean getCamouflage() {
        return camouflage;
    }

    public void setCamouflage(Boolean camouflage) {
        this.camouflage = camouflage;
    }

    public Boolean getVenomous() {
        return venomous;
    }

    public void setVenomous(Boolean venomous) {
        this.venomous = venomous;
    }

    public Boolean getPoisonous() {
        return poisonous;
    }

    public void setPoisonous(Boolean poisonous) {
        this.poisonous = poisonous;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getInk() {
        return ink;
    }

    public void setInk(Double ink) {
        this.ink = ink;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getCuteLevel() {
        return cuteLevel;
    }

    public void setCuteLevel(Double cuteLevel) {
        this.cuteLevel = cuteLevel;
    }

    public Boolean isEdible() {
        return !this.poisonous &&
                !this.venomous &&
                !this.cuteLevel.equals(1);
    }

    public void celebrateBirthday() {
        this.age++;
    }
}
