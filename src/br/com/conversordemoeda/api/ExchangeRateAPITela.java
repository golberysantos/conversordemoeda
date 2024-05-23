package br.com.conversordemoeda.api;

import java.io.IOException;
import java.util.Scanner;

public class ExchangeRateAPITela {
	Scanner ler = new Scanner(System.in);

	public void exibir() throws IOException, InterruptedException {

		ExchangeRateAPICtrl eram = null;
		String op = "";
		while (!op.equals("7")) {
			eram = new ExchangeRateAPICtrl();
						
			Double valor = 0.0;
			Double vlrConvertido = 0.0;
			
			System.out.println("Escolha uma das opção: ");
			System.out.println("1) Dólar >> Peso argentino");
			System.out.println("2) Peso argentino >> Dolar");
			System.out.println("3) Dólar >> Real brasileiro");
			System.out.println("4) Real brasileiro >> Dólar");
			System.out.println("5) Dólar >> Peso colombiano");
			System.out.println("6) Peso colombiano >> Dólar");
			System.out.println("7) Sair");
			op = ler.next();
			if (op.equals("7")) break; 
			System.out.println("Informe o valor para converter: ");
			valor = ler.nextDouble();
			
			switch (op) {
			case "1":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[2],
						suaChaveAPI());
				break;
			case "2":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[2], valor, ExchangeRateAPIModel.ARR_BASE_CODE[1],
						suaChaveAPI());
				break;
			case "3":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[3],
						suaChaveAPI());
				break;
			case "4":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[3], valor, ExchangeRateAPIModel.ARR_BASE_CODE[1],
						suaChaveAPI());
				break;
			case "5":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[4],
						suaChaveAPI());
				break;
			case "6":
				vlrConvertido = eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[4], valor, ExchangeRateAPIModel.ARR_BASE_CODE[1],
						suaChaveAPI());
				break;

			default:
				System.out.println("\n Você escolheu uma opção inválida. Por favor, tente novamente.\n");
				break;
			}			

		} 

		ler.close();
		System.out.println("\n   PROGRAMA FINALIZADO.");
	}

	private String suaChaveAPI() {		
		if (APIInfo.chaveapi.equals("")) {
			System.out.println("INFORME A CHAVE DA API: ");			
			APIInfo.chaveapi = ler.next();
		}
		return APIInfo.chaveapi;
	}
	

}
