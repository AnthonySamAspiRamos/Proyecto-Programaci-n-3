
package proyectoprogra3;

import java.util.Scanner;

public class Personal extends Persona {
    private int Id_Personal;
    private Scanner lec=new Scanner(System.in);

    public Personal(int c, String nom, String pat, String mat, int ed, String sx, int cont, int id) {
        super(c, nom, pat, mat, ed, sx, cont);
        Id_Personal=id;
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
    
}
