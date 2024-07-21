package com.publicissapient.weather.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * The Class HomeController.
 * 

 */
@RestController()

public class HomeController {

    /**
     * Redirect with using redirect view.
     *
     * @param attributes the attributes
     * @return the redirect view
     */
    @RequestMapping("/")
    public RedirectView redirectWithUsingRedirectView(RedirectAttributes attributes) {
        return new RedirectView("swagger-ui.html");
    }
}
