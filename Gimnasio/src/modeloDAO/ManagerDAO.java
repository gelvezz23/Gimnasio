
package modeloDAO;

import modeloDAO.ClienteDAO;

/**
 *
 * @author gelvezz23
 */
public interface ManagerDAO {
    
    ClienteDAO getClienteDAO();
    
    InstructorDAO getInstructorDAO();
    
    ClasesDAO getClasesDAO();
    
}
