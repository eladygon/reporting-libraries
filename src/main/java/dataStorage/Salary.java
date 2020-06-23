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
	private double healthCareContribution;
	private double incomeTax;
	private double incomeTaxFinal;
	
public Salary(double bruttoSalary) {
	this.bruttoSalry = bruttoSalary;
	this.pensionContribution = 0.0976*bruttoSalry;
	this.disabilityPensionContribution =  0.015*bruttoSalry;
	this.sicknessContribution = 0.0245*bruttoSalry;
	this.healthCareContribution = 0.09*(bruttoSalary-sumOfContribution());
	this.incomeTax = 0.17*(bruttoSalary-sumOfContribution()-250)-43.76;
	this.incomeTaxFinal =incomeTaxAlgorithm(); 
	this.nettonSalary = bruttoSalary-sumOfContribution()-this.healthCareContribution-this.incomeTaxFinal;
	}	

private double sumOfContribution() {
	return pensionContribution+disabilityPensionContribution+sicknessContribution;
}
private double incomeTaxAlgorithm() {
	double sevenPercenthealthCareContribution =  0.0775*(this.bruttoSalry-sumOfContribution());
	return this.incomeTax-sevenPercenthealthCareContribution;
} 

public String getNettoSalary() {
	return "For brutto salary: "+ this.bruttoSalry +" netto is: "+this.nettonSalary;
	}


}
