package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "kurs_semestr", schema = "jsohwiz", catalog = "")
@IdClass(KursSemestrEntityPK.class)
public class KursSemestrEntity {
    private Integer kursId;
    private Integer semestrId;
    private KursEntity kursByKursId;
    private SemestrEntity semestrBySemestrId;

    @Id
    @Column(name = "kurs_id")
    public Integer getKursId() {
        return kursId;
    }

    public void setKursId(Integer kursId) {
        this.kursId = kursId;
    }

    @Id
    @Column(name = "semestr_id")
    public Integer getSemestrId() {
        return semestrId;
    }

    public void setSemestrId(Integer semestrId) {
        this.semestrId = semestrId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KursSemestrEntity that = (KursSemestrEntity) o;

        if (kursId != null ? !kursId.equals(that.kursId) : that.kursId != null) return false;
        return semestrId != null ? semestrId.equals(that.semestrId) : that.semestrId == null;
    }

    @Override
    public int hashCode() {
        int result = kursId != null ? kursId.hashCode() : 0;
        result = 31 * result + (semestrId != null ? semestrId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "kurs_id", referencedColumnName = "id", nullable = false,
            insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public KursEntity getKursByKursId() {
        return kursByKursId;
    }

    public void setKursByKursId(KursEntity kursByKursId) {
        this.kursByKursId = kursByKursId;
    }

    @ManyToOne
    @JoinColumn(name = "semestr_id", referencedColumnName = "id", nullable = false,
            insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public SemestrEntity getSemestrBySemestrId() {
        return semestrBySemestrId;
    }

    public void setSemestrBySemestrId(SemestrEntity semestrBySemestrId) {
        this.semestrBySemestrId = semestrBySemestrId;
    }
}
