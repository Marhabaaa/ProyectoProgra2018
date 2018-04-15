package clases;
//Importamos clases que se usaran
import java.io.File;
import java.io.FileWriter;
import java.io.*;


public class Report {
	
	private Orden o;
	private int suma;
	private Pieza p;

	public void ganaciasTotales(SList ordenes) throws IOException{

		File f= new File ("Reporte.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("Reporte.txt"));
		if(f.exists()) {

			bw.write("    Numero de orden 	    	Tecnico			Ganacia por orden ");
			for (int i=0;i<ordenes.size();i++) {
				o = (Orden)ordenes.get(i);
				if(o.isDone()) {
				   bw.newLine();
				   bw.write(" " + o.getOrderNumber()+"		" + o.getTechNumber()+ "		" + o.getPrice());
				   suma = suma + o.getProfit();
				}
			}
			bw.newLine();
			bw.write("el precio total es: "+ suma);
			bw.close();	
		}
		}
		
	public void ganaciasTotalesPantalla(SList ordenes) throws IOException {
		System.out.println("    Numero de orden 	    	Tecnico			Ganacia por orden ");
		for (int i=0;i<ordenes.size();i++) {
			
			o = (Orden)ordenes.get(i);
			if(o.isDone()) {
			System.out.println(""+i+" " + o.getOrderNumber()+"		" + o.getTechNumber()+ "		" + o.getPrice()+"\n");
			   suma = suma + o.getProfit();
			}
			System.out.println("el precio total es: "+ suma);
		}
	}
		
	
	public void stock(SList stock) throws IOException {
		File f= new File ("ReporteStock.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter("ReporteStock.txt"));
		if(f.exists()) {

			bw.write(" Matarial del inventario \n");
			bw.write("Codigo           Nombre                       Cantidad \n");
			for (int i=0;i<stock.size();i++) {
				p = (Pieza)stock.get(i);
				bw.write(" " +p.getCode()+ "		"+p.getDescription()+"		"+p.getCant() +"\n");	
			}
			bw.write("el precio total es: "+ suma);
			bw.close();	
		}

		
	}
	public void stockPantalla(SList stock) throws IOException {
		
			
			System.out.println("Codigo           Nombre                       Cantidad ");
			for (int i=0;i<stock.size();i++) {
				p = (Pieza)stock.get(i);
				System.out.println(" " +p.getCode()+ "		"+p.getDescription()+"		"+p.getCant() );	
			}

		
	}
}


