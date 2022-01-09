package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody   //http 통신 프로토콜의 body 부분에 문자(return 이하)를 직접 넣어주겠다는 의미. 별로 쓸모는 없음.
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name; //hello spring
    }

    @GetMapping("hello-api")
    @ResponseBody   //문자가 아니라 data 형식일 때, 객체를 return 시 사용하며 Json 방식으로 key-value, 이것때문에 보통 이 api 방식을 많이 사용한다.
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
