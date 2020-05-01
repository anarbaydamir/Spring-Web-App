package com.company.dao.impl;

import com.company.dao.inter.AbstractDAO;
import com.company.dao.inter.UserSkillDaoInter;
import com.company.entity.Skill;
import com.company.entity.User;
import com.company.entity.UserSkill;

import javax.swing.plaf.nimbus.State;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class UserSkillDaoImpl extends AbstractDAO implements UserSkillDaoInter {
    
    @Override
    public List<UserSkill> getAllSkillByUserId (int userId) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        Query query = entityManager.createQuery("select us from UserSkill us", UserSkill.class);
        
        List<UserSkill> userSkill = query.getResultList();
        
        return userSkill;
    }
    
    @Override
    public int addUserSkill(UserSkill u) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.persist(u);
        entityManager.flush();
        entityManager.getTransaction().commit();
        
        return u.getId();
    }
    
    @Override
    public boolean updateUserSkill(UserSkill u) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        entityManager.merge(u);
        entityManager.getTransaction().commit();
        
        return true;
    }
    
    @Override
    public boolean removeUserSkill(int id) {
        EntityManagerFactory emf = entityManagerFactory();
        EntityManager entityManager = emf.createEntityManager();
        
        entityManager.getTransaction().begin();
        UserSkill uSkill = entityManager.find(UserSkill.class, id);
        entityManager.remove(uSkill);
        entityManager.getTransaction().commit();
        
        return true;
    }
}
