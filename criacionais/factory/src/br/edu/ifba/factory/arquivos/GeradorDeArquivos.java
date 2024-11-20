package br.edu.ifba.factory.arquivos;

import java.io.File;
import java.io.IOException;

public abstract class GeradorDeArquivos {
    

    public String criar(String nome, String extensao) throws IOException {
        if(!nome.endsWith(extensao)) {
            nome += extensao;
        }

        File arquivo = new File(nome);
        arquivo.createNewFile();

        return arquivo.getAbsolutePath();
    }

    public abstract String criar(String nome) throws IOException;


}