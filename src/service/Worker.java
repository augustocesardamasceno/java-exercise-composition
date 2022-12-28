package service;

import entity.Departament;
import entity.WorkerLevel;
import entity.HourContract;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class Worker {

    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private String departmentName;

    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        contracts.add(contract);
    }

    public void removeContract(HourContract contract){
        contracts.remove(contract);
    }

    public double income (int year, int month){
        double sum = baseSalary;
        Calendar cal = Calendar.getInstance();
        for (HourContract c : contracts){
            cal.setTime(c.getDate());
            int c_year = cal.get(Calendar.YEAR);
            int c_month = 1 + cal.get(Calendar.MONTH);
            if (year == c_year && month == c_month){
                sum += c.totalValue();
            }
        }
        return sum;
    }



    public void workerData(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter departament's name: ");
        departmentName = scanner.nextLine();
        System.out.print("Enter worker data: ");
        System.out.print("Name: ");
        name = scanner.nextLine();
        System.out.print("Level: ");
        String level = scanner.nextLine();
        System.out.print("Salary: ");
        baseSalary = scanner.nextDouble();
        Worker worker = new Worker(name, WorkerLevel.valueOf(level), baseSalary, new Departament(departmentName));

    }

    public void incomeTotalValue(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scanner.next();

        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartmentName());
        System.out.println("Income for: " + monthAndYear + ": " + String.format("%2f", income(year, month)));
    }


}
