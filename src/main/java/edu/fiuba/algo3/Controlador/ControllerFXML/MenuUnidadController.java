package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.Controlador.OtrosHandlers.MostradorAlertas;
import edu.fiuba.algo3.Vista.Botones.Unidades.BotonUnidad;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Unidad.Unidad;
import edu.fiuba.algo3.modelo.Unidad.UnidadNoOperativaError;
import edu.fiuba.algo3.modelo.tablero.Ubicacion;
import edu.fiuba.algo3.modelo.tablero.UbicacionOcupadaError;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class MenuUnidadController extends UnidadMovibleController{

    @FXML
    public Pane contenedorPadre;

    @FXML
    public AnchorPane contenerdorMenu;


    @FXML
    public void onClickedMoverArriba(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try {
            unidad.moverseArriba();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError e){
            MostradorAlertas.mostrarAlerta(e);
        }
        moverUnidadGraficamente(unidad.ubicacion().coordenada());

    }
    @FXML
    public void onClickedMoverAbajo(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try{
            unidad.moverseAbajo();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError e){
            MostradorAlertas.mostrarAlerta(e);
        }

        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    @FXML
    public void onClickedMoverDerecha(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try{
            unidad.moverseDerecha();
        } catch( UnidadNoOperativaError | UbicacionOcupadaError e ){
            MostradorAlertas.mostrarAlerta(e);
        }
        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    @FXML
    public void onClickedMoverIzquierda(MouseEvent event) {
        Unidad unidad = ubicacion.getUnidad();
        try {
            unidad.moverseIzquierda();
        } catch (UnidadNoOperativaError | UbicacionOcupadaError e){
            MostradorAlertas.mostrarAlerta(e);
        }

        moverUnidadGraficamente(unidad.ubicacion().coordenada());
    }

    public  void setElements(GridPane tablero, VBox vBoxMenu , Ubicacion ubicacion,BotonUnidad botonUnidad, JuegoModelo juegoModelo) {
        super.setElements(tablero,vBoxMenu,ubicacion,botonUnidad,juegoModelo);
        if(!ubicacion.getUnidad().esOperativo()){
            int cantidadTurnosParaSerOperativo = ubicacion.getUnidad().getTurnosRestantesParaSerOperativo();
            contenerdorMenu.getChildren().clear();
            contenerdorMenu.getChildren().addAll(cargarMenuEnConstruccion(cantidadTurnosParaSerOperativo));
            return;
        }
        aplicarMovimientoPorTeclado();
        completarEnemigosParaAtacar();
    }

    private void completarEnemigosParaAtacar(){
        int rangoAtaque = ubicacion.getUnidad().getRango();
        int i = 0;
        int j = 0;
        ArrayList<Ubicacion> ubicaciones = juegoModelo.getMapa().buscar(ubicacion.coordenada(), rangoAtaque );
        for(Ubicacion ubicacionAdy : ubicaciones){
            if( ubicacionAdy.existeUnidad() &&  ! ubicacionAdy.esIgual(ubicacion) ){
                System.out.println("Coord x " + ubicacionAdy.coordenada().horizontal() + "Coord y: " + ubicacionAdy.coordenada().vertical() );
                System.out.println("Existe unidad para atacar y esa es ");
                Unidad unidad = ubicacionAdy.getUnidad();
                System.out.println(unidad.getEntidad() );
                System.out.println(contenerdorMenu.getChildren().get(0).getClass());
                System.out.println(contenerdorMenu.getChildren().get(1).getClass());
                System.out.println(contenerdorMenu.getChildren().get(2).getClass());
                System.out.println(contenerdorMenu.getChildren().get(3).getClass());
                System.out.println(contenerdorMenu.getChildren().get(4).getClass());
                System.out.println(contenerdorMenu.getChildren().get(5).getClass());
            }
        }
    }


}
