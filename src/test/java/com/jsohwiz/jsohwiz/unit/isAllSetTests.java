package com.jsohwiz.jsohwiz.unit;

import com.jsohwiz.jsohwiz.bl.service.SemestrServiceImpl;
import com.jsohwiz.jsohwiz.dal.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class isAllSetTests {
    private SemestrEntity semestrEntity;
    private SemestrEntity semestrEntity1;


    private NauczycielEntity fromUniversityNotDoctoral;
    private NauczycielEntity notFromUniversityDoctoral;
    private NauczycielEntity fromUniversityDoctoral;
    private NauczycielEntity notFromUniversityNotDoctoral;
    private NauczycielEntity extraNotFromUniversityDoctoral;


    @Before
    public void setUp() {
        semestrEntity = new SemestrEntity();
        semestrEntity.setId(1);
        semestrEntity.setKursSemestrsById(new ArrayList<>());

        semestrEntity1 = new SemestrEntity();
        semestrEntity1.setId(2);
        semestrEntity1.setKursSemestrsById(new ArrayList<>());

        KursEntity kursEntity = new KursEntity();
        KursEntity kursEntity1 = new KursEntity();

        fromUniversityNotDoctoral = new NauczycielEntity();
        fromUniversityNotDoctoral.setCzyDoktorant(false);
        fromUniversityNotDoctoral.setCzyZUczelni(true);
        fromUniversityNotDoctoral.setHospitacjasById(new ArrayList<>());

        fromUniversityDoctoral = new NauczycielEntity();
        fromUniversityDoctoral.setCzyDoktorant(true);
        fromUniversityDoctoral.setCzyZUczelni(true);
        fromUniversityDoctoral.setHospitacjasById(new ArrayList<>());


        notFromUniversityDoctoral = new NauczycielEntity();
        notFromUniversityDoctoral.setCzyDoktorant(true);
        notFromUniversityDoctoral.setCzyZUczelni(false);
        notFromUniversityDoctoral.setHospitacjasById(new ArrayList<>());


        notFromUniversityNotDoctoral = new NauczycielEntity();
        notFromUniversityNotDoctoral.setCzyDoktorant(true);
        notFromUniversityNotDoctoral.setCzyZUczelni(true);
        notFromUniversityNotDoctoral.setHospitacjasById(new ArrayList<>());


        NauczycielKursEntity fromUniversityNotDoctoral1 = new NauczycielKursEntity();
        fromUniversityNotDoctoral1.setNauczycielByNauczycielId(fromUniversityNotDoctoral);

        NauczycielKursEntity fromUniversityDoctoral1 = new NauczycielKursEntity();
        fromUniversityDoctoral1.setNauczycielByNauczycielId(fromUniversityDoctoral);

        NauczycielKursEntity notFromUniversityDoctoral1 = new NauczycielKursEntity();
        notFromUniversityDoctoral1.setNauczycielByNauczycielId(notFromUniversityDoctoral);

        NauczycielKursEntity notFromUniversityNotDoctoral1 = new NauczycielKursEntity();
        notFromUniversityNotDoctoral1.setNauczycielByNauczycielId(notFromUniversityNotDoctoral);

        kursEntity.setNauczycielKursById(new ArrayList<>());
        kursEntity.getNauczycielKursById().add(fromUniversityNotDoctoral1);
        kursEntity.getNauczycielKursById().add(fromUniversityDoctoral1);
        kursEntity.getNauczycielKursById().add(notFromUniversityDoctoral1);
        kursEntity.getNauczycielKursById().add(notFromUniversityNotDoctoral1);

        kursEntity1.setNauczycielKursById(new ArrayList<>());
        kursEntity1.getNauczycielKursById().add(fromUniversityNotDoctoral1);
        kursEntity1.getNauczycielKursById().add(fromUniversityDoctoral1);
        kursEntity1.getNauczycielKursById().add(notFromUniversityDoctoral1);
        kursEntity1.getNauczycielKursById().add(notFromUniversityNotDoctoral1);

        extraNotFromUniversityDoctoral = new NauczycielEntity();
        extraNotFromUniversityDoctoral.setCzyDoktorant(false);
        extraNotFromUniversityDoctoral.setCzyZUczelni(true);
        extraNotFromUniversityDoctoral.setHospitacjasById(new ArrayList<>());

        NauczycielKursEntity extraNotFromUniversityDoctoral1 = new NauczycielKursEntity();
        extraNotFromUniversityDoctoral1.setNauczycielByNauczycielId(extraNotFromUniversityDoctoral);

        kursEntity1.setNauczycielKursById(new ArrayList<>());
        kursEntity1.getNauczycielKursById().add(extraNotFromUniversityDoctoral1);

        KursSemestrEntity kursSemestrEntity = new KursSemestrEntity();
        kursSemestrEntity.setKursByKursId(kursEntity);

        KursSemestrEntity kursSemestrEntity1 = new KursSemestrEntity();
        kursSemestrEntity1.setKursByKursId(kursEntity1);

        semestrEntity.getKursSemestrsById().add(kursSemestrEntity);

        semestrEntity1.getKursSemestrsById().add(kursSemestrEntity1);
    }

    @Test
    public void noOneHospitated() {
        //arrange [given]
        Boolean expected = false;
        Boolean actual;
        //act [when]
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void everyOneHospitated() {
        //arrange [given]
        Boolean expected = true;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void everyOneHospitatedButOnAnotherSemester() {
        //arrange [given]
        Boolean expected = false;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity1);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void notFromUniversityDoctoralNotHospitated() {
        //arrange [given]
        Boolean expected = false;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void notFromUniversityNotDoctoralNotHospitated() {
        //arrange [given]
        Boolean expected = false;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void fromUniversityDoctoralNotHospitated() {
        //arrange [given]
        Boolean expected = false;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }

    @Test
    public void fromUniversityNotDoctoralNotHospitated() {
        //arrange [given]
        Boolean expected = true;
        Boolean actual;
        //act [when]
        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        fromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        notFromUniversityNotDoctoral.getHospitacjasById().add(hospitacjaEntity);
        hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        extraNotFromUniversityDoctoral.getHospitacjasById().add(hospitacjaEntity);
        actual = SemestrServiceImpl.isAllSet(semestrEntity);
        //assert [then]
        assertEquals(expected, actual);
    }
}
