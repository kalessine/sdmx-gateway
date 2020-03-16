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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@Entity
@Table(name = "nametext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nametext.findAll", query = "SELECT n FROM Nametext n"),
    @NamedQuery(name = "Nametext.findByText", query = "SELECT n FROM Nametext n WHERE n.text = :text"),
    @NamedQuery(name = "Nametext.findByLang", query = "SELECT n FROM Nametext n WHERE n.nametextPK.lang = :lang"),
    @NamedQuery(name = "Nametext.findByName", query = "SELECT n FROM Nametext n WHERE n.nametextPK.name = :name")})
public class Nametext implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NametextPK nametextPK;
    @Size(max = 255)
    @Column(name = "text")
    private String text;
    @JoinColumn(name = "lang", referencedColumnName = "lang", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Language language;
    @JoinColumn(name = "name", referencedColumnName = "name", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Name name1;

    public Nametext() {
    }

    public Nametext(NametextPK nametextPK) {
        this.nametextPK = nametextPK;
    }

    public Nametext(String lang, long name) {
        this.nametextPK = new NametextPK(lang, name);
    }

    public NametextPK getNametextPK() {
        return nametextPK;
    }

    public void setNametextPK(NametextPK nametextPK) {
        this.nametextPK = nametextPK;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Name getName1() {
        return name1;
    }

    public void setName1(Name name1) {
        this.name1 = name1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nametextPK != null ? nametextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nametext)) {
            return false;
        }
        Nametext other = (Nametext) object;
        if ((this.nametextPK == null && other.nametextPK != null) || (this.nametextPK != null && !this.nametextPK.equals(other.nametextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Nametext[ nametextPK=" + nametextPK + " ]";
    }
    
}
