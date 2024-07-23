package com.example.BtkCourseDemo.Entities;

import jakarta.persistence.*;
@Entity //Bu anotasyon bir db ile çalıştığımız için gerekli
@Table(name = "city") //city adlı tabloya referans veriyo
public class City {
    @Id
    @Column(name = "id") //Her bir properitynin hangi kolona referans verildiği
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto incremente olduğunu belirttik galiba
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "countryCode")
    private String countryCode;
    @Column(name = "district")
    private String district;
    @Column(name = "population")
    private int population;

    public City(int id, String name, String countryCode, String district, int population) {
        this.id = id;
        this.name = name;
        this.countryCode = countryCode;
        this.district = district;
        this.population = population;
    }
    public City(){ //hibernate için parametresiz default constructor kullanmamız gerekiyormuş
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
