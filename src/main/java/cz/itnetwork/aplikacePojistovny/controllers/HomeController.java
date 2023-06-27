package cz.itnetwork.aplikacePojistovny.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String renderIndex() {
        return "pages/home/index";
    }                 // vrací odkaz na uvítací stranu
    @GetMapping("/contact")
    public String renderContact() {
        return "pages/home/contact";
    }             // stránka s kontakty
    @GetMapping("/events")
    public String renderReferences() {
        return "pages/home/events";
    }           // události
    @GetMapping("/about")
    public String renderSkills() {
        return "pages/home/about";
    }                // o aplikaci

}
