package br.edu.ifba.observer.bateria.atuacoes;

import br.edu.ifba.observer.bateria.Observador;
import br.edu.ifba.observer.modelo.Nobreak;

public class Desligamento implements Observador {

    @Override
    public void atualizar(Nobreak nobreak) {
        if (nobreak.getBateria() <= 5) {
            System.out.println("realizando desligamento das máquinas");
        }
    }
    
}
