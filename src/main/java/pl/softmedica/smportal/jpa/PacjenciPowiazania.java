/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONObject;
import pl.softmedica.smportal.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.smportal.common.interfaces.InterfaceJSON;
import pl.softmedica.smportal.common.utilities.JSONBuilder;

/**
 *
 * @author Lucek
 */

@Entity
@Table(schema = "uzytkownicy", name = "pacjenci_powiazania")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PacjenciPowiazania.findAll", query = "SELECT p FROM PacjenciPowiazania p"),
    @NamedQuery(name = "PacjenciPowiazania.findById", query = "SELECT p FROM PacjenciPowiazania p WHERE p.id = :id")})
public class PacjenciPowiazania implements Serializable, InterfaceJSON<PacjenciPowiazania>, InterfaceDatabaseObject {

    private static final long serialVersionUID = -1074409810004633322L;

    @Id
    @SequenceGenerator(name = "uzytkownicy.pacjenci_powiazania_id_gen", sequenceName = "uzytkownicy.pacjenci_powiazania_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownicy.pacjenci_powiazania_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;   
    private Boolean nadrzedne;
    @JoinColumn(name = "id_konta", referencedColumnName = "id")
    @ManyToOne
    private Konta konto;
    @JoinColumn(name = "id_pacjenta", referencedColumnName = "id")
    @ManyToOne
    private Pacjenci pacjent;

    public PacjenciPowiazania() {
    }    
    
    @Override
    public Integer getId() {
        return id;
    }

    public PacjenciPowiazania setId(Integer id) {
        this.id = id;
        return this;
    }

    public Konta getKonto() {
        return konto;
    }

    public PacjenciPowiazania setKonto(Konta konto) {
        this.konto = konto;
        return this;
    }

    public Pacjenci getPacjent() {
        return pacjent;
    }

    public PacjenciPowiazania setPacjent(Pacjenci pacjent) {
        this.pacjent = pacjent;
        return this;
    }

    public Boolean getNadrzedne() {
        return nadrzedne;
    }

    public PacjenciPowiazania setNadrzedne(Boolean nadrzedne) {
        this.nadrzedne = nadrzedne;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.konto);
        hash = 89 * hash + Objects.hashCode(this.pacjent);
        hash = 89 * hash + Objects.hashCode(this.nadrzedne);
        return hash;
    }
    
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PacjenciPowiazania)) {
            return false;
        }
        PacjenciPowiazania other = (PacjenciPowiazania) object;
        if (this.id != null && other.id != null) {
            if (!this.id.equals(other.id)) {
                return false;
            }
        } else if (System.identityHashCode(this) != System.identityHashCode(object)) {
            return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        return "pl.softmedica.smportal.jpa.PracownicyPowiazania[ id=" + id + " ]";
    }
    
    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("konto", this.konto)
                .put("pacjent", this.pacjent)
                .put("nadrzedne", this.nadrzedne)
                .build();
    }

    @Override
    public PacjenciPowiazania setJSON(JSONObject json) {
        return this;
    }
    
}
