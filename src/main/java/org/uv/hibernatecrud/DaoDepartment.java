
package org.uv.hibernatecrud;

import java.util.List;
import org.hibernate.query.Query;
import org.hibernate.Session;

/**
 *
 * @author Irais AV
 */
public class DaoDepartment implements IDao<Department>{
    
    Session session;

    public DaoDepartment() {
        session = HibernateUtils.getSessionFactory().openSession(); 
    }        

    @Override
    public void save(Department department) {  
        session.beginTransaction();
        session.save(new Department(department.getName()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Department> read() {
        Query query = (Query) session.createQuery("FROM Department");
        return (List<Department>) query.list();
    }
    
    @Override
    public List<Department> readById(Department department){
        Query query = session.createQuery("FROM Department WHERE id=:id");
        query.setLong("id", department.getId());
        return (List<Department>) query.list();
    }

    @Override
    public void delete(Department department) {
        session.delete(new Department(department.getId()));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public void updated(Department department) {
        session.update(new Department(department.getId(), department.getName()));
        session.close();
    }

}
