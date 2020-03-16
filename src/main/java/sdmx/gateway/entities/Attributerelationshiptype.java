/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@Entity
@Table(name = "attributerelationshiptype")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attributerelationshiptype.findAll", query = "SELECT a FROM Attributerelationshiptype a"),
    @NamedQuery(name = "Attributerelationshiptype.findByAttributerelationshiptype", query = "SELECT a FROM Attributerelationshiptype a WHERE a.attributerelationshiptype = :attributerelationshiptype"),
    @NamedQuery(name = "Attributerelationshiptype.findByEmpty", query = "SELECT a FROM Attributerelationshiptype a WHERE a.empty = :empty"),
    @NamedQuery(name = "Attributerelationshiptype.findByAttachgroup", query = "SELECT a FROM Attributerelationshiptype a WHERE a.attachgroup = :attachgroup"),
    @NamedQuery(name = "Attributerelationshiptype.findByAttachgroups", query = "SELECT a FROM Attributerelationshiptype a WHERE a.attachgroups = :attachgroups"),
    @NamedQuery(name = "Attributerelationshiptype.findByPrimarymeasurereference", query = "SELECT a FROM Attributerelationshiptype a WHERE a.primarymeasurereference = :primarymeasurereference")})
public class Attributerelationshiptype implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "attributerelationshiptype")
    private Long attributerelationshiptype;
    @Column(name = "empty")
    private Short empty;
    @Size(max = 255)
    @Column(name = "attachgroup")
    private String attachgroup;
    @Column(name = "attachgroups")
    private Short attachgroups;
    @Size(max = 2147483647)
    @Column(name = "primarymeasurereference")
    private String primarymeasurereference;
    @OneToOne(mappedBy = "attributerelationshiptype")
    private Datastructurecomponent datastructurecomponent;

    public Attributerelationshiptype() {
    }

    public Attributerelationshiptype(Long attributerelationshiptype) {
        this.attributerelationshiptype = attributerelationshiptype;
    }

    public Long getAttributerelationshiptype() {
        return attributerelationshiptype;
    }

    public void setAttributerelationshiptype(Long attributerelationshiptype) {
        this.attributerelationshiptype = attributerelationshiptype;
    }

    public Short getEmpty() {
        return empty;
    }

    public void setEmpty(Short empty) {
        this.empty = empty;
    }

    public String getAttachgroup() {
        return attachgroup;
    }

    public void setAttachgroup(String attachgroup) {
        this.attachgroup = attachgroup;
    }

    public Short getAttachgroups() {
        return attachgroups;
    }

    public void setAttachgroups(Short attachgroups) {
        this.attachgroups = attachgroups;
    }

    public String getPrimarymeasurereference() {
        return primarymeasurereference;
    }

    public void setPrimarymeasurereference(String primarymeasurereference) {
        this.primarymeasurereference = primarymeasurereference;
    }

    public Datastructurecomponent getDatastructurecomponent() {
        return datastructurecomponent;
    }

    public void setDatastructurecomponent(Datastructurecomponent datastructurecomponent) {
        this.datastructurecomponent = datastructurecomponent;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attributerelationshiptype != null ? attributerelationshiptype.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attributerelationshiptype)) {
            return false;
        }
        Attributerelationshiptype other = (Attributerelationshiptype) object;
        if ((this.attributerelationshiptype == null && other.attributerelationshiptype != null) || (this.attributerelationshiptype != null && !this.attributerelationshiptype.equals(other.attributerelationshiptype))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Attributerelationshiptype[ attributerelationshiptype=" + attributerelationshiptype + " ]";
    }
    
}
