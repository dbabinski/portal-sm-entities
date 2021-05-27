/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.softmedica.ea.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.ea.common.interfaces.InterfaceJSON;
import pl.softmedica.ea.common.utilities.JSONArrayBuilder;
import pl.softmedica.ea.common.utilities.JSONBuilder;
import pl.softmedica.ea.common.utilities.JSONObjectExt;
import pl.softmedica.ea.common.utilities.LinkedHashMapBuiler;
import pl.softmedica.ea.common.utilities.Utilities;

/**
 *
 * @author Łukasz Brzeziński <lukasz.brzezinski@softmedica.pl>
 */
@Entity
@Table(schema = "kody", name = "jednorazowe_kody_dostepu")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "JednorazoweKodyDostepu.findAll", query = "SELECT k FROM JednorazoweKodyDostepu k"),
    @NamedQuery(name = "JednorazoweKodyDostepu.findById", query = "SELECT k FROM JednorazoweKodyDostepu k WHERE k.id = :id")})
public class JednorazoweKodyDostepu implements Serializable, InterfaceJSON<JednorazoweKodyDostepu>, InterfaceDatabaseObject {

    private static final long serialVersionUID = 3950054578979993216L;

    @Id
    @SequenceGenerator(name = "uzytkownicy.grupy_id_gen", sequenceName = "uzytkownicy.grupy_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownicy.grupy_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "kod")
    private String kod;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "pesel")
    private String pesel;
    @Column(name = "znacznik_czasu_utworzenia", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date znacznikCzasuUtworzenia = new Date();
    @Column(name = "wazny_do", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date waznyDo;
    @Column(name = "znacznik_czasu_uzycia", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date znacznikCzasuUzycia = null;

    public JednorazoweKodyDostepu() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public JednorazoweKodyDostepu setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getKod() {
        return kod;
    }

    public JednorazoweKodyDostepu setKod(String kod) {
        this.kod = kod;
        return this;
    }

    public String getPesel() {
        return pesel;
    }

    public JednorazoweKodyDostepu setPesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public Date getZnacznikCzasuUtworzenia() {
        return znacznikCzasuUtworzenia;
    }

    public JednorazoweKodyDostepu setZnacznikCzasuUtworzenia(Date znacznikCzasuUtworzenia) {
        this.znacznikCzasuUtworzenia = znacznikCzasuUtworzenia;
        return this;
    }

    public Date getWaznyDo() {
        return waznyDo;
    }

    public JednorazoweKodyDostepu setWaznyDo(Date waznyDo) {
        this.waznyDo = waznyDo;
        return this;
    }

    public Date getZnacznikCzasuUzycia() {
        return znacznikCzasuUzycia;
    }

    public JednorazoweKodyDostepu setZnacznikCzasuUzycia(Date znacznikCzasuUzycia) {
        this.znacznikCzasuUzycia = znacznikCzasuUzycia;
        return this;
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("kod", this.kod)
                .put("pesel", this.pesel)
                .put("waznyDo", Utilities.dateToString(this.waznyDo, Utilities.DATE_TIME_FORMAT))
                .put("znacznikCzasuUtworzenia", Utilities.dateToString(this.znacznikCzasuUtworzenia, Utilities.DATE_TIME_SEC_FORMAT))                
                .put("znacznikCzasuUzycia", Utilities.dateToString(this.znacznikCzasuUzycia, Utilities.DATE_TIME_SEC_FORMAT))
                .build();
    }

    @Override
    public JednorazoweKodyDostepu setJSON(JSONObject json) {
        if (json != null) {
            JSONObjectExt jsone = new JSONObjectExt(json);
            this.kod = jsone.getString("kod");
            this.pesel = jsone.getString("pesel");
            this.waznyDo = jsone.getDateTime("waznyDo");
            //this.znacznikCzasuUtworzenia = jsone.getDateTime("znacznikCzasuUtworzenia");            
            //this.znacznikCzasuUzycia = jsone.getDate("znacznikCzasuUzycia");
        }
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.kod);
        hash = 11 * hash + Objects.hashCode(this.pesel);
        hash = 11 * hash + Objects.hashCode(this.znacznikCzasuUtworzenia);
        hash = 11 * hash + Objects.hashCode(this.waznyDo);
        hash = 11 * hash + Objects.hashCode(this.znacznikCzasuUzycia);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof JednorazoweKodyDostepu)) {
            return false;
        }
        JednorazoweKodyDostepu other = (JednorazoweKodyDostepu) object;
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
        return "pl.softmedica.smportal.jpa.JednorazoweKodyDostepu[ id=" + id + " ]";
    }

    public static final JSONArray POLA_WYMAGANE = new JSONArrayBuilder()
            .add("kod")
            .add("pesel")
            .add("waznyDo")
            .build();

    public static final HashMap<String, String> MAPA_POL = new LinkedHashMapBuiler<String, String>()
            .put("kod", "Kod")
            .put("pesel", "PESEL")
            .put("waznyDo", "Ważny do")
            .put("znacznikCzasuUtworzenia", "Czas utworzenia")
            .put("znacznikCzasuUzycia", "Czas użycia")
            .build();
}
