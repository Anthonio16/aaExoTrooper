package aaDataAccess.Interfaces;

import java.util.List;

import aaInfrastructure.aaAppException;

public interface IDAO<T> {
    List<T> readAll()            throws aaAppException;
    T       readBy (Integer id)  throws aaAppException;
    boolean create (T entity)    throws aaAppException;
    boolean update (T entity)    throws aaAppException;
    boolean delete (Integer id)  throws aaAppException;
    Integer getMaxReg()          throws aaAppException;
}
