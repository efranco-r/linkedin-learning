package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.SalaDao;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

import java.util.List;

public class AppConsultas {
    public static void main(String[] args) {
        SalaDao salaDao = new SalaDao();

        List<Sala> salasPara4 = salaDao.findSalasParaN(4);
        System.out.println("Salas para 4: " + salasPara4);

        List<Sala> salasPara3 = salaDao.findSalasParaN(3);
        System.out.println("Salas para 3: " + salasPara3);

        List<Sala> salasAdecuadasPara3 = salaDao.findSalasAdecuadasParaN(11);
        System.out.println("Salas adecuadas para 3: " + salasAdecuadasPara3);
    }
}
