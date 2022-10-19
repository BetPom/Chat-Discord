package trololo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import trololo.commands.*;

import javax.security.auth.login.LoginException;


public class Main {
    public static void main(String[] args) throws LoginException {

        JDA jda = JDABuilder.createDefault(Main.TOKEN).build();

        jda.addEventListener(new HelloCommand());
        jda.addEventListener(new Loop());
        jda.addEventListener(new Luck());
        jda.addEventListener(new tescik());
        jda.addEventListener(new picture());
        jda.addEventListener(new wishes());

    }

    private static final String TOKEN = "MTAwNjU5MjYyNTUwOTQyMTE2Ng.Gzzbfu.xYRw-Af7prL3yYITtuD9bcM06CNpxg_OKZbpeM";

    private static class TOKEN {
    }
}
