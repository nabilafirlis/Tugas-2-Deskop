/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import tugas2.DB.dbHandler;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tugas2.MODEL.SetrikaProperty;

/**
 * FXML Controller class
 *
 * @author user
 */
public class FXMLDataViewController implements Initializable {

    @FXML
    private MenuItem menuDeleteData;

    @FXML
    private MenuItem menuTambahData;

    @FXML
    private TableView<SetrikaProperty> tblStrk;

    @FXML
    private TableColumn<SetrikaProperty, String> colId;

    @FXML
    private TableColumn<SetrikaProperty, String> colMerek;

    @FXML
    private TableColumn<SetrikaProperty, String> colHarga;

    @FXML
    private TableColumn<SetrikaProperty, String> colWarna;

    @FXML
    private TableColumn<SetrikaProperty, String> colTanggal;

    @FXML
    void deleteDataSetrika(ActionEvent event) {
        SetrikaProperty datasetrika = tblStrk.getSelectionModel().getSelectedItem();
        int ans = JOptionPane.showConfirmDialog(null, "Yakin Akan Menghapus?");
        if (ans == JOptionPane.YES_OPTION) {
            dbHandler dh = new dbHandler("MYSQL");
            dh.deleteSetrika(datasetrika);
            showDataSetrika();
        }
    }

    @FXML
    void viewTambahData(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();



}
    @FXML
    void updateDataSetrika(ActionEvent event) throws IOException {
        Stage modal = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        modal.setScene(scene);
//        modal.initOwner(((Node)event.getSource()).getScene().getWindow() );
        modal.initModality(Modality.APPLICATION_MODAL);
        modal.showAndWait();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        showDataSetrika();
        tblStrk.getSelectionModel().selectedIndexProperty().addListener(evt -> {
//            JOptionPane.showMessageDialog(null,"Test Klik");
            menuDeleteData.setDisable(false);
        });
    }
    
    public void showDataSetrika() {
        dbHandler dh = new dbHandler("MYSQL");
        ObservableList<SetrikaProperty> data = dh.getSetrika();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colMerek.setCellValueFactory(new PropertyValueFactory<>("merek"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));
        colWarna.setCellValueFactory(new PropertyValueFactory<>("warna"));
        colTanggal.setCellValueFactory(new PropertyValueFactory<>("tanggal"));
        tblStrk.setItems(null);
        tblStrk.setItems(data);
    }
    
}
