/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author danie
 */
public class Diagrama {
    private String proceso;
    private int tiempoRetorno;

    public Diagrama(String proceso, int tiempoRetorno) {
        this.proceso = proceso;
        this.tiempoRetorno = tiempoRetorno;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getTiempoRetorno() {
        return tiempoRetorno;
    }

    public void setTiempoRetorno(int tiempoRetorno) {
        this.tiempoRetorno = tiempoRetorno;
    }

    @Override
    public String toString() {
        return String.format("TiempoRetorno{ proceso=%s , tiempoRetorno=%2d\n",getProceso(), getTiempoRetorno());
    }
    
    
}
