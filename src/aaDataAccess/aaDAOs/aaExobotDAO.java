package aaDataAccess.aaDAOs;

import aaDataAccess.Helpers.DataHelperSQLiteDAO;
import aaDataAccess.aaDTOs.aaExobotDTO;
import aaInfrastructure.aaAppException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class aaExobotDAO extends DataHelperSQLiteDAO<aaExobotDTO> {

    public aaExobotDAO() throws aaAppException {
        super(aaExobotDTO.class, "aaExobot", "aaIdExobot");
    }

    // PUNTO EXTRA: Método para filtrar por TipoExobot
    public List<aaExobotDTO> readByTipo(String tipo) throws aaAppException {
        String sql = String.format("SELECT * FROM %s WHERE aaTipoExobot = ? AND Estado = 'A'", tableName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, tipo);
            try (ResultSet rs = stmt.executeQuery()) {
                return mapResultSetToEntityList(rs);
            }
        } catch (SQLException e) {
            throw new aaAppException("Error al filtrar exobots", e, getClass(), "readByTipo");
        }
    }
}
