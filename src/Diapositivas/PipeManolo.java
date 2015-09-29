package Diapositivas;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class PipeManolo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> comando1 = new ArrayList<String>();
		comando1.add("netstat");
		comando1.add("-ano");
		ProcessBuilder pBuilder1 = new ProcessBuilder(comando1);
		InputStream in1 = null;
		try {
			Process p1 = pBuilder1.start();
			in1 = p1.getInputStream();
			int c;
			while((c=in1.read())!=-1){
				System.out.print((char)c);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
