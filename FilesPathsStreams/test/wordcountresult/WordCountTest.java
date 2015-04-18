package wordcountresult;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class WordCountTest {

	private static Path path;
	private static File file;
	private static WordCountResult result;

	@BeforeClass
	public static void setUpOnce() {
		path = Paths.get("test.txt");
		file = path.toFile();

		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Charset charset = Charset.forName("UTF-8");
		String s = "This method, when given a file,\n"
				+ "returns the number of words,\n"
				+ "lines and characters in that file.";
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write(s, 0, s.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	@Before
	public void setUp() {
		result = new WordCountResult(3, 17, 95);
	}

	@Test
	public void testWordCountPath() {
		WordCountResult actual = WordCount.wordCount(path);
		assertEquals(result.getNumberOfLines(), actual.getNumberOfLines());
		assertEquals(result.getNumberOfWords(), actual.getNumberOfWords());
		assertEquals(result.getNumberOfCharacters(),
				actual.getNumberOfCharacters());
	}
	
	@Test
	public void testWordCountFile() {
		WordCountResult actual = WordCount.wordCount(file);
		assertEquals(result.getNumberOfLines(), actual.getNumberOfLines());
		assertEquals(result.getNumberOfWords(), actual.getNumberOfWords());
		assertEquals(result.getNumberOfCharacters(),
				actual.getNumberOfCharacters());
	}

	@AfterClass
	public static void tearDownOnce() {

		try {
			Files.deleteIfExists(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
