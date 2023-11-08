package com.example.demo.controles;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Persona;
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

public class RegistrarConsumoControlador implements Initializable {
    @FXML
    private TextField concepto;
    @FXML
    private TextField valor;
    @FXML
    private ChoiceBox<String> socioOrAutorizado;
    private int indexSocio = 0;

    private ClubControlador clubControlador = ClubControlador.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();

        for(Socio socio : clubControlador.getClub().getListaSocios()) {
            items.add(socio.getCedula() + ":" + socio.getNombre());
            for (PersonaAutorizada autorizada : socio.getPersonasAutorizadas()) {
                items.add(autorizada.getCedula() + ":" + autorizada.getNombre());
            }
        }

        socioOrAutorizado.setItems(items);
    }

    @FXML
    private void guardarConsumo() {
        Factura factura = validarCampos();

        if (factura != null && tienCupo()) {
            clubControlador.getClub().getListaSocios().get(indexSocio).getFacturasSinPagar().add(factura);

            System.out.println(clubControlador.getClub().getListaSocios().get(indexSocio).getFacturasSinPagar().get(0).getConcepto());

            JOptionPane.showMessageDialog(null, "Consumo agregado");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo agregar el consumo.");
        }
    }

    private boolean tienCupo() {
        if (clubControlador.getClub().getListaSocios().get(indexSocio).getFacturasSinPagar().size() > 20) {
            JOptionPane.showMessageDialog(null, "No se puede agregar mas consumos a este socio");
            return false;
        }
        return true;
    }

    private Factura validarCampos() {
        String titulo = concepto.getText();
        String persona = socioOrAutorizado.getValue();

        if (titulo.isBlank() || titulo.isEmpty() ||
                valor.getText().isEmpty() || valor.getText().isBlank() ||
                persona.isBlank() || persona.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");

            return null;
        }

        double peso = Double.parseDouble(valor.getText());
        int id = Integer.parseInt(persona.split(":")[0]);
        Persona person;

        for(int i = 0; i < clubControlador.getClub().getListaSocios().size(); i++) {
            Socio socio = clubControlador.getClub().getListaSocios().get(i);
            indexSocio = i;
            if (socio.getCedula() == id) {
                person = socio;
                return new Factura(titulo, peso, person);
            }
            for (int j = 0; j < socio.getPersonasAutorizadas().size(); j++) {
                PersonaAutorizada autorizada = socio.getPersonasAutorizadas().get(j);
                if (autorizada.getCedula() == id) {
                    person = autorizada;
                    return new Factura(titulo, peso, person);
                }
            }
        }
       return null;
    }
}
