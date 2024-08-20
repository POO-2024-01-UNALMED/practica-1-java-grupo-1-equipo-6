package BaseDatos;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

public class Deserializador {

	private static Serializable deserializarObjeto(String nombreArchivo) {
        Serializable objeto = null;
        try (FileInputStream fileIn = new FileInputStream(nombreArchivo);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {

            objeto = (Serializable) in.readObject();
            

        } catch (IOException | ClassNotFoundException e) {
        	Interfaz.error();
        }
        return objeto;
    }

    public static ArrayList<Cine> deserializarCines() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Cine.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Cine) {
                return (ArrayList<Cine>) lista;
            }
        }
        
        return new ArrayList<>();
    }

    public static ArrayList<Cliente> deserializarClientes() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Cliente.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Cliente) {
                return (ArrayList<Cliente>) lista;
            }
        }
       
        return new ArrayList<>();
    }

    public static ArrayList<Pelicula> deserializarPeliculas() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Pelicula.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Pelicula) {
                return (ArrayList<Pelicula>) lista;
            }
        }
        
        return new ArrayList<>();
    }

    public static ArrayList<Funcion> deserializarFunciones() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Funcion.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Funcion) {
                return (ArrayList<Funcion>) lista;
            }
        }
       
        return new ArrayList<>();
    }

    public static ArrayList<Maquina> deserializarMaquinas() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Maquina.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Maquina) {
                return (ArrayList<Maquina>) lista;
            }
        }
        
        return new ArrayList<>();
    }

    public static ArrayList<Sala> deserializarSalas() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Sala.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof Sala) {
                return (ArrayList<Sala>) lista;
            }
        }
        
        return new ArrayList<>();
    }

    public static ArrayList<ZonaDeJuegos> deserializarZonasDeJuegos() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/ZonaDeJuegos.txt");
        if (objeto instanceof ArrayList<?>) {
            ArrayList<?> lista = (ArrayList<?>) objeto;
            if (!lista.isEmpty() && lista.get(0) instanceof ZonaDeJuegos) {
                return (ArrayList<ZonaDeJuegos>) lista;
            }
        }
       
        return new ArrayList<>();
    }

    public static Bodega deserializarBodega() {
        Serializable objeto = deserializarObjeto("sr/BaseDatos/temp/Bodega.txt");
        if (objeto instanceof Bodega) {
            return (Bodega) objeto;
        }
        
        return new Bodega("bodega",123);  // Devuelve una nueva instancia por defecto si es necesario
    }
}

