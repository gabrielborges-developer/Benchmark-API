package com.gabriel.CadastroDeHardware.Benchmark;

import com.gabriel.CadastroDeHardware.Hardwares.HardwareModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_benchmarks")
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

    public BenchmarkModel(){
    }

    public BenchmarkModel(Long id, String nomeSoftware, String presetGrafico, int fpsMedio, Resolucao resolucao) {
        this.id = id;
        this.nomeSoftware = nomeSoftware;
        this.presetGrafico = presetGrafico;
        this.fpsMedio = fpsMedio;
        this.resolucao = resolucao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeSoftware() {
        return nomeSoftware;
    }

    public void setNomeSoftware(String nomeSoftware) {
        this.nomeSoftware = nomeSoftware;
    }

    public String getPresetGrafico() {
        return presetGrafico;
    }

    public void setPresetGrafico(String presetGrafico) {
        this.presetGrafico = presetGrafico;
    }

    public int getFpsMedio() {
        return fpsMedio;
    }

    public void setFpsMedio(int fpsMedio) {
        this.fpsMedio = fpsMedio;
    }

    public void setResolucao(Resolucao resolucao){
        this.resolucao = resolucao;
    }

    public Resolucao getResolucao(){
        return resolucao;
    }
}
