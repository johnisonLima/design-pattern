package br.edu.ifba.observer;

import br.edu.ifba.observer.bateria.Bateria;
import br.edu.ifba.observer.bateria.atuacoes.Desligamento;
import br.edu.ifba.observer.bateria.atuacoes.Mensageiro;
import br.edu.ifba.observer.modelo.Nobreak;

public class App {
    public static void main(String[] args) throws Exception {
        Nobreak nobreak = new Nobreak(100.0);
        Bateria bateria = new Bateria(nobreak);

        bateria.adicionarObservador(new Mensageiro());
        bateria.adicionarObservador(new Desligamento());

        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(10);
        bateria.atualizarCaonsumo(30);
    }
}
