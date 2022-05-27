/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugas2.DB;

import tugas2.MODEL.Setrika;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import tugas2.MODEL.SetrikaProperty;


public class dbHandler {
    public final Connection conn;

    public dbHandler(String driver) {
        this.conn = dbHelper.getConnection(driver);
    }
    public void addSetrika(Setrika setrika){
        String insertSetrika = "INSERT INTO `datasetrika`(`id`, `merek`,`harga`,`warna`,`tanggal`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertSetrika);
            stmtInsert.setString(1, setrika.getId());
            stmtInsert.setString(2, setrika.getMerek());
            stmtInsert.setString(3, setrika.getHarga());
            stmtInsert.setString(4, setrika.getWarna());
            stmtInsert.setString(5, setrika.getTanggal());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 public ObservableList<SetrikaProperty> getSetrika(){
        ObservableList<SetrikaProperty> data = FXCollections.observableArrayList();
        
        String sql = "SELECT id, merek, harga, warna, tanggal FROM `datasetrika` ORDER BY id";
        
        try {
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()){
                SetrikaProperty datasetrika = new SetrikaProperty(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
                data.add(datasetrika);
            }
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return data;
    }
    
    public void deleteSetrika(SetrikaProperty datasetrika) {
        String deleteDatasetrika = "DELETE FROM datasetrika WHERE `datasetrika`.`id` = ?";
        try {
            PreparedStatement stmtDelete = conn.prepareStatement(deleteDatasetrika);
            stmtDelete.setString(1, datasetrika.getId());
            stmtDelete.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void updateSetrika(Setrika setrika){
        String insertSetrika = "UPDATE `datasetrika`(`id`, `merek`,`harga`,`warna`,`tanggal`)"
                + "VALUES (?,?,?,?,?)";
        try {
            PreparedStatement stmtInsert = conn.prepareStatement(insertSetrika);
            stmtInsert.setString(1, setrika.getId());
            stmtInsert.setString(2, setrika.getMerek());
            stmtInsert.setString(3, setrika.getHarga());
            stmtInsert.setString(4, setrika.getWarna());
            stmtInsert.setString(5, setrika.getTanggal());
            stmtInsert.execute();
        } catch (SQLException ex) {
            Logger.getLogger(dbHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
    