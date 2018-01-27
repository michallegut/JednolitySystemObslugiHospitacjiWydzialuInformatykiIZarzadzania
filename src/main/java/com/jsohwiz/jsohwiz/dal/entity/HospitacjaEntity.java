package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Entity
@Table(name = "hospitacja", schema = "jsohwiz", catalog = "")
public class HospitacjaEntity {
    private Integer id;
    private Integer grupaZajeciowaId;
    private NauczycielEntity nauczycielByNauczycielId;
    private KursEntity kursByKursId;
    private KomisjahospitacyjnaEntity komisjahospitacyjnaByKomisjaHospitacyjnaId;
    private PlanhospitacjiEntity planhospitacjiByPlanHospitacjiId;

    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "grupa_zajeciowa_id")
    public Integer getGrupaZajeciowaId() {
        return grupaZajeciowaId;
    }

    public void setGrupaZajeciowaId(Integer grupaZajeciowaId) {
        this.grupaZajeciowaId = grupaZajeciowaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HospitacjaEntity that = (HospitacjaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return grupaZajeciowaId != null ? grupaZajeciowaId.equals(that.grupaZajeciowaId) : that.grupaZajeciowaId == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (grupaZajeciowaId != null ? grupaZajeciowaId.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "nauczyciel_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public NauczycielEntity getNauczycielByNauczycielId() {
        return nauczycielByNauczycielId;
    }

    public void setNauczycielByNauczycielId(NauczycielEntity nauczycielByNauczycielId) {
        this.nauczycielByNauczycielId = nauczycielByNauczycielId;
    }

    @ManyToOne
    @JoinColumn(name = "kurs_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public KursEntity getKursByKursId() {
        return kursByKursId;
    }

    public void setKursByKursId(KursEntity kursByKursId) {
        this.kursByKursId = kursByKursId;
    }

    @ManyToOne
    @JoinColumn(name = "komisja_hospitacyjna_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public KomisjahospitacyjnaEntity getKomisjahospitacyjnaByKomisjaHospitacyjnaId() {
        return komisjahospitacyjnaByKomisjaHospitacyjnaId;
    }

    public void setKomisjahospitacyjnaByKomisjaHospitacyjnaId(KomisjahospitacyjnaEntity komisjahospitacyjnaByKomisjaHospitacyjnaId) {
        this.komisjahospitacyjnaByKomisjaHospitacyjnaId = komisjahospitacyjnaByKomisjaHospitacyjnaId;
    }

    @ManyToOne
    @JoinColumn(name = "plan_hospitacji_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public PlanhospitacjiEntity getPlanhospitacjiByPlanHospitacjiId() {
        return planhospitacjiByPlanHospitacjiId;
    }

    public void setPlanhospitacjiByPlanHospitacjiId(PlanhospitacjiEntity planhospitacjiByPlanHospitacjiId) {
        this.planhospitacjiByPlanHospitacjiId = planhospitacjiByPlanHospitacjiId;
    }
}
