package br.edu.ifba.observer.modelo;

public class Nobreak {
    private double bateria = 100.0;

    public Nobreak(double bateria){
        this.bateria = bateria;
    }

    public double getBateria(){
        return bateria;
    }

    public void consumirBateria(double consumo){
        bateria -= consumo;
    }
}
