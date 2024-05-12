package br.com.conversordemoeda.principal;

import java.io.IOException;
import java.util.Scanner;

import br.com.conversordemoeda.api.ExchangeRateAPITela;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		Scanner ler = new Scanner(System.in);
		System.out.println("\n");
		System.out.println("╔═════════════════════════╗");
		System.out.println("║ JAVA HELPER. BY GOLBERY ║");
		System.out.println("╚═════════════════════════╝");
		System.out.println("╔═════════════════════════╗");
		System.out.println("║ OPÇÕES:                 ║");
		System.out.println("║ 0. SAIR                 ║");
		System.out.println("║ 1. Exchange Rate API    ║");
		System.out.println("╚═════════════════════════╝");
		System.out.println("");

		String opcao = ler.next();

		System.out.println(opcao);
		switch (opcao) {
		case "0":

			break;
		case "1":
			br.com.conversordemoeda.api.ExchangeRateAPITela exch = new ExchangeRateAPITela();
			exch.exibir();
			break;

		default:
			break;
		}

		ler.close();
		System.exit(0);
	}
}