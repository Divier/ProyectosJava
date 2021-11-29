package co.com.institucion.business.model;

import co.com.institucion.business.model.Asignatura;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-05T17:42:48")
@StaticMetamodel(Horario.class)
public class Horario_ { 

    public static volatile SingularAttribute<Horario, Long> idHor;
    public static volatile SingularAttribute<Horario, Date> hora;
    public static volatile SingularAttribute<Horario, String> dia;
    public static volatile ListAttribute<Horario, Asignatura> asignaturas;

}