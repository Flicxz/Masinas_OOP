package MUG;

import java.io.File;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;

import MUG.Masina;



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
		String izvelne, failaNosaukums = 
				System.getProperty("user.home")
				+ File.separator + "Desktop" + 
				File.separator + "masinas.txt";
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
					
					
					
					}
					} while(!izvelne.equals("Aizvērt"));

	}

}
