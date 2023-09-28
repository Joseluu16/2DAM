/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ficheros;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author jolun
 */
public class Leer {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\jolun\\Documents\\NetBeansProjects\\Prueba.txt");
        try{
            FileReader fr = new FileReader(archivo);
            BufferedReader bf = new BufferedReader(fr);
            String linea;
            while((linea = bf.readLine())!=null){
                System.out.println(linea);
            }
            bf.close();
            fr.close();
        }catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
            
    }
}
