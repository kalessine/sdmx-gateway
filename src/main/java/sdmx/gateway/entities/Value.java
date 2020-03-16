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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@Entity
@Table(name = "value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Value.findAll", query = "SELECT v FROM Value v"),
    @NamedQuery(name = "Value.findByObservation", query = "SELECT v FROM Value v WHERE v.observation = :observation")})
public class Value implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "observation")
    private Long observation;
    @JoinColumns({
        @JoinColumn(name = "observation", referencedColumnName = "observation", insertable = false, updatable = false),
        @JoinColumn(name = "dataflow", referencedColumnName = "dataflow")})
    @ManyToOne(optional = false)
    private Observation observation1;

    public Value() {
    }

    public Value(Long observation) {
        this.observation = observation;
    }

    public Long getObservation() {
        return observation;
    }

    public void setObservation(Long observation) {
        this.observation = observation;
    }

    public Observation getObservation1() {
        return observation1;
    }

    public void setObservation1(Observation observation1) {
        this.observation1 = observation1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observation != null ? observation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Value)) {
            return false;
        }
        Value other = (Value) object;
        if ((this.observation == null && other.observation != null) || (this.observation != null && !this.observation.equals(other.observation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Value[ observation=" + observation + " ]";
    }
    
}
