/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeloVO;

/**
 *
 * @author Claudia
 */
public class ClasesVO {
    
    String codigo;
    String clase;
    String horario;
    String cod_instructor;

    public ClasesVO() {
    }

    @Override
    public String toString() {
        return "ClasesVO{" + "codigo=" + codigo + ", clase=" + clase + ", horario=" + horario + ", cod_instructor=" + cod_instructor + '}';
    }

    public ClasesVO(String codigo, String clase, String horario, String cod_instructor) {
        this.codigo = codigo;
        this.clase = clase;
        this.horario = horario;
        this.cod_instructor = cod_instructor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getCod_instructor() {
        return cod_instructor;
    }

    public void setCod_instructor(String cod_instructor) {
        this.cod_instructor = cod_instructor;
    }
    
    
    
    
    
}
