package battles;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class LogSingleton {
	static private LogSingleton instance;
	File file;
	FileWriter fr;
	BufferedWriter br;
	private LogSingleton() {
		try {
			file = new File("log.txt");
			fr = new FileWriter(file, true);
			br = new BufferedWriter(fr);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static LogSingleton getInstance() {
		if (instance == null) {
			instance = new LogSingleton();
		}
		return instance;
	}
	
	public void addText(String txt) {
		try {
			br.append(txt);
			br.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			br.close();
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
