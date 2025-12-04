package com.gabriel.CadastroDeHardware.Benchmark;

import com.gabriel.CadastroDeHardware.Hardwares.HardwareModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_benchmarks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BenchmarkModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeSoftware;
    private int fpsMedio;
    private String presetGrafico;
    private Resolucao resolucao;

    @OneToMany(mappedBy = "benchmark")
    private List<HardwareModel> hardwares;

}
