package com.gabriel.CadastroDeHardware.Benchmark;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.CadastroDeHardware.Setup.SetupEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_benchmarks")
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

    public BenchmarkEntity(){}

    public BenchmarkEntity(Long id, int fpsAvg, String softwareName, Resolution resolution, String graphicsPreset, SetupEntity setup) {
        this.id = id;
        this.fpsAvg = fpsAvg;
        this.softwareName = softwareName;
        this.resolution = resolution;
        this.graphicsPreset = graphicsPreset;
        this.setup = setup;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGraphicsPreset() {
        return graphicsPreset;
    }

    public void setGraphicsPreset(String graphicsPreset) {
        this.graphicsPreset = graphicsPreset;
    }

    public SetupEntity getSetup() {
        return setup;
    }

    public void setSetup(SetupEntity setup) {
        this.setup = setup;
    }

    public Resolution getResolution() {
        return resolution;
    }

    public void setResolution(Resolution resolution) {
        this.resolution = resolution;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName;
    }

    public int getFpsAvg() {
        return fpsAvg;
    }

    public void setFpsAvg(int fpsAvg) {
        this.fpsAvg = fpsAvg;
    }


}
