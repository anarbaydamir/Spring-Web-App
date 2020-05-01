package com.company.dao.inter;

import com.company.entity.Skill;

import java.util.List;

public interface SkillDaoInter {
    public List<Skill> getAllSkills();
    
    public Skill getById(int id);
    
    public int addCountry(Skill s);
    
    public boolean updateCountry(Skill s);
    
    public boolean removeCountry(int id);
}
