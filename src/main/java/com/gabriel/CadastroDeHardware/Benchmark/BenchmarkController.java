package com.gabriel.CadastroDeHardware.Benchmark;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benchs")
public class BenchmarkController {

    private final BenchmarkService benchmarkService;

    public BenchmarkController(BenchmarkService benchmarkService){
        this.benchmarkService = benchmarkService;
    }

    @GetMapping
    public List<BenchmarkEntity> getAllBenchmark(){
        return benchmarkService.getAllBenchmarkService();
    }

    @GetMapping("/{id}")
    public BenchmarkEntity getBenchmarkById(@PathVariable Long id){
        return benchmarkService.getBenchmarkServiceById(id);
    }

    @PostMapping
    public BenchmarkEntity createBenchmark(@RequestBody BenchmarkEntity benchmarkCreate){
        return benchmarkService.createBenchmarkService(benchmarkCreate);
    }

    @PutMapping("{id}")
    public BenchmarkEntity updateBenchmark (@PathVariable Long id,@RequestBody BenchmarkEntity benchmarkUpdate){
        return benchmarkService.updateBenchmarkService(id,benchmarkUpdate);
    }

    @DeleteMapping("/{id}")
    public void deleteBencharkById(@PathVariable Long id){
         benchmarkService.deleteBenchmarkService(id);
    }

}
