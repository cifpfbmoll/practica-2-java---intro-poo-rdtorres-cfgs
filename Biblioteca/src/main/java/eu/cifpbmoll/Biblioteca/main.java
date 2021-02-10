package eu.cifpbmoll.Biblioteca;

import java.util.Scanner;
import java.util.ArrayList;
/*
 * @author Roberto Torres Cruz
 */

public class main {

    public static void main(String[] args) {
    	mostrarMenuGeneral();
        // TODO code application logic here
    }
    public static void mostrarMenuGeneral() {  
    	Scanner lectorMenu = new Scanner (System.in);
        boolean menuGeneral;
        menuGeneral = true;
        while (menuGeneral == true) {
        	System.out.println("Bienvenido a la gestión de la Biblioteca");
        	System.out.println("¿Qué acción deseas realizar?");
            System.out.println("1. Gestión de  Libros.");
            System.out.println("2. Intranet.");
            System.out.println("3. Salir.");
            int seleccionMenu = lectorMenu.nextInt ();
            switch (seleccionMenu){
	            case 1:
	            	mostrarMenuLibros();
	            	break;
	            case 2:
	            	mostrarMenuTrabajadores();
	            	break;
	            case 3:
	            	System.out.println("Nos vemos promnto");
	            	menuGeneral= false;
	            	break;
            }
        }
    }
    
    public static void mostrarMenuLibros() {
    	Biblioteca biblio = new Biblioteca ();
    	Scanner lectorMenu = new Scanner (System.in);
    	boolean menuLibros = true;
        while (menuLibros == true){
            System.out.println("Bienvenido a la gestión de Libros");
            System.out.println("¿Qué acción deseas realizar?");
            System.out.println("1. Añadir Libro.");
            System.out.println("2. Eliminar Libro.");
            System.out.println("3. Buscar Libro por ISBN.");
            System.out.println("4. Buscar Libro por título.");
            System.out.println("5. Mostrar lista libros.");
            System.out.println("6. Mostrar libros disponibles.");
            System.out.println("7. Volver al menú general.");
            int seleccionMenu = lectorMenu.nextInt ();
            switch (seleccionMenu){
                case 1:
                	Libro.añadirLibro(biblio.getlistaLibros());
                	break;
                case 2:
                	Libro.eliminarLibro(biblio.getlistaLibros());
                	break;
                case 3:
                	Libro.buscarISBN(biblio.getlistaLibros());
                	break;
                case 4:
                	Libro.buscarTitulo(biblio.getlistaLibros());
                	break;
                case 5:
                	biblio.mostrarLibros();
                	break;
                case 6:
                	biblio.mostrarLibrosDisponibles();
                	break;
                case 7:
                	menuLibros = false;
        	}
        }
    }
    public static void mostrarMenuTrabajadores() {
    	Scanner lectorMenu = new Scanner (System.in);
    	Biblioteca biblio = new Biblioteca ();
    	Persona bibliotecario = new Persona();
    	boolean menuTrabajadores = true;
    	while(menuTrabajadores == true) {
            System.out.println("Bienvenido a la gestión de Trabajadores");
            System.out.println("¿Qué acción deseas realizar?");
            System.out.println("1. Añadir personas a la lista Trabajadores.");
            System.out.println("2. Eliminar personas de la lista Trabajadores.");
            System.out.println("3. Buscar trabajador.");
            System.out.println("4. Mostrar la lista Trabajadores.");
            System.out.println("5. Volver al menú general.");
            int seleccionMenu = lectorMenu.nextInt ();
            switch (seleccionMenu){
	            case 1:
	            	bibliotecario.añadirTrabajador(biblio.getlistaPersonas());
	              break;
	            case 2:
	            	bibliotecario.eliminarTrabajador(biblio.getlistaPersonas());
	              break;
	            case 3:
	            	bibliotecario.buscarTrabajador(biblio.getlistaPersonas());
	              break; 
	            case 4:
	            	bibliotecario.mostrarTrabajadores(biblio.getlistaPersonas());
	                break;
	            case 5:
	            	menuTrabajadores = false;
            }
    	}
    }
}