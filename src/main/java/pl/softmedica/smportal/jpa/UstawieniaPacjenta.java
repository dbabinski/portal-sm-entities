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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import org.json.simple.JSONObject;
import pl.softmedica.smportal.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.smportal.common.interfaces.InterfaceJSON;
import pl.softmedica.smportal.common.utilities.JSONArrayBuilder;
import pl.softmedica.smportal.common.utilities.JSONBuilder;
import pl.softmedica.smportal.common.utilities.JSONObjectExt;

/**
 *
 * @author Lucek
 */
@Entity
@Table(schema = "serwis", name = "ustawienia_pacjenta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UstawieniaPacjenta.findAll", query = "SELECT u FROM UstawieniaPacjenta u"),
    @NamedQuery(name = "UstawieniaPacjenta.findById", query = "SELECT u FROM UstawieniaPacjenta u WHERE u.id = :id")})
public class UstawieniaPacjenta implements Serializable, InterfaceJSON<UstawieniaPacjenta>, InterfaceDatabaseObject {

    private static final long serialVersionUID = 3948334597976651550L;

    @Id
    @SequenceGenerator(name = "serwis.ustawienia_pacjenta_id_gen", sequenceName = "serwis.ustawienia_pacjenta_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "serwis.ustawienia_pacjenta_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_data_urodzenia")
    private boolean obowiazkoweDataUrodzenia = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_miejce_urodzenia")
    private boolean obowiazkoweMiejceUrodzenia = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_telefon")
    private boolean obowiazkoweTelefon = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_dane_adresowe")
    private boolean obowiazkoweDaneAdresowe = false;
    @Column(name = "maksymalny_wiek_pacjenta_powiazanego")
    private Integer maksymalnyWiekPacjentaPowiazanego = null;
    @Column(name = "maksymalna_ilosc_pacjentow_powiazanych")
    private Integer maksymalnaIloscPacjentowPowiazanych = null;
    @Column(name = "minimalny_wiek_pacjenta")
    private Integer minimalnyWiekPacjenta = null;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_data_urodzenia_samodzielnie")
    private boolean obowiazkoweDataUrodzeniaSamodzielnie = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_miejce_urodzenia_samodzielnie")
    private boolean obowiazkoweMiejceUrodzeniaSamodzielnie = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_telefon_samodzielnie")
    private boolean obowiazkoweTelefonSamodzielnie = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_dane_adresowe_samodzielnie")
    private boolean obowiazkoweDaneAdresoweSamodzielnie = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_email")
    private boolean obowiazkoweEmail = false;
    @Basic(optional = false)
    @NotNull
    @Column(name = "obowiazkowe_email_samodzielnie")
    private boolean obowiazkoweEmailSamodzielnie = false;

    public UstawieniaPacjenta() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public UstawieniaPacjenta setId(Integer id) {
        this.id = id;
        return this;
    }

    public boolean getObowiazkoweDataUrodzenia() {
        return obowiazkoweDataUrodzenia;
    }

    public UstawieniaPacjenta setObowiazkoweDataUrodzenia(boolean obowiazkoweDataUrodzenia) {
        this.obowiazkoweDataUrodzenia = obowiazkoweDataUrodzenia;
        return this;
    }

    public boolean getObowiazkoweMiejceUrodzenia() {
        return obowiazkoweMiejceUrodzenia;
    }

    public UstawieniaPacjenta setObowiazkoweMiejceUrodzenia(boolean obowiazkoweMiejceUrodzenia) {
        this.obowiazkoweMiejceUrodzenia = obowiazkoweMiejceUrodzenia;
        return this;
    }

    public boolean getObowiazkoweTelefon() {
        return obowiazkoweTelefon;
    }

    public UstawieniaPacjenta setObowiazkoweTelefon(boolean obowiazkoweTelefon) {
        this.obowiazkoweTelefon = obowiazkoweTelefon;
        return this;
    }

    public boolean getObowiazkoweDaneAdresowe() {
        return obowiazkoweDaneAdresowe;
    }

    public UstawieniaPacjenta setObowiazkoweDaneAdresowe(boolean obowiazkoweDaneAdresowe) {
        this.obowiazkoweDaneAdresowe = obowiazkoweDaneAdresowe;
        return this;
    }

    public Integer getMaksymalnyWiekPacjentaPowiazanego() {
        return maksymalnyWiekPacjentaPowiazanego;
    }

    public UstawieniaPacjenta setMaksymalnyWiekPacjentaPowiazanego(Integer maksymalnyWiekPacjentaPowiazanego) {
        this.maksymalnyWiekPacjentaPowiazanego = maksymalnyWiekPacjentaPowiazanego;
        return this;
    }

    public Integer getMaksymalnaIloscPacjentowPowiazanych() {
        return maksymalnaIloscPacjentowPowiazanych;
    }

    public UstawieniaPacjenta setMaksymalnaIloscPacjentowPowiazanych(Integer maksymalnaIloscPacjentowPowiazanych) {
        this.maksymalnaIloscPacjentowPowiazanych = maksymalnaIloscPacjentowPowiazanych;
        return this;
    }

    public Integer getMinimalnyWiekPacjenta() {
        return minimalnyWiekPacjenta;
    }

    public UstawieniaPacjenta setMinimalnyWiekPacjenta(Integer minimalnyWiekPacjenta) {
        this.minimalnyWiekPacjenta = minimalnyWiekPacjenta;
        return this;
    }

    public boolean isObowiazkoweDataUrodzeniaSamodzielnie() {
        return obowiazkoweDataUrodzeniaSamodzielnie;
    }

    public UstawieniaPacjenta setObowiazkoweDataUrodzeniaSamodzielnie(boolean obowiazkoweDataUrodzeniaSamodzielnie) {
        this.obowiazkoweDataUrodzeniaSamodzielnie = obowiazkoweDataUrodzeniaSamodzielnie;
        return this;
    }

    public boolean isObowiazkoweMiejceUrodzeniaSamodzielnie() {
        return obowiazkoweMiejceUrodzeniaSamodzielnie;
    }

    public UstawieniaPacjenta setObowiazkoweMiejceUrodzeniaSamodzielnie(boolean obowiazkoweMiejceUrodzeniaSamodzielnie) {
        this.obowiazkoweMiejceUrodzeniaSamodzielnie = obowiazkoweMiejceUrodzeniaSamodzielnie;
        return this;
    }

    public boolean isObowiazkoweTelefonSamodzielnie() {
        return obowiazkoweTelefonSamodzielnie;
    }

    public UstawieniaPacjenta setObowiazkoweTelefonSamodzielnie(boolean obowiazkoweTelefonSamodzielnie) {
        this.obowiazkoweTelefonSamodzielnie = obowiazkoweTelefonSamodzielnie;
        return this;
    }

    public boolean isObowiazkoweDaneAdresoweSamodzielnie() {
        return obowiazkoweDaneAdresoweSamodzielnie;
    }

    public UstawieniaPacjenta setObowiazkoweDaneAdresoweSamodzielnie(boolean obowiazkoweDaneAdresoweSamodzielnie) {
        this.obowiazkoweDaneAdresoweSamodzielnie = obowiazkoweDaneAdresoweSamodzielnie;
        return this;
    }

    public boolean isObowiazkoweEmail() {
        return obowiazkoweEmail;
    }

    public UstawieniaPacjenta setObowiazkoweEmail(boolean obowiazkoweEmail) {
        this.obowiazkoweEmail = obowiazkoweEmail;
        return this;
    }

    public boolean isObowiazkoweEmailSamodzielnie() {
        return obowiazkoweEmailSamodzielnie;
    }

    public UstawieniaPacjenta setObowiazkoweEmailSamodzielnie(boolean obowiazkoweEmailSamodzielnie) {
        this.obowiazkoweEmailSamodzielnie = obowiazkoweEmailSamodzielnie;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweDataUrodzenia);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweMiejceUrodzenia);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweTelefon);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweDaneAdresowe);
        hash = 89 * hash + Objects.hashCode(this.maksymalnyWiekPacjentaPowiazanego);
        hash = 89 * hash + Objects.hashCode(this.maksymalnaIloscPacjentowPowiazanych);
        hash = 89 * hash + Objects.hashCode(this.minimalnyWiekPacjenta);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweDataUrodzeniaSamodzielnie);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweMiejceUrodzeniaSamodzielnie);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweTelefonSamodzielnie);
        hash = 89 * hash + Objects.hashCode(this.obowiazkoweDaneAdresoweSamodzielnie);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof UstawieniaPacjenta)) {
            return false;
        }
        UstawieniaPacjenta other = (UstawieniaPacjenta) object;
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
        return "pl.softmedica.smportal.jpa.UstawieniaPacjenta[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("obowiazkoweDataUrodzenia", this.obowiazkoweDataUrodzenia)
                .put("obowiazkoweMiejceUrodzenia", this.obowiazkoweMiejceUrodzenia)
                .put("obowiazkoweTelefon", this.obowiazkoweTelefon)
                .put("obowiazkoweDaneAdresowe", this.obowiazkoweDaneAdresowe)
                .put("obowiazkoweDataUrodzeniaSamodzielnie", this.obowiazkoweDataUrodzeniaSamodzielnie)
                .put("obowiazkoweMiejceUrodzeniaSamodzielnie", this.obowiazkoweMiejceUrodzeniaSamodzielnie)
                .put("obowiazkoweTelefonSamodzielnie", this.obowiazkoweTelefonSamodzielnie)
                .put("obowiazkoweDaneAdresoweSamodzielnie", this.obowiazkoweDaneAdresoweSamodzielnie)
                .put("obowiazkoweEmail", this.obowiazkoweEmail)
                .put("obowiazkoweEmailSamodzielnie", this.obowiazkoweEmailSamodzielnie)
                .put("maksymalnyWiekPacjentaPowiazanego", this.maksymalnyWiekPacjentaPowiazanego)
                .put("maksymalnaIloscPacjentowPowiazanych", this.maksymalnaIloscPacjentowPowiazanych)
                .put("minimalnyWiekPacjenta", this.minimalnyWiekPacjenta)
                .put("polaWymagane", new JSONArrayBuilder()
                        .add("imie")
                        .add("nazwisko")
                        .add("pesel")
                        .add("dataUrodzenia", this.obowiazkoweDataUrodzenia)
                        .add("miejsceUrodzenia", this.obowiazkoweMiejceUrodzenia)
                        .add("email", this.obowiazkoweEmail)
                        .add("telefonKontaktowy", this.obowiazkoweTelefon)
                        .add("miejscowosc", this.obowiazkoweDaneAdresowe)
                        .add("kodPocztowy", this.obowiazkoweDaneAdresowe)
                        .add("ulica", this.obowiazkoweDaneAdresowe)
                        .add("nrDomu", this.obowiazkoweDaneAdresowe)
                        .build())
                .put("polaWymaganeSamodzielnie", new JSONArrayBuilder()
                        .add("imie")
                        .add("nazwisko")
                        .add("pesel")
                        .add("dataUrodzenia", this.obowiazkoweDataUrodzeniaSamodzielnie)
                        .add("miejsceUrodzenia", this.obowiazkoweMiejceUrodzeniaSamodzielnie)
                        .add("email", this.obowiazkoweEmailSamodzielnie)
                        .add("telefonKontaktowy", this.obowiazkoweTelefonSamodzielnie)
                        .add("miejscowosc", this.obowiazkoweDaneAdresoweSamodzielnie)
                        .add("kodPocztowy", this.obowiazkoweDaneAdresoweSamodzielnie)
                        .add("ulica", this.obowiazkoweDaneAdresoweSamodzielnie)
                        .add("nrDomu", this.obowiazkoweDaneAdresoweSamodzielnie)
                        .build())
                .build();
    }

    @Override
    public UstawieniaPacjenta setJSON(JSONObject json) {
        if (json != null) {
            JSONObjectExt jsone = new JSONObjectExt(json);
            this.obowiazkoweDataUrodzenia = jsone.getBooleanSimple("obowiazkoweDataUrodzenia");
            this.obowiazkoweMiejceUrodzenia = jsone.getBooleanSimple("obowiazkoweMiejceUrodzenia");
            this.obowiazkoweTelefon = jsone.getBooleanSimple("obowiazkoweTelefon");
            this.obowiazkoweDaneAdresowe = jsone.getBooleanSimple("obowiazkoweDaneAdresowe");
            this.obowiazkoweDataUrodzeniaSamodzielnie = jsone.getBooleanSimple("obowiazkoweDataUrodzeniaSamodzielnie");
            this.obowiazkoweMiejceUrodzeniaSamodzielnie = jsone.getBooleanSimple("obowiazkoweMiejceUrodzeniaSamodzielnie");
            this.obowiazkoweTelefonSamodzielnie = jsone.getBooleanSimple("obowiazkoweTelefonSamodzielnie");
            this.obowiazkoweDaneAdresoweSamodzielnie = jsone.getBooleanSimple("obowiazkoweDaneAdresoweSamodzielnie");
            this.maksymalnyWiekPacjentaPowiazanego = jsone.getInteger("maksymalnyWiekPacjentaPowiazanego");
            this.maksymalnaIloscPacjentowPowiazanych = jsone.getInteger("maksymalnaIloscPacjentowPowiazanych");
            this.minimalnyWiekPacjenta = jsone.getInteger("minimalnyWiekPacjenta");
            this.obowiazkoweEmail = jsone.getBooleanSimple("obowiazkoweEmail");
            this.obowiazkoweEmailSamodzielnie = jsone.getBooleanSimple("obowiazkoweEmailSamodzielnoe");
        }
        return this;
    }
}
