package com.employee;

import com.employee.resources.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author Brian
 */
@ApplicationScoped
public class EmployeeDAO {

    private DBconnection connector;
    private Connection connection;
    
    private DBconnection getConnector() {
        if(this.connector == null)
            this.connector = new DBconnection();
        return connector;
    }

    private Connection getConnection() {
        if(this.connection == null)
            this.connection = this.getConnector().connect();
        return connection;
    }
    
    public List<Employee> findAll () {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Statement st = this.getConnection().createStatement(); //
            ResultSet rs = st.executeQuery("SELECT * FROM employees");
            while (rs.next()){
                Employee tmp = new Employee();
                tmp.setId(rs.getInt("id"));
                tmp.setFirst_name(rs.getString("first_name"));
                tmp.setLast_name(rs.getString("last_name"));
                tmp.setEmail(rs.getString("email"));
                tmp.setDepartment(rs.getString("department"));
                tmp.setSalary(rs.getBigDecimal("salary"));
                employeeList.add(tmp);
            }
            st.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return employeeList;
    }

    public void insert (Employee employee) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("INSERT INTO employees (first_name, last_name, email, department, salary) VALUES ('"
                + employee.getFirst_name() + "', '"
                + employee.getLast_name() + "', '"
                + employee.getEmail() + "', '"
                + employee.getDepartment() + "', '"
                + employee.getSalary() + "')");
            st.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete (int id) {
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate("DELETE FROM employees WHERE id="+id);  //DELETE FROM employees WHERE id=?
            st.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
   
    public void update (Employee employee){
        try {
            Statement st = this.getConnection().createStatement();
            st.executeUpdate(
                "UPDATE employees SET " +
                "first_name='" + employee.getFirst_name() + "', " +
                "last_name='" + employee.getLast_name() + "', " +
                "email='" + employee.getEmail() + "', " +
                "department='" + employee.getDepartment() + "', " +
                "salary='" + employee.getSalary() + "' " +
                "WHERE id=" + employee.getId()
            );
            st.close();
            System.out.println("updated and closed connection"); //remove
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    
}
