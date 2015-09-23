package Diapositivas;

import java.io.IOException;

public class Runtime2 {
	public static void main(String[] args) {
		//creamos un objeto tipo Runtime
		Runtime runtime = Runtime.getRuntime();
		try {
			Process p = runtime.exec("notepad");
			Process p2 = runtime.exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox");//abrir firefox
			Process p3 = runtime.exec("C:\\Windows\\System32\\cmd");
			Process p4 = runtime.exec("C:\\Windows\\System32\\cmd dir");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Fin de programa");
	}
}
