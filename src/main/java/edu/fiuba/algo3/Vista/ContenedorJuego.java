package edu.fiuba.algo3.Vista;

import edu.fiuba.algo3.Controlador.BotonCriaderoHandler;
import edu.fiuba.algo3.Controlador.BotonEdificioCriadero;
import edu.fiuba.algo3.modelo.Edificio.Zerg.Criadero;
import edu.fiuba.algo3.modelo.Juego.JuegoModelo;
import edu.fiuba.algo3.modelo.Raza.RazaZerg;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.File;


public class ContenedorJuego extends BorderPane {

    public ContenedorJuego(Stage stage, JuegoModelo juegoModelo) {

        GridPane gridPane = new GridPane();
        gridPane.setBackground( new Background(new BackgroundFill( Color.rgb(65, 40, 27, 1) , CornerRadii.EMPTY, Insets.EMPTY) ) );
        gridPane.setAlignment(Pos.CENTER);
        Label labelMenu = new Label("Menu del Juego");
        labelMenu.setEffect(new DropShadow(2.0, Color.BLACK));
        labelMenu.setFont(Font.font(40));
        labelMenu.setTextFill(Color.BLACK);
        VBox menuVertical = new VBox( labelMenu );
        menuVertical.setBackground( new Background(new BackgroundFill( Color.rgb(255, 255, 255, 1) , CornerRadii.EMPTY, Insets.EMPTY) ) );
        gridPane.add(menuVertical,10,1);  // eje x , eje y

        final int TAMANIO = 91;
        // Tierra
        File fileFondo = new File("images/tierra.png");
        Image imagenRaza = new Image(fileFondo.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage primerBackGro = new BackgroundImage(
                imagenRaza,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                try {
                    Button btn = new Button();
                    //btn.setGraphic( new ImageView(imagenRaza) );
                    btn.setMinSize(TAMANIO,TAMANIO);
                    //btn.setPrefSize(TAMANIO, TAMANIO);
                    btn.setBackground( new Background(primerBackGro) );

                    gridPane.add(btn, i, j);
                } catch (Exception e){
                    System.out.println(e);
                }
            }
        }

        // Criadero
        File criaderoFile = new File("images/criadero.png");
        Image criaderoImage = new Image(criaderoFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage criaderoBackGro = new BackgroundImage(
                criaderoImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnCriadero = new Button();
        btnCriadero.setMinSize(TAMANIO,TAMANIO);
        btnCriadero.setBackground( new Background(criaderoBackGro) );
        gridPane.add(btnCriadero, 0, 0);



        // Mineral
        File mineralFile = new File("images/mineral.png");
        Image mineralImage = new Image(mineralFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage mineralBackGro = new BackgroundImage(
                mineralImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnMineral = new Button();
        btnMineral.setMinSize(TAMANIO,TAMANIO);
        btnMineral.setBackground( new Background(mineralBackGro) );
        gridPane.add(btnMineral, 3, 2);

        Button btnMineral2 = new Button();
        btnMineral2.setMinSize(TAMANIO,TAMANIO);
        btnMineral2.setBackground( new Background(mineralBackGro) );
        gridPane.add(btnMineral2, 6, 9);


        // Volcan
        File volcanFile = new File("images/Volcan.png");
        Image volcanImage = new Image(volcanFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage volcanBackGro = new BackgroundImage(
                volcanImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnVolcan = new Button();
        btnVolcan.setMinSize(TAMANIO,TAMANIO);
        btnVolcan.setBackground( new Background(volcanBackGro) );
        gridPane.add(btnVolcan, 4, 3);

        Button btnVolcan2 = new Button();
        btnVolcan2.setMinSize(TAMANIO,TAMANIO);
        btnVolcan2.setBackground( new Background(volcanBackGro) );
        gridPane.add(btnVolcan2, 3, 4);


        // Pilon
        File pilonFile = new File("images/pilon.png");
        Image pilonImage = new Image(pilonFile.toURI().toString(),TAMANIO, TAMANIO, true, true );
        BackgroundImage pilonBackGro = new BackgroundImage(
                pilonImage,
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT
        );
        Button btnPilon = new Button();
        btnPilon.setMinSize(TAMANIO,TAMANIO);
        btnPilon.setBackground( new Background(pilonBackGro) );
        gridPane.add(btnPilon, 9, 9);
        RazaZerg nuevaRaza = new RazaZerg();
        Criadero criadero =  new Criadero();
        BotonEdificioCriadero botonEdificioCriadero =  new BotonEdificioCriadero(criadero, nuevaRaza );
        gridPane.add( botonEdificioCriadero, 10,4 ) ;
        this.setCenter(gridPane);
        //BotonCriaderoHandler botonCriaderoHandler = new BotonCriaderoHandler(menuVertical, criadero );
        //botonEdificioCriadero.setOnAction(botonCriaderoHandler);

    }



    private int getRandom(int limite){
        return (int) (Math.random() * limite);
    }


}


