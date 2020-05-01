package com.company.dao.inter;

import com.company.entity.EmploymentHistory;

import java.util.List;

public interface EmploymentHistoryDaoInter {
    
    public List<EmploymentHistory> getAll ();
    
    public EmploymentHistory getAllEmploymentHistoryByUserId (int userId);
    
    public int addEmploymentHistory(EmploymentHistory eh);
    
    public boolean updateEmploymentHistory(EmploymentHistory eh);
    
    public boolean removeEmploymentHistory(int id);
}
