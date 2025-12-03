package com.gabriel.CadastroDeHardware;

public enum TipoHardware {

    GPU("Placa de Vídeo (GPU)"),
    CPU("Processador (CPU)"),
    ARMAZENAMENTO("SSD/HD"),
    GABINETE("Gabinete"),
    FONTE("Fonte de Alimentação"),
    PLACA_MAE("Placa Mãe"),
    MEMORIA_RAM("Memória RAM");

    private final String descricao;

    TipoHardware(String descricao){
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
