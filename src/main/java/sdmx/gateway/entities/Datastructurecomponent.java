/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
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
@Table(name = "datastructurecomponent")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Datastructurecomponent.findAll", query = "SELECT d FROM Datastructurecomponent d"),
    @NamedQuery(name = "Datastructurecomponent.findByAssignmentstatus", query = "SELECT d FROM Datastructurecomponent d WHERE d.assignmentstatus = :assignmentstatus"),
    @NamedQuery(name = "Datastructurecomponent.findByType", query = "SELECT d FROM Datastructurecomponent d WHERE d.type = :type"),
    @NamedQuery(name = "Datastructurecomponent.findByComponentid", query = "SELECT d FROM Datastructurecomponent d WHERE d.componentid = :componentid"),
    @NamedQuery(name = "Datastructurecomponent.findByAgencyid", query = "SELECT d FROM Datastructurecomponent d WHERE d.datastructurecomponentPK.agencyid = :agencyid"),
    @NamedQuery(name = "Datastructurecomponent.findById", query = "SELECT d FROM Datastructurecomponent d WHERE d.datastructurecomponentPK.id = :id"),
    @NamedQuery(name = "Datastructurecomponent.findByVersion", query = "SELECT d FROM Datastructurecomponent d WHERE d.datastructurecomponentPK.version = :version"),
    @NamedQuery(name = "Datastructurecomponent.findByPosition", query = "SELECT d FROM Datastructurecomponent d WHERE d.datastructurecomponentPK.position = :position")})
public class Datastructurecomponent implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DatastructurecomponentPK datastructurecomponentPK;
    @Size(max = 255)
    @Column(name = "assignmentstatus")
    private String assignmentstatus;
    @Column(name = "type")
    private Integer type;
    @Size(max = 255)
    @Column(name = "componentid")
    private String componentid;
    @JoinColumn(name = "annotations", referencedColumnName = "annotations")
    @OneToOne
    private Annotations annotations;
    @JoinColumn(name = "attributerelationshiptype", referencedColumnName = "attributerelationshiptype")
    @OneToOne
    private Attributerelationshiptype attributerelationshiptype;
    @JoinColumn(name = "codelistenumeration", referencedColumnName = "reference")
    @OneToOne
    private Codelistreference codelistenumeration;
    @JoinColumn(name = "conceptidentity", referencedColumnName = "reference")
    @OneToOne
    private Conceptreference conceptidentity;
    @JoinColumn(name = "conceptschemeenumeration", referencedColumnName = "reference")
    @OneToOne
    private Conceptschemereference conceptschemeenumeration;
    @JoinColumns({
        @JoinColumn(name = "agencyid", referencedColumnName = "agencyid", insertable = false, updatable = false),
        @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false),
        @JoinColumn(name = "version", referencedColumnName = "version", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Datastructure datastructure;

    public Datastructurecomponent() {
    }

    public Datastructurecomponent(DatastructurecomponentPK datastructurecomponentPK) {
        this.datastructurecomponentPK = datastructurecomponentPK;
    }

    public Datastructurecomponent(String agencyid, String id, String version, short position) {
        this.datastructurecomponentPK = new DatastructurecomponentPK(agencyid, id, version, position);
    }

    public DatastructurecomponentPK getDatastructurecomponentPK() {
        return datastructurecomponentPK;
    }

    public void setDatastructurecomponentPK(DatastructurecomponentPK datastructurecomponentPK) {
        this.datastructurecomponentPK = datastructurecomponentPK;
    }

    public String getAssignmentstatus() {
        return assignmentstatus;
    }

    public void setAssignmentstatus(String assignmentstatus) {
        this.assignmentstatus = assignmentstatus;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getComponentid() {
        return componentid;
    }

    public void setComponentid(String componentid) {
        this.componentid = componentid;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Attributerelationshiptype getAttributerelationshiptype() {
        return attributerelationshiptype;
    }

    public void setAttributerelationshiptype(Attributerelationshiptype attributerelationshiptype) {
        this.attributerelationshiptype = attributerelationshiptype;
    }

    public Codelistreference getCodelistenumeration() {
        return codelistenumeration;
    }

    public void setCodelistenumeration(Codelistreference codelistenumeration) {
        this.codelistenumeration = codelistenumeration;
    }

    public Conceptreference getConceptidentity() {
        return conceptidentity;
    }

    public void setConceptidentity(Conceptreference conceptidentity) {
        this.conceptidentity = conceptidentity;
    }

    public Conceptschemereference getConceptschemeenumeration() {
        return conceptschemeenumeration;
    }

    public void setConceptschemeenumeration(Conceptschemereference conceptschemeenumeration) {
        this.conceptschemeenumeration = conceptschemeenumeration;
    }

    public Datastructure getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(Datastructure datastructure) {
        this.datastructure = datastructure;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (datastructurecomponentPK != null ? datastructurecomponentPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Datastructurecomponent)) {
            return false;
        }
        Datastructurecomponent other = (Datastructurecomponent) object;
        if ((this.datastructurecomponentPK == null && other.datastructurecomponentPK != null) || (this.datastructurecomponentPK != null && !this.datastructurecomponentPK.equals(other.datastructurecomponentPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Datastructurecomponent[ datastructurecomponentPK=" + datastructurecomponentPK + " ]";
    }
    
}
