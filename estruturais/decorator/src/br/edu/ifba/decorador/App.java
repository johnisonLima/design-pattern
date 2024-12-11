package br.edu.ifba.decorador;

import br.edu.ifba.decorador.formatacao.Italico;
import br.edu.ifba.decorador.formatacao.Negrito;
import br.edu.ifba.decorador.formatacao.Tachado;
import br.edu.ifba.decorador.modelo.HiperTexto;
import br.edu.ifba.decorador.modelo.Texto;

public class App {
    public static void main(String[] args) throws Exception {
        HiperTexto texto = new Texto("Texto a ser formatado");

        System.out.println(texto.formatar());

        texto = new Negrito(texto);
        System.out.println(texto.formatar());

        texto = new Italico(texto);
        System.out.println(texto.formatar());

        texto = new Tachado(texto);
        System.out.println(texto.formatar());
    }
}
