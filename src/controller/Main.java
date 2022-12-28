package controller;
import entity.HourContract;
import entity.Departament;
import entity.WorkerLevel;
import service.Worker;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);

        Scanner scanner = new Scanner(System.in);

        Worker worker = new Worker();
        HourContract contract = new HourContract();

        worker.workerData();
        contract.quantity();

        worker.addContract(contract);

        System.out.println();

        worker.incomeTotalValue();




    }
}
