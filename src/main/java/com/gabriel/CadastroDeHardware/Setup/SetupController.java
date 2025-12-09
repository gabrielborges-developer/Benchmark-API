package com.gabriel.CadastroDeHardware.Setup;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping
public class SetupController {


    @GetMapping("/helloworld")
    public String helloWorld() {
        return "Primeira mensagem";
    }


//add setup CREATE
    @PostMapping("/criar")
    public String criarSetup(){
        return "Setup criado";
    }


    // listar todos os setups READ
    @GetMapping("buscarTodos")
    public String busarTodosSetup(){
        return "Lista de Setups";
    }
    //buscar setup por ID CRETE

    @GetMapping("buscarID")
    public String busarSetupId(){
        return "Setup Encontrado";
    }


//alterar dados do setup UPDATE

    @PutMapping("/atualizarID")
    public String atualizarSetupId(){
        return "Setup Atualizado";
    }

// deletar um setup DELETE
    @DeleteMapping
    public String deletarSetupID(){
        return "Lista de Setups";
    }

}
