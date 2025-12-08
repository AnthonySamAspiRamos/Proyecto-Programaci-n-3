package Clases;

import proyectoprogra3.*;
import java.util.Scanner;

public class Visitante extends Persona {
    private int Id_Visitante, Id_FichasMedicas, Id_Informaciones;
    private Scanner lec=new Scanner(System.in);

    public Visitante(int c, String nom, String pat, String mat, int ed, String sx, int cont, int idV, int idF, int idI) {
        super(c, nom, pat, mat, ed, sx, cont);
        Id_Visitante=idV;
        Id_FichasMedicas=idF;
        Id_Informaciones=idI;
    }
    public void leer(){
        super.leer();
        System.out.print("Int. Id Visitante => ");Id_Visitante=lec.nextInt();
        System.out.print("Int. Id Fichas Medicas => ");Id_FichasMedicas=lec.nextInt();
        System.out.print("Int. Id Informacion => ");Id_Informaciones=lec.nextInt();
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("Id Visitante: "+Id_Visitante+" | Id Fichas Medicas: "+Id_FichasMedicas+" | Id Informaciones: "+Id_Informaciones);
    }

    public int getId_Visitante() {
        return Id_Visitante;
    }

    public void setId_Visitante(int Id_Visitante) {
        this.Id_Visitante = Id_Visitante;
    }

    public int getId_FichasMedicas() {
        return Id_FichasMedicas;
    }

    public void setId_FichasMedicas(int Id_FichasMedicas) {
        this.Id_FichasMedicas = Id_FichasMedicas;
    }

    public int getId_Informaciones() {
        return Id_Informaciones;
    }

    public void setId_Informaciones(int Id_Informaciones) {
        this.Id_Informaciones = Id_Informaciones;
    }
    @Override
    public String toString() {
        return  getCi()+";"+getNombre()+";"+getPaterno()+";"+getMaterno()+";"+getEdad()+";"+getSexo()+";"+getContacto()+";"+Id_Visitante+";"+Id_FichasMedicas+";"+Id_Informaciones;
    }
    public static Visitante fromString(String linea) {
        try {
        String[] p = linea.split(";");

        if (p.length != 10) return null; // Línea inválida → ignorar

        return new Visitante(
                Integer.parseInt(p[0]),  
                p[1],                    
                p[2],                    
                p[3],                    
                Integer.parseInt(p[4]),  
                p[5],                    
                Integer.parseInt(p[6]),  
                Integer.parseInt(p[7]),  
                Integer.parseInt(p[8]),  
                Integer.parseInt(p[9])   
        );

        } catch (Exception e) {
            System.out.println("Error leyendo línea: " + linea);
            return null;
        }
    }
}
