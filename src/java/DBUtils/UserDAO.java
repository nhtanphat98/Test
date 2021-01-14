/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class UserDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    public boolean checkLogin(String username, String password){
        String sql = "Select * From tblLogin Where Username=? and Password=?";
        try{
        con = DBUtils.getConnection();
        if(con != null){
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            while(rs.next()){
                return true;
            }
        }
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
