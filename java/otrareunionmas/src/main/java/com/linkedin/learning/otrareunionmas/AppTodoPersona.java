package com.linkedin.learning.otrareunionmas;

import com.linkedin.learning.otrareunionmas.dao.imp.PersonaDao;
import com.linkedin.learning.otrareunionmas.dominio.Acta;
import com.linkedin.learning.otrareunionmas.dominio.Persona;
import com.linkedin.learning.otrareunionmas.dominio.Reunion;
import com.linkedin.learning.otrareunionmas.dominio.Sala;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AppTodoPersona {
    private static final Logger logger = Logger.getLogger(AppTodoPersona.class.getName());
    public static void main(String[] args) {
        PersonaDao personaDao = new PersonaDao();

        Optional<Persona> optPersona = personaDao.get(1);
        if (optPersona.isPresent()) {
            Persona p = optPersona.get();
            logger.log(Level.INFO, "Persona: {0}", p);

            Set<Reunion> reuniones = p.getReuniones();
            logger.log(Level.INFO, "Reuniones: {0}", reuniones);

            Set<Sala> salas = new HashSet<>();
            Set<Persona> compis = new HashSet<>();
            Set<Acta> actas = new HashSet<>();

            for (Reunion reunion : reuniones) {
                salas.add(reunion.getSala());
                compis.addAll(reunion.getParticipantes());
                actas.add(reunion.getActa());
            }

            logger.log(Level.INFO, "Salas: {0}", salas);
            logger.log(Level.INFO, "Compis: {0}", compis);
            logger.log(Level.INFO, "Actas: {0}", actas);

        }
    }
}
