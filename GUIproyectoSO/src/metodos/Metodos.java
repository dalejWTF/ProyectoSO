/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metodos;

import clases.Diagrama;
import clases.Proceso;
import clases.TiempoEspera;
import clases.TiempoRetorno;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author danie
 */
public class Metodos {

    private ArrayList<Proceso> procesos;
    private ArrayList<TiempoEspera> tiempoEspera;
    private ArrayList<TiempoRetorno> tiempoRetorno;
    private ArrayList<Diagrama> tiempo;

    public Metodos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
        tiempo = new ArrayList<>();
        tiempoEspera = new ArrayList<>();
        tiempoRetorno = new ArrayList<>();
    }

    public ArrayList<Proceso> getProcesos() {
        return procesos;
    }

    public void setProcesos(ArrayList<Proceso> procesos) {
        this.procesos = procesos;
    }

    public ArrayList<TiempoEspera> getTiempoEspera() {
        return tiempoEspera;
    }

    public void setTiempoEspera(ArrayList<TiempoEspera> tiempoEspera) {
        this.tiempoEspera = tiempoEspera;
    }

    public ArrayList<TiempoRetorno> getTiempoRetorno() {
        return tiempoRetorno;
    }

    public void setTiempoRetorno(ArrayList<Diagrama> grafica) {

        for (int i = 1; i < grafica.size(); i++) {
            tiempoRetorno.add(new TiempoRetorno(grafica.get(i).getProceso(), grafica.get(i).getTiempoRetorno()));
        }

    }

    public ArrayList<Diagrama> getDiagrama() {
        return tiempo;
    }

    public void setDiagrama(ArrayList<Diagrama> tiempo) {
        this.tiempo = tiempo;
    }

    public void OrdenarProcesos() {
        int tmp = 0;
        String aux = "";
        for (int j = 1; j < procesos.size(); j++) {
            for (int i = 0; i < procesos.size() - 1; i++) {
                if (procesos.get(i).getTiempoLlegada() > procesos.get(i + 1).getTiempoLlegada()) {
                    tmp = procesos.get(i).getTiempoLlegada();
                    procesos.get(i).setTiempoLlegada(procesos.get(i + 1).getTiempoLlegada());
                    procesos.get(i + 1).setTiempoLlegada(tmp);

                    tmp = procesos.get(i).getRafagaCpu();
                    procesos.get(i).setRafagaCpu(procesos.get(i + 1).getRafagaCpu());
                    procesos.get(i + 1).setRafagaCpu(tmp);

                    aux = procesos.get(i).getNombre();
                    procesos.get(i).setNombre(procesos.get(i + 1).getNombre());
                    procesos.get(i + 1).setNombre(aux);

                }

            }
        }
    }

    public void Grafica() {
        tiempo.add(new Diagrama("", procesos.get(0).getTiempoLlegada()));
        int x = tiempo.get(0).getTiempoRetorno();
        for (int i = 0; i < procesos.size(); i++) {
            x += procesos.get(i).getRafagaCpu();
            tiempo.add(new Diagrama(procesos.get(i).getNombre(), x));
        }
        setTiempoRetorno(tiempo);

    }

    public void TiempoMedioEspera() {
        for (int i = 0; i < this.procesos.size(); i++) {
            tiempoEspera.add(new TiempoEspera(procesos.get(i).getNombre(), (tiempo.get(i).getTiempoRetorno() - procesos.get(i).getTiempoLlegada())));
        }

    }

    @Override
    public String toString() {
        return "Metodos1{" + "procesos=" + procesos + '}';
    }

}
