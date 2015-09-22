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
@Table(name = "Users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users_1.findAll", query = "SELECT u FROM Users_1 u"),
    @NamedQuery(name = "Users_1.findById", query = "SELECT u FROM Users_1 u WHERE u.id = :id"),
    @NamedQuery(name = "Users_1.findByNikname", query = "SELECT u FROM Users_1 u WHERE u.nikname = :nikname"),
    @NamedQuery(name = "Users_1.findByPassword", query = "SELECT u FROM Users_1 u WHERE u.password = :password")})
public class Users_1 implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2000000000)
    @Column(name = "Nikname")
    private String nikname;
    @Size(max = 2000000000)
    @Column(name = "Password")
    private String password;

    public Users_1() {
    }

    public Users_1(Integer id) {
        this.id = id;
    }

    public Users_1(Integer id, String nikname) {
        this.id = id;
        this.nikname = nikname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNikname() {
        return nikname;
    }

    public void setNikname(String nikname) {
        this.nikname = nikname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        if (!(object instanceof Users_1)) {
            return false;
        }
        Users_1 other = (Users_1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Users_1[ id=" + id + " ]";
    }
    
}
