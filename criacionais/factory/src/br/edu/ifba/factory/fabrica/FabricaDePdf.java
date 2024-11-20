package br.edu.ifba.factory.fabrica;

import java.io.IOException;

import br.edu.ifba.factory.arquivos.GeradorDePdfs;

public class FabricaDePdf implements FabricaDeArquivos {
    @Override
    public String criar(String nomeDOArquivo) throws IOException {
        return new GeradorDePdfs().criar(nomeDOArquivo);
    }
    
}