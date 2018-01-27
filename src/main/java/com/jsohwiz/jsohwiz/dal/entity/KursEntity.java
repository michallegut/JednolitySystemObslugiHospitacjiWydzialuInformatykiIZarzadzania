package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kurs", schema = "jsohwiz", catalog = "")
public class KursEntity {
    private Integer id;
    private Integer dziedzina;
    private String nazwa;
    private Collection<GrupazajeciowaEntity> grupazajeciowasById;
    private Collection<HospitacjaEntity> hospitacjasById;
    private KierunekEntity kierunekByKierunekId;
    private Collection<KursSemestrEntity> kursSemestrsById;
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
    @Column(name = "dziedzina")
    public Integer getDziedzina() {
        return dziedzina;
    }

    public void setDziedzina(Integer dziedzina) {
        this.dziedzina = dziedzina;
    }

    @Basic
    @Column(name = "nazwa")
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KursEntity that = (KursEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (dziedzina != null ? !dziedzina.equals(that.dziedzina) : that.dziedzina != null) return false;
        return nazwa != null ? nazwa.equals(that.nazwa) : that.nazwa == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (dziedzina != null ? dziedzina.hashCode() : 0);
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kursByKursId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<GrupazajeciowaEntity> getGrupazajeciowasById() {
        return grupazajeciowasById;
    }

    public void setGrupazajeciowasById(Collection<GrupazajeciowaEntity> grupazajeciowasById) {
        this.grupazajeciowasById = grupazajeciowasById;
    }

    @OneToMany(mappedBy = "kursByKursId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<HospitacjaEntity> getHospitacjasById() {
        return hospitacjasById;
    }

    public void setHospitacjasById(Collection<HospitacjaEntity> hospitacjasById) {
        this.hospitacjasById = hospitacjasById;
    }

    @ManyToOne
    @JoinColumn(name = "kierunek_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public KierunekEntity getKierunekByKierunekId() {
        return kierunekByKierunekId;
    }

    public void setKierunekByKierunekId(KierunekEntity kierunekByKierunekId) {
        this.kierunekByKierunekId = kierunekByKierunekId;
    }

    @OneToMany(mappedBy = "kursByKursId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<KursSemestrEntity> getKursSemestrsById() {
        return kursSemestrsById;
    }

    public void setKursSemestrsById(Collection<KursSemestrEntity> kursSemestrsById) {
        this.kursSemestrsById = kursSemestrsById;
    }

    @OneToMany(mappedBy = "kursByKursId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<NauczycielKursEntity> getNauczycielKursById() {
        return nauczycielKursById;
    }

    public void setNauczycielKursById(Collection<NauczycielKursEntity> nauczycielKursById) {
        this.nauczycielKursById = nauczycielKursById;
    }
}
