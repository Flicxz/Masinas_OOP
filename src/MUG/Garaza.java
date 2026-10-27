package MUG;

import java.io.File;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;



public class Garaza {
	static String virknesParbaude(String zinojums, String noklusejums) {
		String virkne;
		do {
			virkne = JOptionPane.showInputDialog(zinojums, noklusejums);
			if(virkne == null) 
				return null;
			
			virkne = virkne.trim();
		} while(!Pattern.matches("^[\\p{L} ]+$", virkne));
		
		return virkne;
	}
	
	static int skaitlaParbaude(String zinojums, int min, int max) {
		String ievade;
		int skaitlis;
		
		while(true) {
			ievade = JOptionPane.showInputDialog(zinojums, min);
			if(ievade == null)
				return -1;
			
			try {
				skaitlis = Integer.parseInt(ievade);
				if(skaitlis < min || skaitlis > max) {
					JOptionPane.showMessageDialog(null,
					"Norādītais skaitlis ir ārpus pieļaujamā intervāla",
					"Brīdinājums", JOptionPane.WARNING_MESSAGE);
					continue;
				}
				
				return skaitlis;
				
			} catch(NumberFormatException e) {
				JOptionPane.showMessageDialog(null,
				"Netika ievadīts vesels skaitlis!", "Kļūda",
				JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	public static void main(String[] args) {
		String izvelne;
				Masina car = null;
				String[] darbibuSaraksts = {"Pievienot mašīnu", "Izsaukt metodi",
						"Saglabāt failā", "Apskatīt failā gatavās mašīnas",
						"Aizvērt"};
				
				do {
					izvelne = (String) JOptionPane.showInputDialog(null, 
							"Izvēlies darbību", "Darbību izvēle",
							JOptionPane.QUESTION_MESSAGE, null, darbibuSaraksts,
							darbibuSaraksts[0]);
					
					if(izvelne == null)
						izvelne = "Aizvērt";
					
					switch(izvelne) {
					case "Pievienot mašīnu":
						String razotajs, modelis, krasa;
						String cels;
						int rpm, ratio1, ratio2, ratio3, Fratio1, Fratio2, Fratio3, riepas;
						razotajs = 
								virknesParbaude("Ievadi mašīnas ražotāju", "Porsche");
						modelis =
								virknesParbaude("Ievadi mašīnas modeli", "GT");
						krasa =
								virknesParbaude("Ievadi mašīnas krāsu", "Melna");
						cels =
								virknesParbaude("Ievadi bildes nosaukumu", "car");
						rpm =
								skaitlaParbaude("Ievadi mašīnas dzinēja apgriezienu skaitu:",
										2500, 20500);
						ratio1 =
								skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(_.##)\n"
										+ "zem 25mph - 2\n"
										+ "zem 55mph - 1\n"
										+ "virs 55mph - 0\n",
										0, 4);
						ratio2 =
								skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(" + ratio1 + "._#)\n"
										+ "zem 25mph - 5\n"
										+ "zem 55mph - 3\n"
										+ "virs 55mph -7\n",
										0, 9);
						ratio3 =
								skaitlaParbaude("Ievadi mašīnas pārnesumskaitli(" + ratio1 + "." + ratio2 + "_)\n"
										+ "zem 25mph - 0\n"
										+ "zem 55mph - 0\n"
										+ "virs 55mph -5\n",
										0, 9);
						Fratio1 =
								skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(_.##)\n"
										+ "zem 25mph - 3\n"
										+ "zem 55mph - 3\n"
										+ "virs 55mph - 3\n",
										0, 4);
						Fratio2 =
								skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(" + Fratio1 + "._#)\n"
										+ "zem 25mph - 5\n"
										+ "zem 55mph - 0\n"
										+ "virs 55mph - 0\n",
										0, 9);
						Fratio3 =
								skaitlaParbaude("Ievadi mašīnas galvenā pāra pārnesumskaitli(" + Fratio1 + "." + Fratio2 + "_)\n"
										+ "zem 25mph - 0\n"
										+ "zem 55mph - 0\n"
										+ "virs 55mph - 8\n",
										0, 9);
						riepas =
								skaitlaParbaude("Ievadi riepu diametru",
										26, 531);
						String teksts = ratio1 + "." + ratio2 + ratio3;
						double r = Double.parseDouble(teksts);
						teksts = Fratio1 + "." + Fratio2 + Fratio3;
						double Fr = Double.parseDouble(teksts);
						double atrums = (rpm * riepas) / ((r * Fr) * 336);
							
						car = new Masina(razotajs, modelis, krasa, 
								cels, rpm, ratio1, 
								ratio2, ratio3, Fratio1, Fratio2, Fratio3, riepas, r, Fr, atrums);
						break;
						
					case "Saglabāt failā":
						car.saglabatFaila();
						break;
						
					case "Apskatīt failā gatavās mašīnas":
						car.nolasit();
						break;
						
					case "Izsaukt metodi":
						if(car != null) {
							String [] metozuSaraksts = {"Noteikt ātrumu", 
									"Izbraukt", "Nolasīt mašīnas parametrus", "Pārkrāsot",
									"Samainīt mašīnas parametrus", "Samainīt mašīnu", "Atpakaļ"};
							String metode = (String) JOptionPane.showInputDialog(null,
									"Izvēlies metodi", "Metodes izvēle",
									JOptionPane.QUESTION_MESSAGE, null,
									metozuSaraksts, metozuSaraksts[0]);
							
							if(metode == null)
								break;
							
							switch(metode) {
							case "Noteikt ātrumu":
								car.noteiktAtrumu();
								break;
					
							case "Izbraukt":
								car.izbraukt();
								break;
								
							case "Nolasīt mašīnas parametrus":
								car.nolasit();
								break;
								
							case "Pārkrāsot":
								car.parkrasot();
								break;
								
							case "Samainīt mašīnas parametrus":
								car.samainit();
								break;
								
							case "Samainīt mašīnu":
//								car.masinas();
								break;
								
								
							}
								
						}
					}
					} while(!izvelne.equals("Aizvērt"));

	}

}
