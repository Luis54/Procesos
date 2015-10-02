package Diapositivas;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class PipeManolo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> comando1 = new ArrayList<String>();
		comando1.add("netstat");
		comando1.add("-ano");
		List<String> comando2 = new ArrayList<String>();
		comando2.add("find");
		comando2.add("\"LISTENING\"");
		ProcessBuilder pBuilder1 = new ProcessBuilder(comando1);
		ProcessBuilder pBuilder2 = new ProcessBuilder(comando2);
		BufferedReader in1 = null;
		BufferedWriter out1 = null;
		BufferedReader in2 = null;

		try {
			Process p1 = pBuilder1.start();
			Process p2 = pBuilder2.start();
			in1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			out1 = new BufferedWriter(new OutputStreamWriter(p2.getOutputStream()));
			String lista = ""; 
			while((lista=in1.readLine())!=null){
				out1.write(lista+"\n");
			}
			
			out1.flush();
			out1.close();
			in2 = new BufferedReader(new InputStreamReader(p2.getInputStream()));
			while((lista=in2.readLine())!=null){
				System.out.println(lista);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				in1.close();in2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
