package subtitlefixer;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class SubtitleFixer {

	public static void fixEncoding(Path path) {

		Charset oldCharset = Charset.forName("Windows-1251");
		Charset newCharset = Charset.forName("UTF-8");

		byte[] oldSubs = null;
		try {
			oldSubs = Files.readAllBytes(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		String text = new String(oldSubs, oldCharset);

		try (BufferedWriter writer = Files.newBufferedWriter(path, newCharset)) {
			writer.write(text, 0, text.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

}
