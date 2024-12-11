package br.edu.ifba.fachada.diagnostico.windows;

import br.edu.ifba.fachada.diagnostico.Hardware;
import java.util.Random;

public class HardwareWin implements Hardware {

    @Override
    public String getNumeroDeSerie() {
        Random random = new Random();

        return random.nextInt(Integer.MAX_VALUE) + "";
        
    }

    @Override
    public String getModelCpu() {
        return "Intel Core i7 1230k";
    }

    @Override
    public String getVersaoBios() {
        return "v1.0";
    }

    @Override
    public int getTotalMemoria() {
        return 16;
    }

    @Override
    public int getCapacidadeDisco() {
        return 500;
    }
    
}
