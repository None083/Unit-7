/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea7c;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author noelia
 */
public class UtilidadesFicheros {

    public static void lecturaFicheroPersonas(String id, List<Persona> lista) {
        String linea;
        String[] tokens;

        try (Scanner datosFichero = new Scanner(new File(id), "UTF-8")) {
            datosFichero.nextLine(); //salta la primera linea
            while (datosFichero.hasNextLine()) {
                linea = datosFichero.nextLine();
                tokens = linea.split(",");

                DateTimeFormatter formatters = DateTimeFormatter.ofPattern("d-MM-uuuu");

                lista.add(new Persona(tokens[0], tokens[1], tokens[2], tokens[3],
                        tokens[4], LocalDate.parse(tokens[5], formatters),
                        Boolean.parseBoolean(tokens[6]), tokens[7]));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void escribirFicheroGeneros(Set<String> setGeneros, String id) {
        try (FileWriter writer = new FileWriter(id, true)) {
            for (String s : setGeneros) {
                writer.write(s + "\n");
            }
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo CSV: " + e.getMessage());
        }
    }
    
    public static void escribirCSVGeneros(Map<String, Integer> mapGeneros, String id){
         try (FileWriter writer = new FileWriter(id, true)) {
            
             for (Map.Entry<String, Integer> entry : mapGeneros.entrySet()) {
                 writer.write(entry.getKey() + "," + entry.getValue() + "\n");
             }   
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al escribir en el archivo CSV: " + e.getMessage());
        }
    }

}
