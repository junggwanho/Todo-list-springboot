package com.example.my.domain.todo.controller;

import com.example.my.domain.todo.service.TodoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    ModelAndView modelAndView = new ModelAndView();
    @GetMapping({"", "/"})
    public ModelAndView todoTablePage(HttpSession session) {
        if (session.getAttribute("dto") == null){
            modelAndView.setViewName("redirect:/auth/login");
            return modelAndView;
        }

        System.out.println(session.getAttribute("dto"));

        modelAndView.setViewName("todo/table");
        return modelAndView;
    }

}
