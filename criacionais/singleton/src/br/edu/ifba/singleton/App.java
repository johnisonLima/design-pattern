package br.edu.ifba.singleton;

import br.edu.ifba.singleton.arquivos.GeradorDeArquivos;
import br.edu.ifba.singleton.modelos.TipoDeArquivo;

public class App {
    private static final String ARQUIVO = "E:\\MEGAsync\\projectServ\\www\\projetos\\design-pattern\\criacionais\\singleton\\documentos\\documento";
    
    public static void main(String[] args) throws Exception {
        String arquivo = GeradorDeArquivos.getInstancia().criar(ARQUIVO, TipoDeArquivo.PDF);

        System.out.println("Nome do arquivo" + arquivo);
    }
}
