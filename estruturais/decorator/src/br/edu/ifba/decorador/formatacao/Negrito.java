package br.edu.ifba.decorador.formatacao;

import br.edu.ifba.decorador.modelo.HiperTexto;

public class Negrito extends DecoradorHiperTexto{
    public Negrito(HiperTexto hiperTexto)    {
        super(hiperTexto);
    }

    public String formatar(){
        return "<br>Texto a ser formatado.</br>";
    }
}
