package com.example.demo.controles;

import com.example.demo.modelo.Club;
import com.example.demo.modelo.Socio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistrarSocioControlador implements Initializable {
    @FXML
    private TextField nombreCompleto;
    @FXML
    private TextField identificacion;
    @FXML
    private ChoiceBox<String> tipoMembresia;
    @FXML
    private TextField creditoInicial;

    private Club club = new Club();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("VIP");
        items.add("REGULAR");
        tipoMembresia.setItems(items);
    }

    @FXML
    public void guardarSocio() {
         Socio socio = validarCampos();

        if (validarCupos() && socio != null) {
            club.getListaSocios().add(socio);
            JOptionPane.showMessageDialog(null, "Socio creado");
        }
        JOptionPane.showMessageDialog(null, "No se pudo crear el Socio");
    }

    private boolean validarCupos() {
        if (club.getListaSocios().size() > 30) {
            JOptionPane.showMessageDialog(null, "Ya se agotaron los cupos del club");
        }
        return club.getListaSocios().size() < 30;
    }

    private Socio validarCampos () {
        String nombre = nombreCompleto.getText();
        String suscripcion = tipoMembresia.getValue();

        if (creditoInicial.getText().isEmpty() || creditoInicial.getText().isBlank() ||
                identificacion.getText().isEmpty() || identificacion.getText().isBlank() ||
                nombre.isEmpty() || nombre.isBlank() ||
                suscripcion.isEmpty() || suscripcion.isBlank()) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

            return null;
        }
        float fondos = Float.parseFloat(creditoInicial.getText());
        int cedula = Integer.parseInt(identificacion.getText());

        if (fondos < 30000) { //revisar no me acuerdo de cuanto es segun la membresia.
            JOptionPane.showMessageDialog(null, "Fondos insuficientes o se sobrepaso");

            return null;
        }

        return new Socio(fondos, suscripcion, cedula, nombre);
    }
}

