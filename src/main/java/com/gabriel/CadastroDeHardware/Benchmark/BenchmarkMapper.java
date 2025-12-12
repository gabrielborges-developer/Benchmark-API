package com.gabriel.CadastroDeHardware.Benchmark;

import org.springframework.stereotype.Component;

@Component
public class BenchmarkMapper {

    public BenchmarkEntity toEntity(BenchmarkDTO dto) {
        BenchmarkEntity entity = new BenchmarkEntity();
        entity.setId(dto.id());
        entity.setSoftwareName(dto.softwareName());
        entity.setFpsAvg(dto.fpsAvg());
        entity.setGraphicsPreset(dto.graphicsPreset());
        entity.setResolution(dto.resolution());
        return entity;
    }

    public BenchmarkDTO toDto(BenchmarkEntity entity) {
        return new BenchmarkDTO(
                entity.getId(),
                entity.getSoftwareName(),
                entity.getFpsAvg(),
                entity.getGraphicsPreset(),
                entity.getResolution()
        );
    }
}