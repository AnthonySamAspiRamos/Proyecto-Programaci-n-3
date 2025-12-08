package proyectoprogra3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchLDobleFI {
    private String nom_arch;
	
    public ArchLDobleFI() {
	nom_arch = "";
    }
	
    public ArchLDobleFI(String nom_arch) {
	this.nom_arch = nom_arch;
    }
	
    public void crear() throws FileNotFoundException, IOException {
	ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nom_arch));
	arch.close();
	System.out.println("Archivo creado con nombre " + nom_arch);
    }
	
    public void adicionarListaExistente(LDobleFI x) throws FileNotFoundException, IOException {
	String arch_aux = "LDobleDI_aux.dat";
		
	// donde voy a guardar los nuevos datos
	ObjectOutputStream arch_temp = new ObjectOutputStream(new FileOutputStream(arch_aux));
	// de donde voy a obtener los datos
	ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom_arch));
		
	try {
		LDobleFI es = new LDobleFI();
		while(true) {
			es = (LDobleFI) arch.readObject();
                        //aqui camviar los datos de la cola actual para que se guarde la nueva cola con los neuvos datos
			arch_temp.writeObject(es);
		}
	}catch(Exception e){
			
	}finally {     
                //coloca la nueva cola si es que hay una cola por colocar
		arch_temp.writeObject(x);
		
		arch_temp.close();
		arch.close();
                
		File ARCH = new File(nom_arch);
		File ARCH_TEMP = new File(arch_aux);
			
		ARCH.delete();
		ARCH_TEMP.renameTo(ARCH);
			
	}
	
    }
    
		
    public void listar() throws FileNotFoundException, IOException {
	ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom_arch));
		
	try {
		LDobleFI es = new LDobleFI();
		while(true) {
                    es = (LDobleFI) arch.readObject();
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
