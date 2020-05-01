package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.SkillDaoInter;
import com.company.entity.Skill;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class SkillDaoImpl extends AbstractDAO implements SkillDaoInter {

    @Override
    public List<Skill> getAllSkills () {
       EntityManagerFactory emf = entityManagerFactory();
       EntityManager entityManager = emf.createEntityManager();
       
       Query query = entityManager.createQuery("Select s from Skill s",Skill.class);
       
       List<Skill> skill = query.getResultList();
       
       return skill;
    }
    
    @Override
    public Skill getById(int id) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        Skill skill = entityManager.find(Skill.class, id);
        
        return skill;
    }   
    
    @Override
    public int addCountry(Skill s) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(s);
        entityManager.flush();
        entityManager.getTransaction().commit();
        
        return s.getId();
    }
    
    @Override
    public boolean updateCountry(Skill s) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.merge(s);
        entityManager.getTransaction().commit();
        
        return true;
    }
    
    @Override
    public boolean removeCountry(int id) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        Skill s = entityManager.find(Skill.class, id);
        entityManager.remove(s);
        entityManager.getTransaction().commit();
        
        return true;
    }
}
