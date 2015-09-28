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
		
		try {
			proceso = runtime.exec("netstat -ano");
			proceso2 = runtime.exec("ping");
			in = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(proceso2.getOutputStream()));
			String valores = null;
			proceso.waitFor();
			while((valores=in.readLine())!=null){
				valores=in.readLine();
				out.wait();
				out.write(valores);
				out.flush();
				out.close();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
