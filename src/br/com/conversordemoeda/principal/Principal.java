package br.com.conversordemoeda.principal;

import java.io.IOException;

import br.com.conversordemoeda.api.ExchangeRateAPITela;

public class Principal {

	public static void main(String[] args) throws IOException, InterruptedException {
		System.out.println("\n");
		System.out.println("╔═══════════════════════════════╗");
		System.out.println("║ CONVERSOR DE MOEDA            ║");
		System.out.println("║ API: Exchange Rate API        ║");
		System.out.println("║ BY: Golbery                   ║");
		System.out.println("╚═══════════════════════════════╝");
		System.out.println("");
		br.com.conversordemoeda.api.ExchangeRateAPITela exch = new ExchangeRateAPITela();
		exch.exibir();
		System.exit(0);
	}
}