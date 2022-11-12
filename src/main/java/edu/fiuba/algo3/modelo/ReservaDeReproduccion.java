package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class ReservaDeReproduccion {

    private final int CANTIDAD_TURNOS_OPERATIVO = 12;

    private int turnosRestantesParaSerOperativo;

    private ArrayList<Larva> larvas;

    public ReservaDeReproduccion(){
        larvas = new ArrayList<Larva>();
        turnosRestantesParaSerOperativo = CANTIDAD_TURNOS_OPERATIVO;
        cargarTodaslasLarvas();
    }

    private  void cargarTodaslasLarvas(){
        larvas.add( new Larva() );
        larvas.add( new Larva() );
        larvas.add( new Larva() );
    }


    public Zerling evolucionarLarva(Larva larva) {
        if(turnosRestantesParaSerOperativo > 0 ){
            throw  new EdificioNoOperativoError();
        }
        return larva.evolucionar(this);

    }

    public void ejecutarTurno() {
        turnosRestantesParaSerOperativo--;
    }
}
