package com.github.manish4586.Rohi;

import java.util.Scanner;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.logging.BotLogger;

public class Main {
    public static void main(String[] args) {
        String botToken = "";
        
        if(args.length == 0) {
            Scanner scan = new Scanner(System.in);
            botToken = scan.next();
        } else {
            botToken = args[0];
        }

        ApiContextInitializer.init();

        TelegramBotsApi botsApi = new TelegramBotsApi();

        try {
            botsApi.registerBot(new Rohi(botToken, "Rohi"));
        } catch (TelegramApiRequestException e) {
            BotLogger.error("Oops, something went wrong while registering bot! Try again", e);
        }
    }
}
