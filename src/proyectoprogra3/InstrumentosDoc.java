package proyectoprogra3;

public class InstrumentosDoc {
    private int Id_instrumento,Grupo_instrumentos,Nropuesto;
    private String nombre, tipo, observacion;

    public InstrumentosDoc(int Id_instrumento, int Grupo_instrumentos, int Nropuesto, String nombre, String tipo, String observacion) {
        this.Id_instrumento = Id_instrumento;
        this.Grupo_instrumentos = Grupo_instrumentos;
        this.Nropuesto = Nropuesto;
        this.nombre = nombre;
        this.tipo = tipo;
        this.observacion = observacion;
    }

    
    public void mostrar(){
        System.out.println("Instrumento: ID intrumento"+Id_instrumento+" | idGrupo instrumento"+Grupo_instrumentos+" | NroPuesto: "+Nropuesto+" | Nombre: "+nombre+" | Tipo: "+tipo+" | observaciones: "+observacion);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public int getId_instrumento() {
        return Id_instrumento;
    }

    public void setId_instrumento(int Id_instrumento) {
        this.Id_instrumento = Id_instrumento;
    }

    public int getGrupo_instrumentos() {
        return Grupo_instrumentos;
    }

    public void setGrupo_instrumentos(int Grupo_instrumentos) {
        this.Grupo_instrumentos = Grupo_instrumentos;
    }

    public int getNropuesto() {
        return Nropuesto;
    }

    public void setNropuesto(int Nropuesto) {
        this.Nropuesto = Nropuesto;
    }
    
    
    
    @Override
    public String toString() {
        return  getId_instrumento()+";"+getGrupo_instrumentos()+";"+getNropuesto()+";"+getNombre()+";"+getTipo()+";"+getObservacion();
    }
    public static InstrumentosDoc fromString(String linea) {
        try {
        String[] p = linea.split(";");

        if (p.length != 10) return null; // Línea inválida → ignorar

        return new InstrumentosDoc(
                Integer.parseInt(p[0]),  
                Integer.parseInt(p[1]),                    
                Integer.parseInt(p[2]),                    
                p[3],  
                p[4],   
                p[5]
        );

        } catch (Exception e) {
            System.out.println("Error leyendo línea: " + linea);
            return null;
        }
    }
    
}
