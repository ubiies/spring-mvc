package com.example.mvc;

import com.example.mvc.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class MvcController {

    private int hitCount = 0;

    @RequestMapping("/hits")
    public String hits(Model model) {
        hitCount++;
        model.addAttribute("hits", hitCount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
        // 6개의 입의의 숫자 만들기
        List<Integer> winningNums = new ArrayList<>(); // 인터페이스 -> 구현체
        Random random = new Random();
        // random.nextInt(origin, bound) 임의의 정수를 반환하는 메소드
        for (int i=0;i<6;i++){
            winningNums.add(random.nextInt(1,46));
        }
        model.addAttribute("winningNums", winningNums);
        return "lotto";
    }

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute(
                "message",
                "Hello, Thymeleaf!"
        );
        return "home.html";
    }

    @RequestMapping("/student")
    public String student(Model model){
        model.addAttribute(
                "object",
                new Student("eunbi kim", "alal55al9@outlook.com"));
        return "student.html";
    }

    @RequestMapping("/is-logged-in")
    public String isLoggedIn(Model model){
        model.addAttribute(
                "isLoggedIn",
                true);
        return "if-unless.html";
    }

    @RequestMapping("/each")
    public String items(Model model){
        List<String> listOfStrings = new ArrayList<>();
        listOfStrings.add("foo");
        listOfStrings.add("bar");
        listOfStrings.add("baz");

        model.addAttribute("listOfStrings", listOfStrings);
        return "each.html";
    }
}
