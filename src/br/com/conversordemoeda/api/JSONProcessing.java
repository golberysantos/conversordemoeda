package br.com.conversordemoeda.api;

import javax.json.Json;
import javax.json.JsonObject;

import com.google.gson.stream.JsonReader;

public class JSONProcessing {

	public void pegarValorPorChave(String json) {
		JsonReader rdr = Json.createReader(json) {
			 
			     JsonObject obj = rdr.readObject();
			 JsonArray results = obj.getJsonArray("data");
			 for (JsonObject result : results.getValuesAs(JsonObject.class)) {
			 System.out.print(result.getJsonObject("from").getString("name"));
			 System.out.print(": ");
			System.out.println(result.getString("message", ""));
			System.out.println("-----------");
			}

	}
}
