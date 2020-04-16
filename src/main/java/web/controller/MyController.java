package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserServiсe;

import javax.servlet.http.HttpServletRequest;
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
    public String deleteContact(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        UserServiceImpl.deleteUser(userId);
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
    public ModelAndView editUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = UserServiceImpl.getUserById(userId);
        ModelAndView model = new ModelAndView("edit");
        model.addObject("user", user);
        return model;
    }

    @RequestMapping(value = "/admin/edit", method = RequestMethod.POST)
    public String editUser(@ModelAttribute User user, HttpServletRequest request) {
        user.setId(Integer.parseInt(request.getParameter("id")));
        UserServiceImpl.updateUser(user);
        return "redirect:/";
    }


}
