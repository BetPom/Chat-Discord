package trololo.commands;

import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class wishes extends ListenerAdapter {


    public static Boolean WasWish = false;
    public static Boolean Finished = false;
    public static String LastQuestion = "";


    public void onMessageReceived(MessageReceivedEvent event) {
        if (Finished == true) {
            return;
        }
        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.equalsIgnoreCase("next4")) {
            WasWish = true;
            event.getChannel().sendMessage("To czego chciałabym Ci jeszcze życzyć, " +
                    "to siła, żebyś dawał rade z tymi prackami i ze swoja dziewczyną^^. " +
                    "Czasu, żebyś zdążył zrealizować wszystkie swoje pomysły i zwiedzić cały świat. " +
                    "Spełnienia marzeń, bo zasługujesz na wszystko co najlepsze. " +
                    "Dziękuję Ci za to, że nie zamknąłeś tej furtki i mogę Cie dalej poznawać, " +
                    "jesteś wspaniałą osobą i masz ogromne serducho, czuję to. Jak dla mnie to " +
                    "nigdy się nie zmieniaj, bo jesteś wielki i osiągniesz w życiu wspaniałe rzeczy.").queue();
            event.getChannel().sendMessage("Twoja Bej <3").queue();
            event.getChannel().sendMessage("Jak podobała Ci się aplikacja? (Fajna/niefajna) ").queue();

            LastQuestion = "wishes";
            return;
        }
        if (LastQuestion == "wishes") {
            switch (messageSent.toLowerCase()) {
                case "fajna":
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage("Prawidłowa odpowiedź! Masz na koniec dwa słodziaki. Dobra, jednego " +
                                    "słodziaka i jednego sexi mana.")
                            .addFile(new File("C:\\java\\foto3.jpg"))
                            .queue(); // this actually sends the information to discord
                    Finished = true;
                    break;
                case "niefajna":
                    event.getChannel().sendMessage("Ok, to zrób sobie lepszą, a ta aplikacja " +
                            "ulegnie samodestrukcji za 10").queue();
                    event.getChannel().sendMessage("9").queue();
                    event.getChannel().sendMessage("8").queue();
                    event.getChannel().sendMessage("7").queue();
                    event.getChannel().sendMessage("6").queue();
                    event.getChannel().sendMessage("5").queue();
                    event.getChannel().sendMessage("4").queue();
                    event.getChannel().sendMessage("3").queue();
                    event.getChannel().sendMessage("2").queue();
                    event.getChannel().sendMessage("1").queue();
                    event.getChannel().sendMessage("0").queue();
                    event.getChannel().sendMessage("Dobra żart, nie umiem tak zrobić.").queue();
                    Finished = true;
                    break;

                default:
                    if (!event.getAuthor().isBot()) {
                        event.getChannel().sendMessage("Wybierz fajna/niefajna.").queue();
                    }

            }
        }
    }

}
