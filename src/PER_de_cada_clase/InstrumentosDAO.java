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
import java.util.ArrayList;
import proyectoprogra3.*;
public class InstrumentosDAO {
    private static String ARCHIVO = "Instrumentos.txt";
    
    public List<InstrumentosDoc> cargarInst(){
        List<InstrumentosDoc> lista=new ArrayList<>();
        try(BufferedReader br= new BufferedReader(new FileReader(ARCHIVO))){
            String linea;
            while((linea =br.readLine()) != null)
            {
                lista.add(InstrumentosDoc.fromString(linea));
            }
        }
        catch(IOException e){
            System.out.println("Arhivo no encontrado, se creara uno nuevo");
        }
        return lista;
    }
    
    public void guardarInst(List<InstrumentosDoc>InstumentosDocs){
        try(BufferedWriter bw=new BufferedWriter(new FileWriter(ARCHIVO))){
            for(InstrumentosDoc v: InstumentosDocs){
                bw.write(v.toString());
                bw.newLine();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
