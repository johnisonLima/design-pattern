package br.edu.ifba.decorador.formatacao;

import br.edu.ifba.decorador.modelo.HiperTexto;

public class Tachado extends DecoradorHiperTexto  {
    public Tachado(HiperTexto hiperTexto)    {
        super(hiperTexto);
    }

    public String formatar(){
        return "<del>Texto a ser formatado.</del>";
    }
}
