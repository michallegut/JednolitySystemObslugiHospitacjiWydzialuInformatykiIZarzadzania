package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "semestr", schema = "jsohwiz", catalog = "")
public class SemestrEntity {
    private Integer id;
    private Integer rodzaj;
    private Integer rok;
    private Boolean czyObecny;
    private Collection<KursSemestrEntity> kursSemestrsById;
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
    @Column(name = "rodzaj")
    public Integer getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(Integer rodzaj) {
        this.rodzaj = rodzaj;
    }

    @Basic
    @Column(name = "rok")
    public Integer getRok() {
        return rok;
    }

    public void setRok(Integer rok) {
        this.rok = rok;
    }

    @Basic
    @Column(name = "czy_obecny", columnDefinition = "TINYINT(1)")
    public Boolean getCzyObecny() {
        return czyObecny;
    }

    public void setCzyObecny(Boolean czyObecny) {
        this.czyObecny = czyObecny;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SemestrEntity that = (SemestrEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (rodzaj != null ? !rodzaj.equals(that.rodzaj) : that.rodzaj != null) return false;
        if (rok != null ? !rok.equals(that.rok) : that.rok != null) return false;
        return czyObecny != null ? czyObecny.equals(that.czyObecny) : that.czyObecny == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (rodzaj != null ? rodzaj.hashCode() : 0);
        result = 31 * result + (rok != null ? rok.hashCode() : 0);
        result = 31 * result + (czyObecny != null ? czyObecny.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "semestrBySemestrId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<KursSemestrEntity> getKursSemestrsById() {
        return kursSemestrsById;
    }

    public void setKursSemestrsById(Collection<KursSemestrEntity> kursSemestrsById) {
        this.kursSemestrsById = kursSemestrsById;
    }

    @OneToMany(mappedBy = "semestrBySemestrId")
    @LazyCollection(LazyCollectionOption.FALSE)
    public Collection<PlanhospitacjiEntity> getPlanhospitacjisById() {
        return planhospitacjisById;
    }

    public void setPlanhospitacjisById(Collection<PlanhospitacjiEntity> planhospitacjisById) {
        this.planhospitacjisById = planhospitacjisById;
    }
}
