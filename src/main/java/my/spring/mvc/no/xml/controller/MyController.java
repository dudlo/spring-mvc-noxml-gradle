package my.spring.mvc.no.xml.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
    @RequestMapping(value="/")
    public String myInitial(Model model) {
        return "myhello";
    }
}