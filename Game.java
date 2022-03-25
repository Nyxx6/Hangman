import java.util.List;
import java.util.Vector;

public class Game{
List<String> word;

public Game() {
	word = new Vector<String>();
}

public void add(String w) {
	word.add(w);
	
}

public boolean isempty() {
	return word.isEmpty();
}
public String rand() {
	int i;
	i = (int) (( Math.random() * 10 ) %  word.size());
	return word.get(i);
}

public List<Integer> exist(String w, char c) {
	List<Integer> result = new Vector<Integer>();
	int i = 0;
	while( i < w.length() ) { if (c == w.charAt(i)) { result.add(i); } i++; }
	return result;
}

public void print(String w) {
	System.out.println("The word was < "+w+" >");
}




}