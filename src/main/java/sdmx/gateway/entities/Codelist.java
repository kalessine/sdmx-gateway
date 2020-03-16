/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "codelist")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Codelist.findAll", query = "SELECT c FROM Codelist c"),
    @NamedQuery(name = "Codelist.findByAgencyid", query = "SELECT c FROM Codelist c WHERE c.codelistPK.agencyid = :agencyid"),
    @NamedQuery(name = "Codelist.findById", query = "SELECT c FROM Codelist c WHERE c.codelistPK.id = :id"),
    @NamedQuery(name = "Codelist.findByVersion", query = "SELECT c FROM Codelist c WHERE c.codelistPK.version = :version")})
public class Codelist implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CodelistPK codelistPK;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codelist")
    private List<Code> codeList;
    @JoinColumn(name = "annotations", referencedColumnName = "annotations")
    @OneToOne
    private Annotations annotations;
    @JoinColumn(name = "name", referencedColumnName = "name")
    @OneToOne
    private Name name;

    public Codelist() {
    }

    public Codelist(CodelistPK codelistPK) {
        this.codelistPK = codelistPK;
    }

    public Codelist(String agencyid, String id, String version) {
        this.codelistPK = new CodelistPK(agencyid, id, version);
    }

    public CodelistPK getCodelistPK() {
        return codelistPK;
    }

    public void setCodelistPK(CodelistPK codelistPK) {
        this.codelistPK = codelistPK;
    }

    @XmlTransient
    public List<Code> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<Code> codeList) {
        this.codeList = codeList;
    }

    public Annotations getAnnotations() {
        return annotations;
    }

    public void setAnnotations(Annotations annotations) {
        this.annotations = annotations;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codelistPK != null ? codelistPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codelist)) {
            return false;
        }
        Codelist other = (Codelist) object;
        if ((this.codelistPK == null && other.codelistPK != null) || (this.codelistPK != null && !this.codelistPK.equals(other.codelistPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Codelist[ codelistPK=" + codelistPK + " ]";
    }
    
}
