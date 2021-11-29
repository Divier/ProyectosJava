package co.com.institucion.business.model;

import co.com.institucion.business.model.Colegio;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-05T17:42:48")
@StaticMetamodel(Curso.class)
public class Curso_ { 

    public static volatile SingularAttribute<Curso, Short> grado;
    public static volatile SingularAttribute<Curso, Long> idCur;
    public static volatile SingularAttribute<Curso, Colegio> colegio;
    public static volatile SingularAttribute<Curso, String> salon;

}