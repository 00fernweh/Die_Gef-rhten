import java.util.Random;
/**
*Klasse Orc
*Erstellt einen Orc,
*der entweder Waffe von Typ Fists oder von Typ Sword bekommt
*und Lebenspunkte zwischen 8o und 150 hat 
*/
public class Orc {
	
	private int lebenspunkte;
	private Weapon waffe;
	/**
	*Konstruktor Orc
	*Orc bekommt zufällig eine der beiden Waffen,
	*und Lebenspunkte zwischen 80 und 150
	*/
	public Orc() {
		Random random = new Random();
		int z = random.nextInt(2);
		if ( z == 0 ) {
			this.waffe = new Fists(setFistsName(), setFistsDamage());
		}
		if ( z == 1 ) {
			this.waffe = new Sword(setSwordName(), setSwordDamage());
		}
		this.lebenspunkte = setOrcsLP();
	}
	/**
	*Gibt die Name von der Waffe, die Orc hält
	*@return waffe.getName()
	*/
	public String getName() {
		return this.waffe.getName();
	}
	/**
	*Gibt den Schaden den der Orc mit dem Schlag hinzufügt
	*@return waffe.dealDamage()
	*/
	public int attack() {
		return this.waffe.dealDamage();
	}
	/**
	*Funktion bestimmt zufällig die Lebenspunkte von Orc
	*@return orcsHealth = Wert zwischen 80 und 150
	*/
	public int setOrcsLP() {
		int[] a = {8, 9, 10, 11, 12, 13, 14};
		int[] b = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Random x1 = new Random();
		int y1 = x1.nextInt(7);
		Random x2 = new Random();
		int y2 = x2.nextInt(11);
		int orcsHealth = a[y1] * 10 + b[y2];
		return orcsHealth;
	}	
	/**
	*Gibt die Lebenspunkte von Orc zurück
	*@return lebenspunkte 
	*/	
	public int getOrcsLP() {
		return this.lebenspunkte;
	}
	/**
	*Methode bestimmt zufällig die Name von der Waffe "Fists"
	*@return fistsName 
	*/
	public String setFistsName() {
		String[] a = {"heavy Fists", "mighty Fists", "bloody Fists", "brutal Fists", "rough Fists"};
		Random x = new Random();
		int y = x.nextInt(5);
		String fistsName = a[y];
		return fistsName;
	}
	/**
	*Methode bestimmt zufällig der Schadenswert von der Waffe "Fists"
	*@return fistsDamage 
	*/
	public int setFistsDamage() {
		int[] a = {5, 6, 7, 8, 9, 10};
		Random x = new Random();
		int y = x.nextInt(6);
		int fistsDamage = a[y];
		return fistsDamage;
	}
	/**
	*Methode bestimmt zufällig die Name von der Waffe "Sword"
	*@return swordName 
	*/
	public String setSwordName() {
		String[] a = {"Hadhafang", "Herugrim", "Gurthang", "Ringil", "Aranruth", "Anguirel"};
		Random x = new Random();
		int y = x.nextInt(6);
		String swordName = a[y];
		return swordName;
	}	
	/**
	*Methode bestimmt zufällig der Schadenswert von der Waffe "Sword"
	*@return swordDamage 
	*/
	public int setSwordDamage() {
		int[] a = {20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
		Random x = new Random();
		int y = x.nextInt(11);
		int swordDamage = a[y];
		return swordDamage;
	}	
}
