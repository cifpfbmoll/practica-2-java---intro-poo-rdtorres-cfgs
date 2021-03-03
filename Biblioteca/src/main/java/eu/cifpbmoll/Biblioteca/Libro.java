package eu.cifpbmoll.Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Iterator;
/**
*
* @author Roberto
*/

public class Libro {
    public static Scanner lectorLibro=new Scanner(System.in);
    //ISBN, título, autor, editorial, nº de copias y nº copias disponibles.
	public static int titulosDistintos;
    private int ISBN;
    private String titulo;
    private String autor;
    private String editorial;
    private int NumeroCopiasTotales;
    private int NumeroCopiasDisponibles;
	
    //Constructores
    public Libro() {
	}
    
    public Libro(int ISBN, String titulo, String autor, String editorial, int NumeroCopiasTotales, int NumeroCopiasDisponibles) {
    	titulosDistintos++;
    	this.ISBN=ISBN;
        this.titulo=titulo;
        this.autor=autor;
        this.editorial=editorial;
        this.NumeroCopiasTotales=NumeroCopiasTotales;
        this.NumeroCopiasDisponibles=NumeroCopiasDisponibles;
    }
  
    public Libro (Libro l1) {
    	titulosDistintos++;
		this.setISBN(l1.getISBN());
		this.settitulo(l1.gettitulo());
		this.setautor(l1.getautor());
        this.seteditorial(l1.geteditorial());
		this.setNumeroCopiasTotales(l1.getNumeroCopiasTotales());
		this.setNumeroCopiasDisponibles(l1.getNumeroCopiasDisponibles());
		}

    //Setters and Getters
	public int getISBN() {
		return ISBN;
	}

	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	public String gettitulo() {
		return titulo;
	}

	public void settitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getautor() {
		return autor;
	}

	public void setautor(String autor) {
		this.autor = autor;
	}

	public String geteditorial() {
		return editorial;
	}

	public void seteditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumeroCopiasTotales() {
		return NumeroCopiasTotales;
	}

	public void setNumeroCopiasTotales(int NumeroCopiasTotales) {
		this.NumeroCopiasTotales = NumeroCopiasTotales;
	}

	public int getNumeroCopiasDisponibles() {
		return NumeroCopiasDisponibles;
	}

	public void setNumeroCopiasDisponibles(int NumeroCopiasDisponibles) {
		this.NumeroCopiasDisponibles = NumeroCopiasDisponibles;
	}
	
    //To String
	@Override
	public String toString() {
        return "Libro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", editorial=" + editorial + ", NumeroCopiasTotales=" + NumeroCopiasTotales + ", NumeroCopiasDisponibles=" + NumeroCopiasDisponibles + '}';
    }
	
    //Metodos
	public static void añadirLibro(ArrayList <Libro> listaLibros) {	
		Libro Libro1 =new Libro();

        System.out.println("Dime el ISBN");
        Libro1.setISBN(lectorLibro.nextInt());
        lectorLibro.nextLine();
        
        System.out.println("Dime el Título");
        Libro1.settitulo(lectorLibro.nextLine());
		
        System.out.println("Dime el autor");
        Libro1.setautor(lectorLibro.nextLine());
		
        System.out.println("Dime la editorial");
        Libro1.seteditorial(lectorLibro.nextLine());
		
        System.out.println("Dime la cantidad de copias");
        //Libro1.setNumeroCopiasTotales(lectorLibro.nextInt());
		int CopiasMinimas = lectorLibro.nextInt();
        lectorLibro.nextLine();
        while(CopiasMinimas < 1){
            System.out.println("Debe haber mínimo 1 copia");
            CopiasMinimas = lectorLibro.nextInt();
            lectorLibro.nextLine();
        }
		Libro1.NumeroCopiasTotales= CopiasMinimas;
		
		
		System.out.println("Dime el número de copias disponibles que tiene este libro");
		CopiasMinimas = lectorLibro.nextInt();
        lectorLibro.nextLine();
        while(CopiasMinimas > Libro1.NumeroCopiasTotales){
            System.out.println("No puede haber más copias disponibles que copias totales");
            CopiasMinimas = lectorLibro.nextInt();
            lectorLibro.nextLine();
        }
        Libro1.NumeroCopiasDisponibles = CopiasMinimas;
		
		listaLibros.add(Libro1);
	}
	
	public static void eliminarLibro(ArrayList <Libro> listaLibros){
		System.out.println("¿Cual es el ISBN del libro que deseas eliminar?");
		int ISBN =lectorLibro.nextInt();
		lectorLibro.nextLine();
		
		int i= 0;
		boolean encontrado = false;
		while(i <listaLibros.size()) {;
			if(listaLibros.get(i).getISBN()== ISBN) {
				encontrado = true;
				listaLibros.remove(i);
				System.out.println("El libro ha sido eliminado");
			}
		}
		if(encontrado == false) {
			System.out.println("El libro no ha sido encontrado");
		}
	}

	public static void buscarISBN(ArrayList <Libro> listaLibros){
		System.out.println("¿Cual es el ISBN del libro que deseas buscar?");
		int ISBN =lectorLibro.nextInt();
		lectorLibro.nextLine();
		int i= 0;
		boolean encontrado = false;
		while(i <listaLibros.size()) {;
			if(listaLibros.get(i).getISBN()== ISBN) {
				encontrado = true;
				System.out.println(listaLibros.get(i).getISBN());
				System.out.println("El libro ha sido encontrado");
			}
			i++;
		}
		if(encontrado == false) {
			System.out.println("-1");
		}
	}
	
	public static void buscarTitulo(ArrayList <Libro> listaLibros){
		boolean encontrado= false;
		System.out.println("Dime el título del libro que deseas buscar");
		String titulo = lectorLibro.nextLine();
		for (int i=0;i<listaLibros.size();i++){
			if (listaLibros.get(i).gettitulo().contains(titulo)){
				System.out.println(listaLibros.get(i).toString());
				encontrado=true;
			}
		}
		if (!encontrado) {
			System.out.println("No hay ningún libro que coincida con ese título");
		}
	}

	public static void mostrarLista(ArrayList <Libro> listaLibros){
		Iterator<Libro> libro = listaLibros.iterator();
		while (libro.hasNext())
			System.out.println(libro.next());
	}
}
