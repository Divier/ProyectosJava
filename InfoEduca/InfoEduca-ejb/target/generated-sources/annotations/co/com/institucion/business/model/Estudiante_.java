package co.com.institucion.business.model;

import co.com.institucion.business.model.Relacion;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-05T17:42:48")
@StaticMetamodel(Estudiante.class)
public class Estudiante_ { 

    public static volatile ListAttribute<Estudiante, Relacion> relaciones;
    public static volatile SingularAttribute<Estudiante, Date> fechaNacimiento;
    public static volatile SingularAttribute<Estudiante, Long> idEst;
    public static volatile SingularAttribute<Estudiante, String> nombre;

}