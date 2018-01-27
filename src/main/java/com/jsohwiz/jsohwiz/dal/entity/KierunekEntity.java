package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "kierunek", schema = "jsohwiz", catalog = "")
public class KierunekEntity {
    private Integer id;
    private String nazwa;
    private Collection<KursEntity> kursById;
    private Collection<PlanhospitacjiEntity> planhospitacjisById;

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

        KierunekEntity that = (KierunekEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return nazwa != null ? nazwa.equals(that.nazwa) : that.nazwa == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nazwa != null ? nazwa.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "kierunekByKierunekId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<KursEntity> getKursById() {
        return kursById;
    }

    public void setKursById(Collection<KursEntity> kursById) {
        this.kursById = kursById;
    }

    @OneToMany(mappedBy = "kierunekByKierunekId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<PlanhospitacjiEntity> getPlanhospitacjisById() {
        return planhospitacjisById;
    }

    public void setPlanhospitacjisById(Collection<PlanhospitacjiEntity> planhospitacjisById) {
        this.planhospitacjisById = planhospitacjisById;
    }
}
