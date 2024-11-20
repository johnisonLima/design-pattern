package br.edu.ifba.factory.fabrica;

import java.io.IOException;

import br.edu.ifba.factory.arquivos.GeradorDeDocs;

public class FabricaDeDocs implements FabricaDeArquivos {

    @Override
    public String criar(String nomeDOArquivo) throws IOException {
        return new GeradorDeDocs().criar(nomeDOArquivo);
    }
    
}
