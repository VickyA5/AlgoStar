package edu.fiuba.algo3.Controlador.ControllerFXML;

import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.ID_RAZA;
import edu.fiuba.algo3.Controlador.JuegoVista;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Juego.Jugador;
import edu.fiuba.algo3.modelo.Observador;
import edu.fiuba.algo3.modelo.Raza.Raza;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

public class InterfazJuegoControlador implements Observador {

    @FXML
    public Button btnAccion1;

    @FXML
    public Button btnAccion10;

    @FXML
    public Button btnAccion11;

    @FXML
    public Button btnAccion12;

    @FXML
    public Button btnAccion2;

    @FXML
    public Button btnAccion3;

    @FXML
    public Button btnAccion4;

    @FXML
    public Button btnAccion5;

    @FXML
    public Button btnAccion6;

    @FXML
    public Button btnAccion7;

    @FXML
    public Button btnAccion8;

    @FXML
    public Button btnAccion9;

    @FXML
    public AnchorPane contenedorMapa;

    @FXML
    public VBox vBoxMenu;

    @FXML
    public Button btnTerminarTurno;
    @FXML
    public Label labelMenu;

    @FXML
    public Label lblCantidadGas;

    @FXML
    public Label lblCantidadMineral;

    @FXML
    public Label lblNombreJugador;

    @FXML
    public Pane paneInfoJugador;

    @FXML
    public Label lblCantidadPoblacion;

    @FXML
    public Label lblMaximaCantidadPoblacion;

    @FXML
    public Label lblNombreRaza;


    private JuegoModelo juegoModelo;

    private JuegoVista juegoVista;




    public void setJuego(JuegoModelo juegoModelo){
        this.juegoModelo = juegoModelo;
        juegoModelo.subscribirseRazaActiva(this);
    }

    public void inicializar(){
        JuegoVista juegoVista = new JuegoVista(juegoModelo);
        juegoVista.iniciar(vBoxMenu);
        juegoVista.agregarContenedor(contenedorMapa);
        this.juegoVista = juegoVista;
        actualizar();
        empezarTurno();
    }

    public void empezarTurno(){
        labelMenu.setText("Menu del juego");

        if(juegoModelo.getJugadorActivo().getRaza().getEntidad() == ID_RAZA.PROTOSS  ){
            cambiarHandlerSuperficieActualProtoss();
            System.out.println("Entro el turno para el jugador de protoss");
            // cambiamos todos los handleres de todos las tierra
            // cambiamos de los edifciios
            // cambiamos los handler de las unidades
            // cambiamos los handler de los recursos
        }
        else{
            cambiarHandlerSuperficieActualZerg();
            System.out.println("Entro el turno para el jugador de ZERG");

            // cambiamos todos los handleres de todos las tierra
            // cambiamos de los edifciios
            // cambiamos los handler de las unidades
            // cambiamos los handler de los recursos
        }
    }

    private void cambiarHandlerSuperficieActualZerg() {
        juegoVista.cambiarHandlerSuperficieActualZerg(vBoxMenu);
    }

    private void cambiarHandlerSuperficieActualProtoss() {
        juegoVista.cambiarHandlerSuperficieActualProtoss(vBoxMenu);
    }


    @FXML
    public void onClickTerminarTurno(MouseEvent event) {
        juegoModelo.desubscribirseRazaActiva(this);
        juegoModelo.terminarTurno();
        juegoModelo.subscribirseRazaActiva(this);
        actualizar();
    }

    @Override
    public void actualizar() {
        Jugador jugadorActivo = juegoModelo.getJugadorActivo();
        Raza razaActiva = jugadorActivo.getRaza();
        lblNombreJugador.setText(jugadorActivo.getNombre());
        lblCantidadMineral.setText(razaActiva.getCantidadMineral());
        lblCantidadGas.setText(razaActiva.getCantidadGas());
        lblCantidadPoblacion.setText(String.valueOf(razaActiva.obtenerCantidadPoblacion()));
        lblMaximaCantidadPoblacion.setText(String.valueOf(razaActiva.capacidadReal()));
        lblNombreRaza.setText(razaActiva.getEntidad().toString());
    }
}
