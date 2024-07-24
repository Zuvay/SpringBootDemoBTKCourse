package com.example.BtkCourseDemo.Business;

import com.example.BtkCourseDemo.DataAccess.ICityDal;
import com.example.BtkCourseDemo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service //İş katmanında kullanılıyo
public class CityManager implements ICityService{
    private ICityDal cityDal;

    @Autowired
    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }
    @Override
    @Transactional
    public List<City> getAll() {
        return this.cityDal.getAll();
    }

    @Override
    @Transactional
    public void add(City city) {

    }

    @Override
    @Transactional
    public void update(City city) {

    }

    @Override
    @Transactional
    public void delete(City city) {

    }
}
