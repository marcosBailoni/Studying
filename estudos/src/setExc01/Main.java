package setExc01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	public static void main(String[] args) {

//		String path = "C:\\temp\\testeSet.csv";
		
		Scanner entrada = new Scanner(System.in);
		
		System.out.print("Digite o caminho do arquivo: ");
		String path = entrada.nextLine();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<LogEntry> logs = new HashSet<>();

			String line = br.readLine();
			
			while(line != null) {
				
				String[] read = line.split(" ");
				
				logs.add(new LogEntry(read[0], Date.from(Instant.parse(read[1]))));
				
				line = br.readLine();
			}
			
			System.out.println("Total users: " + logs.size());
			
		} catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		} 
		
		entrada.close();		
	}

}
