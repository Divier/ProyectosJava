package co.com.institucion.business.model;

import co.com.institucion.business.model.Asignatura;
import co.com.institucion.business.model.Curso;
import co.com.institucion.business.model.Estudiante;
import co.com.institucion.business.model.Profesor;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-05T17:42:48")
@StaticMetamodel(Relacion.class)
public class Relacion_ { 

    public static volatile SingularAttribute<Relacion, Asignatura> asignatura;
    public static volatile SingularAttribute<Relacion, Curso> curso;
    public static volatile SingularAttribute<Relacion, Long> idRel;
    public static volatile SingularAttribute<Relacion, Profesor> profesor;
    public static volatile ListAttribute<Relacion, Estudiante> estudiantes;

}