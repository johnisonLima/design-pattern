package br.edu.ifba.observer.bateria.atuacoes;

import br.edu.ifba.observer.bateria.Observador;
import br.edu.ifba.observer.modelo.Nobreak;

public class Mensageiro implements Observador {

    @Override
    public void atualizar(Nobreak nobreak) {
        if (nobreak.getBateria() <= 10) {
         System.out.println("Avisando todos os interessados");   
        } else if(nobreak.getBateria() <= 50){
            System.out.println("Avisando o supervisar");
        } else if(nobreak.getBateria() <= 80){
            System.out.println("Avisando o responsavel");
        }
    }
    
}
