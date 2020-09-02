/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ControladorDeArchivos {

    public static final String RUTA = Paths.get(".").toAbsolutePath().normalize().toString() + "/log.txt";
    private static ArrayList<String> listadoLogs = new ArrayList<>();
    private static String contenido="";
    
    public static void escribirLog() {
        try {
            //Se realiza la consulta a la base de datos para los logs
            ControladorLogIngreso controlador = new ControladorLogIngreso();
            //Se lee el contenido de logs para anadirlo al final
           listadoLogs=controlador.buscarLogs();
            if (listadoLogs != null || !listadoLogs.isEmpty()) {
                for (String log1 : listadoLogs) {
                    contenido += "Usuario:"+ControladorUser.USUARIO_LOGUEADO.getId_usuario()+"->"+log1 + "\n";
                }
                leerLog();
                File file = new File(RUTA);
                // Si el archivo no existe es creado
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(contenido);
                bw.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void leerLog() {
        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        try {
            // Apertura del fichero y creacion de BufferedReader para poder
            // hacer una lectura comoda (disponer del metodo readLine()).
            archivo = new File(RUTA);
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido+="\n"+linea;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // En el finally cerramos el fichero, para asegurarnos
            // que se cierra tanto si todo va bien como si salta 
            // una excepcion.
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
