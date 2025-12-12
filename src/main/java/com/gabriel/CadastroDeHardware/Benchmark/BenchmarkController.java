package com.gabriel.CadastroDeHardware.Benchmark;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benchs")
@Tag(name = "Benchmark", description = "API para gerenciamento de benchmarks de hardware")
public class BenchmarkController {

    private final BenchmarkService benchmarkService;
    private final BenchmarkMapper benchmarkMapper;

    public BenchmarkController(BenchmarkService benchmarkService, BenchmarkMapper benchmarkMapper) {
        this.benchmarkService = benchmarkService;
        this.benchmarkMapper = benchmarkMapper;
    }

    @GetMapping
    @Operation(
            summary = "Listar todos os benchmarks",
            description = "Retorna uma lista com todos os benchmarks cadastrados"
    )
    public List<BenchmarkDTO> getAllBenchmark() {
        List<BenchmarkEntity> entities = benchmarkService.getAllBenchmarkService();
        return entities.stream()
                .map(benchmarkMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar benchmark por ID",
            description = "Retorna um benchmark específico baseado no ID fornecido"
    )
    public BenchmarkDTO getBenchmarkById(@PathVariable Long id) {
        BenchmarkEntity entity = benchmarkService.getBenchmarkServiceById(id);
        return benchmarkMapper.toDto(entity);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Criar novo benchmark",
            description = "Cria um novo registro de benchmark no sistema"
    )
    public BenchmarkDTO createBenchmark(@RequestBody BenchmarkDTO benchmarkDto) {
        BenchmarkEntity entity = benchmarkMapper.toEntity(benchmarkDto);
        BenchmarkEntity saved = benchmarkService.createBenchmarkService(entity);
        return benchmarkMapper.toDto(saved);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar benchmark",
            description = "Atualiza um benchmark existente com base no ID fornecido"
    )
    public BenchmarkDTO updateBenchmark(@PathVariable Long id, @RequestBody BenchmarkDTO benchmarkDTO) {
        BenchmarkEntity entity = benchmarkMapper.toEntity(benchmarkDTO);
        BenchmarkEntity updated = benchmarkService.updateBenchmarkService(id, entity);
        return benchmarkMapper.toDto(updated);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Deletar benchmark",
            description = "Remove um benchmark do sistema baseado no ID fornecido"
    )
    public void deleteBenchmarkById(@PathVariable Long id) {
        benchmarkService.deleteBenchmarkService(id);
    }
}