package edu.fiuba.algo3.Vista.Botones.Unidades;

import edu.fiuba.algo3.Controlador.OtrosHandlers.RUTAS_FXML;
import edu.fiuba.algo3.Vista.Botones.BotonCeldaTablero;

public class BotonHidralisco extends BotonUnidad{

    public BotonHidralisco(BotonCeldaTablero botonCeldaTablero){
        super(botonCeldaTablero,"images/hidralisco.png", RUTAS_FXML.MENU_ATACAR_ENEMIGO,RUTAS_FXML.MENU_VACIO);
    }

    @Override
    public void setElmentsController() {

    }
}
