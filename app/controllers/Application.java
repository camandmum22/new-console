package controllers;

import java.util.LinkedList;
import java.util.Queue;

import play.*;
import play.mvc.*;
import views.html.*;

public class Application extends Controller {
	
	public static class Hilo implements Runnable{
		public static Queue<String> colaComandos = new LinkedList<String>();
		public static Queue<String> colaRespuestas = new LinkedList<String>();

		public Hilo() {
			// TODO Auto-generated constructor stub
		}
		
		@Override
		public void run() {
			while(true){
				if(!colaComandos.isEmpty()){
					String comando = colaComandos.poll();
					//Aqui enviar el comando;
				}
				if(!colaRespuestas.isEmpty()){
					String respuesta = colaRespuestas.poll();
					//Aqui enviar el comando;
				}
			}
		}
    }
	
	public static Hilo hilo = new Hilo();
	
    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
    /*
    public static Result sandBox() {
        return ok(sandBox.render("Sandbox"));
    }
    */
    public void addComando(String cmd){
    	hilo.colaComandos.add(cmd);
    }
    
    public String sacarComando(){
    	return hilo.colaComandos.poll();
    }
    
    public void addRespuesta(String resp){
    	hilo.colaRespuestas.add(resp);
    }
    
    public String sacarRespuesta(){
    	return hilo.colaRespuestas.poll();
    }
}
