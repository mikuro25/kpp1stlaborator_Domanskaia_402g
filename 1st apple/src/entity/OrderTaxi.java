/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Hanna
 */
@Entity
@Table(name = "OrderTaxi")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderTaxi.findAll", query = "SELECT o FROM OrderTaxi o"),
    @NamedQuery(name = "OrderTaxi.findById", query = "SELECT o FROM OrderTaxi o WHERE o.id = :id"),
    @NamedQuery(name = "OrderTaxi.findByPhone", query = "SELECT o FROM OrderTaxi o WHERE o.phone = :phone"),
    @NamedQuery(name = "OrderTaxi.findByName", query = "SELECT o FROM OrderTaxi o WHERE o.name = :name"),
    @NamedQuery(name = "OrderTaxi.findByMarka", query = "SELECT o FROM OrderTaxi o WHERE o.marka = :marka")})
public class OrderTaxi implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Column(name = "Phone")
    private Integer phone;
    @Size(max = 2000000000)
    @Column(name = "Name")
    private String name;
    @Size(max = 2000000000)
    @Column(name = "Marka")
    private String marka;

    public OrderTaxi() {
    }

    public OrderTaxi(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderTaxi)) {
            return false;
        }
        OrderTaxi other = (OrderTaxi) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return " id=" + id + " ]"+" Phone ="+phone+" cars="+marka+"\n";
    }
    
}
