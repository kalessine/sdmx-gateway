/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sdmx.gateway.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author james
 */
@Entity
@Table(name = "name")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Name.findAll", query = "SELECT n FROM Name n"),
    @NamedQuery(name = "Name.findByName", query = "SELECT n FROM Name n WHERE n.name = :name"),
    @NamedQuery(name = "Name.findByEn", query = "SELECT n FROM Name n WHERE n.en = :en")})
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "name")
    private Long name;
    @Size(max = 255)
    @Column(name = "en")
    private String en;
    @OneToOne(mappedBy = "name")
    private Code code;
    @OneToOne(mappedBy = "name")
    private Codelist codelist;
    @OneToOne(mappedBy = "name")
    private Concept concept;
    @OneToOne(mappedBy = "name")
    private Dataflow dataflow;
    @OneToOne(mappedBy = "name")
    private Conceptscheme conceptscheme;
    @OneToOne(mappedBy = "name")
    private Datastructure datastructure;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "name1")
    private List<Nametext> nametextList;

    public Name() {
    }

    public Name(Long name) {
        this.name = name;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public Code getCode() {
        return code;
    }

    public void setCode(Code code) {
        this.code = code;
    }

    public Codelist getCodelist() {
        return codelist;
    }

    public void setCodelist(Codelist codelist) {
        this.codelist = codelist;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Dataflow getDataflow() {
        return dataflow;
    }

    public void setDataflow(Dataflow dataflow) {
        this.dataflow = dataflow;
    }

    public Conceptscheme getConceptscheme() {
        return conceptscheme;
    }

    public void setConceptscheme(Conceptscheme conceptscheme) {
        this.conceptscheme = conceptscheme;
    }

    public Datastructure getDatastructure() {
        return datastructure;
    }

    public void setDatastructure(Datastructure datastructure) {
        this.datastructure = datastructure;
    }

    @XmlTransient
    public List<Nametext> getNametextList() {
        return nametextList;
    }

    public void setNametextList(List<Nametext> nametextList) {
        this.nametextList = nametextList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Name)) {
            return false;
        }
        Name other = (Name) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Name[ name=" + name + " ]";
    }
    
}
