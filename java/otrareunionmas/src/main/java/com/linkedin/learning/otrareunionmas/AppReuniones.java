package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.ReunionDao;

import java.util.logging.Level;
import java.util.logging.Logger;

public class AppReuniones {
    private static final Logger logger = Logger.getLogger(AppReuniones.class.getName());
    public static void main(String[] args) {
        ReunionDao reunionDao = new ReunionDao();
        logger.log(Level.INFO, "Reuniones de Pedro: {0}", reunionDao.reunionesParticipante("E002"));
    }
}
