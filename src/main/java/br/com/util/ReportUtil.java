package br.com.util;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import br.com.inteface.Report;

public class ReportUtil {

	private static final int INTEGER_ONE = 1;
	private static final int INTEGER_ZERO = 0;

	public static Map<String, Object> reportParamsFactory(Object pObject) {

		Map<String, Object> params = new HashMap<String, Object>();
		String key;
		Object value;

		try {
			for (Field f : pObject.getClass().getDeclaredFields()) {
				StringBuilder lField = new StringBuilder(f.getName());
				if (f.isAnnotationPresent(Report.class)) {
					key = f.getAnnotation(Report.class).value();
					value = pObject.getClass().getMethod(getValueAttribute(lField), new Class[INTEGER_ZERO])
							.invoke(pObject, new Object[INTEGER_ZERO]);
				
					if (value!=null && value.getClass().getTypeName().equals(Date.class.getTypeName())) {

						SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
						value = formato.format(value).toString();

					}
					params.put(key, value);
				}
			}
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			e.printStackTrace();
		}

		return params;

	}

	public static String getValueAttribute(StringBuilder lField) {
		return "get" + lField.replace(INTEGER_ZERO, INTEGER_ONE,
				String.valueOf(Character.toUpperCase(lField.charAt(INTEGER_ZERO))));
	}
}
