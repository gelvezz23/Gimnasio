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
import modeloDAO.ClasesDAO;
import modeloVO.ClasesVO;
import modeloVO.ClienteVO;

/**
 *
 * @author gelvezz23
 */
public class MysqlClasesDAO implements ClasesDAO{
    String INSERT = "INSERT INTO clase(codigo,clase,horario,cod_instructor)VALUES(?,?,?,?)";
String UPDATE = "UPDATE clase SET codigo=?,clase=?,horario=?,cod_instructor=? WHERE codigo = ?";
String DELETE = "DELETE FROM clase WHERE codigo = ?";
String BUSCAR = "SELECT * FROM clase";
String BUSQUEDA = "SELECT * FROM clase WHERE codigo = ?";

    public MysqlClasesDAO() {
    }


 Connection conn;

    public MysqlClasesDAO(Connection conn) {
        this.conn = conn;
    }
    
     private ClasesVO buscando(ResultSet rs) throws SQLException{
        
         String codigo = rs.getString("codigo");
         String clase = rs.getString("clase");
         String horario = rs.getString("horario");
         String cod_instructor = rs.getString("cod_instructor");
          
          ClasesVO clases = new ClasesVO(codigo, clase, horario, cod_instructor);      
          return clases; 
    }
     
    @Override
    public void insertar(ClasesVO user) {
 
          PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT);
            pst.setString(1, user.getCodigo());
            pst.setString(2, user.getClase());
            pst.setString(3, user.getHorario());
            pst.setString(4, user.getCod_instructor());
           
            
            if(pst.executeUpdate() != 0) {
                System.out.println("Registro Exitoso");
                
            }
            
        } catch (Exception e) {
            System.out.println("Error : "+ e);
        
        }finally{
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    @Override
    public void deshabilitar(ClasesVO user) {
  
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
    public void modificar(ClasesVO user) {
   
        PreparedStatement pst = null;
        
        try {
            pst = conn.prepareStatement(UPDATE);
            pst.setString(1, user.getCodigo());
            pst.setString(2, user.getClase());
            pst.setString(3, user.getHorario());
            pst.setString(4, user.getCod_instructor());
            pst.setString(5, user.getCodigo());
             
            if(pst.executeUpdate() == 0){
                System.out.println("Error");
            } 
             
             
        } catch (Exception e) {
            System.out.println("Error Modificar " + e);
        }
    
    }

    @Override
    public List consultarTodos() {
   
          PreparedStatement pst;
       ResultSet rs= null;
        List<ClasesVO> clases = new ArrayList<>();
        try {
           pst = conn.prepareStatement(BUSCAR);
           rs = pst.executeQuery();
         
           while(rs.next()){
          clases.add(buscando(rs));
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
    return clases;
    }

    @Override
    public ClasesVO buscar(String id) {
   
         PreparedStatement pst;
       ResultSet rs= null;
       ClasesVO clases = null;
        try {
           pst = conn.prepareStatement(BUSQUEDA);
          pst.setString(1, id);
          pst.executeQuery();
          if(rs.next()){
          clases = buscando(rs);
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
       
    return clases;
    
    
    }
   
}
