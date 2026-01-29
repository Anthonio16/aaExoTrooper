package aaDataAccess.aaDAOs;

import aaDataAccess.Helpers.DataHelperSQLiteDAO;
import aaDataAccess.aaDTOs.aaUsuarioDTO;
import aaInfrastructure.aaAppException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class aaUsuarioDAO extends DataHelperSQLiteDAO<aaUsuarioDTO> {

    public aaUsuarioDAO() throws aaAppException {
        // Asociamos el DTO con la tabla 'aaUsuario' y su PK 'aaIdUsuario'
        super(aaUsuarioDTO.class, "aaUsuario", "aaIdUsuario");
    }

    public aaUsuarioDTO login(String usuario, String clave) throws aaAppException {
        String sql = String.format("SELECT * FROM %s WHERE aaUsuario = ? AND aaClave = ? AND Estado = 'A'", tableName);
        try (PreparedStatement stmt = openConnection().prepareStatement(sql)) {
            stmt.setString(1, usuario);
            stmt.setString(2, clave);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToEntity(rs);
                }
            }
        } catch (SQLException e) {
            throw new aaAppException("Error al validar credenciales", e, getClass(), "login");
        }
        return null;
    }
}
