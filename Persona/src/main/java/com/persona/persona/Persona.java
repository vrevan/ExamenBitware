/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.persona.persona;

/**
 *
 * @author Victor Camacho
 *
 */
public class Persona {
    
    private String NSS="";
    private int Edad=0;
    private double Peso=0;
    private final char Sexo='H';
    private double Altura=0;
    private String Nombre="";

        
    public Persona() {
    
    }

    public Persona(String Nombre, int Edad, double Peso, double Altura) { 
        this.Nombre = Nombre;
        this.Edad = Edad;
        this.NSS = generaNSS();
        this.Peso = Peso;
        this.Altura = Altura;
    }

    public int calcularIMC() {
        final int BajoPeso = -1;
        final int PesoIdeal = 0;
        final int SobrePeso = 1;
        double imc;

        imc = Peso / (Altura*Altura);
       // System.out.println(imc);

        if (imc < 18.5) {
            return BajoPeso;
        } else if (imc >= 18.5 && imc <= 25) {
           return PesoIdeal;
        } else {
            return SobrePeso;
        }

    }

    public boolean esMayorDeEdad() {
        if (Edad >= 18) {
            return true;
        } else {
            return false;
        }
    }

    private boolean comprobarSexo(char sexo) {
        if (sexo == 'H') {
            return true;
            
        }
        else 
            return false;
    }

    

    private String generaNSS() { 
        double numero;
        int numero2;
        int NSSrandom=0;
        char letra;
        String juegoCaracteres;
        String nss;

        for (int i = 0; i < 8; i++) {
            numero = Math.floor(Math.random() * (0 - 9) + 9);
            numero2 = (int) numero;
            NSSrandom = NSSrandom*10+numero2;           
        }               
        juegoCaracteres="TRWAGMYFPDXBNJZSQVHLCKET";
        int modulo = NSSrandom % 23;
        letra = juegoCaracteres.charAt(modulo);
        nss = (""+NSSrandom+letra+"");
       
        return nss;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }

    public void setPeso(double peso) {
        this.Peso = peso;
    }

    public void setAltura(double altura) {
        this.Altura = altura;
    }

    public String getNSS() {
        
        return NSS;
    }

    public int getEdad() {
        return Edad;
    }

    public double getPeso() {
        return Peso;
    }

    public char getSexo() {
        return Sexo;
    }

    public double getAltura() {
        return Altura;
    }

    public String getNombre() {
        return Nombre;
    }

    public boolean Sexo(char sexo){
        
       return comprobarSexo(sexo);
    }
    @Override
    public String toString() {
        return "Persona{" + "NSS=" + NSS + ", Edad=" + Edad + ", Peso=" + Peso + ", Sexo=" + Sexo + ", Altura=" + Altura + ", Nombre=" + Nombre + '}';
    }
    
   
}
