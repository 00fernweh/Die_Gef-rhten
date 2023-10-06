import java.util.Random;
/**
*Klasse Battle
*Hier werden 4 Hobbits erstellt
*Vor jeder Runde wird ein Orc erstellt
*Es wird 10 Runden gekämpft
*Eine Runde endet wenn entweder Orc ist tot oder alle Hobbits sind tot
*/
public class Battle {
	
	public static void main(String[] args) {
		
		Hobbit frodo = new Hobbit("Frodo");
		Hobbit sam = new Hobbit("Sam");
		Hobbit meri = new Hobbit("Meri");
		Hobbit pipin = new Hobbit("Pipin");
		Hobbit[] h = {frodo, sam, meri, pipin};
		int[] health = {frodo.getHobbitsLP(), sam.getHobbitsLP(), meri.getHobbitsLP(), pipin.getHobbitsLP(), 0};
		int[] attack = {frodo.attack(), sam.attack(), meri.attack(), pipin.attack(), 0};
		int[] healthLeft = {0, 0, 0, 0, 0};	
		int round = 1;
		while (round < 11) {
			System.out.println("Round " + round + ":");
			Orc orc = new Orc();
			health[4] = orc.getOrcsLP();
			attack[4] = orc.attack();
			System.out.println("An Orc emerges [ LPs: " + health[4] + " ].");
			
			while (true) {
				for (int i = 0; i < 4; i++) {
					if (isAlive(health, i) == true) {
						System.out.println(h[i].getHobbitName() + " [ LPs: " + health[i] + " ], [ Weapon: " 
										   + h[i].getName() + " ] dealt damage " + h[i].attack() + ".");
						healthLeft = recvDamage(health, attack, i, 4);
						health = healthLeft;
						if (isAlive(health, 4) == true) {
							System.out.println("Orc [ LPs: " + health[4] + " ], [ Weapon: " 
											   + orc.getName() + " ] dealt damage " + orc.attack() + ".");
						} else {
							System.out.println("The Orc is dead!");
							break;
						}
						if (isAlive(health, i) == false) {
							System.out.println(h[i].getHobbitName() + " is dead!");
						}
					}
				}
				if (isAlive(health, 4) == false) {
					break;
				}
				if (((isAlive(health, 0)) == false) && ((isAlive(health, 1)) == false) 
					 && ((isAlive(health, 2)) == false) && ((isAlive(health, 3)) == false)) {
					System.out.println("All hobbits are dead! The orcs won!");
					break;
				} else {
					health = healed(health);
				}	
			}	
			
			if (((isAlive(health, 0)) == false) && ((isAlive(health, 1)) == false) 
				 && ((isAlive(health, 2)) == false) && ((isAlive(health, 3)) == false)) {
				break;
			} else {
				health = healed(health);
			}
			orc = null;
			round++;
		}
		if (((isAlive(health, 0)) == true) || ((isAlive(health, 1)) == true) || ((isAlive(health, 2)) == true) || ((isAlive(health, 3)) == true)) {
			System.out.println("The fellowship won, all orcs are dead!");	
		}
	}	
	/**
	*Diese Methode zieht den Schaden von der Anzahl der Lebenspunkte ab
	*@param a ist das übergebene Array, die Lebenspunkte der Figuren enthält
	*@param b ist das übergebene Array, die von der Figur hinzugefügte Schadenswerte enthält
	*@param i ist die Nummer des Hobbits im health und attack Arrays
	*@param j ist die Nummer des Orcs im health und attack Arrays
	*@return a
	*/
	public static int[] recvDamage(int[] a, int[] b, int i, int j) {
		if (i == 0) {
			if ((a[j] - b[i]) > 0) {
				int[] result00 = {(a[i] - b[j]), a[1], a[2], a[3], a[j] - b[i]};
				return result00;
			}
			if ((a[j] - b[i]) <= 0) {
				int[] result01 = {a[i], a[1], a[2], a[3], a[j] - b[i]};
				return result01;
			}
		}
		if (i == 1) {
			if ((a[j] - b[i]) > 0) {
				int[] result10 = {a[0], a[i] - b[j], a[2], a[3], a[j] - b[i]};
				return result10;
			}
			if ((a[j] - b[i]) <= 0) {
				int[] result11 = {a[0], a[i], a[2], a[3], a[j] - b[i]};
				return result11;
			}
		}
		if (i == 2) {
			if ((a[j] - b[i]) > 0) {
				int[] result20 = {a[0], a[1], a[i] - b[j], a[3], a[j] - b[i]};
				return result20;
			}
			if ((a[j] - b[i]) <= 0) {
				int[] result21 = {a[0], a[1], a[i], a[3], a[j] - b[i]};
				return result21;
			}
		}
		if (i == 3) {
			if ((a[j] - b[i]) > 0) {
				int[] result30 = {a[0], a[1], a[2], a[i] - b[j], a[j] - b[i]};
				return result30;
			}
			if ((a[j] - b[i]) <= 0) {
				int[] result31 = {a[0], a[1], a[2], a[i], a[j] - b[i]};
				return result31;
			}
		}
		return a;
	}
	/**
	*Methode überprüft ob die Figue noch lebt
	*@param a ist das übergebene Array, die Lebenspunkte der Figuren enthält
	*@param i ist die Nummer der Figur im Array
	*@return false falls die Figur tot ist und true falls lebt
	*/
	public static boolean isAlive(int[] a, int i) {
		if (a[i] <= 0) {
			return false;
		}
		return true;
	}
	/**
	*Methode heilt lebende Hobbits um 0 bis 15 LPs
	*@param a ist das übergebene Array, die Lebenspunkte der Figuren enthält
	*@return a
	*/
	public static int[] healed(int[] a) {
		Random x = new Random();
		int y = x.nextInt(16);
		for (int i = 0; i < 4; i++) {
			if (a[i] > 0) {
				a[i] = a[i] + y;
			}
		}
		System.out.println("All living hobbits healed by " + y + ".");
		return a;
	}
}
	