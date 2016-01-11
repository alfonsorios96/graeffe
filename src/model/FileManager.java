package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class FileManager {
	private File archivo = null;
	private FileReader fr = null;
	private BufferedReader br = null;
	private FileWriter fichero = null;
	private PrintWriter pw = null;
    
    public ArrayList<String> read (String path){
    	ArrayList<String> lectura = new ArrayList<String>();
    	try {

            archivo = new File (path);
            fr = new FileReader (archivo);
            br = new BufferedReader(fr);
    
            String row;
            while((row = br.readLine()) != null)
            	lectura.add(row);
            br.close();
         }
         catch(Exception e){
            e.printStackTrace();
         }finally{

            try{                    
               if( null != fr ){   
                  fr.close();     
               }                  
            }catch (Exception e2){ 
               e2.printStackTrace();
            }
         }
    	
    	return lectura;
    }
    
    public void write (String path, String row){
    	try
        {
            fichero = new FileWriter(path);
            pw = new PrintWriter(fichero); 
            pw.println(row);
            fichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
	        
        	try {
	            if (null != fichero)
	               fichero.close();
	            } catch (Exception e2) {
	               e2.printStackTrace();
	            }
	         }
    }

	public void delete (String path){
		try {
            archivo = new File (path);
            archivo.delete();
         }
         catch(Exception e){
            e.printStackTrace();
         }
	}
    
    private File getArchivo() {
		return archivo;
	}

	private void setArchivo(File archivo) {
		this.archivo = archivo;
	}

	private FileReader getFr() {
		return fr;
	}

	private void setFr(FileReader fr) {
		this.fr = fr;
	}

	private BufferedReader getBr() {
		return br;
	}

	private void setBr(BufferedReader br) {
		this.br = br;
	}

	private FileWriter getFichero() {
		return fichero;
	}

	private void setFichero(FileWriter fichero) {
		this.fichero = fichero;
	}

	private PrintWriter getPw() {
		return pw;
	}

	private void setPw(PrintWriter pw) {
		this.pw = pw;
	}
}