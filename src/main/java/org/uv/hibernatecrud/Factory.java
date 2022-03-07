
package org.uv.hibernatecrud;

/**
 *
 * @author Irais AV
 */
public class Factory {
    
    public enum TypeDAO {DEPARTMENT, EMPLOYEE};
    
    public static IDao create(TypeDAO type){
        
        IDao dao = null;
        
        switch(type){
            case DEPARTMENT:
                dao = new DaoDepartment();
                break;
            case EMPLOYEE:
                dao = new DaoEmployee();
                break;
        }
        return dao;
    } 
    
}
