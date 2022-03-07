
package org.uv.hibernatecrud;

import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Irais AV
 */
public interface IDao <T>{
    public void save(T t);
    public List<T> read();
    public List<T> readById(T t);
    public void delete(T t);
    public void updated(T t);
}
