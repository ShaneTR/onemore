/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onemore.entity.sessionbean;

import com.onemore.entity.ShoppingCart;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Brian
 */
@Stateless
public class ShoppingCartFacade extends AbstractFacade<ShoppingCart> {
    @PersistenceContext(unitName = "com.onemore_onemore-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ShoppingCartFacade() {
        super(ShoppingCart.class);
    }
    
}
