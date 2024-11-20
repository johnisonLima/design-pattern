package br.edu.ifba.factory;

import br.edu.ifba.factory.fabrica.Fabrica;
import br.edu.ifba.factory.modelo.TipoDeArquivo;

public class App {
    private static final String ARQUIVO = "E:\\MEGAsync\\projectServ\\www\\projetos\\design-pattern\\criacionais\\factory\\documentos\\documento";

    public static void main(String[] args) throws Exception {
        Fabrica fabrica = new Fabrica();
        fabrica.criarArquivo(ARQUIVO, TipoDeArquivo.PDF);
        fabrica.criarArquivo(ARQUIVO, TipoDeArquivo.DOC);
    }
}