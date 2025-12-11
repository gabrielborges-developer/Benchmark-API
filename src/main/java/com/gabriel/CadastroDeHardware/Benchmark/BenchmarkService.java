package com.gabriel.CadastroDeHardware.Benchmark;


import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BenchmarkService {

    private final BenchmarkRepository benchmarkRepository;

    BenchmarkService(BenchmarkRepository benchmarkRepository){
        this.benchmarkRepository = benchmarkRepository;
    }

    public BenchmarkEntity createBenchmarkService(BenchmarkEntity benchmarkCreate){
        return benchmarkRepository.save(benchmarkCreate);
    }

    public List<BenchmarkEntity> getAllBenchmarkService(){
        return benchmarkRepository.findAll();
    }

    public  BenchmarkEntity getBenchmarkServiceById(Long benchmarkId){
        Optional<BenchmarkEntity> benchmarkEntityOptional = benchmarkRepository.findById(benchmarkId);
        return benchmarkEntityOptional.orElse(null);
    }

    public BenchmarkEntity updateBenchmarkService(Long id, BenchmarkEntity benchmarkUpdated){
        if(benchmarkRepository.existsById(id)){
            benchmarkUpdated.setId(id);
        return benchmarkRepository.save(benchmarkUpdated);
        }
        return null;
    }

    public void deleteBenchmarkService(Long id){
         benchmarkRepository.deleteById(id);
    }


}
