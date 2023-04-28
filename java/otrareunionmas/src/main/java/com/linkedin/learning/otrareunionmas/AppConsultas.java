package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

import java.util.List;

import java.util.logging.Logger;
import java.util.logging.Level;

public class AppConsultas {
    private static final Logger logger = Logger.getLogger(AppConsultas.class.getName());
    public static void main(String[] args) {
        SalaDao salaDao = new SalaDao();

        List<Sala> salasPara4 = salaDao.findSalasParaN(4);
        logger.log(Level.INFO, "Salas para 4: {0}", salasPara4);

        List<Sala> salasPara3 = salaDao.findSalasParaN(3);
        logger.log(Level.INFO, "Salas para 3: {0}", salasPara3);

        List<Sala> salasAdecuadasPara3 = salaDao.findSalasAdecuadasParaN(11);
        logger.log(Level.INFO, "Salas adecuadas para 3: {0}", salasAdecuadasPara3);
    }
}
