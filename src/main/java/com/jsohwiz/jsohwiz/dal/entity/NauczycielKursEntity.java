package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "nauczyciel_kurs", schema = "jsohwiz", catalog = "")
@IdClass(NauczycielKursEntityPK.class)
public class NauczycielKursEntity {
    private Integer nauczycielId;
    private Integer kursId;
    private NauczycielEntity nauczycielByNauczycielId;
    private KursEntity kursByKursId;

    @Id
    @Column(name = "nauczyciel_id")
    public Integer getNauczycielId() {
        return nauczycielId;
    }

    public void setNauczycielId(Integer nauczycielId) {
        this.nauczycielId = nauczycielId;
    }

    @Id
    @Column(name = "kurs_id")
    public Integer getKursId() {
        return kursId;
    }

    public void setKursId(Integer kursId) {
        this.kursId = kursId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NauczycielKursEntity that = (NauczycielKursEntity) o;

        if (nauczycielId != null ? !nauczycielId.equals(that.nauczycielId) : that.nauczycielId != null) return false;
        return kursId != null ? kursId.equals(that.kursId) : that.kursId == null;
    }

    @Override
    public int hashCode() {
        int result = nauczycielId != null ? nauczycielId.hashCode() : 0;
        result = 31 * result + (kursId != null ? kursId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "nauczyciel_id", referencedColumnName = "id", nullable = false,
            insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public NauczycielEntity getNauczycielByNauczycielId() {
        return nauczycielByNauczycielId;
    }

    public void setNauczycielByNauczycielId(NauczycielEntity nauczycielByNauczycielId) {
        this.nauczycielByNauczycielId = nauczycielByNauczycielId;
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
}
