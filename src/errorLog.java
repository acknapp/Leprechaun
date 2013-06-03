/**
 * Logging mechanism for errors
 * @author Andrew Knapp
 *
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class errorLog {
	
	private File f;
	
	public errorLog() {
		
		try {
			this.f = new File("errors.log");
			
			if (!f.exists()) {
				f.createNewFile();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	public void writeLog(String message) {
		try {
			FileWriter writer = new FileWriter(f.getAbsoluteFile());
			BufferedWriter buffWrite = new BufferedWriter(writer);
			buffWrite.write(message);
			buffWrite.close();
		} catch (IOException ie) {
			ie.printStackTrace();
		}
	}
}
