package co.com.institucion.business.model;

import co.com.institucion.business.model.Horario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-05T17:42:48")
@StaticMetamodel(Asignatura.class)
public class Asignatura_ { 

    public static volatile SingularAttribute<Asignatura, Date> fechaHasta;
    public static volatile ListAttribute<Asignatura, Horario> horarios;
    public static volatile SingularAttribute<Asignatura, Date> fechaDesde;
    public static volatile SingularAttribute<Asignatura, Long> idAsg;
    public static volatile SingularAttribute<Asignatura, String> nombre;

}