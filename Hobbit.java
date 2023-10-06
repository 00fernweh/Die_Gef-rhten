import java.util.Random;
/**
*Klasse Hobbit
*Erstellt einen Hobbit,
*der einen Namen hat,
*und entweder Waffe von Typ Fists oder von Typ Sword bekommt
*und 100 Lebenspunkte hat 
*/
public class Hobbit {
	
	private int lebenspunkte;
	private String hobbitName;
	private Weapon waffe;
	/**
	*Konstruktor Hobbit
	*Hobbit bekommt zufällig eine der beiden Waffen,
	*und den Namen
	*und 100 Lebenspunkte
	*@param name ist Hobbitsname 
	*/
	public Hobbit(String name) {
		Random random = new Random();
		int z = random.nextInt(2);
		if (z == 0) {
			this.waffe = new Fists(setFistsName(), setFistsDamage());
		}
		if (z == 1) {
			this.waffe = new Sword(setSwordName(), setSwordDamage());
		}
		this.hobbitName = name;
		this.lebenspunkte = 100;
	}
	/**
	*Gibt die Name des Hobbits zurück
	*@return hobbitName
	*/
	public String getHobbitName() {
		return this.hobbitName;
	}
	/**
	*Gibt die Name von der Waffe, die Hobbit hält
	*@return waffe.getName()
	*/
	public String getName() {
		return this.waffe.getName();
	}
	/**
	*Gibt den Schaden den der Hobbit mit dem Schlag hinzufügt
	*@return waffe.dealDamage()
	*/
	public int attack() {
		return this.waffe.dealDamage();
	}
	/**
	*Gibt die Lebenspunkte von Hobbit zurück
	*@return lebenspunkte
	*/
	public int getHobbitsLP() {
		return this.lebenspunkte;
	}
	/**
	*Methode bestimmt zufällig die Name von der Waffe "Fists"
	*@return fistsName 
	*/
	public String setFistsName() {
		String[] a = {"bare Fists", "gloved Fists", "tiny Fists", "punching Fists", "knobby  Fists"};
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
		String[] a = {"Morgul-Blade", "Narsil", "Sting", "Orcrist", "Glamdring", "Anduril"};
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
