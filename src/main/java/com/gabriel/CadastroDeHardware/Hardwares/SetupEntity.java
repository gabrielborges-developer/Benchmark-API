package com.gabriel.CadastroDeHardware.Hardwares;

import com.gabriel.CadastroDeHardware.Benchmark.BenchmarkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_computer_configs")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SetupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String processor;
    private String videoCard;
    private String memory;
    private String motherBoard;
    private double price;



    @OneToMany(mappedBy = "setup")
    private List<BenchmarkEntity> benchmarkEntityList;



}


