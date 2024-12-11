package br.edu.ifba.observer.bateria;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.observer.modelo.Nobreak;

public class Bateria implements Observavel {
    private List<Observador> observadores = new ArrayList<>();
    private Nobreak nobreak;

    public Bateria(Nobreak nobreak){
        this.nobreak = nobreak;
    }

    public void atualizarCaonsumo(double consumo){
        nobreak.consumirBateria(consumo);
        notificar();
    }


    @Override
    public void adicionarObservador(Observador observador) {
        observadores.add(observador);
    }

    @Override
    public void removerObservador(Observador observador) {
       observadores.remove(observador);
    }

    @Override
    public void notificar() {
        for(Observador observador: observadores){
            observador.atualizar(nobreak);
        }
    }
    
}
