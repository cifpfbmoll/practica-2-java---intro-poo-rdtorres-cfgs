package eu.cifpbmoll.Biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Persona {
		public static Scanner lectorPersona=new Scanner(System.in);
		//Atributos
	    private String nombre;
	    private String apellido1;
	    private String apellido2;
	    private String NIF;
	    private String contraseña;
	    
	    //Constructor vacío
	    public Persona() {
		}
	    
	    //Constructor con parámetros
	    public Persona(String nombre, String apellido1, String apellido2, String NIF, String contraseña) {
	    	this.nombre=nombre;
	    	this.apellido1=apellido1;
	    	this.apellido2=apellido2;
	    	this.NIF=NIF;
	    	this.contraseña=contraseña;
	    }
	    //Constructor copia Persona
	    public Persona (Persona p1) {
	    	this.setNombre(p1.getNombre());
	    	this.setApellido1(p1.getApellido1());
	    	this.setApellido2(p1.getApellido2());
	    	this.setNIF(p1.getNIF());
	    	this.setContraseña(p1.getContraseña());
	    }
	    //Getters And Setters

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido1() {
			return apellido1;
		}

		public void setApellido1(String apellido1) {
			this.apellido1 = apellido1;
		}

		public String getApellido2() {
			return apellido2;
		}

		public void setApellido2(String apellido2) {
			this.apellido2 = apellido2;
		}

		public String getNIF() {
			return NIF;
		}

		public void setNIF(String nIF) {
			NIF = nIF;
		}

		public String getContraseña() {
			return contraseña;
		}

		public void setContraseña(String contraseña) {
			while(contraseña.length() <8) {
				System.out.println("La contraseña debe contener almenos 8 carácteres");
				contraseña = lectorPersona.nextLine();
			}
			this.contraseña = contraseña;
		}
	    //To String
		@Override
		public String toString() {
			return "Persona{" + "nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", NIF=" + NIF + ", contrase\u00f1a=" + contraseña + '}';
	    }
		//Métodos
		public static void añadirTrabajador(ArrayList<Persona> listaPersonas) {
			Persona bibliotecario = new Persona();
			System.out.println("¿Cual es el nombre del trabajador que deseas añadir?");
			bibliotecario.setNombre(lectorPersona.nextLine());
			
			System.out.println("¿Cual es el primer apellido del trabajador?");
			bibliotecario.setApellido1(lectorPersona.nextLine());
			
			System.out.println("¿Cual es el segundo apellido del trabajador?");
			bibliotecario.setApellido2(lectorPersona.nextLine());
			
			System.out.println("¿Cual es NIF del trabajador?");
			bibliotecario.setNIF(lectorPersona.nextLine());
			
			System.out.println("¿Cual es la contraseña que deseas añadir al trabajador?");
			bibliotecario.setContraseña(lectorPersona.nextLine());
			
			listaPersonas.add(bibliotecario);
		}
		
		public static void eliminarTrabajador(ArrayList<Persona> listaPersonas) {
			System.out.println("Para eliminar ponga el NIF y la contraseña del trabajador");
			System.out.println("NIF:");
			String NIF = lectorPersona.nextLine();
			int i = 0;
			boolean encontrarTrabajador = false;
			while (i<listaPersonas.size()) {
				if(listaPersonas.get(i).getNIF().equals(NIF)) {
					encontrarTrabajador = true;
					System.out.println("Contraseña: ");
					String contraseña = lectorPersona.nextLine();
					if(listaPersonas.get(i).getContraseña().equals(contraseña)) {
						listaPersonas.remove(i);
						System.out.println("El trabajador fue eliminado con éxito.");
					}
					else {
						System.out.println("La contraseña no es correcta.");
					}
				}
				else {
					System.out.println("El NIF no es correcto.");
				}
			}
			if (encontrarTrabajador == false) {
				System.out.println("No se ha encontrado al trabajador.");
			}
		}
		
		public static void buscarTrabajador(ArrayList<Persona> listaPersonas) {
			boolean encontrado= false;
			System.out.println("Dime el Nombre del Trabajador");
			String nombre = lectorPersona.nextLine();
			for (int i= 0;i <listaPersonas.size();i++) {
				if (listaPersonas.get(i).getNombre().contains(nombre)) {
					System.out.println(listaPersonas.get(i).toString());
					encontrado=true;
				}
			}
			if(!encontrado) {
				System.out.println("No hemos hayado ningún trabajador con ese nombre");
			}
		}
		
		public static void mostrarTrabajadores(ArrayList<Persona> listaPersonas) {
			System.out.println(listaPersonas);
		}
}
