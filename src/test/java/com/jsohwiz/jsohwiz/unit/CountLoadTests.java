package com.jsohwiz.jsohwiz.unit;

import com.jsohwiz.jsohwiz.bl.service.NauczycielServiceImpl;
import com.jsohwiz.jsohwiz.dal.entity.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CountLoadTests {
    private SemestrEntity semestrEntity;

    private NauczycielEntity nauczycielZero;
    private NauczycielEntity nauczycielMixedRolesOnePlan;
    private NauczycielEntity nauczycielMixedRolesSomePlans;
    private NauczycielEntity nauczycielOnlyChairmanSomePlans;
    private NauczycielEntity nauczycielOnlyMemberSomePlans;

    @Before
    public void setUp() {
        nauczycielZero = new NauczycielEntity();
        nauczycielZero.setKomisjahospitacyjnasById(new ArrayList<>());
        nauczycielZero.setNauczycielKomisjahospitacyjnasById(new ArrayList<>());

        nauczycielMixedRolesOnePlan = new NauczycielEntity();
        nauczycielMixedRolesOnePlan.setKomisjahospitacyjnasById(new ArrayList<>());
        nauczycielMixedRolesOnePlan.setNauczycielKomisjahospitacyjnasById(new ArrayList<>());

        nauczycielMixedRolesSomePlans = new NauczycielEntity();
        nauczycielMixedRolesSomePlans.setKomisjahospitacyjnasById(new ArrayList<>());
        nauczycielMixedRolesSomePlans.setNauczycielKomisjahospitacyjnasById(new ArrayList<>());

        nauczycielOnlyChairmanSomePlans = new NauczycielEntity();
        nauczycielOnlyChairmanSomePlans.setKomisjahospitacyjnasById(new ArrayList<>());
        nauczycielOnlyChairmanSomePlans.setNauczycielKomisjahospitacyjnasById(new ArrayList<>());

        nauczycielOnlyMemberSomePlans = new NauczycielEntity();
        nauczycielOnlyMemberSomePlans.setKomisjahospitacyjnasById(new ArrayList<>());
        nauczycielOnlyMemberSomePlans.setNauczycielKomisjahospitacyjnasById(new ArrayList<>());

        semestrEntity = new SemestrEntity();
        semestrEntity.setId(1);

        PlanhospitacjiEntity planhospitacjiEntity = new PlanhospitacjiEntity();
        planhospitacjiEntity.setSemestrBySemestrId(semestrEntity);
        PlanhospitacjiEntity planhospitacjiEntity1 = new PlanhospitacjiEntity();
        planhospitacjiEntity1.setSemestrBySemestrId(semestrEntity);


        SemestrEntity semestrEntity1 = new SemestrEntity();
        semestrEntity1.setId(2);

        PlanhospitacjiEntity planhospitacjiEntity2 = new PlanhospitacjiEntity();
        planhospitacjiEntity2.setSemestrBySemestrId(semestrEntity1);


        KomisjahospitacyjnaEntity komisjahospitacyjnaEntity = new KomisjahospitacyjnaEntity();
        nauczycielMixedRolesOnePlan.getKomisjahospitacyjnasById().add(komisjahospitacyjnaEntity);

        NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity = new NauczycielKomisjahospitacyjnaEntity();
        nauczycielKomisjahospitacyjnaEntity.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity);
        nauczycielOnlyMemberSomePlans.getNauczycielKomisjahospitacyjnasById().add(nauczycielKomisjahospitacyjnaEntity);

        komisjahospitacyjnaEntity.setHospitacjasById(new ArrayList<>());
        HospitacjaEntity hospitacjaEntity = new HospitacjaEntity();
        hospitacjaEntity.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        komisjahospitacyjnaEntity.getHospitacjasById().add(hospitacjaEntity);

        HospitacjaEntity hospitacjaEntity4 = new HospitacjaEntity();
        hospitacjaEntity4.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity2);
        komisjahospitacyjnaEntity.getHospitacjasById().add(hospitacjaEntity4);


        KomisjahospitacyjnaEntity komisjahospitacyjnaEntity1 = new KomisjahospitacyjnaEntity();
        nauczycielMixedRolesSomePlans.getKomisjahospitacyjnasById().add(komisjahospitacyjnaEntity1);

        NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity1 = new NauczycielKomisjahospitacyjnaEntity();
        nauczycielKomisjahospitacyjnaEntity1.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity1);
        nauczycielMixedRolesOnePlan.getNauczycielKomisjahospitacyjnasById().add(nauczycielKomisjahospitacyjnaEntity1);

        komisjahospitacyjnaEntity1.setHospitacjasById(new ArrayList<>());
        HospitacjaEntity hospitacjaEntity1 = new HospitacjaEntity();
        hospitacjaEntity1.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        komisjahospitacyjnaEntity1.getHospitacjasById().add(hospitacjaEntity1);

        HospitacjaEntity hospitacjaEntity5 = new HospitacjaEntity();
        hospitacjaEntity5.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity2);
        komisjahospitacyjnaEntity1.getHospitacjasById().add(hospitacjaEntity5);


        KomisjahospitacyjnaEntity komisjahospitacyjnaEntity2 = new KomisjahospitacyjnaEntity();
        nauczycielOnlyChairmanSomePlans.getKomisjahospitacyjnasById().add(komisjahospitacyjnaEntity2);

        NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity2 = new NauczycielKomisjahospitacyjnaEntity();
        nauczycielKomisjahospitacyjnaEntity2.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity2);
        nauczycielMixedRolesSomePlans.getNauczycielKomisjahospitacyjnasById().add(nauczycielKomisjahospitacyjnaEntity2);

        NauczycielKomisjahospitacyjnaEntity nauczycielKomisjahospitacyjnaEntity3 = new NauczycielKomisjahospitacyjnaEntity();
        nauczycielKomisjahospitacyjnaEntity3.setKomisjahospitacyjnaByKomisjaHospitacyjnaId(komisjahospitacyjnaEntity2);
        nauczycielOnlyMemberSomePlans.getNauczycielKomisjahospitacyjnasById().add(nauczycielKomisjahospitacyjnaEntity3);

        komisjahospitacyjnaEntity2.setHospitacjasById(new ArrayList<>());
        HospitacjaEntity hospitacjaEntity2 = new HospitacjaEntity();
        hospitacjaEntity2.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity1);
        komisjahospitacyjnaEntity2.getHospitacjasById().add(hospitacjaEntity2);

        HospitacjaEntity hospitacjaEntity3 = new HospitacjaEntity();
        hospitacjaEntity3.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity);
        komisjahospitacyjnaEntity2.getHospitacjasById().add(hospitacjaEntity3);

        HospitacjaEntity hospitacjaEntity6 = new HospitacjaEntity();
        hospitacjaEntity6.setPlanhospitacjiByPlanHospitacjiId(planhospitacjiEntity2);
        komisjahospitacyjnaEntity2.getHospitacjasById().add(hospitacjaEntity6);
    }

    @Test
    public void nauczycielZeroTest() {
        //arrange [given]
        Integer expected = 0;
        Integer actual;
        //act [when]
        actual = NauczycielServiceImpl.countLoad(nauczycielZero, semestrEntity);
        //assert [then]
        assertEquals(actual, expected);
    }

    @Test
    public void nauczycielMixedRolesOnePlanTest() {
        //arrange [given]
        Integer expected = 2;
        Integer actual;
        //act [when]
        actual = NauczycielServiceImpl.countLoad(nauczycielMixedRolesOnePlan, semestrEntity);
        //assert [then]
        assertEquals(actual, expected);
    }

    @Test
    public void nauczycielMixedRolesSomePlansTest() {
        //arrange [given]
        Integer expected = 3;
        Integer actual;
        //act [when]
        actual = NauczycielServiceImpl.countLoad(nauczycielMixedRolesSomePlans, semestrEntity);
        //assert [then]
        assertEquals(actual, expected);
    }

    @Test
    public void nauczycielOnlyChairmanSomePlansTest() {
        //arrange [given]
        Integer expected = 2;
        Integer actual;
        //act [when]
        actual = NauczycielServiceImpl.countLoad(nauczycielOnlyChairmanSomePlans, semestrEntity);
        //assert [then]
        assertEquals(actual, expected);
    }

    @Test
    public void nauczycielOnlyMemberSomePlansTest() {
        //arrange [given]
        Integer expected = 3;
        Integer actual;
        //act [when]
        actual = NauczycielServiceImpl.countLoad(nauczycielOnlyMemberSomePlans, semestrEntity);
        //assert [then]
        assertEquals(actual, expected);
    }
}
