/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onemore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Brian
 */
@Embeddable
public class ProductHasShoppingCartPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shopping_cart_user_id")
    private int shoppingCartUserId;

    public ProductHasShoppingCartPK() {
    }

    public ProductHasShoppingCartPK(int productId, int shoppingCartUserId) {
        this.productId = productId;
        this.shoppingCartUserId = shoppingCartUserId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getShoppingCartUserId() {
        return shoppingCartUserId;
    }

    public void setShoppingCartUserId(int shoppingCartUserId) {
        this.shoppingCartUserId = shoppingCartUserId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) productId;
        hash += (int) shoppingCartUserId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasShoppingCartPK)) {
            return false;
        }
        ProductHasShoppingCartPK other = (ProductHasShoppingCartPK) object;
        if (this.productId != other.productId) {
            return false;
        }
        if (this.shoppingCartUserId != other.shoppingCartUserId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onemore.entity.ProductHasShoppingCartPK[ productId=" + productId + ", shoppingCartUserId=" + shoppingCartUserId + " ]";
    }
    
}
