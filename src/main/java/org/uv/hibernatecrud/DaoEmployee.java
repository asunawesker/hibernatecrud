
package org.uv.hibernatecrud;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Irais AV
 */
public class DaoEmployee implements IDao<Employee>{
    
    HibernateUtils session;

    public DaoEmployee() {
        session = HibernateUtils.getInstance(); 
    }        

    @Override
    public void save(Employee employee) {
        TransactionDb t;
        
        t = new TransactionDb<Employee>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.save(new Employee(employee.getFullname(), employee.getAddress(), employee.getDepartment()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };      
        
        session.execute(t);          
    }

    @Override
    public List<Employee> read() {
        List<Employee> lstEmployee = new ArrayList<>();
        TransactionDb t;
        
        t = new TransactionDb<Employee>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    Query query = (Query) session.createQuery("FROM Employee");
                    for (Object employee : query.list()) {
                        lstEmployee.add((Employee) employee);                        
                    }
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };    
        
        session.execute(t);   
        
        return lstEmployee;
    }
    
    @Override
    public List<Employee> readById(Employee employee){
        List<Employee> lstEmployee = new ArrayList<>();
        TransactionDb t;
        
        t = new TransactionDb<Department>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    Query query = (Query) session.createQuery("FROM Employee WHERE id=:id");
                    query.setLong("id", employee.getId());
                    for (Object employee : query.list()) {
                        lstEmployee.add((Employee) employee);                        
                    }
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };    
        
        session.execute(t);   
        
        return lstEmployee;
    }

    @Override
    public void delete(Employee employee) {
        TransactionDb t;
        
        t = new TransactionDb<Employee>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.delete(new Employee(employee.getId()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };      
        
        session.execute(t);                     
    }

    @Override
    public void updated(Employee employee) {
        TransactionDb t;
        
        t = new TransactionDb<Employee>() {
            @Override
            public boolean execute(Session session) {
                boolean response = false;                
                try {
                    session.beginTransaction();
                    session.update(new Employee(employee.getId(), employee.getAddress()));
                    session.getTransaction().commit();
                    response = true;                     
                 } catch (HibernateException ex) {
                     Logger.getLogger(DaoDepartment.class.getName()).log(Level.SEVERE, null, ex);
                 }
                 
                 return response;
             }
        };      
        
        session.execute(t);   
    }
}
