/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author james
 */
@Embeddable
public class ObservationPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "observation")
    private long observation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataflow")
    private long dataflow;

    public ObservationPK() {
    }

    public ObservationPK(long observation, long dataflow) {
        this.observation = observation;
        this.dataflow = dataflow;
    }

    public long getObservation() {
        return observation;
    }

    public void setObservation(long observation) {
        this.observation = observation;
    }

    public long getDataflow() {
        return dataflow;
    }

    public void setDataflow(long dataflow) {
        this.dataflow = dataflow;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) observation;
        hash += (int) dataflow;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ObservationPK)) {
            return false;
        }
        ObservationPK other = (ObservationPK) object;
        if (this.observation != other.observation) {
            return false;
        }
        if (this.dataflow != other.dataflow) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.ObservationPK[ observation=" + observation + ", dataflow=" + dataflow + " ]";
    }
    
}
