
package vista;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import modeloDAO.ClienteDAO;
import modeloVO.ClienteVO;

/**
 *
 * @author gelvezz23
 */
public class tablaCliente extends AbstractTableModel{

    private ClienteDAO cliente;
    List<ClienteVO> dataCliente = new ArrayList<>();
    

    public tablaCliente(ClienteDAO cliente) {
        this.cliente = cliente;
    }
    
    public void updateModel(){
        dataCliente = cliente.consultarTodos();
    }

    @Override
    public String getColumnName(int column) {
            switch(column){
                case 0 : return "Cedula";
                case 1 : return "Nombre";
                case 2 : return "Apellido";
                case 3 : return "direccion";
                case 4 : return "telefono";
                case 5 : return "Ingreso";
                default: return "[no]";
            
            }
    }

    @Override
    public int getRowCount() {
        return dataCliente.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClienteVO cliente = dataCliente.get(rowIndex);
        switch(columnIndex){
            case 0 : return cliente.getCedula();
            case 1 : return cliente.getNombre();
            case 2 : return cliente.getApellido();
            case 3 : return cliente.getDireccion();
            case 4 : return cliente.getTelefono();
            case 5 : DateFormat df = DateFormat.getDateInstance();
                     return df.format(cliente.getFechaIngreso());
            default : return "[no]";
                    
        
        }
    
    }
    
    
}
