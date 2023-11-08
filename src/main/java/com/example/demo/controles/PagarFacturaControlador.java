package com.example.demo.controles;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Socio;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

import javax.swing.*;
import java.net.URL;
import java.util.ResourceBundle;

public class PagarFacturaControlador implements Initializable {
    @FXML
    private ChoiceBox<String> socio;
    @FXML
    private ChoiceBox<String> factura;
    private ClubControlador clubControlador = ClubControlador.getInstancia();
    private int indexSocio;
    private int indexFactura;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> itemsSocio = FXCollections.observableArrayList();
        ObservableList<String> itemsFactura = FXCollections.observableArrayList();

        for (Socio socio1 : clubControlador.getClub().getListaSocios()) {
            itemsSocio.add(socio1.getCedula() + ":" + socio1.getNombre());

            for (int i = 0; i < socio1.getFacturasSinPagar().size(); i++) {
                Factura factura = socio1.getFacturasSinPagar().get(i);

                itemsFactura.add(i+1 + ":" + factura.getConcepto()+":"+factura.getValor()+":"+factura.getPersona().getNombre());
            }
        }

        socio.setItems(itemsSocio);
        factura.setItems(itemsFactura);
    }

    @FXML
    private void pagarFactura() {
        if(validarCampos()) {
            clubControlador.getClub().getListaSocios().get(indexSocio).getFacturasSinPagar().remove(indexFactura);
            JOptionPane.showMessageDialog(null, "Se ha pagado la factura");
        }
        else {
            JOptionPane.showMessageDialog(null, "No se pudo pagar la factura");
        }
    }

    private boolean validarCampos() {
        String persona = socio.getValue();
        String consumo = factura.getValue();

        if (persona.isBlank() || persona.isEmpty() ||
                consumo.isBlank() || consumo.isEmpty()) {

            JOptionPane.showMessageDialog(null, "Seleccione un socio y una factura");

            return false;
        }

        int id = Integer.parseInt(persona.split(":")[0]);
        indexFactura = Integer.parseInt(consumo.split(":")[0]) - 1;
        double valor = Double.parseDouble(consumo.split(":")[2]);

        for (int i = 0; i < clubControlador.getClub().getListaSocios().size(); i++) {
            Socio socio1 = clubControlador.getClub().getListaSocios().get(i);
            if (socio1.getCedula() == id) {
                indexSocio = i;
            }
        }

        if (clubControlador.getClub().getListaSocios().get(indexSocio).getFondosDisponibles() < valor) {
            JOptionPane.showMessageDialog(null, "Usted no posee fondos suficientes");
            return false;
        }

        return true;
    }
}
