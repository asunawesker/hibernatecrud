/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.uv.hibernatecrud;

import org.hibernate.Session;

/**
 *
 * @author asunawesker
 */
public abstract class TransactionDb<T> {
    protected T pojo;

    public TransactionDb(){}
    
    public TransactionDb(T pojo) {
        this.pojo = pojo;
    }    
    
    public abstract boolean execute(Session session);
        
}
