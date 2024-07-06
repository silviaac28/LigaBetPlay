package com.finalbetplay.views;

import java.util.Scanner;

import com.finalbetplay.Controller;
import com.finalbetplay.clases.Permiso;
import com.finalbetplay.utils.ConsoleUtils;

public class viewPermiso {

    public static Controller controladorPermisos;

    public void startPermiso(){

        Scanner scannerPermisos = new Scanner(System.in);

        while (true) {

            ConsoleUtils.cleanScreen();

            System.out.println("\n-----MENÚ GESTION PERMISOS-----\n");
            
            System.out.println("1. Agregar un permiso");
            System.out.println("2. Ver permisos");
            System.out.println("3. Salir al menú principal \n ");

            int choice = scannerPermisos.nextInt();
            scannerPermisos.nextLine();

            switch (choice) {
                case 1:
                    
                    ConsoleUtils.cleanScreen();


                    Permiso permisos = new Permiso();
                    String codigoPermiso = null;

                    System.out.println("Cuál es el código del permiso: ");
                    codigoPermiso = scannerPermisos.nextLine();

                    System.out.println("Cuál es el id del permiso: ");
                    permisos.setId(scannerPermisos.nextInt());
                    scannerPermisos.nextLine();

                    System.out.println("Cuál es la descripción del permiso: ");
                    permisos.setDescripcion(scannerPermisos.nextLine());

                    controladorPermisos.permisos.put(codigoPermiso, permisos);

                    ConsoleUtils.pause();

                    break;
            
                case 2:

                    ConsoleUtils.cleanScreen();

                    Permiso verPermisos = new Permiso();
                    for (String codPermisos : controladorPermisos.permisos.keySet()) {
                        verPermisos = controladorPermisos.permisos.get(codPermisos);
                        System.out.println("Cod Permiso: " + codPermisos + " Id: " + verPermisos.getId());
                    }

                    ConsoleUtils.pause();
                    
                    break;

                case 3:
                    System.out.println("SALIENDO");
                    return;

                default:
                    break;
            }
        }

    }

}
