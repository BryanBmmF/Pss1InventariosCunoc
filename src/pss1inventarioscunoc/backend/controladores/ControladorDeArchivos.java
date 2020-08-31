/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pss1inventarioscunoc.backend.controladores;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author jesfrin
 */
public class ControladorDeArchivos {

    public static void escribirLog(ArrayList<String> log) {
        try {
            String ruta = "/home/jesfrin/Documentos/filename.txt";
            ControladorLogIngreso controlador = new ControladorLogIngreso();
            ArrayList<String> logs = controlador.buscarLogs();
            String contenido = "";
            if (logs != null) {
                for (String log1 : logs) {
                    contenido+=log1+"\n";
                }
                
                File file = new File(ruta);
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

}
