package br.edu.ifba.decorador.formatacao;

import br.edu.ifba.decorador.modelo.HiperTexto;

public class DecoradorHiperTexto implements HiperTexto  {
    protected HiperTexto hiperTexto;

    public DecoradorHiperTexto(HiperTexto hiperTexto){
        this.hiperTexto = hiperTexto;
    }

    @Override
    public String formatar(){
        return hiperTexto.formatar();
    }    
}
