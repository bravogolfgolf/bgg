package rover;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GameView {
	private BufferedWriter writer;	
	
	public GameView() {
		this.writer = new BufferedWriter(new OutputStreamWriter(System.out));
	}
	
	public void displayOnScreen(String s) throws IOException {
		writer.write(s, 0, s.length());
		writer.newLine();
		writer.flush();	
	}

}
