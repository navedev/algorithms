package algo;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.channels.FileLock;

public class FileLockTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		FileLock fl = null;
		PrintWriter centralOut = null;
		try {
			fos = new FileOutputStream("Output.txt");
			fl = fos.getChannel().tryLock();
			// Null when can't get exclusive lock on file
			int i = 0;
			while (fl == null) {
				try {
					System.out.println("Inside " + i++);
					Thread.sleep(1000);
					fl = fos.getChannel().tryLock();
				} catch (Exception v) {
				}
			}
			// At this point, I have exclusive lock on file!
			centralOut = new PrintWriter("central.log");
			centralOut.println("Superb Message");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (centralOut != null)
					centralOut.close();
			} catch (Exception y) {
			}
			try {
				if (fl != null)
					fl.release();
				if (fos != null)
					fos.close();
			} catch (Exception y) {
			}
		}

	}

}
