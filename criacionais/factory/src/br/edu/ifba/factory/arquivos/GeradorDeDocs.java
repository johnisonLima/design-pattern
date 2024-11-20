package br.edu.ifba.factory.arquivos;

import java.io.IOException;

public class GeradorDeDocs extends GeradorDeArquivos{

    @Override
    public String criar(String nome) throws IOException {
        return super.criar(nome, ".doc");
    }
    
}
