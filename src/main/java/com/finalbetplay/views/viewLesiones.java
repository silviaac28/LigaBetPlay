package com.finalbetplay.views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import com.finalbetplay.Controller;
import com.finalbetplay.clases.Lesion;
import com.finalbetplay.clases.Jugador;
import com.finalbetplay.utils.ConsoleUtils;

public class viewLesiones {

    public static Controller controladorLesion;

    public void StartLesiones(){

        Scanner scannerLesiones = new Scanner(System.in);
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");

        while (true) {
            ConsoleUtils.cleanScreen();

            System.out.println("\n-----MENÚ GESTION LESIONES-----\n");

            System.out.println("1. Ingresar nueva lesión");
            System.out.println("2. Editar lesión");
            System.out.println("3. Eliminar lesión");
            System.out.println("4. Listar lesiones");
            System.out.println("5. Salir al menú principal \n ");

            System.out.println("Selecciona la opción deseada: ");
            int choice = scannerLesiones.nextInt();
            scannerLesiones.nextLine();

            switch (choice) {
                case 1:
                    ConsoleUtils.cleanScreen();

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");


                    Lesion lesiones = new Lesion();
                    System.out.println("Ingrese el código de la lesión: ");
                    String codigoLesion = scannerLesiones.nextLine();
                    System.out.println("Ingrese el ID de la lesión: ");
                    lesiones.setId(scannerLesiones.nextInt());
                    scannerLesiones.nextLine();

                    // SELECCION JUGADOR 
                    Jugador listarJugadores = new Jugador();
                    Jugador jugadores = new Jugador();
                    String codigoJugadorSeleccionado = null;
                    System.out.println("-------------------------");
                    System.out.println("LISTADO DE JUGADORES: ");
                    for (String codJugadores : controladorLesion.jugadores.keySet()) {
                        listarJugadores = controladorLesion.jugadores.get(codJugadores);
                        System.out.println("Codigo: " + codJugadores + " Nombre: " + listarJugadores.getNombre() );
                    }
                    System.out.print("Ingrese el Código del jugador lesionado: ");
                    codigoJugadorSeleccionado = scannerLesiones.nextLine();
                    listarJugadores = controladorLesion.jugadores.get(codigoJugadorSeleccionado);

                    System.out.println("Usted ha seleccionado el jugador: " + listarJugadores.getNombre());
                    lesiones.setJugador(listarJugadores.getNombre());
                    /// fin SELECCION JUGADOR

                    System.out.println("Ingrese el tipo de lesión: ");
                    lesiones.setTipo(scannerLesiones.nextLine());
                    System.out.println("Ingrese la gravedad de la lesión: ");
                    lesiones.setGravedad(scannerLesiones.nextLine());

                    // FECHA INICIO
                    
                    System.out.println("Ingrese la fecha de inicio de la lesión (DD/MM/AAAA): ");
                        String fechaInicioLesionStr = scannerLesiones.nextLine();
                       
                    try {
                        Date fechaInicioLesion = new Date(dateFormat.parse(fechaInicioLesionStr).getTime());
                        lesiones.setFechaInicioLesion(fechaInicioLesion);
                    } catch (ParseException e) {
                        System.out.println("Fecha inválida. Por favor, use el formato yyyy-MM-dd.");
                    }
                    
                    // FECHA FIN
                    
                    System.out.println("Ingrese la fecha de fin de la recuperación (DD/MM/AAAA): ");
                        String fechaFinRecuperacionStr = scannerLesiones.nextLine();
                       
                    try {
                        Date fechaFinRecuperacion = new Date(dateFormat.parse(fechaFinRecuperacionStr).getTime());
                        lesiones.setFechaFinRecuperacion(fechaFinRecuperacion);
                    } catch (ParseException e) {
                        System.out.println("Fecha inválida. Por favor, use el formato yyyy-MM-dd.");
                    }

                    controladorLesion.lesiones.put(codigoLesion, lesiones);
                    System.out.println("Lesión registrada exitosamente.");

                    ConsoleUtils.pause();

                    break;

                case 2:
                    ConsoleUtils.cleanScreen();
                    break;

                case 3:
                    ConsoleUtils.cleanScreen();
                    break;

                case 4:
                    ConsoleUtils.cleanScreen();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                    break;
            }
        }
    }
}