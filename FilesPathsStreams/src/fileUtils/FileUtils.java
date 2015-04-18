package fileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileUtils {

	private FileUtils() {

	}

	public static String readFrom(File file) throws IOException {

		StringBuffer result = new StringBuffer();
		BufferedReader input = null;

		if (file.exists()) {
			input = new BufferedReader(new FileReader(file));
		}

		String line;
		while ((line = input.readLine()) != null) {
			result.append(line);
		}

		if (input != null) {
			input.close();
		}

		return result.toString();
	}

	public static String readFrom(Path path) throws IOException {
		return readFrom(path.toFile());
	}

	public static void writeTo(File file, String content) throws IOException {
		if (!file.exists()) {
			file.createNewFile();
		}
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
		writer.write(content);
		writer.close();
	}
	
	public static void writeTo(Path path, String content) throws IOException {
		writeTo(path.toFile(), content);
	}
	
	public static String reduceFilePath(String path) {
		return Paths.get(path).normalize().toString();
	}
}
