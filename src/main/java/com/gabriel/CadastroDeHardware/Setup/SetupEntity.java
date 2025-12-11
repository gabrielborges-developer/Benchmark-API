package com.gabriel.CadastroDeHardware.Setup;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gabriel.CadastroDeHardware.Benchmark.BenchmarkEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "tb_setup")

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
    @JsonIgnore
    private List<BenchmarkEntity> benchmarkEntityList;


    public SetupEntity() {}

    public SetupEntity(Long id, String processor, String videoCard, String motherBoard, String memory, double price, List<BenchmarkEntity> benchmarkEntityList) {
        this.id = id;
        this.processor = processor;
        this.videoCard = videoCard;
        this.motherBoard = motherBoard;
        this.memory = memory;
        this.price = price;
        this.benchmarkEntityList = benchmarkEntityList;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getVideoCard() {
        return videoCard;
    }

    public void setVideoCard(String videoCard) {
        this.videoCard = videoCard;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getMotherBoard() {
        return motherBoard;
    }

    public void setMotherBoard(String motherBoard) {
        this.motherBoard = motherBoard;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<BenchmarkEntity> getBenchmarkEntityList() {
        return benchmarkEntityList;
    }

    public void setBenchmarkEntityList(List<BenchmarkEntity> benchmarkEntityList) {
        this.benchmarkEntityList = benchmarkEntityList;
    }



}


