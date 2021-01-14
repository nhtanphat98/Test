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
public class StudentDTO {
    private String id;
    private String name;
    private int age;
    private String classId;

    public StudentDTO(String id, String name, int age, String classId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.classId = classId;
    }
    
    public StudentDTO(){
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassId() {
        return classId;
    }

    public void setClassId(String classId) {
        this.classId = classId;
    }

    @Override
    public String toString() {
        return "StudentDTO{" + "id=" + id + ", name=" + name + ", age=" + age + ", classId=" + classId + '}';
    }
    
}
