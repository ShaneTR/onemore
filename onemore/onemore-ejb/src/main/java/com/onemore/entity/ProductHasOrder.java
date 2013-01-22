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
@Table(name = "product_has_order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductHasOrder.findAll", query = "SELECT p FROM ProductHasOrder p"),
    @NamedQuery(name = "ProductHasOrder.findByProductId", query = "SELECT p FROM ProductHasOrder p WHERE p.productHasOrderPK.productId = :productId"),
    @NamedQuery(name = "ProductHasOrder.findByOrderId", query = "SELECT p FROM ProductHasOrder p WHERE p.productHasOrderPK.orderId = :orderId"),
    @NamedQuery(name = "ProductHasOrder.findByQuantity", query = "SELECT p FROM ProductHasOrder p WHERE p.quantity = :quantity")})
public class ProductHasOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ProductHasOrderPK productHasOrderPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @JoinColumn(name = "order_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private CustomerOrder customerOrder;
    @JoinColumn(name = "product_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Product product;

    public ProductHasOrder() {
    }

    public ProductHasOrder(ProductHasOrderPK productHasOrderPK) {
        this.productHasOrderPK = productHasOrderPK;
    }

    public ProductHasOrder(ProductHasOrderPK productHasOrderPK, int quantity) {
        this.productHasOrderPK = productHasOrderPK;
        this.quantity = quantity;
    }

    public ProductHasOrder(int productId, int orderId) {
        this.productHasOrderPK = new ProductHasOrderPK(productId, orderId);
    }

    public ProductHasOrderPK getProductHasOrderPK() {
        return productHasOrderPK;
    }

    public void setProductHasOrderPK(ProductHasOrderPK productHasOrderPK) {
        this.productHasOrderPK = productHasOrderPK;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public CustomerOrder getCustomerOrder() {
        return customerOrder;
    }

    public void setCustomerOrder(CustomerOrder customerOrder) {
        this.customerOrder = customerOrder;
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
        hash += (productHasOrderPK != null ? productHasOrderPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductHasOrder)) {
            return false;
        }
        ProductHasOrder other = (ProductHasOrder) object;
        if ((this.productHasOrderPK == null && other.productHasOrderPK != null) || (this.productHasOrderPK != null && !this.productHasOrderPK.equals(other.productHasOrderPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.onemore.entity.ProductHasOrder[ productHasOrderPK=" + productHasOrderPK + " ]";
    }
    
}
