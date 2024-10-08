package gestorAplicacion;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import BaseDatos.Deserializador;
import BaseDatos.Serializador;
import uiMain.Interfaz;

public class Sala implements Serializable{
	
	private static final long serialVersionUID = 8L;
	
	private int numero;
	private boolean[][] sillas;
	private Cine cine;
	private int capacidad;
	public static ArrayList<Sala> allSalas=new ArrayList<>();;
	public Sala(int numero,int filas, int columnas) {
        this.numero=numero;
        this.capacidad=filas*columnas;
				this.sillas = new boolean[filas][columnas];
				for (int i = 0; i<filas;i++){
					for (int j = 0; j<columnas;j++){
						sillas[i][j] = true;
					}
				}
				if (!allSalas.contains(this)) {
				    allSalas.add(this);
				}
    }
	
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cine getCine(){return cine;}

	public void setCine(Cine c){
		cine = c;
	}

	public boolean[][] getSillas() {
		return sillas;
	}
	public void setSillas(boolean[][] sillas) {
		this.sillas = sillas;
	}

	public boolean hayAsientosLibres(){
		for (int i = 0; i<sillas.length ; i++){
			for (int j = 0; j<sillas[0].length; j++){
				if(sillas[i][j]){
					return true;
				}
			}
		}
		return false;
	}

	public String estadoSilleteria(){
		String sala = "";
		String columnas = "    ";
		for (int y = 0; y<sillas[0].length;y++){
			columnas += String.valueOf(y+1);
			if(y != sillas[0].length -1){
				columnas += "   ";
			} else{
				columnas += "\n";
			}
		}
		for(int j=0; j<sillas.length;j++){
			sala += String.valueOf(j + 1) + "  ";
			for(int i=0;i<sillas[0].length;i++){
				if(sillas[j][i]){
					sala+= "[ ]";
				}else{
					sala += "[*]";
				}
				if(i != sillas[0].length-1){
					sala += " ";
				}else{
					sala += "\n";
				}
			}
		}
		return columnas + sala;
	}
	
	
	
	public boolean reservarSilla(int fila, int columna) {
	   
	    if (fila >= 0 && fila < sillas.length && columna >= 0 && columna < sillas[fila].length) {
	       if (sillas[fila][columna]) {
	            sillas[fila][columna] = false;
	            return true; 
	        } else {
	            return false; 
	        }
	    } else {
	        return false; 
	    }
	}
	
	public boolean estaDisponible(int fila, int columna) {
	    
		if (fila >= 0 && fila < sillas.length && columna >= 0 && columna < sillas[fila].length) {
			return sillas[fila][columna];
	    } else {
	        return false; 
	    }
	}
	
	public String toString() {
        return "Sala: " + numero + ", Capacidad: " + capacidad  ;
    }
	
	public static void cargarSalas() {
        // Utiliza el Deserializador para cargar la lista de cines desde el archivo
        ArrayList<Sala> listaSalas = Deserializador.deserializarSalas();

        if (listaSalas != null) {
            // Reemplaza la lista estática de cines con la lista deserializada
            allSalas = listaSalas;
            
        } else {
        	Interfaz.error();
        }
    }

    public static void guardarSalas() {
        Serializador.serializarSala(allSalas);
    }
	

}

