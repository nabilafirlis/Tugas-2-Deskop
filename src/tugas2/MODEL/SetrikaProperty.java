/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.MODEL;

import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;


/**
 *
 * @author Asus
 */
public class SetrikaProperty {
    private StringProperty id;
    private StringProperty merek;
    private StringProperty harga;
    private StringProperty warna;
    private StringProperty tanggal;

    public SetrikaProperty(String id, String merek, String harga, String warna, String tanggal) {
        this.id = new SimpleStringProperty(id);
        this.merek = new SimpleStringProperty(merek);
        this.harga = new SimpleStringProperty(harga);
        this.warna = new SimpleStringProperty(warna);
        this.tanggal = new SimpleStringProperty(tanggal);
    }

    public SetrikaProperty(Setrika datasetrika) {
        this.id = new SimpleStringProperty(datasetrika.getId());
        this.merek = new SimpleStringProperty(datasetrika.getMerek());
        this.harga = new SimpleStringProperty(datasetrika.getHarga());
        this.warna = new SimpleStringProperty(datasetrika.getWarna());
        this.tanggal = new SimpleStringProperty(datasetrika.getTanggal());
    }

    public StringProperty getIdProperty() {
        return id;
    }

    public void setId(String id) {
        this.id = new SimpleStringProperty(id);
    }

    public StringProperty getMerekProperty() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = new SimpleStringProperty(merek);
    }

    public StringProperty getHargaProperty() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = new SimpleStringProperty(harga);
    }

    public StringProperty getWarnaProperty() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = new SimpleStringProperty(warna);
    }

    public StringProperty getTanggalProperty() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = new SimpleStringProperty(tanggal);
    }
    
    public String getId() {
        return id.get();
    }

    public String getMerek() {
        return merek.get();
    }

    public String getHarga() {
        return harga.get();
    }

    public String getWarna() {
        return warna.get();
    }

    public String getTanggal() {
        return tanggal.get();
    }

    
}

    
