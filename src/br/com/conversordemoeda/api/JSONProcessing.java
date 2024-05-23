package br.com.conversordemoeda.api;

import java.io.StringReader;

import javax.json.Json;
import javax.json.stream.JsonParser;

public class JSONProcessing {

	/**
	 * Reading JSON Data Using a Parser Fonte:
	 * https://docs.oracle.com/javaee/7/tutorial/jsonp004.htm
	 *
	 * @param chave
	 * @param jsonData
	 */
	public static void pegarValorPorChave(String chave, String jsonData) {

		JsonParser parser = Json.createParser(new StringReader(jsonData));
		while (parser.hasNext()) {
			JsonParser.Event event = parser.next();
			switch (event) {
			case START_ARRAY:
			case END_ARRAY:
			case START_OBJECT:
			case END_OBJECT:
			case VALUE_FALSE:
			case VALUE_NULL:
			case VALUE_TRUE:
				System.out.println(event.toString());
				break;
			case KEY_NAME:
				System.out.print(event.toString() + " " + parser.getString() + " - ");
				break;
			case VALUE_STRING:
			case VALUE_NUMBER:
				System.out.println(event.toString() + " " + parser.getString());
				break;
			}

		}

	}
}
