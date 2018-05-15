package main;

import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Para qual email deseja enviar a cotação");
        String emailTo = scanner.next();
        System.out.println("Qual intervalo de horas o bot vai verificar a cotação");
        int period = scanner.nextInt();
        System.out.println("Porcentagem de variação para enviar o e-mail");
        double variation = scanner.nextDouble();

        BotJob botJob = new BotJob(emailTo, variation);

        ScheduledThreadPoolExecutor scheduler = new ScheduledThreadPoolExecutor(1);
        scheduler.scheduleAtFixedRate(botJob, 0, period, TimeUnit.HOURS);
    }
}
