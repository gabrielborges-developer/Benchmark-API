package com.gabriel.CadastroDeHardware.Setup;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.awt.desktop.PreferencesEvent;
import java.util.List;
import java.util.Set;


@RestController
@RequestMapping("/setups")
public class SetupController {

    private SetupService setupService;

    private SetupMapper setupMapper;

    SetupController(SetupService setupService,SetupMapper setupMapper){
        this.setupService =  setupService;
        this.setupMapper = setupMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SetupDTO createSetup(@RequestBody SetupDTO setupDto ){
        SetupEntity setupEntityRequest = setupMapper.toEntity(setupDto);
        SetupEntity setupEntityResponse = setupService.createSetupService(setupEntityRequest);
       return setupMapper.toDto(setupEntityResponse);
    }

    @GetMapping
    public List<SetupEntity> getAllSetups(){
        return setupService.getAllSetupService();
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
