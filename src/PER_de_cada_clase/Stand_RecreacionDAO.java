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
public class Stand_RecreacionDAO {
    private static String ARCHIVO = "Stand_Recreacion.txt";
    
    public List<NodoSR> cargaSR() {
        List<NodoSR> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lista.add(NodoSR.fromString(linea)); // Crear método fromString en NodoSR
            }
        } catch (IOException e) {
            System.out.println("Archivo no encontrado, se creará uno nuevo");
        }
        return lista;
    }
    
    public void guardarSR(List<NodoSR> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (NodoSR n : lista) {
                bw.write(n.toString()); // Sobrescribir toString para guardar en formato legible
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
