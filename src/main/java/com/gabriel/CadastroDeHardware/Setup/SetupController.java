package com.gabriel.CadastroDeHardware.Setup;

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
@RequestMapping("/setups")
@Tag(name = "Setup", description = "API para gerenciamento de configurações de hardware")
public class SetupController {

    private final SetupService setupService;
    private final SetupMapper setupMapper;

    public SetupController(SetupService setupService, SetupMapper setupMapper) {
        this.setupService = setupService;
        this.setupMapper = setupMapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Criar novo setup",
            description = "Cria uma nova configuração de hardware com processador, placa de vídeo, memória, etc."
    )
    public SetupDTO createSetup(@RequestBody SetupDTO setupDto) {
        SetupEntity setupEntityRequest = setupMapper.toEntity(setupDto);
        SetupEntity setupEntityResponse = setupService.createSetupService(setupEntityRequest);
        return setupMapper.toDto(setupEntityResponse);
    }

    @GetMapping
    @Operation(
            summary = "Listar todos os setups",
            description = "Retorna uma lista com todos os setups cadastrados"
    )
    public List<SetupDTO> getAllSetups() {
        List<SetupEntity> entities = setupService.getAllSetupService();
        return entities.stream()
                .map(setupMapper::toDto)
                .toList();
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar setup por ID",
            description = "Retorna um setup específico baseado no ID fornecido"
    )
    public SetupDTO getSetupById(@PathVariable Long id) {
        SetupEntity setupEntityResponse = setupService.getSetupServiceById(id);
        return setupMapper.toDto(setupEntityResponse);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar setup",
            description = "Atualiza um setup existente com base no ID fornecido"
    )
    public SetupDTO updateSetupById(@PathVariable Long id, @RequestBody SetupDTO setup) {
        SetupEntity setupEntityRequest = setupMapper.toEntity(setup);
        SetupEntity entitySetupResponse = setupService.updateSetupServiceById(id, setupEntityRequest);
        return setupMapper.toDto(entitySetupResponse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Deletar setup",
            description = "Remove um setup do sistema baseado no ID fornecido"
    )
    public void deleteSetupById(@PathVariable Long id) {
        setupService.deleteSetupByIdService(id);
    }
}