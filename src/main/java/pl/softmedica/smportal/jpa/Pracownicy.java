/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.Comparator;
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
@Table(schema = "public", name = "pracownicy")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pracownicy.findAll", query = "SELECT p FROM Pracownicy p"),
    @NamedQuery(name = "Pracownicy.findById", query = "SELECT p FROM Pracownicy p WHERE p.id = :id"),
    @NamedQuery(name = "Pracownicy.findByKonto", query = "SELECT p FROM Pracownicy p WHERE p.konto = :konto")})
public class Pracownicy implements Serializable, InterfaceJSON<Pracownicy>, InterfaceDatabaseObject {

    private static final long serialVersionUID = 5408249825443934740L;

    @Id
    @SequenceGenerator(name = "public.pracownicy_id_gen", sequenceName = "public.pracownicy_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "public.pracownicy_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "id_konta")
    private Integer konto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "imie")
    private String imie;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2147483647)
    @Column(name = "nazwisko")
    private String nazwisko;
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
    @Column(name = "id_komorki_organizacyjnej")
    private Integer komorkaOrganizacyjna;

    public Pracownicy() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Pracownicy setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getKonto() {
        return konto;
    }

    public Pracownicy setKonto(Integer konta) {
        this.konto = konta;
        return this;
    }

    public String getImie() {
        return imie;
    }

    public Pracownicy setImie(String imie) {
        this.imie = imie;
        return this;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Pracownicy setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
        return this;
    }

    public String getTelefonKontaktowy() {
        return telefonKontaktowy;
    }

    public Pracownicy setTelefonKontaktowy(String telefonKontaktowy) {
        this.telefonKontaktowy = telefonKontaktowy;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Pracownicy setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPlec() {
        return plec;
    }

    public Pracownicy setPlec(String plec) {
        this.plec = plec;
        return this;
    }

    public Integer getKomorkaOrganizacyjna() {
        return komorkaOrganizacyjna;
    }

    public Pracownicy setKomorkaOrganizacyjna(Integer komorkaOrganizacyjna) {
        this.komorkaOrganizacyjna = komorkaOrganizacyjna;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.konto);
        hash = 89 * hash + Objects.hashCode(this.imie);
        hash = 89 * hash + Objects.hashCode(this.nazwisko);
        hash = 89 * hash + Objects.hashCode(this.telefonKontaktowy);
        hash = 89 * hash + Objects.hashCode(this.email);
        hash = 89 * hash + Objects.hashCode(this.plec);
        hash = 89 * hash + Objects.hashCode(this.komorkaOrganizacyjna);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Pracownicy)) {
            return false;
        }
        Pracownicy other = (Pracownicy) object;
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
        return "pl.softmedica.euslugi.zarzadzanie.jpa.Pracownicy[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("imie", this.imie)
                .put("nazwisko", this.nazwisko)
                .put("telefonKontaktowy", this.telefonKontaktowy)
                .put("email", this.email)
                .put("plec", this.plec)
                .build();
    }

    @Override
    public Pracownicy setJSON(JSONObject json) {
        if (json != null) {
            this.imie = Utilities.stringToNull((String) json.get("imie"));
            this.nazwisko = Utilities.stringToNull((String) json.get("nazwisko"));
            this.telefonKontaktowy = Utilities.stringToNull((String) json.get("telefonKontaktowy"));
            this.email = Utilities.stringToNull((String) json.get("email"));
            this.plec = Utilities.stringToNull((String) json.get("plec"));
        }
        return this;
    }
    
    public static Comparator<Pracownicy> COMPARATOR_BY_NAZWISKO_IMIE = (Pracownicy o1, Pracownicy o2) -> {
        if (o1 != null && o2 != null) {
            int result = Utilities.nullToString(o1.getNazwisko()).toString()
                    .compareTo(Utilities.nullToString(o2.getNazwisko()).toString());
            return ((result == 0)
                    ? Utilities.nullToString(o1.getImie()).toString().compareTo(Utilities.nullToString(o2.getImie()).toString())
                    : result);
        }
        return 0;
    };

    public static enum kolumnyDoImportu{
        IMIE,
        NAZWISKO,
        TELEFON_KONTAKTOWY,
        EMAIL,
        PLEC
    }
    
    public static final List<kolumnyDoImportu> COLUMN_LIST = new ListBuilder<kolumnyDoImportu>()
            .append(kolumnyDoImportu.IMIE)
            .append(kolumnyDoImportu.NAZWISKO)
            .append(kolumnyDoImportu.TELEFON_KONTAKTOWY)
            .append(kolumnyDoImportu.EMAIL)
            .append(kolumnyDoImportu.PLEC)
            .build();

    public static final HashMap<kolumnyDoImportu, Boolean> OBLIGATORY_COLUMNS_MAP = new LinkedHashMapBuiler<kolumnyDoImportu, Boolean>()
        .put(kolumnyDoImportu.IMIE, true)
        .put(kolumnyDoImportu.NAZWISKO, true)
        .put(kolumnyDoImportu.TELEFON_KONTAKTOWY, false)
        .put(kolumnyDoImportu.EMAIL, false)
        .put(kolumnyDoImportu.PLEC, true)
        .build();

    public static final HashMap<kolumnyDoImportu, String> EXAMPLE_COLUMN_VALUES = new LinkedHashMapBuiler<kolumnyDoImportu, String>()
        .put(kolumnyDoImportu.IMIE, "Jan")
        .put(kolumnyDoImportu.NAZWISKO, "Testowy")
        .put(kolumnyDoImportu.TELEFON_KONTAKTOWY, "000000000")
        .put(kolumnyDoImportu.EMAIL, "test@test.pl")
        .put(kolumnyDoImportu.PLEC, "m")
        .build();
}
