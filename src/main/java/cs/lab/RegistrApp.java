package cs.lab;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

public class RegistrApp {
    static final Logger logger = Logger.getLogger(RegistrApp.class.getName());
    Scanner input = new Scanner(System.in);


    public RegistrApp() {

    }

    public boolean Ingresar(String nombre, String contracena){
        boolean estado = false;
        while (!estado) {
            if (getContracena(nombre).equals(contracena)) {
                estado = true;
            } else {
                logger.info("Fail");
                estado = false;
            }
        }
        return estado;
    }

    public String getContracena(String nombre){
        return "0";
    }

    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    public void RegistrarClase(){
        String titulo = input.next();
        String enlace = input.next();
        boolean estado = ValidarClase(titulo,enlace);
        if (estado){
            NotificarClase();
        }
        else{
            logger.info("Fail" );
        }
    }

    public boolean ValidarClase(String titulo, String enlace){
        boolean verTitulo = false, verEnlace = false;

        String[] datos = titulo.split(",");
        String[] subdatos = datos[0].split(" ");
        if(isNumeric(subdatos[0].substring(0,3))
                && subdatos[2].length() == 6
                && subdatos[3].length() == 2
                && subdatos[3].equals(datos[3].toUpperCase())
                && isNumeric(datos[1])
                && isNumeric(datos[2].substring(6))){
            verTitulo = true;
        }
        if(enlace.substring(0,30).equals("https://utec.zoom.us/rec/share/")){
            verEnlace = true;
        }
        if (verEnlace && verTitulo){
            return true;
        }else   return false;
    }

    public void NotificarClase(){

    }
}
