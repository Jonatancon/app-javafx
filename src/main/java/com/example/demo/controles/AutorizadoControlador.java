package com.example.demo.controles;

import com.example.demo.modelo.PersonaAutorizada;
import com.example.demo.modelo.Socio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class AutorizadoControlador implements Initializable {

    @FXML
    private TextField nombreAfiliado;
    @FXML
    private TextField idAfiliado;
    @FXML
    private ChoiceBox<String> socioVinculado;

    private ClubControlador clubControlador = ClubControlador.getInstancia();
    private int indiceSocio = 0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();

        for(Socio socio : clubControlador.getClub().getListaSocios()) {
            items.add(socio.getCedula() + ":" + socio.getNombre());
        }

        socioVinculado.setItems(items);
    }

    @FXML
    private void guardarAutorizado() {
        PersonaAutorizada autorizada = validarAutorizado();

        if (autorizada != null) {
            clubControlador.getClub().getListaSocios().get(indiceSocio).getPersonasAutorizadas().add(autorizada);

            JOptionPane.showMessageDialog(null, "Persona Autorizada creado");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo crear a la persona autorizada");
        }
    }

    private PersonaAutorizada validarAutorizado() {
        String nombre = nombreAfiliado.getText();
        String socio = socioVinculado.getValue();

        if (nombre.isBlank() || nombre.isEmpty() ||
                idAfiliado.getText().isEmpty() || idAfiliado.getText().isBlank() ||
                socio.isBlank() || socio.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

            return null;
        }

        int cedula = Integer.parseInt(idAfiliado.getText());


        for (int i = 0; i < clubControlador.getClub().getListaSocios().size(); i++) {
            if (clubControlador.getClub().getListaSocios().get(i).getCedula() == Integer.parseInt(socio.split(":")[0]) &&
                    clubControlador.getClub().getListaSocios().get(i).getPersonasAutorizadas().size() <= 10) {

                indiceSocio = i;

                return new PersonaAutorizada(clubControlador.getClub().getListaSocios().get(i), cedula, nombre);
            }
        }

        JOptionPane.showMessageDialog(null, "El socio supero el limite de personas autorizadas");
        return null;
    }




}
