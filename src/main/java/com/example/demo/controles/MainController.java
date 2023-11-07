package com.example.demo.controles;

import com.example.demo.HelloApplication;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {
    private Stage stage;

   @FXML
   protected void resgistrarPersonaOnClick () {
       showView("Registrar_Socio","Registrar Socio");

    }
    @FXML
    protected void personaAutorizadaOnClick () {
        showView("Persona_Autorizada","Persona Autorizada");

    }
    @FXML
    protected void resgistrarConsumoOnClick () {
        showView("Registrar_Consumo","Registrar Consumo");

    }
    @FXML
    protected void pagarFacturaOnClick () {
        showView("Pagar_Factura","Pagar Factura");

    }
    @FXML
    protected void aumentarFondosOnClick () {
        showView("Aumentar_Fondos","Aumentar Fondos");

    }
    @FXML
    protected void eliminarPersonaOnClick () {
        showView("Eliminar_Persona","Eliminar Persona");

    }

    private void showView(String view,String setTitle){
       try {
           if (stage== null){
               stage=new Stage();
           }

           FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(view+".fxml"));
           Scene scene = new Scene(fxmlLoader.load(), 616, 668);
           stage.setTitle(setTitle);
           //stage.initStyle(StageStyle.UNDECORATED);
           stage.setScene(scene);
           stage.show();

       }catch(IOException e){
           System.out.println(e);
       }
    }

}
