package trololo.commands;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.MessageChannel;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.io.File;

public class picture extends ListenerAdapter {

    public static Boolean WasPicture = false;
    public static Boolean Finished = false;
    public static String LastQuestion = "";




    public void onMessageReceived(MessageReceivedEvent event) {
        if (Finished == true) {
            return;
        }
        String messageSent = event.getMessage().getContentRaw();
        if (messageSent.equalsIgnoreCase("next3")) {
            WasPicture = true;
            event.getChannel().sendMessage("Teraz wybierz prezent niespodzianke. " +
                    "Wybierz A lub B").queue();
            LastQuestion = "picture";
            return;
        }
        EmbedBuilder eb;
        eb = new EmbedBuilder();

        if (LastQuestion == "picture") {
            switch (messageSent.toLowerCase()) {
                case "a":
                    MessageChannel channel = event.getChannel();
                    channel.sendMessage("Wszystkiego najlepszego! ")
                            .addFile(new File("C:\\java\\foto1.jpg"))
                            .queue(); // this actually sends the information to discord
                    Finished = true;
                    break;
                case "b":
                    MessageChannel channel1 = event.getChannel();
                    channel1.sendMessage("Wszystkiego najlepszego! Żebyś zawsze był taki uśmiechnięty <3")
                            .addFile(new File("C:\\java\\foto2.jpg"))
                            .queue(); // this actually sends the information to discord
                    Finished = true;
                    break;
                default:
                    if (!event.getAuthor().isBot()) {
                        event.getChannel().sendMessage("To nie jest A ani B.").queue();

                    }

            }
        }
    }

}
