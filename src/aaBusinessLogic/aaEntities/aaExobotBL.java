package aaBusinessLogic.aaEntities;

import aaBusinessLogic.FactoryBL;
import aaDataAccess.aaDAOs.aaExobotDAO;
import aaDataAccess.aaDTOs.aaExobotDTO; // Importante: usar el DTO
import aaInfrastructure.aaAppException;
import java.util.List;

public class aaExobotBL {
    private FactoryBL<aaExobotDTO> aaFactory;

    public aaExobotBL() {
        this.aaFactory = new FactoryBL<>(aaExobotDAO.class);
    }

    public List<aaExobotDTO> aaLeerTodo() throws aaAppException {
        return aaFactory.getAll();
    }

    public boolean aaEntrenar(aaExobotDTO aaDto) throws aaAppException {
        aaDto.setAaEntreno("SI");
        System.out.println("GOOD: Soldado Experto Laser/Bayoneta entrenar"); 
        return aaFactory.upd(aaDto); 
    }

    public String aaEjecutarDisparo(aaExobotDTO aaDto) throws aaAppException {
        aaDto.setAaNoAccion(aaDto.getAaNoAccion() + 1);
        aaFactory.upd(aaDto);
        String aaMunicion = "Energía Laser"; 
        return "GOOD: Laser/Bayoneta disparar " + aaMunicion; 
    }

    public List<aaExobotDTO> aaBuscarPorTipo(String aaTipo) throws aaAppException {
        aaExobotDAO aaDao = new aaExobotDAO(); 
        return aaDao.readByTipo(aaTipo);
    }
    
}
