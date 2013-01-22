/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onemore.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Brian
 */
@Entity
@Table(name = "product_has_shopping_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasShoppingCart.findAll", query = "SELECT p FROM ProductHasShoppingCart p"),
    @NamedQuery(name = "ProductHasShoppingCart.findByProductId", query = "SELECT p FROM ProductHasShoppingCart p WHERE p.productHasShoppingCartPK.productId = :productId"),
    @NamedQuery(name = "ProductHasShoppingCart.findByShoppingCartUserId", query = "SELECT p FROM ProductHasShoppingCart p WHERE p.productHasShoppingCartPK.shoppingCartUserId = :shoppingCartUserId"),
    @NamedQuery(name = "ProductHasShoppingCart.findByQuantity", query = "SELECT p FROM ProductHasShoppingCart p WHERE p.quantity = :quantity")})
public class ProductHasShoppingCart implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductHasShoppingCartPK productHasShoppingCartPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "shopping_cart_user_id", referencedColumnName = "user_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private ShoppingCart shoppingCart;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductHasShoppingCart() {
    }

    public ProductHasShoppingCart(ProductHasShoppingCartPK productHasShoppingCartPK) {
        this.productHasShoppingCartPK = productHasShoppingCartPK;
    }

    public ProductHasShoppingCart(ProductHasShoppingCartPK productHasShoppingCartPK, int quantity) {
        this.productHasShoppingCartPK = productHasShoppingCartPK;
        this.quantity = quantity;
    }

    public ProductHasShoppingCart(int productId, int shoppingCartUserId) {
        this.productHasShoppingCartPK = new ProductHasShoppingCartPK(productId, shoppingCartUserId);
    }

    public ProductHasShoppingCartPK getProductHasShoppingCartPK() {
        return productHasShoppingCartPK;
    }

    public void setProductHasShoppingCartPK(ProductHasShoppingCartPK productHasShoppingCartPK) {
        this.productHasShoppingCartPK = productHasShoppingCartPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productHasShoppingCartPK != null ? productHasShoppingCartPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasShoppingCart)) {
            return false;
        }
        ProductHasShoppingCart other = (ProductHasShoppingCart) object;
        if ((this.productHasShoppingCartPK == null && other.productHasShoppingCartPK != null) || (this.productHasShoppingCartPK != null && !this.productHasShoppingCartPK.equals(other.productHasShoppingCartPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onemore.entity.ProductHasShoppingCart[ productHasShoppingCartPK=" + productHasShoppingCartPK + " ]";
    }
    
}
