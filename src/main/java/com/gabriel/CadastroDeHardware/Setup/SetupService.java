package com.gabriel.CadastroDeHardware.Setup;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class SetupService {


    private final SetupRepository setupRepository;

    public SetupService(SetupRepository setupRepository){

        this.setupRepository = setupRepository;
    }


    public List<SetupEntity> getAllSetupService(){

        return setupRepository.findAll();
    }

    public SetupEntity createSetupService(SetupEntity setup){
       return setupRepository.save(setup);
    }

    public SetupEntity listSetupServiceById(Long id){

        Optional<SetupEntity> setupServiceListOptional = setupRepository.findById(id);

        return setupServiceListOptional.orElse(null);
    }

    public SetupEntity updateSetupServiceById(Long id, SetupEntity setup){
        if(setupRepository.existsById(id)){
            setup.setId(id);
            return setupRepository.save(setup);
        }
        return null;
    }

    public void deleteSetupByIdService(Long id){

       setupRepository.deleteById(id);
    }



}
