package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "komisjahospitacyjna", schema = "jsohwiz", catalog = "")
public class KomisjahospitacyjnaEntity {
    private Integer id;
    private Collection<HospitacjaEntity> hospitacjasById;
    private NauczycielEntity nauczycielByNauczycielId;
    private Collection<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnasById;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KomisjahospitacyjnaEntity that = (KomisjahospitacyjnaEntity) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @OneToMany(mappedBy = "komisjahospitacyjnaByKomisjaHospitacyjnaId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<HospitacjaEntity> getHospitacjasById() {
        return hospitacjasById;
    }

    public void setHospitacjasById(Collection<HospitacjaEntity> hospitacjasById) {
        this.hospitacjasById = hospitacjasById;
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

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "komisjahospitacyjnaByKomisjaHospitacyjnaId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<NauczycielKomisjahospitacyjnaEntity> getNauczycielKomisjahospitacyjnasById() {
        return nauczycielKomisjahospitacyjnasById;
    }

    public void setNauczycielKomisjahospitacyjnasById(Collection<NauczycielKomisjahospitacyjnaEntity> nauczycielKomisjahospitacyjnasById) {
        this.nauczycielKomisjahospitacyjnasById = nauczycielKomisjahospitacyjnasById;
    }
}
