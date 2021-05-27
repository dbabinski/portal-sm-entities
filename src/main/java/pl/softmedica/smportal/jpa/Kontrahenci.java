/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
import org.json.simple.JSONObject;
import pl.softmedica.ea.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.ea.common.interfaces.InterfaceJSON;
import pl.softmedica.ea.common.utilities.JSONBuilder;
import pl.softmedica.ea.common.utilities.LinkedHashMapBuiler;
import pl.softmedica.ea.common.utilities.ListBuilder;
import pl.softmedica.ea.common.utilities.Utilities;

/**
 *
 * @author Lucek
 */
@Entity
@Table(schema = "public", name = "kontrahenci")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kontrahenci.findAll", query = "SELECT k FROM Kontrahenci k"),
    @NamedQuery(name = "Kontrahenci.findById", query = "SELECT k FROM Kontrahenci k WHERE k.id = :id"),
    @NamedQuery(name = "Kontrahenci.findByKonto", query = "SELECT k FROM Kontrahenci k WHERE k.konto = :konto")
})
public class Kontrahenci implements Serializable, InterfaceJSON<Kontrahenci>,  InterfaceDatabaseObject {

    private static final long serialVersionUID = -1776163171420456037L;

    @Id
    @SequenceGenerator(name = "public.kontrahenci_id_gen", sequenceName = "public.kontrahenci_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.kontrahenci_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_konta")
    private Integer konto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwa")
    private String nazwa;
    @Size(max = 2147483647)
    @Column(name = "telefon_kontaktowy")
    private String telefonKontaktowy;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 2147483647)
    @Column(name = "email")
    private String email;
    @Size(max = 2147483647)
    @Column(name = "plec")
    private String plec;

    public Kontrahenci() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Kontrahenci setId(Integer id) {
        this.id = id;
        return this;
    }

    /*public Integer getKonto() {
        return konto;
    }*/

    /*public Kontrahenci setKonto(Integer Konto) {
        this.konto = Konto;
        return this;
    }*/

    public String getNazwa() {
        return nazwa;
    }

    public Kontrahenci setNazwa(String nazwa) {
        this.nazwa = nazwa;
        return this;
    }

    public String getTelefonKontaktowy() {
        return telefonKontaktowy;
    }

    public Kontrahenci setTelefonKontaktowy(String telefonKontaktowy) {
        this.telefonKontaktowy = telefonKontaktowy;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Kontrahenci setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPlec() {
        return plec;
    }

    public Kontrahenci setPlec(String plec) {
        this.plec = plec;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        //hash = 89 * hash + Objects.hashCode(this.konto);
        hash = 89 * hash + Objects.hashCode(this.nazwa);
        hash = 89 * hash + Objects.hashCode(this.telefonKontaktowy);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.plec);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Kontrahenci)) {
            return false;
        }
        Kontrahenci other = (Kontrahenci) object;
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
        return "pl.softmedica.smportal.zarzadzanie.jpa.Kontrahenci[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("nazwa", this.nazwa)
                .put("telefonKontaktowy", this.telefonKontaktowy)
                .put("email", this.email)
                .put("plec", this.plec)
                .build();
    }

    @Override
    public Kontrahenci setJSON(JSONObject json) {
        if (json != null) {
            this.nazwa = Utilities.stringToNull((String) json.get("nazwa"));
            this.telefonKontaktowy = Utilities.stringToNull((String) json.get("telefonKontaktowy"));
            this.email = Utilities.stringToNull((String) json.get("email"));
            this.plec = Utilities.stringToNull((String) json.get("plec"));
        }
        return this;
    }

    public static enum kolumnyDoImportu{
        NAZWA,
        TELEFON_KONTAKTOWY,
        EMAIL
    }
    
    public static final List<kolumnyDoImportu> COLUMN_LIST = new ListBuilder<kolumnyDoImportu>()
            .append(kolumnyDoImportu.NAZWA)
            .append(kolumnyDoImportu.TELEFON_KONTAKTOWY)
            .append(kolumnyDoImportu.EMAIL)
            .build();

    public static final HashMap<kolumnyDoImportu, Boolean> OBLIGATORY_COLUMNS_MAP = new LinkedHashMapBuiler<kolumnyDoImportu, Boolean>()
        .put(kolumnyDoImportu.NAZWA, true)
        .put(kolumnyDoImportu.TELEFON_KONTAKTOWY, false)
        .put(kolumnyDoImportu.EMAIL, false)
        .build();

    public static final HashMap<kolumnyDoImportu, String> EXAMPLE_COLUMN_VALUES = new LinkedHashMapBuiler<kolumnyDoImportu, String>()
        .put(kolumnyDoImportu.NAZWA, "Kontrahent testowy")
        .put(kolumnyDoImportu.TELEFON_KONTAKTOWY, "000000000")
        .put(kolumnyDoImportu.EMAIL, "test@test.pl")
        .build();    
}
