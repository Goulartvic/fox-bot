package main;

import bot.Bot;
import email.SendEmail;

public class RunBot {

    public static void main(String[] args) {
        Bot bot = new Bot();
        SendEmail sendEmail = new SendEmail();

        sendEmail.sendBitcoinPrice(bot.getBitcoinPrice());
    }
}
