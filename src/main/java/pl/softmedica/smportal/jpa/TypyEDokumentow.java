/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.softmedica.ea.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.ea.common.interfaces.InterfaceJSON;
import pl.softmedica.ea.common.utilities.JSONArrayBuilder;
import pl.softmedica.ea.common.utilities.JSONBuilder;
import pl.softmedica.ea.common.utilities.LinkedHashMapBuiler;
import pl.softmedica.ea.common.utilities.Utilities;

/**
 *
 * @author Lucek
 */
@Entity
@Table(schema = "slowniki", name = "typy_e_dokumentow")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypyEDokumentow.findAll", query = "SELECT t FROM TypyEDokumentow t"),
    @NamedQuery(name = "TypyEDokumentow.findById", query = "SELECT t FROM TypyEDokumentow t WHERE t.id = :id")})
public class TypyEDokumentow implements Serializable, InterfaceJSON<TypyEDokumentow>, InterfaceDatabaseObject {

    private static final long serialVersionUID = -1541338631271359997L;

    @Id
    @SequenceGenerator(name = "slowniki.typy_e_dokumentow_id_gen", sequenceName = "slowniki.typy_e_dokumentow_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "slowniki.typy_e_dokumentow_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "opis")
    private String opis;

    public TypyEDokumentow() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public TypyEDokumentow setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getOpis() {
        return opis;
    }

    public TypyEDokumentow setOpis(String opis) {
        this.opis = opis;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.opis);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof TypyEDokumentow)) {
            return false;
        }
        TypyEDokumentow other = (TypyEDokumentow) object;
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
        return "pl.softmedica.smportal.jpa.TypyEDokumentow[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("opis", this.opis)
                .build();
    }

    @Override
    public TypyEDokumentow setJSON(JSONObject json) {
        if (json != null) {
            this.opis = Utilities.stringToNull((String) json.get("opis"));
        }
        return this;
    }

    public static final JSONArray POLA_WYMAGANE = new JSONArrayBuilder()
            .add("opis")
            .build();

    public static final HashMap<String, String> MAPA_POL = new LinkedHashMapBuiler<String, String>()
            .put("opis", "Opis")
            .build();
}
