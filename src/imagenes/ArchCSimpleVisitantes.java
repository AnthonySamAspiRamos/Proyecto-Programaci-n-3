package proyectoprogra3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ArchCSimpleVisitantes {
    private String nom_arch;
	
    public ArchCSimpleVisitantes() {
	nom_arch = "";
    }
	
    public ArchCSimpleVisitantes(String nom_arch) {
	this.nom_arch = nom_arch;
    }
	
    public void crear() throws FileNotFoundException, IOException {
	ObjectOutputStream arch = new ObjectOutputStream(new FileOutputStream(nom_arch));
	arch.close();
	System.out.println("Archivo creado con nombre " + nom_arch);
    }
	
    public void adicionarColaExistente(CSimpleV x) throws FileNotFoundException, IOException {
	String arch_aux = "CSimpleV_aux.dat";
		
	// donde voy a guardar los nuevos datos
	ObjectOutputStream arch_temp = new ObjectOutputStream(new FileOutputStream(arch_aux));
	// de donde voy a obtener los datos
	ObjectInputStream arch = new ObjectInputStream(new FileInputStream(nom_arch));
		
	try {
		CSimpleV es = new CSimpleV();
		while(true) {
			es = (CSimpleV) arch.readObject();
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
		CSimpleV es = new CSimpleV();
		while(true) {
                    es = (CSimpleV) arch.readObject();
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

