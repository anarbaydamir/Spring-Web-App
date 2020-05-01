package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.CountryDaoInter;
import com.company.entity.Country;
import com.company.entity.User;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CountryDaoImpl extends AbstractDAO implements CountryDaoInter {
    
    @Override
    public List<Country> getAllCountries () {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();
        
        Query query = entityManager.createQuery("select c from Country c", Country.class);
        
        List<Country> country = query.getResultList();
        
        emf.close();
        entityManager.close();
        
        return country;
    }
    
    @Override
    public Country getById(int id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();
        
        Country c = entityManager.find(Country.class, id);
        
        entityManager.close();
        emf.close();
        
        return c;
    }
    
    @Override
    public int addCountry(Country c) {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emfactory.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(c);
        entityManager.flush();//oldu olmadi idni qaytarir, sadece deqiqleshdirmek uchundu bu
        entityManager.getTransaction().commit();
        
        entityManager.close();
        emfactory.close();
        
        return c.getId();
    }
   
    @Override
    public boolean updateCountry(Country c) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.merge(c);
        entityManager.getTransaction().commit();
        
        entityManager.close();
        emf.close();
        
        return true;
    }
    
    @Override
    public boolean removeCountry(int id) {
      EntityManagerFactory emf = Persistence.createEntityManagerFactory("resumeappPU");
      EntityManager entityManager = emf.createEntityManager();
      
      entityManager.getTransaction().begin();
      User u = entityManager.find(User.class, id);
      entityManager.remove(id);
      entityManager.getTransaction().commit();
      
      entityManager.close();
      emf.close();
      
      return true;
    }
}
