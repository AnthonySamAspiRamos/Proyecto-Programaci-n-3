package proyectoprogra3;

public class ProyectoProgra3 {
    /*
    * ESTO ES SOLO PARA PRUEBASEL ORIGINAL ES EL APPMAIN
    */

    public static void main(String[] args) {
        LSimplePI a=new LSimplePI();
        a.adicionar(1, "Mañana", new Personal(1, "nom1", "pat1", "mat1", 15, "F", 77777, 1));
        a.adicionar(2, "Mañana", new Personal(1, "nom1", "pat1", "mat1", 15, "F", 77777, 1));
        a.adicionar(3, "Tarde", new Personal(3, "nom3", "pat3", "mat3", 15, "F", 77777, 3));
        
        LSimplePI a1=new LSimplePI();
        a1.adicionar(1, "Mañana", new Personal(4, "nom11", "pat11", "mat11", 15, "F", 77777, 1));
        a1.adicionar(2, "Mañana", new Personal(5, "nom21", "pat21", "mat21", 16, "M", 77777, 1));
        a1.adicionar(3, "Tarde", new Personal(6, "nom31", "pat31", "mat31", 17, "F", 77777, 3));
        
        LDobleSI A=new LDobleSI();
        A.adicionar(1, 5, 3, a);
        A.adicionar(2, 5, 4, a1);
        
        A.mostrar();
        
    }
    
}
