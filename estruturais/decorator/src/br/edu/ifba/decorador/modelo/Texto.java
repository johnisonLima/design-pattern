package br.edu.ifba.decorador.modelo;

public class Texto implements HiperTexto{
    private  String texto;
    
    public Texto(String texto){
        this.texto = texto;
    }

    @Override
    public String formatar(){
        return texto;
    }
}
