package br.edu.ifba.fachada.diagnostico.windows;

import br.edu.ifba.fachada.diagnostico.Software;
import java.util.List;

public class SoftwareWin implements Software {

    @Override
    public List<String> getDrivers() {
        List<String> drivers = List.of("Drive 1", "Drive 2", "Drive 3", "Drive 4");

        return drivers;
    }

    @Override
    public List<String> getSoftware() {
        List<String> softwares = List.of("Software 1", "Software 2", "Software 3", "Software 4");

        return  softwares;
    }
    
}
