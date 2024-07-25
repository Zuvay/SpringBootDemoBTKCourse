package com.example.BtkCourseDemo.restApi;

import com.example.BtkCourseDemo.Business.ICityService;
import com.example.BtkCourseDemo.Entities.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping("/add") //Get işlemleri için get mapping, set gibi işlemler için post mapping
    public void add(@RequestBody City city){ //Parametreyi biz yapılan isteğin body'sinden alacağız. O yüzden bu anotasyon kullanılır
        cityService.add(city);
    }
    @PostMapping("/update") //post komutlarını tarayıcıda test edemiyoruz. Postman kullanmak lazım
    public void update(@RequestBody City city){ //Postman'de 200OK kodu başarılı anlamına geliyor
        cityService.update(city);
    }
    @PostMapping("/delete")
    public void delete(@RequestBody City city){
        cityService.delete(city);
    }
    @GetMapping("/cities/{id}")//bir get işlemi yapıcaz ama parametre bir değişken istiyor
    public City getById(@PathVariable int id){ //Bu anotasyon değişken ile yolun aynı olmasını sağlıyor
        return cityService.getById(id);
    }
}
