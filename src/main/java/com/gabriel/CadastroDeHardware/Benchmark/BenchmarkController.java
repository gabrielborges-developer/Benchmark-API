package com.gabriel.CadastroDeHardware.Benchmark;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("benchmark")
public class BenchmarkController {

    @GetMapping("/listar")
    public String listarBenchmark(){
        return "Benchmarks: ";
    }

    @PostMapping("/criar")
    public String criarBenchmark(){
        return "Benchmark criado com sucesso!";
    }

    @PutMapping("/alterar")
    public String alterarBenchmark(){
        return "Benchamark alterado com sucesso!";
    }

    @DeleteMapping("/deletar")
    public String deletarBenchmark(){
        return "Benchmark Deletado com sucesso!";
    }

}
