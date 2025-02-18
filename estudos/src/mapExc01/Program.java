package mapExc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

//		Locale.setDefault(Locale.US);

		Scanner scanner = new Scanner(System.in);

		System.out.println("Digite o caminho do arquivo: ");
//		String path = "C:\\temp\\in2.csv";
		String path = scanner.nextLine();

		boolean hasError = false;

		Map<String, Integer> mapa = new HashMap<>();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();

			while (line != null) {
				String[] entrada = line.split(",");

				try {

					if (mapa.containsKey(entrada[0])) {
						mapa.put(entrada[0], mapa.get(entrada[0]) + Integer.parseInt(entrada[1]));
					} else {
						mapa.put(entrada[0], Integer.parseInt(entrada[1]));
					}

					line = br.readLine();

				} catch (NumberFormatException e) {
					System.out.println(" Dados de entrada errados: " + e.getMessage());
					line = null;
					hasError = true;
				}
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}

		if (!hasError) {
			for (String c : mapa.keySet()) {
				System.out.println(c + ": " + mapa.get(c));
			}

		}

		scanner.close();

	}
}
