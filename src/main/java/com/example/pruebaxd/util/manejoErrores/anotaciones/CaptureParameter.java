package com.example.pruebaxd.util.manejoErrores.anotaciones;

import com.example.pruebaxd.util.manejoErrores.anotaciones.interfaces.ParametroObligatorio;;

import java.lang.reflect.Field; 
 public class CaptureParameter {
            public static <T> String getParameterObligatorio(T instancia)   {
                Class<?> clase = instancia.getClass();
                Field[] campos = clase.getDeclaredFields();

                for (Field campo : campos) {
                    campo.setAccessible(true);
                    if (campo.isAnnotationPresent(ParametroObligatorio.class)) {
                        try {
                            if (campo.get(instancia) == null) {
                                return "PARAMETRO OBLIGATORIO"+" : "+campo.getName();
                            }
                        } catch (IllegalAccessException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                return null;
            }
}