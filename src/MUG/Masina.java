package MUG;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Masina {
	DecimalFormat df = new DecimalFormat("#.00"); 
	String razotajs, modelis, krasa;
	int rpm, ratio1, ratio2, ratio3, Fratio1, Fratio2, Fratio3, riepas;
	double atrums = 0, r, Fr;
	ImageIcon bilde;
	
	public Masina(String razotajs, String modelis, String krasa,
			String cels, int rpm, int ratio1, 
			int ratio2, int ratio3, int Fratio1, int Fratio2, int Fratio3, int riepas, double r, double Fr, double atrums) {
		this.razotajs = razotajs;
		this.modelis = modelis;
		this.krasa = krasa;
		this.rpm = rpm;
		this.ratio1 = ratio1;
		this.ratio2 = ratio2;
		this.Fratio1 = Fratio1;
		this.Fratio2 = Fratio2;
		this.riepas = riepas;
		this.atrums = atrums;
		this.r = r;
		this.Fr = Fr;
	}
	 void noteiktAtrumu(){
		JOptionPane.showMessageDialog(null, razotajs + modelis + " atrums ir " + df.format(atrums) + "(MPH)",
				"Informācija", JOptionPane.INFORMATION_MESSAGE);
	}
	 void izbraukt() {
		 if(atrums < 25) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + df.format(atrums) + "(MPH).\n" + 
					 "Meitenes smejās par tavu mašīnu(viņām nepatīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }else if(atrums < 55) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + df.format(atrums) + "(MPH).\n" +
					 "Meitenes skatās uz tavu mašīnu(viņām patīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }else if(atrums >= 55) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + df.format(atrums) + "(MPH).\n" +
					 "Meitenes SKRIEN pakaļ tavai mašīnai(viņām ĻOTI patīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }
	 }
	 void nolasit() {
		 StringBuilder T = new StringBuilder();
		 try (BufferedReader lasa = new BufferedReader(new FileReader("masinas.txt"))) {
		        String rinda;
		        while ((rinda = lasa.readLine()) != null) {
		            T.append(rinda).append("\n");
		        }
		        
		        JOptionPane.showMessageDialog(null, 
		                T.length() > 0 ? T.toString() : "Fails ir tukšs.", 
		                "Saglabātās mašīnas", 
		                JOptionPane.INFORMATION_MESSAGE);
		                
		    } catch (IOException e) {
		        JOptionPane.showMessageDialog(null, 
		                "Kļūda, nolasot failu: " + e.getMessage(), 
		                "Kļūda", 
		                JOptionPane.ERROR_MESSAGE);
		    }
	 }
	 void saglabatFaila() {
		 try (PrintWriter raksta = new PrintWriter(new FileWriter("masinas.txt", true))) {
	            raksta.println("Ražotājs: " + razotajs + 
	                    "\nModelis: " + modelis + 
	                    "\nKrāsa: " + krasa + 
	                    "\nĀtrums: " + df.format(atrums) + " mph");
	            
	            JOptionPane.showMessageDialog(null, 
	                    "Mašīna veiksmīgi saglabāta failā:\n" + "masinas.txt", 
	                    "Gatavs", 
	                    JOptionPane.INFORMATION_MESSAGE);
	                    
	        } catch (IOException e) {
	            JOptionPane.showMessageDialog(null, 
	                    "Kļūda, saglabājot failu: " + e.getMessage(), 
	                    "Kļūda", 
	                    JOptionPane.ERROR_MESSAGE);
	        }
	 }
	 void parkrasot() {
		 krasa = Garaza.virknesParbaude("Ievadi mašīnas krāsu", "Melna"); 
	 }
	 void samainit() {
		 String izvelne;
		 do {
		 String[] darbibuSaraksts = {"Ražotājs", "Modelis",
					"RPM", "Pārnesumskaitlis: _.##", "Pārnesumskaitlis: #._#", "Pārnesumskaitlis: #.#_",
					"Galvenais pārnesumskaitlis: _.##", "Galvenais pārnesumskaitlis: #._#", "Galvenais pārnesumskaitlis: #.#_", 
					"Riepas", "Atpakaļ"};
		 izvelne = (String) JOptionPane.showInputDialog(null, 
					"Izvēlies darbību", "Darbību izvēle",
					JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts,
					darbibuSaraksts[0]);
		 switch(izvelne) {
		 case "Ražotājs":
			 razotajs = 
				Garaza.virknesParbaude("Ievadi mašīnas ražotāju", "Porsche");
			 break;
			 
		 case "Modelis":
			 modelis =
				Garaza.virknesParbaude("Ievadi mašīnas modeli", "GT");
			 break;
			 
		 case "RPM":
			 rpm =
				Garaza.skaitlaParbaude("Ievadi mašīnas dzinēja apgriezienu skaitu:",
						2500, 20500);
			 break;
			 
		 case "Pārnesumskaitlis: _.##":
			 ratio1 =
				Garaza.skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(_.##)\n"
						+ "zem 25mph - 2\n"
						+ "zem 55mph - 1\n"
						+ "virs 55mph - 0\n",
						0, 4);
			 break;
			 
		 case "Pārnesumskaitlis: #._#":
			 ratio2 =
				Garaza.skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(" + ratio1 + "._#)\n"
						+ "zem 25mph - 5\n"
						+ "zem 55mph - 3\n"
						+ "virs 55mph -7\n",
						0, 9);
			 break;
			 
		 case "Pārnesumskaitlis: #.#_":
			 ratio3 =
				Garaza.skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(" + ratio1 + "." + ratio2 + "_)\n"
						+ "zem 25mph - 0\n"
						+ "zem 55mph - 0\n"
						+ "virs 55mph -5\n",
						0, 9);
			 break;
			 
		 case "Galvenais pārnesumskaitlis: _.##":
			 Fratio1 =
				Garaza.skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(_.##)\n"
						+ "zem 25mph - 3\n"
						+ "zem 55mph - 3\n"
						+ "virs 55mph - 3\n",
						0, 4);
			 break;
			 
		 case "Galvenais pārnesumskaitlis: #._#":
			 Fratio2 =
				Garaza.skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(" + Fratio1 + "._#)\n"
						+ "zem 25mph - 5\n"
						+ "zem 55mph - 0\n"
						+ "virs 55mph - 0\n",
						0, 9);
			 break;
			 
		 case "Galvenais pārnesumskaitlis: #.#_":
			 Fratio3 =
				Garaza.skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(" + Fratio1 + "." + Fratio2 + "_)\n"
						+ "zem 25mph - 0\n"
						+ "zem 55mph - 0\n"
						+ "virs 55mph - 8\n",
						0, 9);
			 break;
			 
		 case "Riepas":
			 riepas =
				Garaza.skaitlaParbaude("Ievadi riepu diametru",
						26, 531);
			 
		 }
	 }while(!izvelne.equals("Atpakaļ"));
	 }
}
