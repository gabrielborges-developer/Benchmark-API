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
    public List<SetupDTO> getAllSetups(){
        List<SetupEntity> entities = setupService.getAllSetupService();
        return entities.stream()
                .map(setupMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    public SetupDTO getSetupById(@PathVariable Long id){
        SetupEntity setupEntityResponse = setupService.getSetupServiceById(id);
        return setupMapper.toDto(setupEntityResponse);
    }

    @PutMapping("/{id}")
    public SetupDTO updateSetupById(@PathVariable Long id, @RequestBody SetupDTO setup){
       SetupEntity setupEntityRequest = setupMapper.toEntity(setup);
       SetupEntity entitySetupResponse = setupService.updateSetupServiceById(id,setupEntityRequest);
        return setupMapper.toDto(entitySetupResponse);
    }

    @DeleteMapping("/{id}")
    public String deleteSetupById(@PathVariable Long id){
        setupService.deleteSetupByIdService(id);
        return  "Setup Deletado";
    }

}
