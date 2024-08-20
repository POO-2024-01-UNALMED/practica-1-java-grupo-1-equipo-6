package BaseDatos;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import gestorAplicacion.Bodega;
import gestorAplicacion.Cine;
import gestorAplicacion.Cliente;
import gestorAplicacion.Funcion;
import gestorAplicacion.Maquina;
import gestorAplicacion.Pelicula;
import gestorAplicacion.Sala;
import gestorAplicacion.ZonaDeJuegos;
import uiMain.Interfaz;

public class Serializador {

// Método para serializar un objeto sin borrar el archivo existente
	    public static void serializarObjeto(Serializable objeto, String nombreArchivo) {
	        // Guardar el objeto en el archivo existente sin eliminarlo
	        try (FileOutputStream fileOut = new FileOutputStream(nombreArchivo);
	             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {

	            out.writeObject(objeto);

	        } catch (IOException e) {
	            Interfaz.error();  // Maneja el error según tu implementación
	        }
	    }
	

    // Métodos específicos para serializar listas completas de cada tipo de objeto
    public static void serializarCine(ArrayList<Cine> cines) {
        serializarObjeto(cines, "sr/BaseDatos/temp/Cine.txt");
    }

    public static void serializarCliente(ArrayList<Cliente> clientes) {
        serializarObjeto(clientes, "sr/BaseDatos/temp/Cliente.txt");
    }

    public static void serializarPelicula(ArrayList<Pelicula> peliculas) {
        serializarObjeto(peliculas, "sr/BaseDatos/temp/Pelicula.txt");
    }

    public static void serializarFuncion(ArrayList<Funcion> funciones) {
        serializarObjeto(funciones, "sr/BaseDatos/temp/Funcion.txt");
    }

    public static void serializarMaquina(ArrayList<Maquina> maquinas) {
        serializarObjeto(maquinas, "sr/BaseDatos/temp/Maquina.txt");
    }

    public static void serializarSala(ArrayList<Sala> salas) {
        serializarObjeto(salas, "sr/BaseDatos/temp/Sala.txt");
    }

    public static void serializarZonaDeJuegos(ArrayList<ZonaDeJuegos> zonasDeJuegos) {
        serializarObjeto(zonasDeJuegos, "sr/BaseDatos/temp/ZonaDeJuegos.txt");
    }

    public static void serializarBodega(ArrayList<Bodega> bodegas) {
        serializarObjeto(bodegas, "sr/BaseDatos/temp/Bodega.txt");
    }
}