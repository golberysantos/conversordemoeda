package br.com.conversordemoeda.api;

import java.io.IOException;

import com.google.gson.Gson;

public class ExchangeRateAPICtrl implements MyGson {

	private ExchangeRateAPIRegistro erar;
	

	public Double converter(String baseCode, Double vlrAConverter, String baseCodeAConverter, String suaChaveAPI)
			throws IOException, InterruptedException {
		Double cotacaoMoeda = 0.0, cotacaoMoedaAConverter=0.0;  
		ExchangeRateAPI erapi = new ExchangeRateAPI(baseCode, suaChaveAPI);
		desserializar(erapi.rate());		
		ExchangeRateAPIModel eram = new ExchangeRateAPIModel(getErar());
		cotacaoMoeda = (Double) eram.getConversion_rates().get(baseCode);
		cotacaoMoedaAConverter = (Double) eram.getConversion_rates().get(baseCodeAConverter);

		System.out.println("\n");
		System.out.println("Cotacao moeda["+ baseCode +"]: " + cotacaoMoeda);
		System.out.println("Cotacao moeda a converter["+ baseCodeAConverter+"]: "+cotacaoMoedaAConverter);		
		System.out.println("Valor a converter: "+vlrAConverter);		
		return calcular(vlrAConverter, cotacaoMoeda, cotacaoMoedaAConverter);
	}

	private Double calcular(Double vlrAConverter, Double cotacaoMoeda, Double cotacaoMoedaAConverter) {
		return  (vlrAConverter*cotacaoMoedaAConverter)/cotacaoMoeda;
	}

	@Override
	public String serializar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void desserializar(String ejson) {
		try {
			/*
			 * Gson gson = new GsonBuilder()
			 * .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE) .create();
			 */
			Gson gson = new Gson();
			setErar(gson.fromJson(ejson, ExchangeRateAPIRegistro.class));

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


}
