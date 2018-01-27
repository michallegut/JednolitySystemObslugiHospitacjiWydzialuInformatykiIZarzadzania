package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "planhospitacji", schema = "jsohwiz", catalog = "")
public class PlanhospitacjiEntity {
    private Integer id;
    private Boolean czyZatwierdzony;
    private Boolean czyAktualny;
    private Date dataUtworzenia;
    private Collection<HospitacjaEntity> hospitacjasById;
    private SemestrEntity semestrBySemestrId;
    private KierunekEntity kierunekByKierunekId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "czy_zatwierdzony", columnDefinition = "TINYINT(1)")
    public Boolean getCzyZatwierdzony() {
        return czyZatwierdzony;
    }

    public void setCzyZatwierdzony(Boolean czyZatwierdzony) {
        this.czyZatwierdzony = czyZatwierdzony;
    }

    @Basic
    @Column(name = "czy_aktualny", columnDefinition = "TINYINT(1)")
    public Boolean getCzyAktualny() {
        return czyAktualny;
    }

    public void setCzyAktualny(Boolean czyAktualny) {
        this.czyAktualny = czyAktualny;
    }

    @Basic
    @Column(name = "data_utworzenia")
    public Date getDataUtworzenia() {
        return dataUtworzenia;
    }

    public void setDataUtworzenia(Date dataUtworzenia) {
        this.dataUtworzenia = dataUtworzenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PlanhospitacjiEntity that = (PlanhospitacjiEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (czyZatwierdzony != null ? !czyZatwierdzony.equals(that.czyZatwierdzony) : that.czyZatwierdzony != null)
            return false;
        if (czyAktualny != null ? !czyAktualny.equals(that.czyAktualny) : that.czyAktualny != null) return false;
        return dataUtworzenia != null ? dataUtworzenia.equals(that.dataUtworzenia) : that.dataUtworzenia == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (czyZatwierdzony != null ? czyZatwierdzony.hashCode() : 0);
        result = 31 * result + (czyAktualny != null ? czyAktualny.hashCode() : 0);
        result = 31 * result + (dataUtworzenia != null ? dataUtworzenia.hashCode() : 0);
        return result;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "planhospitacjiByPlanHospitacjiId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<HospitacjaEntity> getHospitacjasById() {
        return hospitacjasById;
    }

    public void setHospitacjasById(Collection<HospitacjaEntity> hospitacjasById) {
        this.hospitacjasById = hospitacjasById;
    }

    @ManyToOne
    @JoinColumn(name = "semestr_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public SemestrEntity getSemestrBySemestrId() {
        return semestrBySemestrId;
    }

    public void setSemestrBySemestrId(SemestrEntity semestrBySemestrId) {
        this.semestrBySemestrId = semestrBySemestrId;
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
}
