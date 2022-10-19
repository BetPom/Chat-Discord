package trololo.commands;

import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class HelloCommand extends ListenerAdapter {
public static Boolean WasHello = false;
public static Boolean Finished = false;
public static String LastQuestion = "";
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(Finished == true){
            return;
        }
        String message = event.getMessage().getContentRaw();
        String authorName = event.getAuthor().getName();
        if(message.equalsIgnoreCase("!hello")) {
            WasHello = true;
            event.getChannel().sendMessage("cześć " + authorName).queue();
            event.getChannel().sendMessage("Gdzie mieszkasz?").queue();
            LastQuestion = "miasto";
            return;
        }

        if (LastQuestion == "miasto")
        {
            switch (message.toLowerCase()){
                case "w lublinie":
                    event.getChannel().sendMessage("ja też").queue();
                    Finished = true;
                    break;
                case "lublin":
                    event.getChannel().sendMessage("ja też").queue();
                    Finished = true;
                    break;
                case "warszawa":
                    event.getChannel().sendMessage("Jak moja siostrzyczka<3").queue();
                    Finished = true;
                    break;
                case "w warszawie":
                    event.getChannel().sendMessage("Jak moja siostrzyczka<3").queue();
                    Finished = true;
                    break;
                default:
                    if(!event.getAuthor().isBot()) {
                        event.getChannel().sendMessage(message + " to piękne miasto").queue();
                        Finished = true;
                    }

            }
//            if(message.equalsIgnoreCase("Lublin")) {
//
//            } else if (message.equalsIgnoreCase("Warszawa"))
//                event.getChannel().sendMessage("Jak moja siostrzyczka<3").queue();
//            else if(!event.getAuthor().isBot()){
//                event.getChannel().sendMessage(message + " to piękne miasto").queue();
//            }

        }

    }
}
