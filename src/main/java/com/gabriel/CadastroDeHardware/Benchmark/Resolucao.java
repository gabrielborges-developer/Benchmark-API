package com.gabriel.CadastroDeHardware.Benchmark;

public enum Resolucao {

    HD_720P("1280X720"),
    FULLHD_1080P("1920X1080"),
    QUADHD_1440P("2560X1440"),
    ULTRAHD_4K("3840X2160");


    private final String resolucao;

    Resolucao(String resolucao){
        this.resolucao = resolucao;
    }

    public String getResolucao() {
        return resolucao;
    }
}
