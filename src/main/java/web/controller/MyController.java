package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserServiсe;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private UserServiсe UserServiceImpl;


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView listContact(ModelAndView model) {
        List<User> listContact = UserServiceImpl.getAllUsers();
        model.addObject("listContact", listContact);
        model.setViewName("home");
        return model;
    }

    @RequestMapping(value = "/admin/delete", method = RequestMethod.GET)
    public String deleteContact(Integer id) {
        UserServiceImpl.deleteUser(id);
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.GET)
    public String addUser() {
        return "add";
    }

    @RequestMapping(value = "/admin/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute User user) {
        UserServiceImpl.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.GET)
    public ModelAndView editUser(Integer id) {
        User user = UserServiceImpl.getUserById(id);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, Integer id) {
        user.setId(id);
        UserServiceImpl.updateUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/userProfile", method = RequestMethod.GET)
    public String readUserGetController(ModelMap model, HttpSession session) {
        model.addAttribute("user", session.getAttribute("user"));
        return "userProfile";
    }

}
