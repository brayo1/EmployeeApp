package com.employee;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author Brian
 */


@ManagedBean
@SessionScoped
public class EmployeeBean implements Serializable {

    private List<Employee> employeeList; 
    @Inject
    private EmployeeDAO employeeDAO;
    private Employee employee = new Employee();
    private int employeeIdToDelete;

    @PostConstruct
    public void initialise() {
        this.employeeList = employeeDAO.findAll();
    }
    
    public void createOrUpdate () {
        if(this.employee.getId()==0){
            this.getEmployeeDAO().insert(this.employee);
            this.employee = new Employee();
        }else{
            this.getEmployeeDAO().update(this.employee);
            this.employee = new Employee();
        }
    }
    
    public void delete(int id) {
        this.getEmployeeDAO().delete(id);
        this.employee = new Employee(); // 
    }
    //
    public void employeeIdToDelete(int id) {  
        this.employeeIdToDelete = id;
    }
    public void confirmDelete() {
        this.getEmployeeDAO().delete(employeeIdToDelete);
        this.employee = new Employee();
    }
    
    public void editEmployee(Employee emp) {
        this.employee = emp;
    }

    
    public List<Employee> getEmployeeList() {
        this.employeeList = this.getEmployeeDAO().findAll();  
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    private EmployeeDAO getEmployeeDAO() {
        if(this.employeeDAO == null)
            this.employeeDAO = new EmployeeDAO();
        return employeeDAO;
    }

    public void setEmployeeDAO(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public Employee getEmployee() {
        if(this.employee == null)
            this.employee = new Employee();
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}