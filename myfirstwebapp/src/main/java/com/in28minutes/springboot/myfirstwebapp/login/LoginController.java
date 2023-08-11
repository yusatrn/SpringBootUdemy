package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    // private Logger logger = LoggerFactory.getLogger(getClass());
    private AuthenticationService authenticationService = new AuthenticationService();
    @RequestMapping("login1")
    public String gotoLoginPageName(@RequestParam String name, ModelMap model) {
        model.put("name", name);
        //logger.debug("Request param is {}",name);
        //logger.info("I want this printed at info level");
        //logger.warn("I want this printed at info level");
        // System.out.println("Request param is " + name);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String gotoLoginPage() {
        //logger.debug("Request param is {}",name);
        //logger.info("I want this printed at info level");
        //logger.warn("I want this printed at info level");
        // System.out.println("Request param is " + name);
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String gotoWelcomePage(@RequestParam String name, @RequestParam String password
    ,ModelMap model) {
        if (authenticationService.authenticate(name, password)) {
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
        model.put("errorMessage","Hatali Giris Yaptiniz lütfen tekrar deneyinizz");
        return "login";
    }
}
