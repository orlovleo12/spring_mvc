package web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import web.service.CarService;

import java.util.Locale;

@Controller
public class CarController {

    @Autowired
    private MessageSource messageSource;
    @Autowired
    private CarService carService;

    @GetMapping("cars")
    public String index(Model model, @ModelAttribute("locale") String locale) {
        model.addAttribute("localeCars", messageSource.getMessage("car", null, new Locale(locale)));
        model.addAttribute("cars", carService.getCarList());
        return "cars";
    }

}
