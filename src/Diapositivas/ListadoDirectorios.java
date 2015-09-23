
package Diapositivas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ListadoDirectorios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> comandos = new ArrayList<String>();
		comandos.add("netstat");
		comandos.add("-an");
		BufferedWriter out = null;
		String ruta = "prueba2.txt";
		
		//creo el objetoBuilder
		ProcessBuilder pBuilder = new ProcessBuilder(comandos);
		BufferedReader in = null;
		try {
			Process proceso = pBuilder.start();
			in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			out = new BufferedWriter(new PrintWriter(new File(ruta)));
			String recojervalores = null;
			while((recojervalores=in.readLine())!=null)
				System.out.println(recojervalores);
				out.write(recojervalores+"\n");
				out.flush();
				
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
