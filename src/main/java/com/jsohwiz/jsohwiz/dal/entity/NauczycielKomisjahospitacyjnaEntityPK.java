package com.jsohwiz.jsohwiz.dal.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class NauczycielKomisjahospitacyjnaEntityPK implements Serializable {
    private Integer nauczycielId;
    private Integer komisjaHospitacyjnaId;

    @Column(name = "nauczyciel_id")
    @Id
    public Integer getNauczycielId() {
        return nauczycielId;
    }

    public void setNauczycielId(Integer nauczycielId) {
        this.nauczycielId = nauczycielId;
    }

    @Column(name = "komisja_hospitacyjna_id")
    @Id
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

        NauczycielKomisjahospitacyjnaEntityPK that = (NauczycielKomisjahospitacyjnaEntityPK) o;

        if (nauczycielId != null ? !nauczycielId.equals(that.nauczycielId) : that.nauczycielId != null) return false;
        return komisjaHospitacyjnaId != null ? komisjaHospitacyjnaId.equals(that.komisjaHospitacyjnaId) : that.komisjaHospitacyjnaId == null;
    }

    @Override
    public int hashCode() {
        int result = nauczycielId != null ? nauczycielId.hashCode() : 0;
        result = 31 * result + (komisjaHospitacyjnaId != null ? komisjaHospitacyjnaId.hashCode() : 0);
        return result;
    }
}
