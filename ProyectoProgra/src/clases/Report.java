package clases;
//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import java.io.*;


public class Report {
	File f= new File ("Reporte");


public void ganaciasTotales(SList ordenes){
	Orden o;
	int suma;
	
	try {
		FileWriter w = new FileWriter(f);
		BufferedWriter bw = new BufferedWriter(w);
	    PrintWriter wr = new PrintWriter(bw);
		wr.println("numero de orden			Tecnico				Ganancia ");
		for(int i=0;i<=ordenes.size();i++){
			o=(Orden)ordenes.get(i);
			if(o.isDone()) {
			//funcion append es para seguir escribiendo debabo de lo que ya existia
			wr.append(+o.getOrderNumber()"\t"+o.getTecNumber()"\t"o.getPrice());
			}
			suma=suma+o.getPrice();
		}
		wr.append("Ganancias Totales"+suma);
		bw.close();
		wr.close();
			
	}
	 catch (Exception e) {
    e.printStackTrace();
	}	

	

	
}

}
