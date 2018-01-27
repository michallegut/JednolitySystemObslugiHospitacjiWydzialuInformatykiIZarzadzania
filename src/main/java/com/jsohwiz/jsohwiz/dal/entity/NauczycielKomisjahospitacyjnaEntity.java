package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "nauczyciel_komisjahospitacyjna", schema = "jsohwiz", catalog = "")
@IdClass(NauczycielKomisjahospitacyjnaEntityPK.class)
public class NauczycielKomisjahospitacyjnaEntity {
    private Integer nauczycielId;
    private Integer komisjaHospitacyjnaId;
    private NauczycielEntity nauczycielByNauczycielId;
    private KomisjahospitacyjnaEntity komisjahospitacyjnaByKomisjaHospitacyjnaId;

    @Id
    @Column(name = "nauczyciel_id")
    public Integer getNauczycielId() {
        return nauczycielId;
    }

    public void setNauczycielId(Integer nauczycielId) {
        this.nauczycielId = nauczycielId;
    }

    @Id
    @Column(name = "komisja_hospitacyjna_id")
    public Integer getKomisjaHospitacyjnaId() {
        return komisjaHospitacyjnaId;
    }

    public void setKomisjaHospitacyjnaId(Integer komisjaHospitacyjnaId) {
        this.komisjaHospitacyjnaId = komisjaHospitacyjnaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        NauczycielKomisjahospitacyjnaEntity that = (NauczycielKomisjahospitacyjnaEntity) o;

        if (nauczycielId != null ? !nauczycielId.equals(that.nauczycielId) : that.nauczycielId != null) return false;
        return komisjaHospitacyjnaId != null ? komisjaHospitacyjnaId.equals(that.komisjaHospitacyjnaId) : that.komisjaHospitacyjnaId == null;
    }

    @Override
    public int hashCode() {
        int result = nauczycielId != null ? nauczycielId.hashCode() : 0;
        result = 31 * result + (komisjaHospitacyjnaId != null ? komisjaHospitacyjnaId.hashCode() : 0);
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
    @JoinColumn(name = "komisja_hospitacyjna_id", referencedColumnName = "id", nullable = false,
            insertable = false, updatable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public KomisjahospitacyjnaEntity getKomisjahospitacyjnaByKomisjaHospitacyjnaId() {
        return komisjahospitacyjnaByKomisjaHospitacyjnaId;
    }

    public void setKomisjahospitacyjnaByKomisjaHospitacyjnaId(KomisjahospitacyjnaEntity komisjahospitacyjnaByKomisjaHospitacyjnaId) {
        this.komisjahospitacyjnaByKomisjaHospitacyjnaId = komisjahospitacyjnaByKomisjaHospitacyjnaId;
    }
}
