package Diapositivas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class RunTime {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		BufferedReader in = null;
		BufferedWriter out = null;
		String ruta = "prueba.txt";
		
		try {
			process = runtime.getRuntime().exec("ping www.google.com");
			
			in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			out = new BufferedWriter(new PrintWriter(new File(ruta)));
			String recojervalores = "";
			while((recojervalores=in.readLine())!=null){
				System.out.println(recojervalores);
				out.write(recojervalores);
				out.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("No pudimos correr el ping");
			System.exit(-1);
		}
		if(process == null) process.destroy();
		
		try {
			
			process.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			System.out.println("No pudimos esperar por termino"); 
			System.exit(-1);

		}
		finally{
			
				if(in !=null)
					try {
						in.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			
		}
		System.out.println("Estatus de termino: "+process.exitValue()); //si es  se ejecuta correctamente muestra 0 y 1 si no es correcto
		System.exit(0); 
	}


}
