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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Setup criado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SetupDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos fornecidos",
                    content = @Content
            )
    })
    public SetupDTO createSetup(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados do setup a ser criado",
                    required = true,
                    content = @Content(schema = @Schema(implementation = SetupDTO.class))
            )
            @RequestBody SetupDTO setupDto
    ) {
        SetupEntity setupEntityRequest = setupMapper.toEntity(setupDto);
        SetupEntity setupEntityResponse = setupService.createSetupService(setupEntityRequest);
        return setupMapper.toDto(setupEntityResponse);
    }

    @GetMapping
    @Operation(
            summary = "Listar todos os setups",
            description = "Retorna uma lista com todos os setups cadastrados"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista de setups retornada com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SetupDTO.class)
                    )
            )
    })
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Setup encontrado",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SetupDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Setup não encontrado",
                    content = @Content
            )
    })
    public SetupDTO getSetupById(
            @Parameter(description = "ID do setup a ser buscado", required = true, example = "1")
            @PathVariable Long id
    ) {
        SetupEntity setupEntityResponse = setupService.getSetupServiceById(id);
        return setupMapper.toDto(setupEntityResponse);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Atualizar setup",
            description = "Atualiza um setup existente com base no ID fornecido"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Setup atualizado com sucesso",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = SetupDTO.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Setup não encontrado",
                    content = @Content
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Dados inválidos fornecidos",
                    content = @Content
            )
    })
    public SetupDTO updateSetupById(
            @Parameter(description = "ID do setup a ser atualizado", required = true, example = "1")
            @PathVariable Long id,
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "Dados atualizados do setup",
                    required = true,
                    content = @Content(schema = @Schema(implementation = SetupDTO.class))
            )
            @RequestBody SetupDTO setup
    ) {
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
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Setup deletado com sucesso"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Setup não encontrado",
                    content = @Content
            )
    })
    public void deleteSetupById(
            @Parameter(description = "ID do setup a ser deletado", required = true, example = "1")
            @PathVariable Long id
    ) {
        setupService.deleteSetupByIdService(id);
    }
}