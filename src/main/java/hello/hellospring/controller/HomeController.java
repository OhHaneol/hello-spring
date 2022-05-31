package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    // localhost:8080 으로 들어오면 바로 호출되는 것, 여기서 또 home.html 호출(return)
    @GetMapping("/")
    public String home() {
        return "home";
    }
}
