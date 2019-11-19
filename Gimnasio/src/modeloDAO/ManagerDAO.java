
package modeloDAO;

import modeloDAO.ClienteDAO;
import modeloDAO.InstructorDAO;

/**
 *
 * @author gelvezz23
 */
public interface ManagerDAO {
    
    ClienteDAO getClienteDAO();
    
    InstructorDAO getInstructorDAO();
    
    ClasesDAO getClasesDAO();
    
}
