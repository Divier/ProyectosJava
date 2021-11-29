/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.com.institucion.business.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;

/**
 *
 * @author ECM1378G
 */
public class ObjectMapperUtil {

    private static ModelMapper modelMapper = new ModelMapper();

    /**
     * Model mapper property setting are specified in the following block.
     * Default property matching strategy is set to Strict see
     * {@link MatchingStrategies} Custom mappings are added using
     * {@link ModelMapper#addMappings(PropertyMap)}
     */
    static {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    /**
     * Hide from public usage.
     */
    private ObjectMapperUtil() {
    }

    /**
     * <p>
     * Note: outClass object must have default constructor with no arguments</p>
     *
     * @param <D> type of result object.
     * @param <T> type of source object to map from.
     * @param entity entity that needs to be mapped.
     * @param outClass class of result object.
     * @return new object of <code>outClass</code> type.
     */
    public static <D, T> D map(final T entity, Class<D> outClass) {

        if(entity != null) {
            Converter<String, Date> stringToDate = new Converter<String, Date>() {
                @Override
                public Date convert(MappingContext<String, Date> mc) {

                    if (mc.getSource() != null) {
                        try {
                            Date date = null;
                            Pattern pFull = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
                            Pattern pDate = Pattern.compile("\\d{4}-\\d{2}-\\d{2}");
                            Pattern pHour = Pattern.compile("\\d{2}:\\d{2}:\\d{2}");
                            if (pFull.matcher(mc.getSource()).matches()) {
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", new Locale("es", "ES"));
                                formatter.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                                date = formatter.parse(mc.getSource());
                            } else if (pHour.matcher(mc.getSource()).matches()) {
                                SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss", new Locale("es", "ES"));
                                formatter.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                                date = formatter.parse(mc.getSource());
                            } else if (pDate.matcher(mc.getSource()).matches()) {
                                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
                                formatter.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                                date = formatter.parse(mc.getSource());
                            }
                            return date;
                        } catch (ParseException ex) {
                        }
                    }
                    return null;
                }
            };
            Converter<Date, String> dateToString = new Converter<Date, String>() {
                @Override
                public String convert(MappingContext<Date, String> mc) {

                    if (mc.getSource() != null) {
                        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss", new Locale("es", "ES"));
                        formatter.setTimeZone(TimeZone.getTimeZone("America/Bogota"));
                        return formatter.format(mc.getSource()); 
                    }
                    return null;
                }
            };
            modelMapper.addConverter(stringToDate);
            modelMapper.addConverter(dateToString);
            return modelMapper.map(entity, outClass);
        }
        return null;
    }

    /**
     * <p>
     * Note: outClass object must have default constructor with no arguments</p>
     *
     * @param entityList list of entities that needs to be mapped
     * @param outCLass class of result list element
     * @param <D> type of objects in result list
     * @param <T> type of entity in <code>entityList</code>
     * @return list of mapped object with <code><D></code> type.
     */
    public static <D, T> List<D> mapAll(final Collection<T> entityList, Class<D> outCLass) {

        if(entityList != null) {
            return entityList.stream()
                    .map(entity -> map(entity, outCLass))
                    .collect(Collectors.toList());
        }
        return null;
    }

    /**
     * Maps {@code source} to {@code destination}.
     *
     * @param source object to map from
     * @param destination object to map to
     */
    public static <S, D> D map(final S source, D destination) {

        if(source != null) {
            modelMapper.map(source, destination);
            return destination;
        }
        return null;
    }
}
