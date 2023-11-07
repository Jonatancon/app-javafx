package com.example.demo.controles;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

import javax.print.DocFlavor;
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> items = FXCollections.observableArrayList();
        items.add("VIP");
        items.add("REGULAR");
        tipoMembresia.setItems(items);

    }
}

