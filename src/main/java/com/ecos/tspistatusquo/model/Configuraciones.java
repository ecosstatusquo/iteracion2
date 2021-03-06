/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ecos.tspistatusquo.model;

import com.ecos.tspistatusquo.exceptions.ExceptionApp;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author Dev
 */
public abstract class Configuraciones {

    private static Properties prop;
    private static String sDirectorioTrabajo = System.getProperty("user.dir");
    private static String sSeparator = System.getProperty("file.separator");
    private static String propFileName = "ConfigProperties.properties";

    private static void cargaPropiedades() throws ExceptionApp{
        try {
            final InputStream inputStream = new FileInputStream(sDirectorioTrabajo + sSeparator + propFileName);
            if (inputStream != null) {
                prop.load(inputStream);
            } else {
                throw new FileNotFoundException("El Archivo de propiedades '" + propFileName + "' no se encuentra en el CLASSPATH");
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Ocurrio un Error : " + ex.getMessage());
            throw new ExceptionApp("Error al leer la ruta del programa. " + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Ocurrio un Error : " + ex.getMessage());
            throw new ExceptionApp("Error al leer la ruta del programa. " + ex.getMessage());
        }
    }

    public static Properties getProp() throws ExceptionApp {
        if(prop == null) {
            prop = new Properties();
            cargaPropiedades();
        }
        return prop;
    }    
}
