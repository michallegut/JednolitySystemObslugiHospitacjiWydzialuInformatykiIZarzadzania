package com.jsohwiz.jsohwiz.dal.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class NauczycielKursEntityPK implements Serializable {
    private Integer nauczycielId;
    private Integer kursId;

    @Column(name = "nauczyciel_id")
    @Id
    public Integer getNauczycielId() {
        return nauczycielId;
    }

    public void setNauczycielId(Integer nauczycielId) {
        this.nauczycielId = nauczycielId;
    }

    @Column(name = "kurs_id")
    @Id
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

        NauczycielKursEntityPK that = (NauczycielKursEntityPK) o;

        if (nauczycielId != null ? !nauczycielId.equals(that.nauczycielId) : that.nauczycielId != null) return false;
        return kursId != null ? kursId.equals(that.kursId) : that.kursId == null;
    }

    @Override
    public int hashCode() {
        int result = nauczycielId != null ? nauczycielId.hashCode() : 0;
        result = 31 * result + (kursId != null ? kursId.hashCode() : 0);
        return result;
    }
}
