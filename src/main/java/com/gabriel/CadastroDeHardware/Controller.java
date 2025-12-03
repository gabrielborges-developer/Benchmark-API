package com.gabriel.CadastroDeHardware;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping
public class Controller {


    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Primeira mensagem";
    }
}
