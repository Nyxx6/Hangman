import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
public class User {
String Id;
ArrayList<Integer> sc;

public User( String n ) {
	Id = n.toUpperCase();
	sc = new ArrayList<Integer>();
	System.out.println("      **Welcome "+Id+" to hangman game**      ");
}

public void print() {
	System.out.println( Id+" score is "+sc.get(sc.size()-1));
	int mx = sc.get(0);
	File g = new File("score.txt");
	for ( int i = 0; i < sc.size(); i++ ) {
	mx = Math.max(mx, sc.get(i));	
	
	System.out.println("      **We hope you enjoyed the game**      ");
	}
	System.out.println( "Your best score is "+mx);
	try {
		String s = "Your best score is ";
		BufferedWriter buf = new BufferedWriter(new FileWriter(g));
		buf.write(s+mx);
		buf.newLine();
		buf.close();
		
		}
		catch(IOException e) { System.out.println("Exception detected..."+e.toString()); }
	}


public void addscore( int s ) {
	sc.add(s);
}


}
