package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.ReunionDao;

public class AppReuniones {
    public static void main(String[] args) {
        ReunionDao reunionDao = new ReunionDao();
        System.out.println("Reuniones de Pedro: " + reunionDao.reunionesParticipante("E002"));
    }
}
