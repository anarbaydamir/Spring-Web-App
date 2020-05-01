package com.company.dao.impl;

import com.company.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Integer>, UserRepositoryCustom
//bunlardan User entityndi, Integer ise primary keyivin tipini gosterir.
    //CrudRepository de var. JpaRepository daha ustundu ve Jpa Cruddan extend eliyib.
{
    User findByName(String name); //burada xususi bir method yaziriq name'e gore axtarish uchun. findByName'deki name columnuna esasen axtarir demekdi
    User findByNameAndSurname(String name,String surname); //name ve surname'e esasen axtarir

//    @Query(value = "select * from user where email=?", nativeQuery = true)  nativequery yazib jpqlden istifade etmek istemeye bilersen
    @Query(value = "select u from User u where u.email=:email")
    User findByEmail(@Param("email") String email);
}
