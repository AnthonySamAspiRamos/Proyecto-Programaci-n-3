
package proyectoprogra3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchFeria {
    private String nom_arch;
	
    public ArchFeria() {
	nom_arch = "";
    }
	
    public ArchFeria(String nom_arch) {
	this.nom_arch = nom_arch;
    }
	
    public void crear() throws FileNotFoundException, IOException {
	ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nom_arch));
	arch.close();
	System.out.println("Archivo creado con nombre " + nom_arch);
    }
	
    public void adicionarFerias(int id, Feria x) throws FileNotFoundException, IOException {
	String arch_aux = "Ferias_aux.dat";
		
	// donde voy a guardar los nuevos datos
	ObjectOutputStream arch_temp = new ObjectOutputStream(new FileOutputStream(arch_aux));
	// de donde voy a obtener los datos
	ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom_arch));
		
	try {
		MultiColaF es = new MultiColaF();
		while(true) {
			es = (MultiColaF) arch.readObject();
			arch_temp.writeObject(es);
		}
	}catch(Exception e){
			
	}finally {
		MultiColaF es1 = new MultiColaF();
                es1.setNc(id);
		es1.adicionar(id, x);
                
		arch_temp.writeObject(es1);
		
		arch_temp.close();
		arch.close();
			
		File ARCH = new File(nom_arch);
		File ARCH_TEMP = new File(arch_aux);
			
		ARCH.delete();
		ARCH_TEMP.renameTo(ARCH);
			
	}
	
    }
    
		
    public void listar() throws FileNotFoundException, IOException {
        System.out.println("entrando al metodo de listar");
	ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom_arch));
		
	try {
                System.out.println("intentando listar");
		MultiColaF es = new MultiColaF();
		while(true) {
                    System.out.println("Esta entrando a la primera Multicola");
                    es = (MultiColaF) arch.readObject();
                    es.mostrar();
                    System.out.println(" ");
		}
			
	} catch (Exception e) {
		          System.out.println(e);
	}finally{
		arch.close();
	}
    }

    
}
