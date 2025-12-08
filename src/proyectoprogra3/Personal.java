
package proyectoprogra3;

import java.util.Scanner;

public class Personal extends Persona {
    private int Id_Personal;
    private String tipo,categoria;
    private Scanner lec=new Scanner(System.in);

    public Personal(int c, String nom, String pat, String mat, int ed, String sx, int cont, int id,String tip,String cat) {
        super(c, nom, pat, mat, ed, sx, cont);
        Id_Personal=id;
        tipo=tip;
        categoria=cat;
        
    }
    
    public void leer(){
        super.leer();
        System.out.print("Int. Id Personal: "); Id_Personal=lec.nextInt();
    }
    public void mostrar(){
        super.mostrar();
        System.out.println("Id Personal: "+Id_Personal);
    }

    public int getId_Personal() {
        return Id_Personal;
    }

    public void setId_Personal(int Id_Personal) {
        this.Id_Personal = Id_Personal;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    @Override
    public String toString() {
        return  getCi()+";"+getNombre()+";"+getPaterno()+";"+getMaterno()+";"+getEdad()+";"+getSexo()+";"+getContacto()+";"+Id_Personal+";"+tipo+";"+categoria;
    }
    public static Personal fromString(String linea) {
        try {
        String[] p = linea.split(";");

        if (p.length != 10) return null; // Línea inválida → ignorar

        return new Personal(
                Integer.parseInt(p[0]),  
                p[1],                    
                p[2],                    
                p[3],                    
                Integer.parseInt(p[4]),  
                p[5],                    
                Integer.parseInt(p[6]),  
                Integer.parseInt(p[7]),
                p[8],
                p[9]
        );

        } catch (Exception e) {
            System.out.println("Error leyendo línea: " + linea);
            return null;
        }
    }
}
