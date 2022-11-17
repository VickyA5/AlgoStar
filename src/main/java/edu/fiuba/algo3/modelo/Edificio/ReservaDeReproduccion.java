package edu.fiuba.algo3.modelo.Edificio;

import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Unidad.Larva;
import edu.fiuba.algo3.modelo.Recurso.Recurso;
import edu.fiuba.algo3.modelo.Unidad.Zerling;

import java.util.ArrayList;

public class ReservaDeReproduccion extends Edificio {

    private static final int CANTIDAD_TURNOS_OPERATIVO = 12;


    public ReservaDeReproduccion(){
        super(CANTIDAD_TURNOS_OPERATIVO);
    }


    public Zerling evolucionarLarva(Larva larva) {
        verififarEdificioOperativo();
        return larva.evolucionar(this);

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
        raza.fueAgregadoReserva();
    }

}
