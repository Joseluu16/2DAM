/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
import java.io.*;

public class Escribir {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\jolun\\Documents\\NetBeansProjects\\Prueba.txt");
        FileWriter fw = null;
        BufferedWriter bw = null;
        Scanner sc = new Scanner(System.in);
        
        try {
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            System.out.println("Inserte texto, para finalizar escriba (#)");
            String linea;
            
            while (true) {
                linea = sc.nextLine();
                bw.write(linea);
                bw.newLine();
                
                if (linea.contains(".")) {
                    break;
                }
                System.out.println("Se ha añadido correctamente");
            }
        } catch (IOException e) {
            System.out.println("Error al insertar texto");
            e.printStackTrace();
        } finally {
            try {
                if (bw != null) {
                    bw.close();
                }
                if (fw != null) {
                    fw.close();
                }
                if (sc != null) {
                    sc.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar los recursos");
                e.printStackTrace();
            }
        }
    }
}
