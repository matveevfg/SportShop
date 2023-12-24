package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String category() {
        return "index";
    }
    @GetMapping("/category_list")
    public String category_list() {
        return "category_list";
    }

}
