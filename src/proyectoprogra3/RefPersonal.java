package proyectoprogra3;

public class RefPersonal {
    private int Id_RPersonal;
    private String tipo, categoria;

    public RefPersonal(int Id_RPersonal, String tipo, String categoria) {
        this.Id_RPersonal = Id_RPersonal;
        this.tipo = tipo;
        this.categoria = categoria;
    }
    public void mostrar(){
        System.out.println("Id Referencia Personal: "+Id_RPersonal+" | Tipo: "+tipo+" | Categoria: "+categoria);
    }

    public int getId_RPersonal() {
        return Id_RPersonal;
    }

    public void setId_RPersonal(int Id_RPersonal) {
        this.Id_RPersonal = Id_RPersonal;
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
    
    
   
}
