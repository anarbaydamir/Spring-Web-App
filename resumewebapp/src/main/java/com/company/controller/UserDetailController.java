package com.company.controller;

import com.company.dao.impl.UserRepository;
import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.inter.UserServiceInter;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@Controller
public class UserDetailController {

    @Autowired
    private UserServiceInter userServiceInter;

    @RequestMapping(method = RequestMethod.GET,value = "/userdetail")
    public ModelAndView userDetailGet(@RequestParam("id") Integer userId) {
        User user = userServiceInter.getById(userId);

        ModelAndView mv = new ModelAndView("userdetail");
        mv.addObject("user",user);

        return mv;
    }

    @RequestMapping(method = RequestMethod.POST,value = "/userdetail")
    public ModelAndView userDetailPost (@RequestParam("id") Integer id,
                                  @RequestParam("name") String name,
                                  @RequestParam("surname") String surname,
                                  @RequestParam("email") String email,
                                  @RequestParam("phoneNumber") String phone){

        User user = userServiceInter.getById(id);
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setPhoneNumber(phone);
        userServiceInter.updateUser(user);

        ModelAndView mv = new ModelAndView("redirect:/users");
        return mv;
    }
}
