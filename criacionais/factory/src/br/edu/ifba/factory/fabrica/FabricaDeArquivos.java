package br.edu.ifba.factory.fabrica;

import java.io.IOException;

public interface FabricaDeArquivos {
    public String criar(String nomeDOArquivo) throws IOException;
}
