package textfilecompression;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import fileUtils.FileUtils;

public class TextFileCompression {

	public static void compress(Path filePath) {
		String toCompress = "";
		String compressed = "";

		final String prepender = "~";
		final String pipe = "|";

		ArrayList<String> wordNumbers = new ArrayList<String>();

		try {
			toCompress = FileUtils.readFrom(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (toCompress.endsWith(".")) {
			toCompress = toCompress.substring(0, toCompress.length() - 1);
		}

		String[] words = toCompress.split(" ");

		for (String word : words) {
			if (!wordNumbers.contains(word)) {
				wordNumbers.add(word);
			}

			compressed += String.format("%s%d ", prepender,
					wordNumbers.indexOf(word));
		}
		compressed = compressed.substring(0, compressed.length() - 1) + ".";
		compressed = wordNumbers.toString().substring(1,
				wordNumbers.toString().length() - 1)
				+ pipe + compressed;

//		Path comprPath = Paths.get(String.format("%s%s", filePath.toString(),
//				extensionCompr));

		try {
			FileUtils.writeTo(filePath, compressed);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void decompress(Path filePath) {
		String toDeCompress = "";
		String deCompressed = "";

		final String prepender = "~";
		final String pipe = "|";

		try {
			toDeCompress = FileUtils.readFrom(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (toDeCompress.endsWith(".")) {
			toDeCompress = toDeCompress.substring(0, toDeCompress.length() - 1);
		}

		ArrayList<String> wordNumbers = new ArrayList<>(
				Arrays.asList(toDeCompress.split(pipe)[0].split(", ")));

		String[] wordInts = toDeCompress.split(pipe)[1].split(prepender + " ");

		for (String number : wordInts) {
			deCompressed += String.format("%s%s",
					wordNumbers.get(Integer.parseInt(number)), " ");
		}
		
		deCompressed = deCompressed.substring(0, deCompressed.length() - 1) + ".";
		
//		Path comprPath = Paths.get(String.format("%s%s", filePath.toString(),
//				extensionCompr));

		try {
			FileUtils.writeTo(filePath, deCompressed);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Path path = Paths.get("/home/stoilov/Ivan/subtitle_fix/test.txt");
//		compress(path);
		decompress(path);
	}

}
