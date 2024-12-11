package br.edu.ifba.observer.bateria;

public interface Observavel {
    public void adicionarObservador(Observador observador);

    public void removerObservador(Observador observador);

    public void notificar();
}
