
package org.uv.hibernatecrud;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Irais AV
 */
public class DaoEmployee implements IDao<Employee>{
    
    Session session;

    public DaoEmployee() {
        session = HibernateUtils.getSessionFactory().openSession(); 
    }        

    @Override
    public void save(Employee employee) {
        session.beginTransaction();
        session.save(new Employee(employee.getFullname(), employee.getAddress(), employee.getDepartment()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Employee> read() {
        session.beginTransaction();
        Query query = (Query) session.createQuery("FROM Employee");
        session.close();
        return (List<Employee>) query.list();
    }
    
    @Override
    public List<Employee> readById(Employee employee){
        session.beginTransaction();
        Query query = (Query) session.createQuery("FROM Employee WHERE id=:id");
        query.setLong("id", employee.getId());
        session.close();
        return (List<Employee>) query.list();
    }

    @Override
    public void delete(Employee employee) {
        session.beginTransaction();
        session.delete(new Employee(employee.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updated(Employee employee) {
        session.beginTransaction();
        session.update(new Employee(employee.getId(), employee.getAddress()));
        session.getTransaction().commit();
        session.close();
    }
}
