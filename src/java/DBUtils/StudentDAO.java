/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DBUtils;

import phat.dto.StudentDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.naming.NamingException;
import java.sql.SQLException;
/**
 *
 * @author Admin
 */
public class StudentDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    public ArrayList<StudentDTO> getAllStudent() throws SQLException, NamingException {
        ArrayList<StudentDTO> list = new ArrayList<StudentDTO>();
        try {
            String sql = "Select * From tblStudent";
            StudentDTO dto;
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String name = rs.getString("Name");
                    int age = rs.getInt("Age");
                    String classId = rs.getString("ClassId");
                    dto = new StudentDTO(id, name, age, classId);
                    list.add(dto);
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return list;
    }

    public boolean insertStudent(StudentDTO dto) throws Exception {
        String sql = "Insert tblStudent Values(?,?,?,?)";
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, dto.getId());
                ps.setString(2, dto.getName());
                ps.setInt(3, dto.getAge());
                ps.setString(4, dto.getClassId());
                ps.executeUpdate();
                return true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public StudentDTO searchStudent(String pid) throws Exception {
        StudentDTO dto;
        String sql = "Select * From tblStudent where ID=?";
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, pid);
                rs = ps.executeQuery();
                while (rs.next()) {
                    String id = rs.getString("ID");
                    String name = rs.getString("Name");
                    int age = rs.getInt("Age");
                    String classId = rs.getString("ClassId");
                    dto = new StudentDTO(id, name, age, classId);
                    return dto;
                }
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return null;
    }

    public boolean deleteStudent(String id) throws Exception {
        String sql = "Delete From tblStudent Where ID = ?";
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                ps = con.prepareStatement(sql);
                ps.setString(1, id);
                ps.executeUpdate();
                return true;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }

    public boolean updateStudent(StudentDTO dto) throws Exception {
        String sql = "Update tblStudent set Name=?, Age=?, ClassId=? Where ID=?";
        try {
            con = DBUtils.getConnection();
            if(con != null){
                ps = con.prepareStatement(sql);
                
                ps.setString(1, dto.getName());
                ps.setInt(2, dto.getAge());
                ps.setString(3, dto.getClassId());
                ps.setString(4, dto.getId());
                ps.executeUpdate();
                return true;
            }
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return false;
    }
    
    public boolean checkLogin(String username, String password) throws Exception{
        String sql = "Select * From Login Where username=? and Password=?";
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
        }finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
            
        }
        return false;
    }
}
