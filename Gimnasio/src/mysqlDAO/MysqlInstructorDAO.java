/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloDAO.InstructorDAO;
import modeloVO.ClienteVO;
import modeloVO.InstructorVO;

/**
 *
 * @author gelvezz23
 */
public class MysqlInstructorDAO implements InstructorDAO{

String INSERT = "INSERT INTO instructor(codigo,nombre,apellido,telefono,especialidad,jornada,hora)VALUES(?,?,?,?,?,?,?)";
String UPDATE = "UPDATE instructor SET codigo=?,nombre=?,apellido=?,telefono=?,especialidad=?,jornada=?,hora=? WHERE codigo = ?";
String DELETE = "DELETE FROM instructor WHERE codigo = ?";
String BUSCAR = "SELECT * FROM instructor";
String BUSQUEDA = "SELECT * FROM instructor WHERE codigo = ?";

    public MysqlInstructorDAO() {
    }
    

Connection conn;

    public MysqlInstructorDAO(Connection conn) {
        this.conn = conn;
    }
    
     private InstructorVO buscando(ResultSet rs) throws SQLException{
        
          String codigo = rs.getString("codigo");
          String nombre = rs.getString("nombre");
          String apellido = rs.getString("apellido");
          String telefono = rs.getString("telefono");
          String especialidad = rs.getString("especialidad");
          String jornada = rs.getString("jornada");
          String hora = rs.getString("hora");
          
          InstructorVO instructor = new InstructorVO(codigo, nombre, apellido, telefono, especialidad, jornada, hora);      
          return instructor; 
    }
    
    @Override
    public void insertar(InstructorVO user) {
  
          PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT);
            pst.setString(1, user.getCodigo());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getTelefono());
            pst.setString(5, user.getEspecialidad());
            pst.setString(6,  user.getJornada());
            pst.setString(7, user.getHora());
            
            if(pst.executeUpdate() != 0) {
                System.out.println("Registro Exitoso");                
            }
            
        } catch (Exception e) {
            System.out.println("Error : "+ e);
        
        }finally{
                 
        }    
    }

    @Override
    public void deshabilitar(InstructorVO user) {
  
    PreparedStatement pst=null;
 
        try {
            pst = conn.prepareStatement(DELETE);
            pst.setString(1, user.getCodigo());
            if(pst.executeUpdate() == 0){
                    System.out.println("eliminado");
            }
        } catch (Exception e) {
            System.out.println("Error Elimiar " + e);
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void modificar(InstructorVO user) {
    PreparedStatement pst = null;
        
        try {
            pst = conn.prepareStatement(UPDATE);
            pst.setString(1, user.getCodigo());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getTelefono());
            pst.setString(5, user.getEspecialidad());
            pst.setString(6, user.getJornada());
            pst.setString(7, user.getHora());
            pst.setString(8, user.getCodigo());
             
             if(pst.executeUpdate() == 0){
                System.out.println("Error modificar ");
            }else{
                System.out.println("Modificado");
            }  
             
        } catch (Exception e) {
            System.out.println("Error Modificar " + e);
        }
    }

    @Override
    public List consultarTodos() {
   
      PreparedStatement pst;
       ResultSet rs= null;
        List<InstructorVO> instructor = new ArrayList<>();
        try {
           pst = conn.prepareStatement(BUSCAR);
           rs = pst.executeQuery();
          while(rs.next()){
          instructor.add(buscando(rs));
          }
          
        } catch (Exception e) {
            System.out.println("error buscar todos" + e);
        }finally{
        if(rs != null){
            try { 
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
       
        }
        return instructor;
    }

    @Override
    public InstructorVO buscar(String id) {
  PreparedStatement pst;
       ResultSet rs= null;
       InstructorVO instructor = null;
        try {
           pst = conn.prepareStatement(BUSQUEDA);
          pst.setString(1, id);
          pst.executeQuery();
          if(rs.next()){
          instructor = buscando(rs);
          }
          
        } catch (Exception e) {
            System.out.println("error busqueda" + e);
        }finally{
        if(rs != null){
            try { 
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            
        }
       
    return instructor;
    }
    
    
    
}
