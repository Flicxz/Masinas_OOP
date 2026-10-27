package MUG;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Masina {
	DecimalFormat df = new DecimalFormat("#.00"); 
	String razotajs, modelis, krasa;
	int rpm, ratio1, ratio2, Fratio1, Fratio2, riepas;
	double atrums = 0;
	ImageIcon bilde;
	
	public Masina(String razotajs, String modelis, String krasa,
			String cels, int rpm, int ratio1, 
			int ratio2, int Fratio1, int Fratio2, int riepas, double r, double Fr, double atrums) {
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
	}
	 void noteiktAtrumu(){
		JOptionPane.showMessageDialog(null, razotajs + modelis + " atrums ir " + df.format(atrums) + "(MPH)",
				"Informācija", JOptionPane.INFORMATION_MESSAGE);
	}
	 void izbraukt() {
		 if(atrums < 25) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + atrums + "(MPH).\n" + 
					 "Meitenes smejās par tavu mašīnu(viņām nepatīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }else if(atrums < 55) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + atrums + "(MPH).\n" +
					 "Meitenes skatās uz tavu mašīnu(viņām patīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }else if(atrums >= 55) {
			 JOptionPane.showMessageDialog(null, 
					 "Jūs esat izbraukuši ar " + razotajs + modelis + 
					 " laukā ar ātrumu " + atrums + "(MPH).\n" +
					 "Meitenes SKRIEN pakaļ tavai mašīnai(viņām ĻOTI patīk tava mašīna)...", 
					 "Informācija", JOptionPane.INFORMATION_MESSAGE);
		 }
		 
	 }
}
