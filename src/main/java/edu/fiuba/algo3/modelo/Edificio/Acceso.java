package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Recurso.Recurso;

import java.util.ArrayList;

public class Acceso extends Edificio {

    private static final int CANTIDAD_TURNOS_OPERATIVO = 6;


    public Acceso(){
        super(CANTIDAD_TURNOS_OPERATIVO);
    }


    public void transportarTropas() {
        verififarEdificioOperativo();
    }

    @Override
    public void construirEdificioEn(Recurso recurso) {
        throw new ConstruccionIncorrectaError();
    }

    public void verificarSiPuedeSerConstruido(int unidadesDeMineral, int unidadesDeGas){
        verificarSiPuedeSerConstruidoSegunRecursos(unidadesDeMineral, unidadesDeGas, 150 , 0);
    }

    @Override
    public int consumirGas(int unidadesDeGas) {
        return unidadesDeGas;
    }

    @Override
    public int consumirMineral(int unidadesDeMineral) {
        return unidadesDeMineral - 150;
    }

    @Override
    public void fueAgregado(Raza raza) {
        raza.fueAgregadoAcceso();
    }

    public void energizado(ArrayList<Pilon> lista){
        lista.get(0).enRango(ubicacion(),lista);
    }
}
