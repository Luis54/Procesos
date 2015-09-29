package Diapositivas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Runtime3 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Runtime runtime = Runtime.getRuntime();
		Process proceso = null;
		Process proceso2 = null;
		BufferedReader in = null;
		BufferedWriter out= null;
		BufferedReader in2 = null;
		
		
		try {
			proceso = runtime.exec("netstat -ano");
			proceso2 = runtime.exec("find \"LISTEN\"");
			in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			proceso.waitFor();
			String valores;String lista="";
			while((valores=in.readLine())!=null){
				lista+=valores+"\n";
			}
			out = new BufferedWriter(new OutputStreamWriter(proceso2.getOutputStream()));
			out.write(lista);
			out.flush();
			out.close();
			in2 = new BufferedReader(new InputStreamReader(proceso2.getInputStream()));
			while((valores=in2.readLine())!=null){
				System.out.println(valores);
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
