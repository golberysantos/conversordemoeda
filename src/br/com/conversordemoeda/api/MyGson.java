package br.com.conversordemoeda.api;

/**
 * Gson é uma biblioteca Java que pode ser usada para converter objetos Java em
 * sua representação JSON (serializar).
 * 
 * Também pode ser usado para converter uma string JSON em um objeto Java
 * equivalente (desserializa).
 * 
 * Here is an example of how Gson is used for a simple Class: Gson gson = new
 * Gson(); // Or use new GsonBuilder().create(); MyType target = new MyType();
 * String json = gson.toJson(target); // serializes target to Json
 * 
 * MyType target2 = gson.fromJson(json, MyType.class); // deserializes json into
 * target2
 * 
 * Fonte:
 * https://www.javadoc.io/doc/com.google.code.gson/gson/2.8.5/com/google/gson/Gson.html
 * https://mvnrepository.com/artifact/com.google.code.gson/gson/2.10
 */
public interface MyGson {

	String serializar();

	/**
	 * Transforma json em um objeto java. Retorna um objeto java.
	 * 
	 * @param Json
	 * @return 
	 */
	void desserializar();

}
