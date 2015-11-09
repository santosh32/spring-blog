package in.spring4buddies.application;

import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class GsonUtility {

	public static void main(String args[]) throws IOException {
		String jsonString = IOUtils.toString(GsonUtility.class.getClassLoader()
				.getResourceAsStream("sample.json"));
		String formattedJson = new GsonBuilder().setPrettyPrinting().create()
				.toJson(new JsonParser().parse(jsonString));
		System.out.println(formattedJson);

	}
}
