package br.edu.ifba.singleton.arquivos;

import java.io.File;
import java.io.IOException;

import br.edu.ifba.singleton.modelos.TipoDeArquivo;
import br.edu.ifba.singleton.modelos.NaoImplementado;

public class GeradorDeArquivos {
    private static GeradorDeArquivos instancia = null;

    public static GeradorDeArquivos getInstancia(){
        if(instancia == null){
            instancia = new GeradorDeArquivos();
        }

        return instancia;
    }

    private GeradorDeArquivos(){}

    public void iniciar(){
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String criar(String nomeDoArquivo, TipoDeArquivo tipo) throws IOException, NaoImplementado{
        String novoArquivo = "";

        if(tipo == TipoDeArquivo.PDF){
            novoArquivo = criarPDF(nomeDoArquivo);
        }else if(tipo == TipoDeArquivo.DOC){
            novoArquivo = criarDOC(nomeDoArquivo);
        }else{
            throw new NaoImplementado();
        }
        
        return novoArquivo;
    }

    private String criar(String nomeDoArquivo, String extensao) throws IOException{
        if(!nomeDoArquivo.endsWith(extensao)){
            nomeDoArquivo += extensao;
        }

        File arquivo = new File(nomeDoArquivo);
        arquivo.createNewFile();

        return arquivo.getAbsolutePath();
    }

    private String criarPDF(String nomeDoArquivo) throws IOException{
        return criar(nomeDoArquivo, ".pdf");
    }

    private String criarDOC(String nomeDoArquivo) throws IOException{
        return criar(nomeDoArquivo, "doc");
    }
    
}