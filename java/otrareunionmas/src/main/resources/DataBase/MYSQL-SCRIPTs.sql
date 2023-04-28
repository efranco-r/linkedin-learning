# REINICIAR EL AUTOINCREMENTABLE DE UNA TABLA
ALTER TABLE REUNION AUTO_INCREMENT = 1;
ALTER TABLE PERSONA AUTO_INCREMENT = 1;
ALTER TABLE ACTA AUTO_INCREMENT = 1;

# CONSULTAS DE SALAS BASADOS EN SU CAPACIDAD
SELECT *
FROM SALA SALA
WHERE CAPACIDAD >=:CAP;

SELECT *
FROM SALA SALA
WHERE CAPACIDAD >= :CAPMIN AND CAPACIDAD <= (:CAPMIN * 2);

# CONSULTA DE ACTAS ANTERIORES AL DIA EN CUESTION
SELECT *
FROM ACTA ACTA
INNER JOIN REUNION REUNION ON ACTA.REUNION_ID = REUNION.ID 
WHERE REUNION.FECHA <= DATE_SUB(NOW(), INTERVAL 1 DAY);

# CONSULTAR REUNIONES DE UN PARTICIPANTE
SELECT REUNION.*
FROM REUNION REUNION
INNER JOIN PERSONA_REUNION PERSONA_REUNION  ON PERSONA_REUNION.reuniones_ID = REUNION.ID 
INNER JOIN PERSONA PERSONA ON PERSONA.ID = PERSONA_REUNION.participantes_ID
WHERE PERSONA.NUMERO_EMPLEADO = "E002";

select * 
from acta a 
inner join reunion r on a.reunion_id = r.id
inner join sala s on r.sala_id = s.id
where s.capacidad > 5;
