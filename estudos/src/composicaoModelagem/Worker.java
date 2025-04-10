package composicaoModelagem;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department dep = new Department();

	List<HourContract> contracts = new ArrayList<>();

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, String depName) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		dep.setName(depName);
	}

	//---------------gets & sets---------------
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}

	public String departmentName() {
		return this.dep.getName();
	}

	// Calcular salário do mês
	public Double income(Integer year, Integer month) {
		Double sum = baseSalary;
		Calendar cal = Calendar.getInstance();

		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int contractYear = cal.get(Calendar.YEAR);
			int contractMonth = cal.get(Calendar.MONTH);

			if (contractYear == year && contractMonth == month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}

}
