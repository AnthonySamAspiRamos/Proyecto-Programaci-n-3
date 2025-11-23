package proyectoprogra3;

import java.util.Scanner;

public class Persona {
    private int ci, edad, contacto;
    private String nombre, paterno, materno, sexo;
    private Scanner lec=new Scanner(System.in);
    
    
    public Persona(int c, String nom, String pat,String mat, int ed, String sx, int cont){
        ci=c;
        nombre=nom;
        paterno=pat;
        materno=mat;
        edad=ed;
        sexo=sx;
        contacto=cont;
    }
    public void leer(){
        System.out.print("Int. Ci(Prymari Key) => ");ci=lec.nextInt();
        System.out.print("Int. nombre => ");nombre=lec.next();
        System.out.print("Int. Ap. Pat => ");paterno=lec.next();
        System.out.print("Int. Ap. Mat => ");materno=lec.next();
        System.out.print("Int. Edad => ");edad=lec.nextInt();
        System.out.print("Int. Sexo => ");sexo=lec.next();
        System.out.print("Int. Contacto => ");contacto=lec.nextInt();
        System.out.println("Datos agregados correctamente");
    }
    public void mostrar(){
        System.out.println("Ci: "+ci+" | Nombre: "+nombre+" | Ap. Pat: "+paterno+" | Ap. Mat: "+materno+" | Edad: "+edad+" | Sexo: "+sexo+" | Contacto: "+contacto);
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getMaterno() {
        return materno;
    }

    public void setMaterno(String materno) {
        this.materno = materno;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getContacto() {
        return contacto;
    }

    public void setContacto(int contacto) {
        this.contacto = contacto;
    }
    
    
}
