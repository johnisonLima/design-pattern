package br.edu.ifba.fachada;

import br.edu.ifba.fachada.diagnostico.windows.Fachada;
import br.edu.ifba.fachada.modelo.Maquina;
import br.edu.ifba.fachada.modelo.TipoSistema;

public class App {

    private static final int TOTAL_DE_MAQUINAS_PARA_PRODUZIR = 20;

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < TOTAL_DE_MAQUINAS_PARA_PRODUZIR; i++) {
            Fachada fachada = new Fachada();
            fachada.iniciar(TipoSistema.WINDOWS);

            Maquina maquina = fachada.diagnosticar();
            System.out.println("Máquina produzida: " + maquina.getNumeroDeSerie());
        }
    }
}
