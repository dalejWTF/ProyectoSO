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
public class Proceso {
    private String nombre;
    private int rafagaCpu;
    private int tiempoLlegada;

    public Proceso(String nombre, int rafagaCpu, int tiempoLlegada) {
        this.nombre = nombre;
        this.rafagaCpu = rafagaCpu;
        this.tiempoLlegada = tiempoLlegada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRafagaCpu() {
        return rafagaCpu;
    }

    public void setRafagaCpu(int rafagaCpu) {
        this.rafagaCpu = rafagaCpu;
    }

    public int getTiempoLlegada() {
        return tiempoLlegada;
    }

    public void setTiempoLlegada(int tiempoLlegada) {
        this.tiempoLlegada = tiempoLlegada;
    }

    @Override
    public String toString(){
        return String.format("%s\t%2d\t%d",getNombre(),getRafagaCpu(),getTiempoLlegada());
    }
}
