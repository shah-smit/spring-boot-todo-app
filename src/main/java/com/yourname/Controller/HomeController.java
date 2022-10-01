package com.yourname.Controller;

import com.yourname.Entity.TodoItem;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping(value = "")
    public @ResponseBody String greeting() {
        return "Hello World";
    }
}
