package exercicio_Lista_AumentoFuncionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exec {

	public static void main(String[] args) {

		Scanner entrada = new Scanner(System.in);

		int qtdFuncionarios; // Quantos funcionários terá

		int idFuncionario;
		String nomeFuncionario;
		double salarioFuncionario;

		int idAlterar;
		Integer pos;
		List<Funcionario> listaDeFuncionarios = new ArrayList<Funcionario>();

		System.out.print("Digite quantos funcionários irá cadastrar: ");
		qtdFuncionarios = entrada.nextInt();
		System.out.println();

		for (int i = 1; i <= qtdFuncionarios; i++) {

			System.out.println("Funcionário " + i + ":");
			System.out.print("Digite o ID do funcionário: ");
			idFuncionario = entrada.nextInt();
			entrada.nextLine();
			
			while(hasId(listaDeFuncionarios, idFuncionario)) {
				System.out.println("ID já cadastrado, insira outro: ");
				idFuncionario = entrada.nextInt();
				entrada.nextLine();
			}

			System.out.print("Digite o nome do funcionário: ");
			nomeFuncionario = entrada.nextLine();

			System.out.print("Digite o salario do funcionário: ");
			salarioFuncionario = entrada.nextDouble();
			entrada.nextLine();
			System.out.println();

			listaDeFuncionarios.add(new Funcionario(idFuncionario, nomeFuncionario, salarioFuncionario));
		}
			System.out.println("Digite o ID do funcionário que terá aumento de salário: ");
			idAlterar = entrada.nextInt();
			entrada.nextLine();

			pos = position(listaDeFuncionarios, idAlterar);

			if (pos != null) {

				System.out.println("Porgentagem para aumento: ");
				double porcentagem = entrada.nextDouble();

				for (Funcionario f : listaDeFuncionarios) {
					if (f.getId() == idAlterar) {
						f.recalcularSalario(porcentagem);
					}
				}
				
			} else {
				System.out.println("funcionário não encontrado");
			}

			for (Funcionario f : listaDeFuncionarios) {
				System.out.println(f);

			}
		

		entrada.close();
	}

	static public Integer position(List<Funcionario> lista, int id) {
		for (int i = 0; i < lista.size(); i++) {
			if (id == lista.get(i).getId()) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean hasId(List<Funcionario> lista, int id) {
		Funcionario fun = lista.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return fun != null;
	}
}