/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffee.data;

import static coffee.data.connectdata.openConnection;
import coffee.model.material;
import coffee.model.nhanvien;
import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author danhnghia
 */
public class material_data {
     public void GetMaterialData(DefaultTableModel myModel)
    {
        Connection connection = openConnection();//Mo ket noi
        String sql="SELECT * FROM nguyenlieu"; //Chuoi truy van CSDL
        try{
            PreparedStatement ps = connection.prepareStatement(sql);//Chuan bi truy van
            ResultSet rs = ps.executeQuery();//Thuc thi truy van
            while(rs.next())//Doc du lieu
            {
                
                material mat = new material();
                mat.setId(rs.getInt("id_nguyenlieu"));
                mat.setName(rs.getString("tennguyenlieu"));
                mat.setAmount(rs.getString("luong"));
                mat.setUnit(rs.getString("donvi"));
                
                //Dua du lieu nhanvien vao vector
                Vector vector = new Vector();
                vector.add(mat.getId());
                vector.add(mat.getName());
                vector.add(mat.getAmount());
                vector.add(mat.getUnit());

                //Dua vector vao model
                myModel.addRow(vector);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}