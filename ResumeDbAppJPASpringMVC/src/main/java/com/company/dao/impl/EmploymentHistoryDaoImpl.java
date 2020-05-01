package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.EmploymentHistoryDaoInter;
import com.company.entity.EmploymentHistory;
import com.company.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class EmploymentHistoryDaoImpl extends AbstractDAO implements EmploymentHistoryDaoInter {
    
    @Override
    public List<EmploymentHistory> getAll () {
       EntityManagerFactory emf = entityManagerFactory();
       EntityManager entityManager = emf.createEntityManager();
       
       Query query = entityManager.createQuery("select em from EmploymentHistory em",EmploymentHistory.class);
       
       List<EmploymentHistory> eHistory = query.getResultList();
       
       return eHistory;
    }
    
    @Override
    public EmploymentHistory getAllEmploymentHistoryByUserId(int userId) {
         EntityManagerFactory emf = entityManagerFactory();
         EntityManager entityManager = emf.createEntityManager();
         
         EmploymentHistory emHistory = entityManager.find(EmploymentHistory.class, userId);
         
         return emHistory;
    }
    
    @Override
    public int addEmploymentHistory(EmploymentHistory eh) {
          EntityManagerFactory emf = entityManagerFactory();
          EntityManager entityManager = emf.createEntityManager();
          
          entityManager.getTransaction().begin();
          entityManager.persist(eh);
          entityManager.flush();
          entityManager.getTransaction().commit();
          
          return eh.getId();
    }
    
    @Override
    public boolean updateEmploymentHistory(EmploymentHistory eh) {
          EntityManagerFactory emf = entityManagerFactory();
          EntityManager entityManager = emf.createEntityManager();
          
          entityManager.getTransaction().begin();
          entityManager.merge(eh);
          entityManager.getTransaction().commit();
          
          return true;
    }
    
    @Override
    public boolean removeEmploymentHistory(int id) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        EmploymentHistory eh = entityManager.find(EmploymentHistory.class, id);
        entityManager.remove(eh);
        entityManager.getTransaction().commit();
        
        return true;
    }
}
