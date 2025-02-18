package heranca;

import infra.DAO;

public class Main {
	
	public static void main(String[] args) {
		
		Aluno a1 = new Aluno(1,"Marcos", 500.0);
		AlunoBolsista a2 = new AlunoBolsista(2, "Lucas", 500.0, 200);
		
		DAO<Aluno> dao = new DAO<>();
		
		dao.inserirAtomico(a1);
		dao.inserirAtomico(a2);
		
		dao.fechar();
	
	}

}
