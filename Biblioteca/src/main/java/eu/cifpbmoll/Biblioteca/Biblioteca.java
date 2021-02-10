package eu.cifpbmoll.Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
*
* @author Roberto
*/
public class Biblioteca {
	public static Scanner lector=new Scanner(System.in);
	private String nombreBiblioteca;
	private ArrayList <Libro> listaLibros=new ArrayList <Libro>();; 
	private ArrayList <Persona> listaPersonas=new ArrayList <Persona>();

	//Constructores
	
		//Constructor vacio
	public Biblioteca(){
		
	}
		//Constructor completo
	public Biblioteca(String nombreBiblioteca) {
		this.setnombreBiblioteca(nombreBiblioteca);
		this.listaLibros = new ArrayList<Libro>();
		this.listaPersonas = new ArrayList<Persona>();
	}
		//Constructor copia
	public Biblioteca(Biblioteca Biblioteca){
        this.setnombreBiblioteca(Biblioteca.getnombreBiblioteca());
        this.setlistaPersonas(Biblioteca.getlistaPersonas());
        }
	
	//Setters and Getters
	public String getnombreBiblioteca() {
		return nombreBiblioteca;
	}

	public void setnombreBiblioteca(String nombreBiblioteca) {
		while((Character.getType(nombreBiblioteca.charAt(0)))!=1){
			System.out.println("La biblioteca debe empezar por mayúscula.");
			System.out.println("Escribelo bien.");
			nombreBiblioteca= lector.nextLine();
		}
		this.nombreBiblioteca = nombreBiblioteca;
	}
	public ArrayList<Persona> getlistaPersonas() {
		return listaPersonas;
	}
	public void setlistaPersonas(ArrayList<Persona> listaPersonas) {
		this.listaPersonas = listaPersonas;
	}
	
	public ArrayList<Libro> getlistaLibros() {
		return listaLibros;
	}
	public void setlistaLibros(ArrayList<Libro> listaLibros) {
		this.listaLibros = listaLibros;
	}
	//ToString
	@Override
	public String toString() {
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", listaLibros=" + listaLibros +", listaPersonas=" + listaPersonas + '}';
    }
	//Metodos
	/*public  void mostrarLibros(){
		for (int i=0;i<listaLibros.size();i++){
            System.out.println(listaLibros.get(i).toString());
        }
    }*/
	public  void mostrarLibros(){
		Iterator<Libro> libro = listaLibros.iterator();
		while (libro.hasNext())
			System.out.println(libro.next());
    }
	
	public void mostrarLibrosDisponibles(){
		for (int i=0;i<listaLibros.size();i++){
            if (listaLibros.get(i).getNumeroCopiasDisponibles()>0){
                System.out.println(listaLibros.get(i).toString());
            }
        }
	}
}
