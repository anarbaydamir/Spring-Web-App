package com.company.dao.impl;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.company.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


//@Component yazilmalidi en azindan ki spring bu classi menimsesin. Repository gosterir ki class db connect classidi. Server classi da deyishenler olan classlarda olur.
@Repository("userDao2")
public class UserDaoImpl2 implements UserRepositoryCustom {

    @PersistenceContext
    EntityManager entitymanager;

    //@PersistenceUnit yazsaq bu zaman Entitymanager ve entitymanagerfactoryni ozumuz yaratmali olacaiyiq yeni spring buna nezaret elemir.
    //@PersistenceContext springin nezaret etmesi uchun yazilir, bu zaman entitymanageri yaratmaga onu close etmeye ehtiyac yoxdur
    
    @Override
    public List<User> getAll(String name,String surname,Integer nationalityId) {
        

            String jpql = "select u from User u where 1=1";

           // String sql = "select u.*,c.name as birthplace, n.nationality as nationality from USERS as u left join country as n on u.nationality_id=n.id left join country as c on u.birthplace_id=c.id where 1=1";
            
            if (name!=null && !name.trim().isEmpty()) {
                jpql+=" and u.name= :name";
            }
            if (surname!=null && !surname.trim().isEmpty()) {
                jpql+=" and u.surname= :surname";
            }
            if (nationalityId!=null) {
                jpql+=" and u.nationalityId.id= :nId";
            }
            
            Query query = entitymanager.createQuery(jpql, User.class);

            if (name!=null && !name.trim().isEmpty()){
                query.setParameter("name", name);
            }
            if (surname!=null && !surname.trim().isEmpty()){
                query.setParameter("surname", surname);
            }
            if (nationalityId!=null) {
                query.setParameter("nId", nationalityId);
            }
            
            List<User> user = query.getResultList();
            return user;
    }
    
    @Override
    public User getById(int userID) {
        User u = entitymanager.find(User.class, userID);
        return u;
    }
    
     @Override
    public boolean updateUser(User u) {
        entitymanager.merge(u);
        return true;
    }
    
    @Override
     public boolean removeUser(int id) {
       //User u = getById(id); bele yazsam ishlemeyecek chunki bu User classi jpa terefinden yaradilmayib ve entity bunun imkanlarindan istifade ede bilmez ona gore entitiy oz funksiyasi ile tapmalidi useri
       User u = entitymanager.find(User.class, id);
       entitymanager.remove(u);
       return true;
     }

    private BCrypt.Hasher crypt = BCrypt.withDefaults();

    @Override
    public int addUser(User u) {
        u.setPassword(crypt.hashToString(4, u.getPassword().toCharArray()));
        entitymanager.persist(u);
        entitymanager.flush();
        return u.getId();
    }
    

    @Override
    public User getUserByEmailAndPassword(String email, String password) {
        Query query = entitymanager.createQuery("select u from User u where u.email= :email, u.password= :password",User.class);
        query.setParameter("email", email);
        query.setParameter("password", password);
      //  query.getSingleResult(); tekce neticeni gonderir, yeni eminsen ki bir dene column qayidacaq, o zaman yazmaq lazimdir. Birden chox olursa artiq error verecek
        List<User> user = query.getResultList();
        if(user.size() == 1)
        {
            return user.get(0);
        }
        return null;
    }

//    @Override
//    public User getUserByEmail(String email) {
//        Query query = entitymanager.createQuery("select u from User u where u.email= :email", User.class);
//        query.setParameter("email", email);
//        List<User> user = query.getResultList();
//        if(user.size() == 1)
//        {
//            return user.get(0);
//        }
//        
//        return null;
//    }
    
    
    //CREATE BUILDER sql kodu yazmirsan
//    @Override
//    public User getUserByEmail (String email) {
//        CriteriaBuilder criteriaBuilder = entitymanager.getCriteriaBuilder();
//        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
//        Root<User> postRoot = criteriaQuery.from(User.class);
//        
//        CriteriaQuery<User> q2 = criteriaQuery
//                .where(criteriaBuilder.equal(postRoot.get("email"), email));
//        
//        Query query = entitymanager.createQuery(q2);
//        
//        List<User> user = query.getResultList();
//
//        if (user.size()==1) 
//        {
//            return user.get(0);
//        }
//        
//        return null;
//    }
    
    //NamedQuery
    @Override
    public User getUserByEmail (String email)
    {
        Query query = entitymanager.createNamedQuery("User.findByEmail",User.class);
        query.setParameter("email", email);
      
        List<User> user = query.getResultList();
        if(user.size()==1)
        {
            return user.get(0);
        }
        return null;
    }
    
    //NativeQuery
//    @Override
//    public User getUserByEmail (String email)
//    {
//        Query query = entityManager.createNativeQuery("select * from user where email=?",User.class);
//        query.setParameter("1", email);
//        List<User> user = query.getResultList();
//        if(user.size()==1)
//        {
//            return user.get(0);
//        }
//        return null;
//    }
}
