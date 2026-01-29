package aaDataAccess.aaDAOs;

import aaDataAccess.Helpers.DataHelperSQLiteDAO;
import aaDataAccess.aaDTOs.aaAccionEventoDTO;
import aaInfrastructure.aaAppException;

public class aaAccionEventoDAO extends DataHelperSQLiteDAO<aaAccionEventoDTO> {

    public aaAccionEventoDAO() throws aaAppException {
        super(aaAccionEventoDTO.class, "aaAccionEvento", "aaIdEvento");
    }
    
    // El método create(T entity) del genérico ya se encarga de insertar los logs
}
