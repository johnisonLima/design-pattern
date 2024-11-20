package br.edu.ifba.factory.fabrica;

import java.io.IOException;

import br.edu.ifba.factory.modelo.NaoImplementado;
import br.edu.ifba.factory.modelo.TipoDeArquivo;

public class Fabrica {
    public String criarArquivo(String nome, TipoDeArquivo tipo) throws NaoImplementado, IOException {
        FabricaDeArquivos fabrica = null;

        if(tipo == TipoDeArquivo.PDF) {
            fabrica = new FabricaDePdf();
        } else if (tipo == TipoDeArquivo.DOC) {
            fabrica = new FabricaDeDocs();
        } else {
            throw new NaoImplementado();
        }

        return fabrica.criar(nome);
    }
}