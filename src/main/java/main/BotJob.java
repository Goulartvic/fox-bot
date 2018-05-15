package main;

import bot.Bot;
import email.SendEmail;

public class BotJob implements Runnable{

    private String emailTo;

    private double bitcoinCompare = 0;

    private double bitcoinVariation;

    public BotJob(String emailTo, double bitcoinVariation) {
        this.emailTo = emailTo;
        this.bitcoinVariation = bitcoinVariation/100;
    }

    public void run() {
        Bot bot = new Bot();
        SendEmail sendEmail = new SendEmail();
        double bitcoinPriceNow = Double.parseDouble(bot.getBitcoinPrice());
        if (bitcoinCompare == 0) {
            bitcoinCompare = bitcoinPriceNow;
            sendEmail.sendBitcoinPrice(bitcoinPriceNow, emailTo);
        } else {
            double bitcoinPriceUp = bitcoinPriceNow + (bitcoinPriceNow*bitcoinVariation);
            double bitcoinPriceDown = bitcoinPriceNow - (bitcoinPriceNow*bitcoinVariation);

            if (bitcoinCompare>bitcoinPriceUp||bitcoinCompare<bitcoinPriceDown) {
                bitcoinCompare = bitcoinPriceNow;
                sendEmail.sendBitcoinPrice(bitcoinCompare, emailTo);
            }
            else {
                System.out.println("Variação dentro dos limites");
            }
        }
    }
}
