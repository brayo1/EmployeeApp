package com.employee;
import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 *
 * @author Brian
 */
@Entity
@Table(name = "employees")
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String first_name;
    private String last_name;
    private String email;
    private String department;
    private BigDecimal salary;

    public int getId() {return id;}
    public void setId(int id) {
        this.id = id; 
    }

    public String getFirst_name() {return first_name;}
    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {return last_name;}
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {return email;}
    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {return department;}
    public void setDepartment(String department) {
        this.department = department;
    }
    
    public BigDecimal getSalary() {return salary;}
    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }
    
    
    
}
