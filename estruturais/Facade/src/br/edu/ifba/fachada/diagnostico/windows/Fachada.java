package br.edu.ifba.fachada.diagnostico.windows;

import br.edu.ifba.fachada.diagnostico.Hardware;
import br.edu.ifba.fachada.diagnostico.Software;
import br.edu.ifba.fachada.modelo.Maquina;
import br.edu.ifba.fachada.modelo.TipoSistema;

public class Fachada {
    private Hardware hardware;
    private Software software;

    public void iniciar(TipoSistema tipo) throws Exception{
        if(tipo == TipoSistema.WINDOWS){
            this.hardware = new HardwareWin();
            this.software = new SoftwareWin();
        } else {
            throw new Exception("Sistema operacional não suportado");
        }
    }

    public Maquina diagnosticar(){
        Maquina maquina = new Maquina();

        maquina.setTipo(TipoSistema.WINDOWS);
        maquina.setNumeroDeSerie(hardware.getNumeroDeSerie());
        maquina.setModeloCpu(hardware.getVersaoBios());
        maquina.setTotalMemoria(hardware.getTotalMemoria());
        maquina.setCapacidadeDisco(hardware.getCapacidadeDisco());
        maquina.setDrivers(software.getDrivers());
        maquina.setSoftware(software.getSoftware());

        return maquina;
    }
}
