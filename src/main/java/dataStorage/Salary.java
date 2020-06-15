package dataStorage;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Salary {
	private double bruttoSalry;
	private double nettonSalary;
	
	private double pensionContribution;
	private double disabilityPensionContribution;
	private double sicknessContribution;
	private double incomeTax;
	
public Salary(double bruttoSalary) {
	this.bruttoSalry = bruttoSalary;
	
}	



}
