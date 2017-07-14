package com.alura.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by marcos.nami on 13/07/2017.
 */
@Controller
public class OlaMundoController {

    @RequestMapping("/olaMundoSpring")
    public String execute() {
        System.out.println("Executando a lógica com Spring MVC");
        return "ok";
    }
}
