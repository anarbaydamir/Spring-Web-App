package com.company.controller;

import com.company.entity.User;
import com.company.form.UserForm;
import com.company.service.DummyService;
import com.company.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserServiceInter userService;

    //    @RequestMapping(method = RequestMethod.GET)
//    public String index (HttpServletRequest request) {
//        String name = request.getParameter("name");
//        String surname = request.getParameter("surname");
//
//        String nationalityIdStr = request.getParameter("nid");
//        Integer nationalityId = null;
//        if (nationalityIdStr != null && !nationalityIdStr.trim().isEmpty())
//        {
//            nationalityId = Integer.parseInt(nationalityIdStr);
//        }
//
//        List<User> list = userService.getAll(name,surname,nationalityId);
//
//        request.setAttribute("list",list);
//
//        return "users";
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/users")
    public ModelAndView index(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "surname", required = false) String surname,
                              @RequestParam(value = "nid", required = false) Integer nationalityId) {

        List<User> list = userService.getAll(name, surname, nationalityId);

        ModelAndView mv = new ModelAndView("users");

        mv.addObject("users", list);
        return mv;
    }

    //ModelAttribute methodu
    @RequestMapping(method = RequestMethod.GET,value = "/usersm")
    public ModelAndView indexM(@Valid
                               @ModelAttribute("user") UserForm userForm,
                               BindingResult bindingResult) {

        ModelAndView mv = new ModelAndView("users");
        if (bindingResult.hasErrors())
        {
            return mv;
        }

        List<User> userList = userService.getAll(userForm.getName(),userForm.getSurname(),userForm.getNationalityId());
        mv.addObject("users",userList);

        return mv;
    }

    @Autowired
    DummyService dummyService;

    @RequestMapping(method = RequestMethod.GET,value = "/foo")
    public String foo(){
        dummyService.foo();
        return "users";
    }
    @ModelAttribute("user") //butun metodlarda addObject etmemek uchun burda bir defe yaziriq ve users controllere gelen her requestde bu qayidacaq
    public UserForm getEmptyUserForm(){
        return new UserForm();
    }

}
