import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Play {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Game jeu = new Game();
		List<Character> letters = new ArrayList<Character>(); // liste des lettres inserées
		
		System.out.println(" >> Hello what's your name? "); System.out.print(" >>"); String nam = scan.next();
		User us = new User(nam); 
		//Create file with user name :
		
		
		int j; 
		boolean Next = true;
		while(Next) {
			File f = new File("chars.txt"); // call file :
			try {
		        BufferedWriter buf = new BufferedWriter(new FileWriter(f)); // delete old data :
				buf.close();
				}
		        catch(IOException exp) { System.out.println("Exception detected..."+exp.toString()); }
			Compteur points = new Compteur();
		// fill list w 3 words at a time:
		int i = 1;
		while(i != 0 || jeu.isempty() ) { System.out.println("Add a word > "); 
		             String w = scan.next(); if (!w.matches("[a-z]")) System.out.println("Word must contain only letters!");
		             else jeu.add(w);
		             System.out.println("Add a word > ");
		             w = scan.next(); if (!w.matches("[a-z]")) System.out.println("Word must contain only letters!(not been added)");
		             else jeu.add(w);
		        
		System.out.println(" >> Would you like to add more words to the list ? (1/0)"); i = scan.nextInt();
		}
		
		//choose a word randomly:
		String word = jeu.rand(); System.out.println(" >> The word is "+word.length()+" long ");
         //building a list of the user's characters (starting by ---)
		List<Character> ccts = new ArrayList<Character>(word.length()); // list of the random word's characters:
        for( i = 0; i < word.length(); i++) { ccts.add('-') ;} // at first we fill it with '-':
        //the user interface:
        int e = 0; // 3 errors max:
        while( e < 3 && ccts.contains('-')) {
        //create table of chars for input memory
        System.out.print("Here is your input history [ ");
        for(j = 0; j < letters.size(); j++) { System.out.print(letters.get(j)); }
        System.out.println(" ]");
        for( i = 0; i < ccts.size(); i++) { System.out.print(ccts.get(i)); }
        
        System.out.println(" >> Enter a character (a..z..A..Z): "); // case-insensitive :
        char c = scan.next().charAt(0); 
        if( (c >= 'a' && c <= 'z' || c <= 'Z' && c >= 'A')) {
        // c must not exist in (letters) !!!!!!!!!!!
        if(!letters.contains(c)) { letters.add(c); try {
        BufferedWriter buf = new BufferedWriter(new FileWriter(f, true)); 
		buf.write(c);
		buf.newLine();
		buf.close();
		}
        catch(IOException exp) { System.out.println("Exception detected..."+exp.toString()); }
        } else System.out.println(c+" is already in the list !!");
        // we get the position(s) of the user's character
        for(j = 0; j < jeu.exist(word, c).size(); j++) { ccts.set(jeu.exist(word, c).get(j), c); } // (output user)
        
        if ( !jeu.exist(word, c).isEmpty() ) { points.Inccpt(10); 
        
        System.out.println(" *-* Good + 10 points"); } 
        // either he spotted a character and gets +10pts or lose a move e-- and -10pts
        else { System.out.println(" Try again! - 10 points :("); e++; points.Deccpt(10); }} else System.out.println(c+" is not a letter!");
        // increment error  and decrement cpt by 10
      }//error closed
        
        if (e == 3) {System.out.println(" >> Oopsy you lose.. ;-;"); jeu.print(word); }// us.addscore(points.cpt); us.print();} 
        else { System.out.println(" >> You win!! :D "); }
        us.addscore(points.cpt); us.print(); 
        
        System.out.println(" >> Would you like to play again ?(1 / 0)"); i = scan.nextInt(); 
        if (i == 0) { Next = false; System.out.println("         **Byee**      ");} 
        ccts.clear(); letters.clear(); 
        
	}
	}
}
