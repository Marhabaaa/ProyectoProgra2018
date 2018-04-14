package clases;
//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import java.io.*;


public class Report {
	
	Orden o;
	int suma;
	Pieza p;

	public void ganaciasTotales(SList ordenes){

		File f= new File ("Reporte.txt");
		if(f.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter("Reporte.txt"));
			bw.write("    Numero de orden 	    	Tecnico			Ganacia por orden \n");
		
			for (int i=0;i<ordenes.size();i++) {
				o = (Orden)ordenes.get(i);
				if(o.isDone()) {
				   bw.write(""+i+" " + o.getOrderNumber()+"		" + o.getTechNumber()+ "		" + o.getPrice()+"\n");
				   suma = suma + o.getProfit();
				}
			}
			bw.write("el precio total es: "+ suma);
			bw.close();	
		}
		}
		
	
/*	public void ganaciasTotalesPantalla(Slist ordenes) {
		for (int i=0;i<ordenes.size();i++) {
			o = (Orden)ordenes.get(i);
			if(o.isDone()) {
			  
			   suma = suma + o.getProfit();
			}
		}
	}
		
	}*/
	public void stock(SList stock) {
		File f= new File ("ReporteStock.txt");
		if(f.exists()) {
			BufferedWriter bw = new BufferedWriter(new FileWriter("ReporteStock.txt"));
			bw.write(" Matarial del inventario \n");
			
		
			bw.write("Codigo           Nombre                       Cantidad \n");
			for (int i=0;i<stock.size();i++) {
				p = (Pieza)stock.get(i);
				bw.write(" "p.getCode()+ "		"+p.getDescription()+"		"+p.getCant()+"\n");		
			}
			bw.write("el precio total es: "+ suma);
			bw.close();	
		}
		
	}
}


