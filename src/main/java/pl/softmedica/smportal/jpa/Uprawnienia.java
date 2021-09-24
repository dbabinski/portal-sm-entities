/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.softmedica.smportal.jpa;

import java.io.Serializable;
import java.util.Comparator;
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
import pl.softmedica.smportal.common.interfaces.InterfaceDatabaseObject;
import pl.softmedica.smportal.common.interfaces.InterfaceJSON;
import pl.softmedica.smportal.common.utilities.JSONArrayBuilder;
import pl.softmedica.smportal.common.utilities.JSONBuilder;
import pl.softmedica.smportal.common.utilities.JSONObjectExt;
import pl.softmedica.smportal.common.utilities.LinkedHashMapBuilder;

/**
 *
 * @author Lucek
 */
@Entity
@Table(schema = "uzytkownicy", name = "uprawnienia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Uprawnienia.findAll", query = "SELECT u FROM Uprawnienia u"),
    @NamedQuery(name = "Uprawnienia.findById", query = "SELECT u FROM Uprawnienia u WHERE u.id = :id")})
public class Uprawnienia implements Serializable, InterfaceJSON<Uprawnienia>, InterfaceDatabaseObject {

    private static final long serialVersionUID = -1730688243080925852L;

    @Id
    @SequenceGenerator(name = "uzytkownicy.uprawnienia_id_gen", sequenceName = "uzytkownicy.uprawnienia_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "uzytkownicy.uprawnienia_id_gen")
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dodawanie_pacjentow_powiazanych")
    private boolean dodawaniePacjentowPowiazanych;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dostep_do_listy_pacjentow")
    private boolean dostepDoListyPacjentow;
    @Basic(optional = false)
    @NotNull
    @Column(name = "planowanie_wizyt")
    private boolean planowanieWizyt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "dostep_do_kartoteki_pacjenta_powiazanego")
    private boolean dostepDoKartotekiPacjentaPowiazanego;
    @Basic(optional = false)
    @NotNull
    @Column(name = "blokowanie_konta")
    private boolean blokowanieKonta;
    @JoinColumn(name = "id_grupy", referencedColumnName = "id")
    @ManyToOne
    private Grupy idGrupy;

    public Uprawnienia() {
    }

    @Override
    public Integer getId() {
        return id;
    }

    public Uprawnienia setId(Integer id) {
        this.id = id;
        return this;
    }

    public boolean getDodawaniePacjentowPowiazanych() {
        return dodawaniePacjentowPowiazanych;
    }

    public Uprawnienia setDodawaniePacjentowPowiazanych(boolean dodawaniePacjentowPowiazanych) {
        this.dodawaniePacjentowPowiazanych = dodawaniePacjentowPowiazanych;
        return this;
    }

    public boolean getDostepDoListyPacjentow() {
        return dostepDoListyPacjentow;
    }

    public Uprawnienia setDostepDoListyPacjentow(boolean dostepDoListyPacjentow) {
        this.dostepDoListyPacjentow = dostepDoListyPacjentow;
        return this;
    }

    public boolean getPlanowanieWizyt() {
        return planowanieWizyt;
    }

    public Uprawnienia setPlanowanieWizyt(boolean planowanieWizyt) {
        this.planowanieWizyt = planowanieWizyt;
        return this;
    }

    public boolean getDostepDoKartotekiPacjentaPowiazanego() {
        return dostepDoKartotekiPacjentaPowiazanego;
    }

    public Uprawnienia setDostepDoKartotekiPacjentaPowiazanego(boolean dostepDoKartotekiPacjentaPowiazanego) {
        this.dostepDoKartotekiPacjentaPowiazanego = dostepDoKartotekiPacjentaPowiazanego;
        return this;
    }

    public boolean getBlokowanieKonta() {
        return blokowanieKonta;
    }

    public Uprawnienia setBlokowanieKonta(boolean blokowanieKonta) {
        this.blokowanieKonta = blokowanieKonta;
        return this;
    }

    public Grupy getIdGrupy() {
        return idGrupy;
    }

    public Uprawnienia setIdGrupy(Grupy idGrupy) {
        this.idGrupy = idGrupy;
        return this;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + (id != null ? id.hashCode() : 0);
        hash = 89 * hash + Objects.hashCode(this.idGrupy);
        hash = 89 * hash + Objects.hashCode(this.dodawaniePacjentowPowiazanych);
        hash = 89 * hash + Objects.hashCode(this.dostepDoListyPacjentow);
        hash = 89 * hash + Objects.hashCode(this.planowanieWizyt);
        hash = 89 * hash + Objects.hashCode(this.dostepDoKartotekiPacjentaPowiazanego);
        hash = 89 * hash + Objects.hashCode(this.blokowanieKonta);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Uprawnienia)) {
            return false;
        }
        Uprawnienia other = (Uprawnienia) object;
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
        return "pl.softmedica.smportal.jpa.Uprawnienia[ id=" + id + " ]";
    }

    @Override
    public JSONObject getJSON() {
        return new JSONBuilder()
                .put("id", this.id)
                .put("idGrupy", this.idGrupy != null ? this.idGrupy.getId() : null)
                .put("grupa", this.idGrupy != null ? this.idGrupy.getJSON() : null)
                .put("dodawaniePacjentowPowiazanych", this.dodawaniePacjentowPowiazanych)
                .put("dostepDoListyPacjentow", this.dostepDoListyPacjentow)
                .put("planowanieWizyt", this.planowanieWizyt)
                .put("dostepDoKartotekiPacjentaPowiazanego", this.dostepDoKartotekiPacjentaPowiazanego)
                .put("blokowanieKonta", this.blokowanieKonta)
                .build();
    }

    @Override
    public Uprawnienia setJSON(JSONObject json) {
        if (json != null) {
            JSONObjectExt jsone = new JSONObjectExt(json);
            this.dodawaniePacjentowPowiazanych = jsone.getBooleanSimple("dodawaniePacjentowPowiazanych");
            this.dostepDoListyPacjentow = jsone.getBooleanSimple("dostepDoListyPacjentow");
            this.planowanieWizyt = jsone.getBooleanSimple("planowanieWizyt");
            this.dostepDoKartotekiPacjentaPowiazanego = jsone.getBooleanSimple("dostepDoKartotekiPacjentaPowiazanego");
            this.blokowanieKonta = jsone.getBooleanSimple("blokowanieKonta");
        }
        return this;
    }

    public static final JSONArray POLA_WYMAGANE = new JSONArrayBuilder()
            .add("idGrupy")
            .add("dodawaniePacjentowPowiazanych")
            .add("dostepDoListyPacjentow")
            .add("planowanieWizyt")
            .add("dostepDoKartotekiPacjentaPowiazanego")
            .add("blokowanieKonta")
            .build();

    public static final HashMap<String, String> MAPA_POL = new LinkedHashMapBuilder<String, String>()
            .put("idGrupy", "Nazwa grupy")
            .put("grupa", "Nazwa grupy")
            .put("dodawaniePacjentowPowiazanych", "Dodawanie pacjentów powiązanych")
            .put("dostepDoListyPacjentow", "Dostęp do listy pacjentów")
            .put("planowanieWizyt", "Planowanie wizyt")
            .put("dostepDoKartotekiPacjentaPowiazanego", "Dostęp do kartoteki pacjenta powiązanego")
            .put("blokowanieKonta", "Blokowanie konta")
            .build();

    public static Comparator<Uprawnienia> COMPARATOR_BY_GRUPA = (Uprawnienia o1, Uprawnienia o2) -> {
        if (o1 != null && o2 != null) {
            if (o1.getIdGrupy() != null && o2.getIdGrupy() != null) {
                return Grupy.COMPARATOR_BY_OPIS.compare(o1.getIdGrupy(), o2.getIdGrupy());
            }
            if (o1 != null) {
                return -1;
            }
            if (o2 != null) {
                return 1;
            }
        }
        return 0;
    };
}
