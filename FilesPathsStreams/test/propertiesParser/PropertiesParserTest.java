package propertiesParser;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PropertiesParserTest {

	private static Path path;

	private ArrayList<String> list;

	private Map<String, String> expected;

	@BeforeClass
	public static void setUpOnce() {
		path = Paths.get("test.properties");

		try {
			Files.createFile(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Charset charset = Charset.forName("UTF-8");
		String s = "# this=comment\na1=b1\na2 =b2\n"
				+ "a3    =    b3\n   a4 = b4\n"
				+ "a5=b6=b7=b8\na6=b9 #comment\na7==b10";
		try (BufferedWriter writer = Files.newBufferedWriter(path, charset)) {
			writer.write(s, 0, s.length());
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}

	@Before
	public void setUp() {

		list = new ArrayList<String>(Arrays.asList("# this=comment", "a1=b1",
				"a2 =b2", "a3    =    b3", "   a4 = b4", "a5=b6=b7=b8",
				"a6=b9 #comment", "a7==b10"));

		expected = new HashMap<String, String>();
		expected.put("a1", "b1");
		expected.put("a2", "b2");
		expected.put("a3", "    b3");
		expected.put("a4", " b4");
		expected.put("a5", "b6=b7=b8");
		expected.put("a6", "b9 #comment");
		expected.put("a7", "=b10");
	}

	@Test
	public void testListToMap() {
		assertEquals(expected, PropertiesParser.listToMap(list));
	}

	@Test
	public void testParseProperties() {
		File file = path.toFile();
		assertEquals(expected, PropertiesParser.parseProperties(file));
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
