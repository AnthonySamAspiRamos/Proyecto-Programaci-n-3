package proyectoprogra3;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args){
        Scanner lec=new Scanner(System.in);
        //AQUI SE INSTANCIARA EL PROGRAMA MAIN
        
        /*
        * PERSONAL DE LOS STANDS
        */
        //COLA SIMPLE DE REFERENCIA DE PERSONAL
        CSimpleRP RP=new CSimpleRP();
        RP.adicionar(new RefPersonal(1,"Medico", "Encargado"));
        RP.adicionar(new RefPersonal(2,"Medico", "Empleado"));
        RP.adicionar(new RefPersonal(3,"Medico", "Ayudante"));
        RP.adicionar(new RefPersonal(4,"Paramedico", "Encargado"));
        RP.adicionar(new RefPersonal(5,"Paramedico", "Empleado"));
        RP.adicionar(new RefPersonal(6,"Paramedico", "Ayudante"));
        RP.adicionar(new RefPersonal(7,"Expositor", "Encargado"));
        RP.adicionar(new RefPersonal(8,"Promotor", "Encargado"));
        RP.adicionar(new RefPersonal(9,"Promotor", "Ayudante"));
        
        /*
        * LOGISTICA DE MEDICAMENTOS
        */
        //Cola Simple de Medicamentos Disponibles
        //NOTA: ademas de ver cuanto hay disponible en toda la feria, este tambien es como indice para la multipila
        CSimpleMD MedDispo=new CSimpleMD();
        MedDispo.adicionar(new MedicamentosDispo(1, "Analgesicos", 150));
        MedDispo.adicionar(new MedicamentosDispo(2, "Antibioticos", 180));
        MedDispo.adicionar(new MedicamentosDispo(3, "AntiInflamatorios", 150));
        //Multipila de Medicamentos Suministrados
        MultipilaMS MedSumi=new MultipilaMS();
        MedSumi.setNP(3);//Este numero cambiara si aumenta mas tipos de medicamentos haya
        //Analgesicos
        MedSumi.adicionar(1, new MedicamentosSumi("Paracetamol", 50, "tabletas"));
        MedSumi.adicionar(1, new MedicamentosSumi("Ibuprofeno", 20, "tabletas"));
        MedSumi.adicionar(1, new MedicamentosSumi("Aspirinas", 50, "tabletas"));
        MedSumi.adicionar(1, new MedicamentosSumi("Naxopresol", 30, "tabletas"));
        //Antibioticos
        MedSumi.adicionar(2, new MedicamentosSumi("Penicilina", 80, "Capsula"));
        MedSumi.adicionar(2, new MedicamentosSumi("Quinolona", 50, "Tabletas"));
        MedSumi.adicionar(2, new MedicamentosSumi("Macrolido", 50, "frascos"));
        //Antiinflamatorios
        MedSumi.adicionar(3, new MedicamentosSumi("Oxaprozina", 30, "tabletas"));
        MedSumi.adicionar(3, new MedicamentosSumi("Tolmetina", 70, "capsulas"));
        MedSumi.adicionar(3, new MedicamentosSumi("Flurbiprofeno", 50, "frascos"));
        
        /*
        * LOGISTICA DE LOS COMPONENTES OTORGADOS A LOS STANDS
        */
        //Listas de componentes
        //Lista de Prueba de un Stand de Informacion
        LSimpleC Comp1=new LSimpleC();
        Comp1.adiFinal("Proyector", "Presentacion", "negro, 3 horas de uso");
        Comp1.adiFinal("Patalla de proyeccion", "Presentacion", "con tripode");
        Comp1.adiFinal("Bascula", "Medicion de Peso", "Ninguna");
        Comp1.adiFinal("Tensiometro", "Medir Presion", "de muñeca");
        Comp1.adiFinal("Tensiometro", "Medir Presion", "de Brazo");
        Comp1.adiFinal("estadiómetro", "Medir altura", "Ninguna");
        //Cola de Componentes Suministrados
        CSimpleC Comp=new CSimpleC();
        Comp.adicionar(new Componente(1, Comp1));
        //AUN NO ESTAN LOS STANDS Y NOS E SABE CUANTOS NROS DE PUESTOS ESTARAN ASI QUE POR AHORA ESTO ESTA DE PRUEBA
        
        /*
        * EJEMPLOS DE PROBLEMAS DE EJERCICIOS
        */
        AgregarMedicamentos(MedDispo, MedSumi);
        MedDispo.mostrar();
        System.out.println(" ");
        MedSumi.mostrar();
    }    
    // EJERCICIOS
    /*
    * SUMINISTRAR MAS MEDICAMENTOS A NUESTRA MULTIPILA DE MEDICAMENTOS
    */
    public static void AgregarMedicamentos(CSimpleMD a, MultipilaMS b){
        System.out.println("AGREGANDO NUEVO PAQUETE DE MEDICAMENTOS");
        Scanner lec=new Scanner(System.in);
        System.out.println("Elija entre estas opciones");
        //Lista de opciones
        int c=0;
        CSimpleMD aux=new CSimpleMD();
        while(!a.esvacia()){
            c++;
            MedicamentosDispo elem=a.eliminar();
            System.out.println(c+". "+elem.getTipo());
            aux.adicionar(elem);
        }
        System.out.println(c+1+". Salir");
        a.vaciar(aux);
        System.out.print("Ponga un numero entre [1-"+c+"] => ");int n=lec.nextInt();
        if(n==c+1 || n>c+1){
            System.out.println("Volviendo atras.");
            return;
        }else{
            String nom;
            int cant;
            System.out.print("Int. Nombre del medicamento => ");nom=lec.next();
            if(VeriMedExiste(nom,n,b)){
                System.out.println("El Medicamento ya existe solo aumentaremos su stock");
                System.out.print("Int. Cantidad a agregar => ");cant=lec.nextInt();
                PilaMS aux2=new PilaMS();
                while(!b.esvacia(n)){
                    MedicamentosSumi elem2=b.eliminar(n);
                    if(elem2.getNombre().equals(nom)){
                        MedicamentosSumi nue=new MedicamentosSumi(elem2.getNombre(), elem2.getCapacidad()+cant, elem2.getTipo());
                        aux2.adicionar(nue);
                    }else
                        aux2.adicionar(elem2);                
                }
                b.vaciar(n, aux2);
            }else{
                String tip;
                System.out.println("El Medicamento no existe en esta seccion, se agregara uno nuevo");
                System.out.print("Int. Cantidad a agregar => ");cant=lec.nextInt();
                System.out.print("Int. Tipo de Embase => "); tip=lec.next();
                MedicamentosSumi nue=new MedicamentosSumi(nom, cant, tip);
                b.adicionar(n, nue);
            }
            //Modificando El stock en Cola de Medicamentos Disponibles
            c=0;
            while(!a.esvacia()){
                c++;
                MedicamentosDispo elem=a.eliminar();
                if(c==n){
                    elem.setStock(elem.getStock()+cant);
                }
                aux.adicionar(elem);
            }
            a.vaciar(aux);
        }     
            
            
    }
    private static boolean VeriMedExiste(String nom, int n, MultipilaMS b) {
        boolean v=false;
        PilaMS aux=new PilaMS();
        while(!b.esvacia(n)){
            MedicamentosSumi elem=b.eliminar(n);
            if(elem.getNombre().equals(nom)){
                v=true;
            }
            aux.adicionar(elem);
        }
        b.vaciar(n, aux);
        return v;
    }
    //Fin de la suministracion
    
}
