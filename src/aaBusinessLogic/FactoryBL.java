//  © 2K26 ❱──💀──❰ pat_mic ? code is life : life is code
package aaBusinessLogic;

import aaDataAccess.Interfaces.IDAO;
import aaInfrastructure.aaAppException;
import java.util.List;

public class FactoryBL<T>  {
    private final IDAO<T> oDAO;

    public FactoryBL(Class<? extends IDAO<T>> classDAO) {
        try {
            this.oDAO = classDAO.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            aaAppException er = new aaAppException("Error al instanciar classDAO<T>", e, getClass(), "FactoryBL(...)");
            throw new RuntimeException(er);
        }
    }

    // Constructor que usa un Supplier para crear la instancia de T
    // public FactoryBL(Supplier<IDAO<T>> supplier) {
    //     this.oDAO = supplier.get(); 
    // }
 
    public List<T> getAll() throws aaAppException {
         return oDAO.readAll();
    }

    public T getBy(Integer id) throws aaAppException {
        return oDAO.readBy(id);
    }

    public boolean add(T oT) throws aaAppException {
        return oDAO.create(oT);
    }

    public boolean upd(T oT) throws aaAppException {
        return oDAO.update(oT);
    }

    public boolean del(Integer id) throws aaAppException {
        return oDAO.delete(id);
    }
}
