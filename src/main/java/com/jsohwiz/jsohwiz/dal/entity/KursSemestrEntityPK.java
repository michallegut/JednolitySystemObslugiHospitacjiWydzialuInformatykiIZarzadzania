package com.jsohwiz.jsohwiz.dal.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class KursSemestrEntityPK implements Serializable {
    private Integer kursId;
    private Integer semestrId;

    @Column(name = "kurs_id")
    @Id
    public Integer getKursId() {
        return kursId;
    }

    public void setKursId(Integer kursId) {
        this.kursId = kursId;
    }

    @Column(name = "semestr_id")
    @Id
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

        KursSemestrEntityPK that = (KursSemestrEntityPK) o;

        if (kursId != null ? !kursId.equals(that.kursId) : that.kursId != null) return false;
        return semestrId != null ? semestrId.equals(that.semestrId) : that.semestrId == null;
    }

    @Override
    public int hashCode() {
        int result = kursId != null ? kursId.hashCode() : 0;
        result = 31 * result + (semestrId != null ? semestrId.hashCode() : 0);
        return result;
    }
}
