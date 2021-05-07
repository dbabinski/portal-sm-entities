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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import pl.softmedica.ea.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.ea.common.interfaces.InterfaceJSON;
import pl.softmedica.ea.common.utilities.JSONArrayBuilder;
import pl.softmedica.ea.common.utilities.JSONBuilder;
import pl.softmedica.ea.common.utilities.JSONObjectExt;
import pl.softmedica.ea.common.utilities.LinkedHashMapBuiler;

/**
 *
 * @author Łukasz Brzeziński<lukasz.brzezinski@softmedica.pl>
 */
@Entity
@Table(schema = "uzytkownicy", name = "uprawnienia_konta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UprawnieniaKonta.findAll", query = "SELECT u FROM UprawnieniaKonta u"),
    @NamedQuery(name = "UprawnieniaKonta.findById", query = "SELECT u FROM UprawnieniaKonta u WHERE u.id = :id"),
    @NamedQuery(name = "UprawnieniaKonta.findByIdKonta", query = "SELECT u FROM UprawnieniaKonta u WHERE u.idKonta = :idKonta")})
public class UprawnieniaKonta implements Serializable, InterfaceJSON<UprawnieniaKonta>, InterfaceDatabaseObject {

    private static final long serialVersionUID = -7680276683483183615L;
    
    public static final String DOSTEP_DO_KARTOTETKI_PACJENTA_POWIAZANEGO_KEY = "dostepDoKartotekiPacjentaPowiazanego";

    @Id
    @SequenceGenerator(name = "uzytkownicy.uprawnienia_id_gen", sequenceName = "uzytkownicy.uprawnienia_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownicy.uprawnienia_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @JoinColumn(name = "id_konta", referencedColumnName = "id")
    @ManyToOne
    private Konta idKonta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dostep_do_kartoteki_pacjenta_powiazanego")
    private boolean dostepDoKartotekiPacjentaPowiazanego;

    public UprawnieniaKonta() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public UprawnieniaKonta setId(Integer id) {
        this.id = id;
        return this;
    }

    public Konta getIdKonta() {
        return idKonta;
    }

    public UprawnieniaKonta setIdKonta(Konta idKonta) {
        this.idKonta = idKonta;
        return this;
    }

    public boolean isDostepDoKartotekiPacjentaPowiazanego() {
        return dostepDoKartotekiPacjentaPowiazanego;
    }

    public UprawnieniaKonta setDostepDoKartotekiPacjentaPowiazanego(boolean dostepDoKartotekiPacjentaPowiazanego) {
        this.dostepDoKartotekiPacjentaPowiazanego = dostepDoKartotekiPacjentaPowiazanego;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.idKonta);
        hash = 67 * hash + (this.dostepDoKartotekiPacjentaPowiazanego ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UprawnieniaKonta)) {
            return false;
        }
        UprawnieniaKonta other = (UprawnieniaKonta) object;
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
        return "pl.softmedica.euslugi.jpa.UprawnieniaKonta[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("idKonta", this.idKonta != null ? this.idKonta.getId() : null)
                .put("dostepDoKartotekiPacjentaPowiazanego", this.dostepDoKartotekiPacjentaPowiazanego)
                .build();
    }

    @Override
    public UprawnieniaKonta setJSON(JSONObject json) {
        if (json != null) {
            JSONObjectExt jsone = new JSONObjectExt(json);
            this.dostepDoKartotekiPacjentaPowiazanego = jsone.getBooleanSimple("dostepDoKartotekiPacjentaPowiazanego");
        }
        return this;
    }

    public static final JSONArray POLA_WYMAGANE = new JSONArrayBuilder()
            .add("idKonta")
            .add("dostepDoKartotekiPacjentaPowiazanego")
            .build();

    public static final HashMap<String, String> MAPA_POL = new LinkedHashMapBuiler<String, String>()
            .put("idKonta", "konto")
            .put("dostepDoKartotekiPacjentaPowiazanego", "Dostęp do kartoteki pacjenta powiązanego")
            .build();
}
