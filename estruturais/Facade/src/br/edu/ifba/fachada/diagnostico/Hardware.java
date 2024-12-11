package br.edu.ifba.fachada.diagnostico;

public interface  Hardware {
    public String getNumeroDeSerie();

    public String getModelCpu();

    public String getVersaoBios();

    public int getTotalMemoria();

    public int getCapacidadeDisco();
}
