package proyectoprogra3;

import java.util.Scanner;

public class AppMain {
    public static void main(String[] args){
        Scanner lec=new Scanner(System.in);
        
        //AQUI SE INSTANCIARA EL PROGRAMA MAIN
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
        
        //Pilas de Instrumentos para Medicos
        PilaInsD ind1=new PilaInsD();
        ind1.adicionar(new InstrumentosDoc("estetoscopio", "Escuchar", "Rojo"));
        ind1.adicionar(new InstrumentosDoc("Tensiometro", "Medicion de presion", "de brazo"));
        
        //Lista de Juegos Recreativos
        LDobleJ ju1=new LDobleJ();
        ju1.adicionar("Juego1", "2 minutos", "Algun Juego de estrategia", 4);
        
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
        RP.adicionar(new RefPersonal(8,"Expositor", "Ayudante"));
        RP.adicionar(new RefPersonal(9,"Promotor", "Encargado"));
        RP.adicionar(new RefPersonal(10,"Promotor", "Ayudante"));
        
        //Personal
        // DATOS: Ci, Nombre, Ap_Pat, Ap_Mat, Edad, Sexo [M/F], Contacto (Telefono), Id_Ref Personal
        
        //**Estos son de Prueba**
        //MEDICOS
        Personal pmed1=new Personal(1111111, "Hernesto", "Ticona", "Maita", 35, "M", 77288659, 1);//ese 1 significa que es medico encarfgado
        Personal pmed2=new Personal(2222222, "Maria", "Sosa", "Lonza", 28, "F", 88875691, 2);
        Personal pmed3=new Personal(3333333, "Carlos", "Mamani", "Quispe", 24, "M", 8156871, 3);
        Personal pmed4=new Personal(4444444, "Limbert", "Colque", "Jaime", 22, "M", 15982, 3);
        
        //INFORMADORES
        Personal pinf1=new Personal(5555555, "Maribel", "Jaime", "Chambi", 22, "F", 852159357, 7);
        Personal pinf2=new Personal(6666666, "Ronald", "Alba", "chambi", 22, "M", 951357456, 8);
        Personal pinf3=new Personal(6666666, "Omar", "Garme", "Poma", 21, "M", 258147369, 5);
        
        //PROMOTORES
        Personal prec1=new Personal(8888888, "Linci", "Clarc", "bustamante", 29, "F", 346812, 9);
        Personal prec2=new Personal(9999999, "Gonzalo", "Marquez", "Choque", 21, "M", 256314789, 10);
        Personal prec3=new Personal(1010101, "Pedro", "Jaime", "Chambi", 21, "M", 258147369, 10);
        
        
        //DATOS DE PERSONAL: ID de informador/medico/promotor, Horario, Persona-Personal
        //Listas Simples de Personal de Infomracion
        LSimplePI pi1=new LSimplePI();
        //Datos de personar de informacion: Id_Informador, Horario, Persona Agregado
        pi1.adicionar(1, "mañana", pinf1);
        pi1.adicionar(2, "mañana", pinf2);
        pi1.adicionar(3, "tarde", pinf3);
        pi1.adicionar(4, "tarde", pinf1);
        //Listas Simples de Personal de Atencion
        LSimplePA pm1=new LSimplePA();
        //Datos de personar de informacion: Id_Medico, Horario, Persona Agregado
        pm1.adicionar(1, "mañana", pmed1);
        pm1.adicionar(2, "mañana", pmed2);
        pm1.adicionar(3, "tarde", pmed2);
        pm1.adicionar(4, "mañana", pmed4);
        //Lista Simple de Personal Recreativos        
        LSimplePR pr1=new LSimplePR();
        //Datos de personar de informacion: Id_Promotor, Horario, Persona Agregado
        pr1.adicionar(1, "Mañana", prec1);
        pr1.adicionar(2, "Mañana", prec2);
        pr1.adicionar(3, "tarde", prec2);
        
        /*
        * DATOS DE FERIAS
        */
        //STANDS de la Feria posicion multicola 1, Feria 1
        //Listas Dobles de Stands de Infomracion
        LDobleSI si1=new LDobleSI();
        //Listas Dobles de Stands de Atencion
        LDobleSA sa1=new LDobleSA();
        //Listas Dobles de Stands Recreativos
        LDobleSR sr1=new LDobleSR();
        //Datos del stand de informacion: 
        // NroPuesto, IdFeria, Id_Componentes, ListaSimple de Personal de informacion;
        si1.adicionar(1, 1, 1, pi1);
        // NroPuesto, IdFeria, Id_Medicamentos Disponibles,Pila de Instrumentos, Lista Simple de Personal de informacion;
        sa1.adicionar(2, 1, 1, ind1, pm1);
        // NroPuesto, IdFeria, Id_Componentes,ListaDoble de Juegos, LSimplePI Personal de Promotores;
        sr1.adicionar(3, 1, 1, ju1, pr1);
        
        
        
        
        /*
        * FERIA INSTANCIADA
        */
        //MultiCola de ferias
        MultiColaF Ferias=new MultiColaF();
        //Datos de las ferias de la multicola: ID_feria, Nombre, Feecha Inicio, Fecha final, Hora que iniciaba, Hora que terminaba, Ubicacion, Lista de Stands de informacion. Lista de Stansd de Atencion, Lista de Stands Recreativos
        Ferias.setNc(1);
        Ferias.adicionar(1, new Feria(1, "Feria de Salud 1", "24/01/2025", "2/02/2025", "10:00", "16:00", "Monobloc", si1, sa1, sr1));
        //Ferias.adicionar(1, new Feria(2, "Feria de Salud 2", "01/02/2025", "15/02/2025", "12:00", "18:00", "El Alto", null, null, null));
        Ferias.mostrar(1);
        
        
        
        
        
        
        
        
        
        /*
        * EJEMPLOS DE PROBLEMAS DE EJERCICIOS
        */
        //AgregarMedicamentos(MedDispo, MedSumi);
        //MedDispo.mostrar();
        //System.out.println(" ");
        //MedSumi.mostrar();
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
