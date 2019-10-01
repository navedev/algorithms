package algo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class ReadWriteFromToFile {

	public static void main(String[] args) throws IOException {

		long time = System.currentTimeMillis();

		final FileInputStream inputStream = new FileInputStream("LargeTestFile.txt");
		final FileOutputStream outputStream = new FileOutputStream("Output.txt");
		final FileChannel inChannel = inputStream.getChannel();
		final FileChannel outChannel = outputStream.getChannel();
		// FileLock outChannelLock = outChannel.lock();

		System.out.println("Size of Input File to Copy :: " + inChannel.size());

		inChannel.transferTo(0, inChannel.size(), outChannel);

		while (inChannel.size() - outChannel.size() != 1) {
			inChannel.transferTo(outChannel.size() + 1, inChannel.size(), outChannel);
		}

		System.out.println("Size of Output File :: " + outChannel.size());

		inChannel.close();
		// outChannelLock.release();
		outChannel.close();
		inputStream.close();
		outputStream.close();

		System.out.println("Time needed: " + (System.currentTimeMillis() - time) + "ms");

	}

}
