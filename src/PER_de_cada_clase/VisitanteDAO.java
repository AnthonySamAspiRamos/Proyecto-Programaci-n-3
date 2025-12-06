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
import proyectoprogra3.Visitante;
public class VisitanteDAO {
    private static String ARCHIVO = "visitantes.txt";
    
    public List<Visitante> cargaVisitantes(){
        List<Visitante> lista=new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(ARCHIVO))){
            String linea;
            while((linea =br.readLine()) != null)
            {
                lista.add(Visitante.fromString(linea));
            }
        }
        catch(IOException e){
            System.out.println("Arhivo no encontrado, se creara uno nuevo");
        }
        return lista;
    }
    
    public void guardarVisitantes(List<Visitante>visitantes){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(ARCHIVO))){
            for(Visitante v: visitantes){
                bw.write(v.toString());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
