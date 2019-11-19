/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysqlDAO;

import Servicios.Conexion;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modeloDAO.ClienteDAO;
import modeloVO.ClienteVO;

/**
 *
 * @author gelvezz23
 */
public class MysqlClienteDAO implements ClienteDAO{
String INSERT = "INSERT INTO cliente(cedula,nombre,apellido,direccion,telefono,fecha)VALUES(?,?,?,?,?,?)";
String UPDATE = "UPDATE cliente SET cedula=?,nombre=?,apellido=?,direccion=?,telefono=?,fecha=? WHERE cedula = ?";
String DELETE = "DELETE FROM cliente WHERE cedula = ?";
String BUSCAR = "SELECT cedula,nombre,apellido,direccion,telefono,fecha FROM cliente";
String BUSQUEDA = "SELECT cedula,nombre,apellido,direccion,telefono,fecha FROM cliente WHERE cedula = ?";

    Connection conn;

    public MysqlClienteDAO() {
    }

    public MysqlClienteDAO(Connection conn) {
        this.conn = conn;
    }
     private ClienteVO buscando(ResultSet rs) throws SQLException{
        
          int cedula = rs.getInt("cedula");
          String nombre = rs.getString("nombre");
          String apellido = rs.getString("apellido");
          String direccion = rs.getString("direccion");
          String telefono = rs.getString("telefono");
          Date fecha = rs.getDate("fecha");
         // System.out.println(cedula+" -- "+nombre+" -- "+apellido+" -- "+direccion+" -- "+telefono+" -- "+fecha);
          ClienteVO cliente = new ClienteVO(nombre, apellido, String.valueOf(cedula), direccion, telefono, fecha);      
        
          return cliente; 
          
    }
    
    @Override
    public void insertar(ClienteVO user) {
  
        PreparedStatement pst;
        try {
            pst = conn.prepareStatement(INSERT);
            pst.setString(1, user.getCedula());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getDireccion());
            pst.setString(5, user.getTelefono());
            pst.setDate(6,  new Date(user.getFechaIngreso().getTime()));
            
            if(pst.executeUpdate() != 0) {
                System.out.println("Registro Exitoso");
                
            }
            
        } catch (SQLException e) {
            System.out.println("Error------: "+ e);
        
        }
    }

    @Override
    public void deshabilitar(ClienteVO user) {
 PreparedStatement pst=null;
 
        try {
            pst = conn.prepareStatement(DELETE);
            pst.setString(1, user.getCedula());
            if(pst.executeUpdate() == 0){
                    System.out.println("eliminado");
            }
        } catch (SQLException e) {
            System.out.println("Error Elimiar " + e);
        }
        
    }

    @Override
    public void modificar(ClienteVO user) {
        PreparedStatement pst = null;
        
        try {
            pst = conn.prepareStatement(UPDATE);
            pst.setString(1, user.getCedula());
            pst.setString(2, user.getNombre());
            pst.setString(3, user.getApellido());
            pst.setString(4, user.getDireccion());
            pst.setString(5, user.getTelefono());
            pst.setDate(6, new Date(user.getFechaIngreso().getTime()));
            pst.setString(7, user.getCedula());
             
            if(pst.executeUpdate() == 0){
                System.out.println("Error modificar ");
            }else{
                System.out.println("Modificado");
            } 
             
             
        } catch (SQLException e) {
            System.out.println("Error Modificar " + e);
        }
 
    }

    
    
    @Override
    public List<ClienteVO> consultarTodos() {
          PreparedStatement pst =null;
       ResultSet rs= null;
        List<ClienteVO> cliente = new ArrayList<>();
        try {
           pst = conn.prepareStatement(BUSCAR);
           rs = pst.executeQuery();
          while(rs.next()){
              
          cliente.add(buscando(rs));
             
          }
          
        } catch (SQLException e) {
            System.out.println("error buscar todos" + e);
        }finally{
        if(rs != null){
            try { 
                rs.close();
            } catch (SQLException ex) {
            Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
        if(rs == null){ 
        try {
            rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            if(pst != null ){
                try {
                    pst.close();
                } catch (SQLException ex) {
                    Logger.getLogger(MysqlClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            }
        }
            
        }
        
       return cliente;
           
        
   }

   
    
    @Override
    public ClienteVO buscar(String id) {
       PreparedStatement pst;
       ResultSet rs= null;
       ClienteVO cliente = null;
        try {
           pst = conn.prepareStatement(BUSQUEDA);
          pst.setString(1, id);
          rs = pst.executeQuery();
          if(rs.next()){
          cliente = buscando(rs);
          }
          
        } catch (SQLException e) {
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
       
    return cliente;
    }
    
   

    
    
}
