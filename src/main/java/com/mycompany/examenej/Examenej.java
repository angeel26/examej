/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.examenej;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Examenej {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numeroAlumnos;
        int opcion;
        
        String[] nombres;
        double[][] notas;
        
        System.out.println("Introduce el numero de alumnos: ");
        numeroAlumnos = sc.nextInt();
        
        while (numeroAlumnos <= 0) {            
            System.out.println("Error. Introduce un numero mayor que 0:");
            numeroAlumnos = sc.nextInt();
        }
        // Crear el array de nombres y la matriz de notas.
        nombres = new String[numeroAlumnos];
        notas = new double[numeroAlumnos][3];
        
        // Recorrer los alumnos para pedir sus nombres y sus tres notas.
        for (int i = 0; i < numeroAlumnos; i++) {
            System.out.print("Introduce el nombre del alumno " + (i + 1) + ": ");
            nombres[i] = sc.next();

            for (int j = 0; j < 3; j++) {

                System.out.print("Introduce la nota del trimestre " + (j + 1) + " de " + nombres[i] + ": ");

                notas[i][j] = sc.nextDouble();
                
                // Validar que las notas esten entre 0 y 10.
                while (notas[i][j] < 0 || notas[i][j] > 10) {

                    System.out.print("Error. La nota debe estar entre 0 y 10: ");
                    notas[i][j] = sc.nextDouble();

                }
            }
        }
        // Mostrar el menu hasta seleccionar la opcion de salida.
        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Listado de alumnos suspensos");
            System.out.println("2. Alumno aprobado con mejor nota media");
            System.out.println("3. Alumnos aprobados dentro de un rango");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                // Aqui calcularemos y mostraremos los suspensos.
                    double notaMedia;
                    boolean suspendeTrimestre;
                    
                    System.out.println("Vamos a calcular los alumnos suspensos");
                    for (int i = 0; i < numeroAlumnos; i++) {
                        // Calcular la media de los tres trimestres.
                        notaMedia = (notas[i][0] + notas[i][1] + notas[i][2]) / 3;
                        suspendeTrimestre = false;
                        // Comprobar si alguna nota es inferior a 4.
                        if (notas[i][0] < 4 || notas[i][1] < 4 || notas[i][2] < 4) {
                            suspendeTrimestre = true;
                        }
                        // Mostrar los alumnos suspensos con su nombre.
                        if (suspendeTrimestre || notaMedia < 5) {
                            System.out.printf("Los alumnos suspensos son: " + nombres[i]);
                        }
                    }
                break;

                case 2:
                // Aqui buscaremos al alumno con mejor media.
                    double notaMedia2;
                    double mayorNotaMedia = -1;
                    String alumnoMayorNota = "";
                    boolean suspendeTrimestre2;
                    
                    for (int i = 0; i < numeroAlumnos; i++) {
                        notaMedia2 = (notas[i][0] + notas[i][1] + notas[i][2]) / 3;
                        suspendeTrimestre2 = false;
                        if (notas[i][0] < 4 || notas[i][1] < 4 || notas[i][2] < 4) {
                            suspendeTrimestre2 = true;
                        }
                        // Comprobar que el alumno esta aprobado y buscar la mayor nota media.
                        if (!suspendeTrimestre2 && notaMedia2 >= 5) {
                            if (notaMedia2 > mayorNotaMedia) {
                                mayorNotaMedia = notaMedia2;
                                alumnoMayorNota = nombres[i];
                            }
                        }
                    }
                    // Mostrar el alumno aprobado con mayor nota media.
                     if (mayorNotaMedia >= 5) {
                        System.out.println("\n===== MEJOR ALUMNO APROBADO =====");
                        System.out.println("Nombre: " + alumnoMayorNota);
                        System.out.printf("Nota media: ", mayorNotaMedia);
                     } else {
                         System.out.println("No hay ningun alumno aprobado.");
                     }
                break;

                case 3:
                // Aqui mostraremos los aprobados dentro del rango.
                    double notaMinima;
                    double notaMaxima;
                    double notaMedia3;
                    boolean suspendeTrimestre3;
                    // Pedir y validar el rango de notas.
                    System.out.print("Introduce la nota minima (entre 5 y 10): ");
                    notaMinima = sc.nextDouble();
                    System.out.print("Introduce la nota maxima: ");
                    notaMaxima = sc.nextDouble();
                    
                    while (notaMaxima < notaMinima || notaMaxima > 10) {
                        System.out.print("Error. La nota maxima debe ser igual o superior a " + notaMinima + " y no superar 10: ");
                        notaMaxima = sc.nextDouble();
                    }
                    for (int i = 0; i < numeroAlumnos; i++) {
                        notaMedia3 = (notas[i][0] + notas[i][1] + notas[i][2]) / 3;
                    
                        suspendeTrimestre3 = false;
                    
                        if (notas[i][0] < 4 || notas[i][1] < 4 || notas[i][2] < 4) {
                            suspendeTrimestre3 = true;
                        }
                        // Mostrar los alumnos aprobados cuya media este dentro del rango.
                        if (!suspendeTrimestre3 && notaMedia3 >= 5 && notaMedia3 >= notaMinima && notaMedia3 <= notaMaxima) {
                            System.out.printf("Estos son los aprobados dentro del rango" + nombres[i]);
                        }
                    }
                break;

                case 4:
                System.out.println("Saliendo del programa...");
                break;

                default:
                System.out.println("Error. Opcion no valida.");
                break;
            }

        } while (opcion != 4);
            
    }
}
