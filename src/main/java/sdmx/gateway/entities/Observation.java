/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "observation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Observation.findAll", query = "SELECT o FROM Observation o"),
    @NamedQuery(name = "Observation.findByObservation", query = "SELECT o FROM Observation o WHERE o.observationPK.observation = :observation"),
    @NamedQuery(name = "Observation.findByDateupdated", query = "SELECT o FROM Observation o WHERE o.dateupdated = :dateupdated"),
    @NamedQuery(name = "Observation.findByDataflow", query = "SELECT o FROM Observation o WHERE o.observationPK.dataflow = :dataflow")})
public class Observation implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ObservationPK observationPK;
    @Column(name = "dateupdated")
    @Temporal(TemporalType.DATE)
    private Date dateupdated;
    @JoinColumn(name = "dataflow", referencedColumnName = "dataflow", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Dataflow dataflow1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "observation1")
    private List<Value> valueList;

    public Observation() {
    }

    public Observation(ObservationPK observationPK) {
        this.observationPK = observationPK;
    }

    public Observation(long observation, long dataflow) {
        this.observationPK = new ObservationPK(observation, dataflow);
    }

    public ObservationPK getObservationPK() {
        return observationPK;
    }

    public void setObservationPK(ObservationPK observationPK) {
        this.observationPK = observationPK;
    }

    public Date getDateupdated() {
        return dateupdated;
    }

    public void setDateupdated(Date dateupdated) {
        this.dateupdated = dateupdated;
    }

    public Dataflow getDataflow1() {
        return dataflow1;
    }

    public void setDataflow1(Dataflow dataflow1) {
        this.dataflow1 = dataflow1;
    }

    @XmlTransient
    public List<Value> getValueList() {
        return valueList;
    }

    public void setValueList(List<Value> valueList) {
        this.valueList = valueList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (observationPK != null ? observationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Observation)) {
            return false;
        }
        Observation other = (Observation) object;
        if ((this.observationPK == null && other.observationPK != null) || (this.observationPK != null && !this.observationPK.equals(other.observationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Observation[ observationPK=" + observationPK + " ]";
    }
    
}
