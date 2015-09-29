package Diapositivas;

import java.io.IOException;

public class DestroyWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Process  proceso = new ProcessBuilder("notepad").start();//lanza el proceso directamente
			System.out.println("Abriendo el Notepad 10 segundos");
			Thread.sleep(10_000);//detiene la ejecuacion del proceso 10s
			proceso.destroy();//destruye el proceso
			//proceso.waitFor();//deja el proceso abierto hasta que lo cerremos
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Acabado el proceso");
	}

}
