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

    // 사용하고 싶은 객체가 있을 경우 먼저 선언
    // 변화하지 않는 객체 -> 주입받은 객체를 함부로 다뤘다가 똑같은 곳에 쓰고 있으면
    // 다른 객체에 문제가 생길 수 있음으로 주입받은 대상 클래스에서 함부로 변화시키지 않도록
    // final 붙여주기
    private final LottoService lottoService;

    // 생성자 생성하면 스프링이 알아서 빈 객체에 주입해줌 -> 의존성 주입을 하고 있는 모습(DI)
    public MvcController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    @RequestMapping("/hits")
    public String hits(Model model) {
        int hitCount = lottoService.addHit();
        model.addAttribute("hits", hitCount);
        return "hits";
    }

    @RequestMapping("/lotto")
    public String lotto(Model model) {
        String winningNums = lottoService.lotto();
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
