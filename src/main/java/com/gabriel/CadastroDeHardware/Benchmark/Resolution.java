package com.gabriel.CadastroDeHardware.Benchmark;


public enum Resolution {


        HD_720P("1280X720"),
        FULLHD_1080P("1920X1080"),
        QUADHD_1440P("2560X1440"),
        ULTRAHD_4K("3840X2160");


        private final String resolution;

        Resolution(String resolution){
            this.resolution = resolution;
        }

        public String getResolution() {
            return resolution;
        }

}
