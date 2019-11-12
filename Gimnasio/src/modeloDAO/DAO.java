/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloDAO;

import java.util.List;

/**
 *
 * @author gelvezz23
 */
public interface DAO<clasesis, tipodat> {
    
     void insertar(clasesis user);
    
    void deshabilitar(clasesis user);
    
    void modificar(clasesis user);
    
    List<clasesis> consultarTodos();
    
    clasesis buscar(tipodat id);
    
    
}
