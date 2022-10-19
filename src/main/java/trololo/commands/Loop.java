package trololo.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Loop extends ListenerAdapter {

    public static Boolean WasStart = false;
    public static String LastQuestion = "";

    public static Boolean Finished = false;

    public void onMessageReceived(MessageReceivedEvent event) {
        if (Finished == true) {
            return;
        }
        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.equalsIgnoreCase("start")) {
            WasStart = true;
            event.getChannel().sendMessage("Łukasz, czego szukasz?").queue();
            LastQuestion = "searching";
            return;
        }
        if (LastQuestion == "searching") {
            switch (messageSent.toLowerCase()) {
                case "szczescia":
                    event.getChannel().sendMessage("Szczęście stoi koło Ciebie ;)").queue();
                    Finished = true;
                    break;
                case "pieniedzy":
                    event.getChannel().sendMessage("Na hajsik przyjdzie czas.").queue();
                    Finished = true;
                    break;
                case "milosci":
                    event.getChannel().sendMessage("A już nie znalazłeś? ^^").queue();
                    Finished = true;
                    break;
                case "niczego":
                    event.getChannel().sendMessage("Czyli już wszystko masz?").queue();
                    Finished = true;
                    break;
                default:
                    if (!event.getAuthor().isBot()) {
                        event.getChannel().sendMessage(messageSent + "? Ok, takiej odpowiedzi się nie " +
                                "spodziewałam, zaskakujesz jak zawsze.").queue();
                        Finished = true;
                    }

            }
        }
    }
}