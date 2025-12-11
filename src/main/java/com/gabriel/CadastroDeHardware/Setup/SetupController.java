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

    @GetMapping
    public List<SetupEntity> getAllSetups(){
        return setupService.getAllSetupService();
    }

    @PostMapping
    public SetupEntity createSetup(@RequestBody SetupEntity setup ){
        return setupService.createSetupService(setup);
    }

    @GetMapping("/{id}")
    public SetupEntity getSetupById(@PathVariable Long id){
        return setupService.listSetupServiceById(id);
    }

    @PutMapping("/{id}")
    public SetupEntity updateSetupById(@PathVariable Long id, @RequestBody SetupEntity setup){
        return setupService.updateSetupServiceById(id,setup);
    }

    @DeleteMapping("/{id}")
    public String deleteSetupById(@PathVariable Long id){
        setupService.deleteSetupByIdService(id);
        return  "Setup Deletado";
    }

}
