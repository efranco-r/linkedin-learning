package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.ActaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppActas {
    private static final Logger logger = Logger.getLogger(AppActas.class.getName());
    public static void main(String[] args) {
        ActaDao actaDao = new ActaDao();
        List<Acta> actasAntiguasQuery = actaDao.findActasReunionesAntiguasQuery();
        logger.log(Level.INFO, "Actas antiguas: {0}", actasAntiguasQuery);

        List<Acta> actasAntiguasCriteria = actaDao.findActasReunionesAntiguasCriteria();
        logger.log(Level.INFO, "Actas antiguas: {0}", actasAntiguasCriteria);
    }
}
