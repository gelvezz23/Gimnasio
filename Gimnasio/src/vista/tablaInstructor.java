/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import modeloDAO.InstructorDAO;
import modeloVO.ClienteVO;
import modeloVO.InstructorVO;

/**
 *
 * @author gelvezz23
 */
public class tablaInstructor extends AbstractTableModel{
    
     private InstructorDAO instructor;
    List<InstructorVO> dataInstructor = new ArrayList<>();
    

    public tablaInstructor(InstructorDAO instructor) {
        this.instructor = instructor;
    }
    
    public void updateModel(){
        dataInstructor = instructor.consultarTodos();
    }

    @Override
    public String getColumnName(int column) {
            switch(column){
                
                case 0 : return "Codigo";
                case 1 : return "Nombre";
                case 2 : return "Apellido";
                case 3 : return "Telefono";
                case 4 : return "Especialidad";
                case 5 : return "Jornada";
                default: return "Hora";
            
            }
    }

    @Override
    public int getRowCount() {
        return dataInstructor.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        InstructorVO instructor = dataInstructor.get(rowIndex);
        switch(columnIndex){
            case 0 : return instructor.getCodigo();
            case 1 : return instructor.getNombre();
            case 2 : return instructor.getApellido();
            case 3 : return instructor.getTelefono();
            case 4 : return instructor.getEspecialidad();
            case 5 : return instructor.getJornada();
            default : return instructor.getHora();
                    
        
        }
    
    }
    
    
}
