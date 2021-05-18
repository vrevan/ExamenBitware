/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.persona;

import java.util.Scanner;

/**
 *
 * @author Victor Camacho
 */
public class Datos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce tu nombre: ");
        String nombre = scanner.next();
        System.out.println("Introduce tu edad: ");
        int edad = scanner.nextInt();
        System.out.println("Introduce tu sexo (H o M): ");
        char sexo = scanner.next().charAt(0);
        System.out.println("Introduce tu peso: ");
        double peso = scanner.nextDouble();
        System.out.println("Introduce tu altura: ");
        double altura = scanner.nextDouble();
       
        Persona persona = new Persona(nombre, edad, peso, altura);     
     
        if(!persona.Sexo(sexo))
            System.out.println("Solo se permite introducir Hombre");
        
        switch(persona.calcularIMC())
        {
            case -1: System.out.println("Usted se encuentra bajo de peso");
                     break;
            case 0: System.out.println("Usted se encuentra en su peso ideal");
                     break;
            case 1: System.out.println("Usted se encuentra en sobre peso");
                     break;
        }
        if(persona.esMayorDeEdad())
            System.out.println("Usted es mayor de edad");
        else
            System.out.println("Usted es menor de edad");
        
    
       
       
        System.out.println( persona.toString());
    }
    
}
