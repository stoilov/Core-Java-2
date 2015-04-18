package propertiesParser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PropertiesParser {

	public static Map<String, String> listToMap(List<String> list) {
		Map<String, String> result = new HashMap<String, String>();

		for (String element : list) {
			if (!element.startsWith("#")) {
				int index = element.indexOf("=");
				String key = element.substring(0, index).trim();
				String value = element.substring(index + 1);
				result.put(key, value);
			}
		}

		return result;
	}

	public static Map<String, String> parseProperties(File file) {
		List<String> list = new ArrayList<String>();

		try (BufferedReader input = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = input.readLine()) != null) {
				list.add(line);
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return listToMap(list);
	}
}
