package com.example.BtkCourseDemo.restApi;

import com.example.BtkCourseDemo.Business.ICityService;
import com.example.BtkCourseDemo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //restful api yazdığımızı bu anotasyon ile belirtiyoruz
@RequestMapping("/api")
public class CityController {
    private ICityService cityService;
    @Autowired
    public CityController(ICityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/cities") // localhost:8080/api/cities
    public List<City> get(){
        return cityService.getAll();
    }
}
