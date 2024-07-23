package com.example.BtkCourseDemo.DataAccess;

import com.example.BtkCourseDemo.Entities.City;

import java.util.List;

public interface ICityDal {
    List<City> getAll();
    void add(City city);
    void update(City city);
    void delete(City city);
}
