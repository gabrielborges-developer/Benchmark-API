package com.gabriel.CadastroDeHardware.Benchmark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.CadastroDeHardware.Setup.SetupEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_benchmarks")
@AllArgsConstructor
@Data
public class BenchmarkEntity {

    public BenchmarkEntity(){}

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String softwareName;
    private int fpsAvg;
    private String graphicsPreset;
    private Resolution resolution;

   @ManyToOne
   @JoinColumn(name = "setup_id")
   @JsonIgnore
   private SetupEntity setup;

}
