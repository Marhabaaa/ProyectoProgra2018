package clases;
//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import java.io.*;


public class Report {
	


	public void ganaciasTotales(SList ordenes){
		Orden o;
		int suma;
		File f= new File ("Reporte.txt");
		if(f.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Reporte.txt"));
			bw.write("    Numero de orden 	    	Tecnico			Ganacia por orden \n");
		
			for (int i=0;i<ordenes.size();i++) {
				o = (Orden)ordenes.get(i);
				if(o.isDone()) {
				   bw.write(""+i+" " + o.getOrderNumber()+"		" + o.getTecNumber()+ "		" + o.getPrice()+"\n");
				}
			}
		}
		bw.close();	
	}
	
	public void ganaciasTotalesPantalla(Slist ordenes) {
		
	}

}
