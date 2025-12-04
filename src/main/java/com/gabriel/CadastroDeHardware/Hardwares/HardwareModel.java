package com.gabriel.CadastroDeHardware.Hardwares;

import com.gabriel.CadastroDeHardware.Benchmark.BenchmarkModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_hardware")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class HardwareModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private String marca;
    private double preco;
    private TipoHardware tipo;


    @ManyToOne
    @JoinColumn(name = "benchmark_id")
    private BenchmarkModel benchmark;

}


