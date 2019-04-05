package gui;
import java.lang.ProcessBuilder;
import java.io.IOException;



/*
 *terminal print class
 */
public class print {
/*
 * Print string text in terminal
 */
public static void printterm(String text){
	
	System.out.println(text);

}

/*
 * Run String text inside a terminal(linux)
 */
public static void termrun(String text) {
	ProcessBuilder builder = new ProcessBuilder("/bin/bash", "-c",text);
	if(!text.equals("")){
		try {
		Process p = builder.start();
		System.out.println(p);
		}
		catch(IOException e){
		e.printStackTrace();
		}
	}
	else {
		System.out.println("Bitte geben Sie ein Befehl ein.");
	}
}
}