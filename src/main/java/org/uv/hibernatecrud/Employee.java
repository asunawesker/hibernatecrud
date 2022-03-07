
package org.uv.hibernatecrud;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Irais AV
 */
@Entity
@Table(name="employees")
public class Employee implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String address;
    @ManyToOne
    @JoinColumn(name="id_dept")
    private Department department;

    public Employee() {
    }

    public Employee(Long id) {
        this.id = id;
    }    

    public Employee(Long id, String address) {
        this.id = id;
        this.address = address;
    }

    public Employee(String fullname, String address, Department department) {
        this.fullname = fullname;
        this.address = address;
        this.department = department;
    }        

    public Employee(Long id, String fullname, String address, Department department) {
        this.id = id;
        this.fullname = fullname;
        this.address = address;
        this.department = department;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    
}
