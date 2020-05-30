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
public class TiempoEspera {
    private String proceso;
    private int tiempoLlegada;

    public TiempoEspera(String proceso, int tiempoLlegada) {
        this.proceso = proceso;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public int getTiempoEspera() {
        return tiempoLlegada;
    }

    public void setTiempoEspera(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    @Override
    public String toString() {
        return String.format("proceso= %2s , tiempoLlegada= %2d\n", getProceso(),getTiempoEspera());
    }
    
}
