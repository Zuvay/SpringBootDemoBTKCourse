package com.example.BtkCourseDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //restful api yazdığımızı bu anotasyon ile belirtiyoruz
public class ProductsController {
    @GetMapping("/") //Ana sayfada direkt olarak çalışacak.
    public String get(){
        return "Laptop";
    }
    @GetMapping("/products")
    public String get2(){
        return "Laptop 4";
    }

}
