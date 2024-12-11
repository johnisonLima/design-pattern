package br.edu.ifba.decorador.formatacao;

import br.edu.ifba.decorador.modelo.HiperTexto;

public class Italico extends DecoradorHiperTexto {
    public Italico(HiperTexto hiperTexto)    {
        super(hiperTexto);
    }

    public String formatar(){
        return "<i>Texto a ser formatado.</i>";
    }
}
