package com.gabriel.CadastroDeHardware.Setup;

import com.gabriel.CadastroDeHardware.Benchmark.BenchmarkEntity;
import org.springframework.stereotype.Component;

import java.util.List;

public record SetupDTO(Long id,String processor, String videoCard,String motherboard,String memory, double price, List<BenchmarkEntity> benchmarkEntityList,String fonte) {
}
