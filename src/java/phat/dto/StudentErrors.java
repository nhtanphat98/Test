/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phat.dto;

/**
 *
 * @author Admin
 */
public class StudentErrors {

    private String idErr;
    private String nameErr;
    private String ageErr;
    private String classIdErr;

    public StudentErrors() {
    }

    public String getIdErr() {
        return idErr;
    }

    public void setIdErr(String idErr) {
        this.idErr = idErr;
    }

    public String getNameErr() {
        return nameErr;
    }

    public void setNameErr(String nameErr) {
        this.nameErr = nameErr;
    }

    public String getAgeErr() {
        return ageErr;
    }

    public void setAgeErr(String ageErr) {
        this.ageErr = ageErr;
    }

    public String getClassIdErr() {
        return classIdErr;
    }

    public void setClassIdErr(String classIdErr) {
        this.classIdErr = classIdErr;
    }
    
}
