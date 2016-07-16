/**
 * @(#)Lector.java
 * Tema: Programación Interactiva
 * Programa No. 3
 * @author Garfia Pahua Jose G.
 * @version 1.00 2012/9/2
 */
import java.io.*;

class Lector{

    //atributos
    InputStreamReader isr;
	BufferedReader br;

	//constructor
	public Lector(){
	    isr = new InputStreamReader(System.in);
		br  = new BufferedReader(isr);
	}

    public int leerEntero()throws Exception{
    	return Integer.parseInt(br.readLine());
    }

    public float leerFlotante()throws Exception{
    	return Float.parseFloat(br.readLine());
    }

    public double leerDoble()throws Exception{
    	return Double.parseDouble(br.readLine());
    }

    public String leerCadena()throws Exception{
    	return br.readLine();
    }

    /********* metodo principal ***********/
    public static void main(String args[])throws Exception{
    	//creando objeto lector
    	Lector lec=new Lector();

    	double salario;

    	//entrada
    	System.out.print("Cual es tu salario: ");
    	salario=lec.leerDoble();

    	//salida
    	System.out.println("Salario = "+salario);


    }//main
}//clase