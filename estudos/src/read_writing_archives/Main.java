package read_writing_archives;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Locale;

public class Main {
    
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);        
        
        String inputPath = "C:\\temp\\in.csv";
        String outputPath = "C:\\temp\\out\\summary.csv";
        
        // Criar diretório de saída se não existir
        new File("C:\\temp\\out").mkdirs();
        
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             BufferedWriter bw = new BufferedWriter(new FileWriter(outputPath))) { // Criar o BufferedWriter aqui
             
            String line = br.readLine();            
            while (line != null) {                    
                String[] values = line.split(","); // Criar um vetor de strings, usando a line do txt, separando cada elemento por ","
                String nome = values[0];
                Double preco = Double.parseDouble(values[1]);
                int quantidade = Integer.parseInt(values[2]);
                
                // Calcular o total e formatar a linha de saída
                String outputLine = nome + "," + String.format("%.2f", preco * quantidade);
                
                // Escrever a linha formatada no arquivo de saída
                bw.write(outputLine);
                bw.newLine();
                
                line = br.readLine(); // Ler a próxima linha
            }            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
