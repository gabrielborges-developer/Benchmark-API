package com.gabriel.CadastroDeHardware.Setup;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SetupService {


    private SetupRepository setupRepository;

    public SetupService(SetupRepository setupRepository){

        this.setupRepository = setupRepository;
    }


    public SetupEntity createSetup(SetupEntity setup){
       return setupRepository.save(setup);
    }

    public List<SetupEntity> listAll(){

        return setupRepository.findAll();
    }

    public SetupEntity listSetupById(Long id){

        Optional<SetupEntity> setupServiceListOptional = setupRepository.findById(id);

        return setupServiceListOptional.orElse(null);
    }

    public void deleteSetupById(Long id){

       setupRepository.deleteById(id);
    }



}
