package br.edu.ifba.fachada.modelo;

import java.util.List;

public class Maquina {
    private TipoSistema tipo;
    private String numeroDeSerie;
    private String modeloCpu;
    private String versaoBios;
    private int totalMemoria;
    private int capacidadeDisco;
    private List<String> drivers;
    private List<String> software;
    
    public TipoSistema getTipo() {
        return tipo;
    }
    public void setTipo(TipoSistema tipo) {
        this.tipo = tipo;
    }
    public String getNumeroDeSerie() {
        return numeroDeSerie;
    }
    public void setNumeroDeSerie(String numeroDeSerie) {
        this.numeroDeSerie = numeroDeSerie;
    }
    public String getModeloCpu() {
        return modeloCpu;
    }
    public void setModeloCpu(String modeloCpu) {
        this.modeloCpu = modeloCpu;
    }
    public String getVersaoBios() {
        return versaoBios;
    }
    public void setVersaoBios(String versaoBios) {
        this.versaoBios = versaoBios;
    }
    public int getTotalMemoria() {
        return totalMemoria;
    }
    public void setTotalMemoria(int totalMemoria) {
        this.totalMemoria = totalMemoria;
    }
    public int getCapacidadeDisco() {
        return capacidadeDisco;
    }
    public void setCapacidadeDisco(int capacidadeDisco) {
        this.capacidadeDisco = capacidadeDisco;
    }
    public List<String> getDrivers() {
        return drivers;
    }
    public void setDrivers(List<String> drivers) {
        this.drivers = drivers;
    }
    public List<String> getSoftware() {
        return software;
    }
    public void setSoftware(List<String> software) {
        this.software = software;
    }
}
