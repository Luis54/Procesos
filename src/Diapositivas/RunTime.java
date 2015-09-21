package Diapositivas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunTime {
	public static void main(String[] args) {
		Runtime runtime = Runtime.getRuntime();
		Process process = null;
		
		try {
			process = runtime.getRuntime().exec("ping -a www.google.es");
			BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
			for (int i = 0; i < 10; i++) {
				System.out.println("saludos " + in.readLine());
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
		System.out.println("Estatus de termino: "+process.exitValue()); 
		System.exit(0); 
	}

}
