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
import proyectoprogra3.Personal;
public class PersonalDAO {
    private static String ARCHIVO = "Personal.txt";
    
    public List<Personal> cargaPersonal(){
        List<Personal> lista=new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(ARCHIVO))){
            String linea;
            while((linea =br.readLine()) != null)
            {
                lista.add(Personal.fromString(linea));
            }
        }
        catch(IOException e){
            System.out.println("Arhivo no encontrado, se creara uno nuevo");
        }
        return lista;
    }
    
    public void guardarPersonal(List<Personal>Personal){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(ARCHIVO))){
            for(Personal p: Personal){
                bw.write(p.toString());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
