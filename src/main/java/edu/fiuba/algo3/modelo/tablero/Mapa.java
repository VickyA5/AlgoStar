package edu.fiuba.algo3.modelo.tablero;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Recurso.NodoMineral;
import edu.fiuba.algo3.modelo.Recurso.Volcan;

import java.util.ArrayList;

public class Mapa {

    private Ubicacion[][] mapa;
    private int base;
    private int altura;

    public Mapa(int Base, int Altura) {
        mapa = new Ubicacion[Base+1][Altura+1];
        base = Base;
        altura = Altura;
        for (int i = 0; i <= Base; i++) {
            for (int j = 0; j <= Altura; j++) {
                mapa[i][j] = new Ubicacion(new Coordenada(i, j));
            }
        } // falta definir los nodos minerales y los volcanes lugares ala mtitad del mapa lo definimos apriori.
    }

    public Ubicacion buscar(Coordenada coordenada) {
        for (int i = 0; i <= base; i++) {
            for (int j = 0; j <= altura; j++) {
                if (coordenada.esIgual(mapa[i][j].coordenada())) {
                    return mapa[i][j];
                }
            }

        }
        throw new UbicacionFueraDelMapaError();
    }
    public ArrayList<Ubicacion> buscar(Coordenada coordenada,int radio){
        ArrayList<Ubicacion> lista = new ArrayList<Ubicacion>();
        for (int i =0;i<=base;i++){
            for (int j = 0;j<=altura;j++){
                if (coordenada.distancia(mapa[i][j].coordenada())<= radio){
                    lista.add(mapa[i][j]);
                }
            }
        }
        return lista;
        }
    public int distanciaMaxima(){
        return mapa[0][0].distancia(mapa[base][altura]);
    }
    public Ubicacion buscarOpuesto(Coordenada coor){
        return buscar(coor.opuesta(base,altura));
    }

    public void inicializarMapa() {
        this.buscar(new Coordenada(0,0)).ubicar(new Criadero());
        this.buscar(new Coordenada(0,2)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(2,0)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(2,2)).ubicarRecurso(new Volcan());

        this.buscar(new Coordenada(base-1,altura-1)).ubicar(new Criadero());
        this.buscar(new Coordenada(base-3,altura)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(base,altura-3)).ubicarRecurso(new NodoMineral());
        this.buscar(new Coordenada(base-3,altura-3)).ubicarRecurso(new NodoMineral());

    }
}
