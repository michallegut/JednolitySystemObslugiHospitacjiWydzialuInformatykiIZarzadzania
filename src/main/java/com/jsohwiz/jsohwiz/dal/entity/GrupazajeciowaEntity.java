package com.jsohwiz.jsohwiz.dal.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "grupazajeciowa", schema = "jsohwiz", catalog = "")
public class GrupazajeciowaEntity {
    private Integer id;
    private String kod;
    private Integer dzienTygodnia;
    private Time czasRozpoczecia;
    private Time czasZakonczenia;
    private KursEntity kursByKursId;
    private NauczycielEntity nauczycielByNauczycielId;

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
    @Column(name = "kod")
    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    @Basic
    @Column(name = "dzien_tygodnia")
    public Integer getDzienTygodnia() {
        return dzienTygodnia;
    }

    public void setDzienTygodnia(Integer dzienTygodnia) {
        this.dzienTygodnia = dzienTygodnia;
    }

    @Basic
    @Column(name = "czas_rozpoczecia")
    public Time getCzasRozpoczecia() {
        return czasRozpoczecia;
    }

    public void setCzasRozpoczecia(Time czasRozpoczecia) {
        this.czasRozpoczecia = czasRozpoczecia;
    }

    @Basic
    @Column(name = "czas_zakonczenia")
    public Time getCzasZakonczenia() {
        return czasZakonczenia;
    }

    public void setCzasZakonczenia(Time czasZakonczenia) {
        this.czasZakonczenia = czasZakonczenia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GrupazajeciowaEntity that = (GrupazajeciowaEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (kod != null ? !kod.equals(that.kod) : that.kod != null) return false;
        if (dzienTygodnia != null ? !dzienTygodnia.equals(that.dzienTygodnia) : that.dzienTygodnia != null)
            return false;
        if (czasRozpoczecia != null ? !czasRozpoczecia.equals(that.czasRozpoczecia) : that.czasRozpoczecia != null)
            return false;
        return czasZakonczenia != null ? czasZakonczenia.equals(that.czasZakonczenia) : that.czasZakonczenia == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (kod != null ? kod.hashCode() : 0);
        result = 31 * result + (dzienTygodnia != null ? dzienTygodnia.hashCode() : 0);
        result = 31 * result + (czasRozpoczecia != null ? czasRozpoczecia.hashCode() : 0);
        result = 31 * result + (czasZakonczenia != null ? czasZakonczenia.hashCode() : 0);
        return result;
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
    @JoinColumn(name = "nauczyciel_id", referencedColumnName = "id", nullable = false)
    @LazyCollection(LazyCollectionOption.FALSE)
    public NauczycielEntity getNauczycielByNauczycielId() {
        return nauczycielByNauczycielId;
    }

    public void setNauczycielByNauczycielId(NauczycielEntity nauczycielByNauczycielId) {
        this.nauczycielByNauczycielId = nauczycielByNauczycielId;
    }
}
