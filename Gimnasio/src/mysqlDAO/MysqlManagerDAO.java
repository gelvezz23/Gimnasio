/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlDAO;

import Servicios.Conexion;
import java.sql.Connection;
import java.util.List;
import modeloDAO.ClasesDAO;
import modeloDAO.ClienteDAO;
import modeloDAO.InstructorDAO;
import modeloDAO.ManagerDAO;
import modeloVO.ClienteVO;

/**
 *
 * @author gelvezz23
 */
public class MysqlManagerDAO implements ManagerDAO {
    
    private Connection conn;
    Conexion conexion = new Conexion();
    
    
    private ClienteDAO cliente = null;
    private InstructorDAO instructor = null;
    private ClasesDAO clases = null;
    
    public MysqlManagerDAO(){
            conn = conexion.getConnection();
}

    @Override
    public ClienteDAO getClienteDAO() {
  if(cliente == null){
      cliente = new MysqlClienteDAO(conn);
  }
          return cliente;
          }

    @Override
    public InstructorDAO getInstructorDAO() {
   if(instructor == null){
       instructor = new MysqlInstructorDAO(conn);
   } 
   return instructor;
    }

    @Override
    public ClasesDAO getClasesDAO() {
   if(clases == null){
       clases = new MysqlClasesDAO(conn);
   }
   return clases; 
        
    }
    
    public static void main(String [] args){
     MysqlManagerDAO man = new MysqlManagerDAO();
     List<ClienteVO> cliente = man.getClienteDAO().consultarTodos();
        System.out.println(cliente);
         }
    
}
