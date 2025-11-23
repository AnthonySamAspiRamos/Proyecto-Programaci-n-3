package proyectoprogra3;

public class Feria {
    private int IdFeria;
    private String nombre, Fecha_Ini, Fecha_Fin, Hora_Ini, Hora_Fin;
    private LDobleSI lsi;
    private LDobleSA lsa;
    private LDobleSR lsr;
    
    public Feria(int id, String nom, String fi,String ff, String hi, String hf, LDobleSI si,LDobleSA sa,LDobleSR sr){
        IdFeria=id;
        nombre=nom;
        Fecha_Ini=fi;
        Fecha_Fin=ff;
        Hora_Ini=hi;
        Hora_Fin=hf;
        lsi=si;
        lsa=sa;
        lsr=sr;
    }
    
    public void mostrar(){
        System.out.println("======== FERIA: ========");
        System.out.println("Nombre: "+nombre+" | Fecha de Inicio: "+Fecha_Ini+" | Fecha Final: "+Fecha_Fin+" | Hora iniciada: "+Hora_Ini+" | Hora Final: "+Hora_Fin);
        System.out.println("-- Lista de Stands Informativos: --");
        lsi.mostrar();
        System.out.println("-- Lista de Stands de Atencion: --");
        lsa.mostrar();
        System.out.println("-- Lista de Stands Recreativos: --");
        lsr.mostrar();
    }

    public int getIdFeria() {
        return IdFeria;
    }

    public void setIdFeria(int IdFeria) {
        this.IdFeria = IdFeria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha_Ini() {
        return Fecha_Ini;
    }

    public void setFecha_Ini(String Fecha_Ini) {
        this.Fecha_Ini = Fecha_Ini;
    }

    public String getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(String Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public String getHora_Ini() {
        return Hora_Ini;
    }

    public void setHora_Ini(String Hora_Ini) {
        this.Hora_Ini = Hora_Ini;
    }

    public String getHora_Fin() {
        return Hora_Fin;
    }

    public void setHora_Fin(String Hora_Fin) {
        this.Hora_Fin = Hora_Fin;
    }

    public LDobleSI getLsi() {
        return lsi;
    }

    public void setLsi(LDobleSI lsi) {
        this.lsi = lsi;
    }

    public LDobleSA getLsa() {
        return lsa;
    }

    public void setLsa(LDobleSA lsa) {
        this.lsa = lsa;
    }

    public LDobleSR getLsr() {
        return lsr;
    }

    public void setLsr(LDobleSR lsr) {
        this.lsr = lsr;
    }
    
    
}
