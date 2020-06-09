package dxc.com.au.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
public class RoutingController {

    @RequestMapping("/test")
    public ModelAndView testPage(){
        return new ModelAndView("test");
    }

    @RequestMapping("/homepage")
    public ModelAndView landingPage(){
        return new ModelAndView("homepage");
    }
}
