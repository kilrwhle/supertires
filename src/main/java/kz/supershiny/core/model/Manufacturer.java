/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package kz.supershiny.core.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author kilrwhle
 */
@Entity
@Table(name = "MANUFACTURERS")
public class Manufacturer implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "COMPANY_NAME", unique = true)
    private String companyName;
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    private String description;
    
    public Manufacturer() {
    }
    
    public Manufacturer(String companyName) {
        this(companyName, null);
    }

    public Manufacturer(String companyName, String description) {
        this.companyName = companyName;
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.companyName != null ? this.companyName.hashCode() : 0);
        hash = 53 * hash + (this.description != null ? this.description.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Manufacturer other = (Manufacturer) obj;
        if ((this.companyName == null) ? (other.companyName != null) : !this.companyName.equals(other.companyName)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return companyName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
