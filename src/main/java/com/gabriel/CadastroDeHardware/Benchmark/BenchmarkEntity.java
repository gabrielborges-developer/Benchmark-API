package com.gabriel.CadastroDeHardware.Benchmark;

import com.gabriel.CadastroDeHardware.Hardwares.SetupEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_benchmarks")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BenchmarkEntity {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String softwareName;
    private int fpsAvg;
    private String graphicsPreset;
    private Resolution resolution;

   @ManyToOne
   @JoinColumn(name = "setup_id")
   private SetupEntity setup;

}
