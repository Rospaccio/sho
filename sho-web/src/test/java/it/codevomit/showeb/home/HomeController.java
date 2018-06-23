package it.codevomit.showeb.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author merka
 */
@Controller
@RequestMapping("/")
public class HomeController
{
    @GetMapping({"", "/index", "/home"})
    public String index(){
        return "index";
    }
}
