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
public class AnnotationtextPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "annotations")
    private long annotations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "index")
    private short index;
    @Basic(optional = false)
    @NotNull
    @Column(name = "textindex")
    private short textindex;

    public AnnotationtextPK() {
    }

    public AnnotationtextPK(long annotations, short index, short textindex) {
        this.annotations = annotations;
        this.index = index;
        this.textindex = textindex;
    }

    public long getAnnotations() {
        return annotations;
    }

    public void setAnnotations(long annotations) {
        this.annotations = annotations;
    }

    public short getIndex() {
        return index;
    }

    public void setIndex(short index) {
        this.index = index;
    }

    public short getTextindex() {
        return textindex;
    }

    public void setTextindex(short textindex) {
        this.textindex = textindex;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) annotations;
        hash += (int) index;
        hash += (int) textindex;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AnnotationtextPK)) {
            return false;
        }
        AnnotationtextPK other = (AnnotationtextPK) object;
        if (this.annotations != other.annotations) {
            return false;
        }
        if (this.index != other.index) {
            return false;
        }
        if (this.textindex != other.textindex) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.AnnotationtextPK[ annotations=" + annotations + ", index=" + index + ", textindex=" + textindex + " ]";
    }
    
}
