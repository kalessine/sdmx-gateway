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
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author james
 */
@Entity
@Table(name = "annotationtext")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Annotationtext.findAll", query = "SELECT a FROM Annotationtext a"),
    @NamedQuery(name = "Annotationtext.findByLang", query = "SELECT a FROM Annotationtext a WHERE a.lang = :lang"),
    @NamedQuery(name = "Annotationtext.findByText", query = "SELECT a FROM Annotationtext a WHERE a.text = :text"),
    @NamedQuery(name = "Annotationtext.findByAnnotations", query = "SELECT a FROM Annotationtext a WHERE a.annotationtextPK.annotations = :annotations"),
    @NamedQuery(name = "Annotationtext.findByIndex", query = "SELECT a FROM Annotationtext a WHERE a.annotationtextPK.index = :index"),
    @NamedQuery(name = "Annotationtext.findByTextindex", query = "SELECT a FROM Annotationtext a WHERE a.annotationtextPK.textindex = :textindex")})
public class Annotationtext implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AnnotationtextPK annotationtextPK;
    @Size(max = 255)
    @Column(name = "lang")
    private String lang;
    @Size(max = 3000)
    @Column(name = "text")
    private String text;
    @JoinColumns({
        @JoinColumn(name = "annotations", referencedColumnName = "annotations", insertable = false, updatable = false),
        @JoinColumn(name = "index", referencedColumnName = "index", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Annotation annotation;

    public Annotationtext() {
    }

    public Annotationtext(AnnotationtextPK annotationtextPK) {
        this.annotationtextPK = annotationtextPK;
    }

    public Annotationtext(long annotations, short index, short textindex) {
        this.annotationtextPK = new AnnotationtextPK(annotations, index, textindex);
    }

    public AnnotationtextPK getAnnotationtextPK() {
        return annotationtextPK;
    }

    public void setAnnotationtextPK(AnnotationtextPK annotationtextPK) {
        this.annotationtextPK = annotationtextPK;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Annotation getAnnotation() {
        return annotation;
    }

    public void setAnnotation(Annotation annotation) {
        this.annotation = annotation;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (annotationtextPK != null ? annotationtextPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Annotationtext)) {
            return false;
        }
        Annotationtext other = (Annotationtext) object;
        if ((this.annotationtextPK == null && other.annotationtextPK != null) || (this.annotationtextPK != null && !this.annotationtextPK.equals(other.annotationtextPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sdmx.gateway.entities.Annotationtext[ annotationtextPK=" + annotationtextPK + " ]";
    }
    
}
