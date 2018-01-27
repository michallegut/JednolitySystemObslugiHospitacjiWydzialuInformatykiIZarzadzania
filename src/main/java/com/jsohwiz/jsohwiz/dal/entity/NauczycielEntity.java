package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "nauczyciel", schema = "jsohwiz", catalog = "")
public class NauczycielEntity {
    private Integer id;
    private Integer stopienNaukowy;
    private Boolean czyDoktorant;
    private Boolean czyZUczelni;
    private Integer obciazenie;
    private Integer specjalizacje;
    private String imie;
    private String nazwisko;
    private Collection<GrupazajeciowaEntity> grupazajeciowasById;
    private Collection<HospitacjaEntity> hospitacjasById;
    private Collection<KomisjahospitacyjnaEntity> komisjahospitacyjnasById;
    private Collection<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnasById;
    private Collection<NauczycielKursEntity> nauczycielKursById;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "stopien_naukowy")
    public Integer getStopienNaukowy() {
        return stopienNaukowy;
    }

    public void setStopienNaukowy(Integer stopienNaukowy) {
        this.stopienNaukowy = stopienNaukowy;
    }

    @Basic
    @Column(name = "czy_doktorant", columnDefinition = "TINYINT(1)")
    public Boolean getCzyDoktorant() {
        return czyDoktorant;
    }

    public void setCzyDoktorant(Boolean czyDoktorant) {
        this.czyDoktorant = czyDoktorant;
    }

    @Basic
    @Column(name = "czy_z_uczelni", columnDefinition = "TINYINT(1)")
    public Boolean getCzyZUczelni() {
        return czyZUczelni;
    }

    public void setCzyZUczelni(Boolean czyZUczelni) {
        this.czyZUczelni = czyZUczelni;
    }

    @Basic
    @Column(name = "obciazenie")
    public Integer getObciazenie() {
        return obciazenie;
    }

    public void setObciazenie(Integer obciazenie) {
        this.obciazenie = obciazenie;
    }

    @Basic
    @Column(name = "specjalizacje")
    public Integer getSpecjalizacje() {
        return specjalizacje;
    }

    public void setSpecjalizacje(Integer specjalizacje) {
        this.specjalizacje = specjalizacje;
    }

    @Basic
    @Column(name = "imie")
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko")
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NauczycielEntity that = (NauczycielEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (stopienNaukowy != null ? !stopienNaukowy.equals(that.stopienNaukowy) : that.stopienNaukowy != null)
            return false;
        if (czyDoktorant != null ? !czyDoktorant.equals(that.czyDoktorant) : that.czyDoktorant != null) return false;
        if (czyZUczelni != null ? !czyZUczelni.equals(that.czyZUczelni) : that.czyZUczelni != null) return false;
        if (obciazenie != null ? !obciazenie.equals(that.obciazenie) : that.obciazenie != null) return false;
        if (specjalizacje != null ? !specjalizacje.equals(that.specjalizacje) : that.specjalizacje != null)
            return false;
        if (imie != null ? !imie.equals(that.imie) : that.imie != null) return false;
        return nazwisko != null ? nazwisko.equals(that.nazwisko) : that.nazwisko == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (stopienNaukowy != null ? stopienNaukowy.hashCode() : 0);
        result = 31 * result + (czyDoktorant != null ? czyDoktorant.hashCode() : 0);
        result = 31 * result + (czyZUczelni != null ? czyZUczelni.hashCode() : 0);
        result = 31 * result + (obciazenie != null ? obciazenie.hashCode() : 0);
        result = 31 * result + (specjalizacje != null ? specjalizacje.hashCode() : 0);
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "nauczycielByNauczycielId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<GrupazajeciowaEntity> getGrupazajeciowasById() {
        return grupazajeciowasById;
    }

    public void setGrupazajeciowasById(Collection<GrupazajeciowaEntity> grupazajeciowasById) {
        this.grupazajeciowasById = grupazajeciowasById;
    }

    @OneToMany(mappedBy = "nauczycielByNauczycielId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<HospitacjaEntity> getHospitacjasById() {
        return hospitacjasById;
    }

    public void setHospitacjasById(Collection<HospitacjaEntity> hospitacjasById) {
        this.hospitacjasById = hospitacjasById;
    }

    @OneToMany(mappedBy = "nauczycielByNauczycielId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<KomisjahospitacyjnaEntity> getKomisjahospitacyjnasById() {
        return komisjahospitacyjnasById;
    }

    public void setKomisjahospitacyjnasById(Collection<KomisjahospitacyjnaEntity> komisjahospitacyjnasById) {
        this.komisjahospitacyjnasById = komisjahospitacyjnasById;
    }

    @OneToMany(mappedBy = "nauczycielByNauczycielId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<NauczycielKomisjahospitacyjnaEntity> getNauczycielKomisjahospitacyjnasById() {
        return nauczycielKomisjahospitacyjnasById;
    }

    public void setNauczycielKomisjahospitacyjnasById(Collection<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnasById) {
        this.nauczycielKomisjahospitacyjnasById = nauczycielKomisjahospitacyjnasById;
    }

    @OneToMany(mappedBy = "nauczycielByNauczycielId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<NauczycielKursEntity> getNauczycielKursById() {
        return nauczycielKursById;
    }

    public void setNauczycielKursById(Collection<NauczycielKursEntity> nauczycielKursById) {
        this.nauczycielKursById = nauczycielKursById;
    }
}
