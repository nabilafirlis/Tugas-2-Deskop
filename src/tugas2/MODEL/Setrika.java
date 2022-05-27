/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.MODEL;

/**
 *
 * @author Asus
 */
public class Setrika {
    private String id;
    private String merek;
    private String harga;
    private String warna;
    private String tanggal;

    public Setrika(String id, String merek, String harga, String warna, String tanggal) {
        this.id = id;
        this.merek = merek;
        this.harga = harga;
        this.warna = warna;
        this.tanggal = tanggal;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        this.merek = merek;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }
    
    
    }
    
