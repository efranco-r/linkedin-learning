package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.ActaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;

import java.util.List;

public class AppActas {
    public static void main(String[] args) {
        ActaDao actaDao = new ActaDao();
        List<Acta> actasAntiguasQuery = actaDao.findActasReunionesAntiguasQuery();
        System.out.println("Actas antiguas: " + actasAntiguasQuery);

        List<Acta> actasAntiguasCriteria = actaDao.findActasReunionesAntiguasCriteria();
        System.out.println("Actas antiguas: " + actasAntiguasCriteria);
    }
}
