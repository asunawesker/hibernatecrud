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
        Session session = (Session) HibernateUtils.getSessionFactory().openSession();
        
        session.beginTransaction();
        System.out.println("Se inicia sesion");
        
        IDao department = Factory.create(Factory.TypeDAO.DEPARTMENT);
        IDao employee = Factory.create(Factory.TypeDAO.EMPLOYEE);
        
        // OPERACIONES DEPARTAMENTO
        
        //department.save(session, new Department("Administracion"));
        //department.delete(session, new Department(Long.valueOf(6)));
        //department.updated(session, new Department(Long.valueOf(3), "Administracion"));
        //List<Department> lstDepartment = department.readById(new Department(Long.valueOf(3)));
        List<Department> lstDepartment = department.read();
        for(Department dpt : lstDepartment){
            System.out.println("Id: "+dpt.getId());
            System.out.println("Nombre: "+dpt.getName());
        }                   
        
        // OPERACIONES EMPLEADOS
        
        //employee.save(session, new Employee("Uriel Carmona", "Tenango", new Department(Long.valueOf(5))));
        //employee.delete(session, new Employee(Long.valueOf(8)));
        //employee.updated(new Employee(Long.valueOf(9), "Colonia Centro"));
        
        
//        List<Employee> lstEmployee = employee.read(session);
//        for(Employee emp : lstEmployee){
//            System.out.println("Id: "+emp.getId());
//            System.out.println("Nombre: "+emp.getFullname());
//        }
        
    }
    
}
