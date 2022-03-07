package org.uv.hibernatecrud;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author asunawesker
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        IDao department = Factory.create(Factory.TypeDAO.DEPARTMENT);
        IDao employee = Factory.create(Factory.TypeDAO.EMPLOYEE);
        
        // OPERACIONES DEPARTAMENTO
        
        //department.save(new Department("Administracion"));
        //department.delete(new Department(Long.valueOf(12)));
        //department.updated(new Department(Long.valueOf(3), "Administracion"));
        //List<Department> lstDepartment = department.readById(new Department(Long.valueOf(3)));
//        List<Department> lstDepartment = department.read();
//        for(Department dpt : lstDepartment){
//            System.out.println("Id: "+dpt.getId());
//            System.out.println("Nombre: "+dpt.getName());
//        }                   
        
        // OPERACIONES EMPLEADOS
        
        //employee.save(new Employee("Uriel Carmona", "Tenango", new Department(Long.valueOf(5))));
        //employee.delete(new Employee(Long.valueOf(8)));
        //employee.updated(new Employee(Long.valueOf(9), "Colonia Centro"));
        
        
//        List<Employee> lstEmployee = employee.read();
//        for(Employee emp : lstEmployee){
//            System.out.println("Id: "+emp.getId());
//            System.out.println("Nombre: "+emp.getFullname());
//        }
        
    }
    
}
