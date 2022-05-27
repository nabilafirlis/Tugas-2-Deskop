/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2;

import tugas2.DB.dbHandler;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import tugas2.MODEL.Setrika;

public class FXMLDocumentController implements Initializable{
    @FXML
    private Label label;

    @FXML
    private TextField textId;

    @FXML
    private TextField textMerek;

    @FXML
    private TextField textHarga;

    @FXML
    private DatePicker date;

    @FXML
    private ComboBox<?> textWarna;
    
    @FXML
    private Button save;

    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        
        System.out.println(textId.getText());
        System.out.println(textMerek.getText());
        System.out.println(textHarga.getText());
        System.out.println(textWarna.getValue().toString());
        System.out.println(date.getValue().toString());
        
        Setrika setrika = new Setrika(textId.getText(),textMerek.getText(),textHarga.getText(),
                textWarna.getValue().toString(), date.getValue().toString());
        dbHandler dh = new dbHandler("MYSQL");
        dh.addSetrika(setrika);
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODOArrayList <String> list = new ArrayList<String>();
        ArrayList <String> list = new ArrayList<>();
        list.add("Ungu");
        list.add("Merah");
        list.add("Biru");
        list.add("Kuning");
        ObservableList items = FXCollections.observableArrayList(list);
        textWarna.setItems(items);
    }    
    
}