package com.example.BtkCourseDemo.DataAccess;

import com.example.BtkCourseDemo.Entities.City;
import jakarta.persistence.*;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Repository //Mevcut kullandığım reponun bu olduğunu belirtmek için.
public class HibernateCityDal implements ICityDal{
    private EntityManager entityManager; // Constructor injection için bunu kullanacağız
    @Autowired //Springin ilgili paketler ile bu nesneyi bağlamasını sağladı.
    public HibernateCityDal(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional //Session aç kapa işlemlerini bizim yapmamıza gerek kalmayacak. Buna AOP deseni deniyo. Aspect Orianted Programming
    public List<City> getAll() {
        Session session = entityManager.unwrap(Session.class); //Hibernate işlerimizi yapacak session nesnesini böyle oluşturuyoruz
        return session.createQuery("from City",City.class).getResultList();
    }

    @Override
    @Transactional
    public void add(City city) {
        Session session = entityManager.unwrap(Session.class); //Hibernate işlerimizi yapacak session nesnesini böyle oluşturuyoruz
        session.saveOrUpdate(city); //ilgili id varda update edecek yoksa add yapacak
    }

    @Override
    @Transactional
    public void update(City city) {
        Session session = entityManager.unwrap(Session.class); //Hibernate işlerimizi yapacak session nesnesini böyle oluşturuyoruz
        session.saveOrUpdate(city); //ilgili id varda update edecek yoksa add yapacak
    }

    @Override
    @Transactional
    public void delete(City city) {
        Session session = entityManager.unwrap(Session.class); //Hibernate işlerimizi yapacak session nesnesini böyle oluşturuyoruz
        City cityToDelete = session.get(City.class,city.getId());
        session.delete(cityToDelete);
    }

    @Override
    @Transactional
    public City getById(int id) {
        Session session = entityManager.unwrap(Session.class); //Hibernate işlerimizi yapacak session nesnesini böyle oluşturuyoruz
        City city = session.get(City.class,id);
        return city;
    }
}
