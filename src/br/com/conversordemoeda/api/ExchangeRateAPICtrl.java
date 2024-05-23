package br.com.conversordemoeda.api;

import java.io.IOException;

import com.google.gson.Gson;

public class ExchangeRateAPICtrl implements MyGson {

	private ExchangeRateAPIRegistro erar;
	private String Ejson;

	public Double converter(String baseCode, Double valor, String codeConverter, String suaChaveAPI)
			throws IOException, InterruptedException {
		Double vlrRate = 0.0;

		ExchangeRateAPI erapi = new ExchangeRateAPI(baseCode, suaChaveAPI);
		System.out.println("Exchange Rate: " + erapi.rate());
		setEjson(erapi.rate());
		desserializar();
		ExchangeRateAPIModel eram = new ExchangeRateAPIModel(getErar());

		System.out.println("baseCode: " + baseCode + " | valor: " + valor + "codeConverter: " + codeConverter);
		System.out.println(">>> resultado: " + eram.getConversion_rates().get(codeConverter));
				
		vlrRate = (Double) eram.getConversion_rates().get(codeConverter);
		return calcular(valor, vlrRate);
	}

	private Double calcular(Double valor, Double vlrRate) {

		return valor * vlrRate;
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
