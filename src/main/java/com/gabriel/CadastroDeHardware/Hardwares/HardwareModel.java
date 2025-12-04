package com.gabriel.CadastroDeHardware.Hardwares;

import com.gabriel.CadastroDeHardware.Benchmark.BenchmarkModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_hardware")
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


    public HardwareModel() {
    }

    public HardwareModel(String modelo, String marca, double preco, TipoHardware tipo){
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.tipo = tipo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public TipoHardware getTipo() {
        return tipo;
    }

    public void setTipo(TipoHardware tipo) {
        this.tipo = tipo;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}


