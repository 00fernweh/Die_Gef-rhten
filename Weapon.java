/**
*Klasse Weapon
*Erstellt die Waffen,
*die Namen und Schadenswert haben
*/
public class Weapon {
	
	private String name;
	private int  damage;
	
	/**
	*Konstruktor Weapon
	*nimmt Name und Schadenswert an
	*@param name = der Name 
	*@param damage = der Schadenswert
	*/
	public Weapon(String name, int damage) {
		this.name = name;
		this.damage = damage;
	}
	/**
	*Funktion gibt den Namen der Waffe zurück
	*@return name
	*/	
	public String getName() {
		return this.name;
	}
	/**
	*Funktion gibt den Schadenswert der Waffe zurück
	*@return damage
	*/	
	public int dealDamage() {
		return this.damage;
	}	
}