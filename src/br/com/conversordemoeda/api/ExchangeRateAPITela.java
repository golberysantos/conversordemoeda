package br.com.conversordemoeda.api;

import java.io.IOException;
import java.util.Scanner;

public class ExchangeRateAPITela {
	Scanner ler = new Scanner(System.in);

	public void exibir() throws IOException, InterruptedException {
		ExchangeRateAPICtrl eram = new ExchangeRateAPICtrl();
		String op = "";
		float valor = 0;

		do {
			System.out.println(") \nBEM VINDO AO CONVERSOR DE MOEDA =]");
			System.out.println("1) Dólar >> Peso argentino");
			System.out.println("2) Peso argentino >> Dolar");
			System.out.println("3) Dólar >> Real brasileiro");
			System.out.println("4) Real brasileiro >> Dólar");
			System.out.println("5) Dólar >> Peso colombiano");
			System.out.println("6) Peso colombiano >> Dólar");
			System.out.println("7) Sair");
			System.out.println("Escolha uma opção válida: ");
			op = ler.nextLine();
			System.out.println("Informe o valor para converter: ");
			valor = ler.nextFloat();

			switch (op) {
			case "1":
				eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[2], suaChaveAPI());
				break;
			case "2":
				eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[2], valor, ExchangeRateAPIModel.ARR_BASE_CODE[1], suaChaveAPI());
				break;
			case "3":
				eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[3], suaChaveAPI());
				break;
			case "4":
				eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[3], valor, ExchangeRateAPIModel.ARR_BASE_CODE[1], suaChaveAPI());
				break;
			case "5":
				eram.converter(ExchangeRateAPIModel.ARR_BASE_CODE[1], valor, ExchangeRateAPIModel.ARR_BASE_CODE[4], suaChaveAPI());
				break;

			default:
				break;
			}

		} while (op == "7");

		ler.close();
	}

	private String suaChaveAPI() {
		APIInfo info = new APIInfo();
		if (info.getChaveapi().equals("")) {
			System.out.println("INFORME A CHAVE DA API: ");
			String chave = ler.next();
			info.setChaveapi(chave);
		}
		return info.getChaveapi();
	}
}
