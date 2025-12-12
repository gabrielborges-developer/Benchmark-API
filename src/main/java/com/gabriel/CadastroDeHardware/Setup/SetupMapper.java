package com.gabriel.CadastroDeHardware.Setup;

import org.springframework.stereotype.Component;

@Component
public class SetupMapper {

    public SetupEntity toEntity(SetupDTO dto){

        SetupEntity entity = new SetupEntity();
        entity.setId(dto.id());
        entity.setProcessor(dto.processor());
        entity.setVideoCard(dto.videoCard());
        entity.setMemory(dto.memory());
        entity.setMotherBoard(dto.motherboard());
        entity.setPrice(dto.price());
        entity.setBenchmarkEntityList(dto.benchmarkEntityList());
        entity.setFonte(dto.fonte());

        return entity;
    }

    public SetupDTO toDto(SetupEntity entity){
       return new SetupDTO(
               entity.getId(),
               entity.getProcessor(),
               entity.getVideoCard(),
               entity.getMemory(),
               entity.getMotherBoard(),
               entity.getPrice(),
               entity.getBenchmarkEntityList(),
               entity.getFonte()
       );
    }


}
