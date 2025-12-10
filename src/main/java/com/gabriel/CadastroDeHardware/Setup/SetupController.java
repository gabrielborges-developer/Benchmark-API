package com.gabriel.CadastroDeHardware.Setup;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/setups")
public class SetupController {

    private SetupService setupService;

    SetupController(SetupService setupService){
        this.setupService =  setupService;
    }

    @PostMapping
    public SetupEntity createSetup(@RequestBody SetupEntity setup ){
        return setupService.createSetup(setup);
    }

    @GetMapping
    public List<SetupEntity> getAllSetups(){
        return setupService.listAll();
    }

    @GetMapping("/{id}")
    public SetupEntity getSetupById(@PathVariable Long id){
        return setupService.listSetupById(id);
    }

    @PutMapping("/atualizar-setupID")
    public String atualizarSetupId(){
        return "Setup Atualizado";
    }

    @DeleteMapping("/{id}")
    public String deleteSetupById(@PathVariable Long id){
        setupService.deleteSetupById(id);
        return  "Setup Deletado";
    }

}
