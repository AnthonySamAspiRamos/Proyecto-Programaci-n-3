/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PER_de_cada_clase;

/**
 *
 * @author YOSHUA
 */

import java.io.*;
import java.util.*;
import proyectoprogra3.*;
public class Personal_informacionDAO {
    private static String ARCHIVO = "informadores.txt";
    
    public List<NodoPI> cargaInformadores() {
        List<NodoPI> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(NodoPI.fromString(linea)); // Crear método fromString en NodoPI
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo");
        }
        return lista;
    }
    
    public void guardarInformadores(List<NodoPI> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (NodoPI n : lista) {
                bw.write(n.toString()); // Sobrescribir toString para guardar en formato legible
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
