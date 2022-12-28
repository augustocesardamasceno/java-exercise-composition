package entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class HourContract {

    private Date date;
    private double valuePerHour;
    private Integer hour;

    public HourContract() {
    }

    public HourContract(Date date, double valuePerHour, Integer hour, int contractNumber) {
        this.date = date;
        this.valuePerHour = valuePerHour;
        this.hour = hour;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getValuePerHour() {
        return valuePerHour;
    }

    public void setValuePerHour(double valuePerHour) {
        this.valuePerHour = valuePerHour;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }


    public double totalValue(){
       return valuePerHour * hour;
    }

    public void quantity() throws ParseException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many contracts to this worker: ");
        int contractNumber = scanner.nextInt();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        HourContract contract = new HourContract();

        for (int i = 1; i <= contractNumber; i++){
            System.out.println("Enter contract #" +  i + " data: ");

            System.out.print("Date (DD/MM/YYYY): ");
            Date date = sdf.parse(scanner.next());
            setDate(date);

            System.out.print("Value per hour: ");
            valuePerHour = scanner.nextDouble();

            System.out.print("Duration: ");
            hour = scanner.nextInt();
        }

    }


}
