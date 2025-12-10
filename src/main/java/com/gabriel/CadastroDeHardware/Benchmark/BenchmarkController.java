package com.gabriel.CadastroDeHardware.Benchmark;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("benchmark")
public class BenchmarkController {

    @GetMapping("/listar-bench")
    public String listarBenchmark(){
        return "Benchmarks: ";
    }

    @PostMapping("/criar-bench")
    public String criarBenchmark(){
        return "Benchmark criado com sucesso!";
    }

    @PutMapping("/alterar-bench")
    public String alterarBenchmark(){
        return "Benchamark alterado com sucesso!";
    }

    @DeleteMapping("/deletar-bench")
    public String deletarBenchmarkID(){
        return "Benchmark Deletado com sucesso!";
    }

}
