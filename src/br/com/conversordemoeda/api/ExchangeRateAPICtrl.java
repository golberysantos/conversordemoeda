package br.com.conversordemoeda.api;

import java.io.IOException;

import com.google.gson.Gson;

public class ExchangeRateAPICtrl implements MyGson{
	
	private ExchangeRateAPIRegistro erar;
	private String Ejson;
	
	public float converter(String base_code, float valor, String base_code2, String suaChaveAPI)
			throws IOException, InterruptedException {
		ExchangeRateAPI erapi = new ExchangeRateAPI(base_code, suaChaveAPI);		
		System.out.println("Exchange Rate: " + erapi.rate());		
		setEjson(erapi.rate());
		ExchangeRateAPIModel eram = new ExchangeRateAPIModel();
		eram.setResult(erar.result());
		System.out.println(eram.getConversion_rates());
		
		filtrar();
		return calcular();
	}

	private void filtrar() {
		System.out.println(">>>>> ");
	}

	private float calcular() {

		return 0;
	}
	
	@Override
	public String serializar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desserializar() {
		try {
			/*
			 * Gson gson = new GsonBuilder()
			 * .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) .create();
			 */
			Gson gson = new Gson();
			erar = gson.fromJson(getEjson(), ExchangeRateAPIRegistro.class);
			setErar(gson.fromJson(getEjson(), ExchangeRateAPIRegistro.class));
			
		} catch (NumberFormatException e) {
			System.out.println("Aconteceu um erro: ");
			System.out.println(e.getMessage());
		} catch (IllegalArgumentException e) {
			System.out.println("Erro de argumento na busca \n ERRO: " + e);
		} catch (Exception e) {
			System.out.println(
					"Algo de errado não está certo :| na hora de desserializar o Json. \n ERRO: " + e.getMessage());
		}
				
	}

	public ExchangeRateAPIRegistro getErar() {
		return erar;
	}

	public void setErar(ExchangeRateAPIRegistro erar) {
		this.erar = erar;
	}

	public String getEjson() {
		return Ejson;
	}

	public void setEjson(String ejson) {
		Ejson = ejson;
	}

}
