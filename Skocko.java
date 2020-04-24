/*
Sastaviti program koji imitira igru Skocko iz Slagalice.
Karakteri koje je moguce koristiti su: @ # $ % & *
Program automatki generise kombinacuju 4 od 6 karaktera.
Potrebno je da igrac pogodi 4 automatski generisanu kombinaciju karaktera i pozicije svakog karaktera.
Igrac ima 7 pokusaja.
*/
package skocko;

import java.util.Random;
import java.util.Scanner;

public class Skocko {

	// metoda za automatsko generisanje zadate kombinacije znakova
	public static char[] generateCombination(char[] n) {
		char[] combination = new char[4];
		Random generator = new Random();
		int random = 0;
		for (int i = 0; i < combination.length; i++) {
			random = generator.nextInt(n.length);
			combination[i] = n[random];
		}
		return combination;
	}

	// metoda za ispis zadate kombinacije znakova
	public static void printGeneratedCombination(char[] n) {
		System.out.print("\nZadata kombinacija znakova je: \n");
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i] + " ");
		}
	}

	// metoda za unos pokusaja pogadjanja kombinacije
	@SuppressWarnings("resource")
	public static char[] insertCombination() {
		Scanner sc = new Scanner(System.in);
		char[] comb = new char[4];
		System.out.println("Unesite zeljenu kombinaciju: ");
		for (int i = 0; i < comb.length; i++) {
			comb[i] = sc.next().charAt(0);
		}
		return comb;
	}

	// provera da li pokusaj odgovara zadatoj kombinaciji znakova
	public static boolean checkCombination(char[] n, char[] n1) {
		int count = 0;
		int temp = 5;
		int poz = 0;

		for (int i = 0; i < 4; i++) {
			if (n[i] == n1[i]) {
				poz++;
				count++;
				temp = i;
			}

			else {
				for (int j = 0; j < 4; j++) {
					if (temp != j) {
						if (n[i] == n1[j]) {
							count++;
							temp = j;
							j = 4;
						}
					}
				}
			}
		}
		
		if (poz == 4) {
			System.out.println("\nPogodili ste " + count + " znakova.");
			System.out.println(poz + " su na pravim pozicijama.");
			return true;
		} else {
			System.out.println("\nPogodili ste " + count + " znakova.");
			System.out.println(poz + " su na pravim pozicijama.");
			return false;
		}
	}

	public static void main(String[] args) {

		char[] characters = { '*', '%', '&', '@', '#', '$' };
		
		System.out.println("Karakteri koje mozete koristiti su:\n"+"@ # $ % & *");

		char[] combination = generateCombination(characters);

		for (int i = 0; i < 7; i++) {
			char[] choosedCombination = insertCombination();
			boolean checked = checkCombination(combination, choosedCombination);
			if (checked == true) {
				System.out.println("Bravo! Pogodili ste kombinaciju iz " + (i + 1) + ". puta.");
				i = 7;
			} else if (i < 6) {
				System.out.println("Imate jos " + (6 - i) + " pokusaja.\n");
			}

		}
		printGeneratedCombination(combination);
	}

}
