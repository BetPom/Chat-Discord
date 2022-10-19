package trololo.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class tescik extends ListenerAdapter {

        public static Boolean Wastescik = false;
        public static Boolean Finished = false;
        public static String LastQuestion = "";

        public void onMessageReceived(MessageReceivedEvent event) {
            if (Finished == true) {
                return;
            }
            String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equalsIgnoreCase("next2")) {
                Wastescik = true;
                event.getChannel().sendMessage("To może teraz inaczej, żeby nie było " +
                        "nudno. Zrobimy mały teścik, ostrzegam, że bez prawidłowej odpowiedzi " +
                        "nie pójdziemy dalej, ale wierzę w Ciebie i wiem, że sobie poradzisz. " +
                        "Oto pytanie: Którego dnia tygodnia poznałeś Bej?").queue();
                LastQuestion = "tescik";
                return;
            }

            if (LastQuestion == "tescik") {
                switch (messageSent.toLowerCase()) {
                    case "poniedzialek":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz.").queue();

                        break;
                    case "wtorek":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz.").queue();

                        break;
                    case "sroda":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz").queue();

                        break;
                    case "czwartek":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz.").queue();

                        break;
                    case "piatek":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz.").queue();

                        break;
                    case "sobota":
                        event.getChannel().sendMessage("... Załóżmy, że tego nie widziałam, spróbuj jeszcze raz.").queue();
                        break;
                    case "niedziela":
                        event.getChannel().sendMessage("Prawidłowa odpowiedź! Wygrywasz kolejne życzenie jakim" +
                                " jest: WYTRWAŁOŚĆ. Teraz żaden task/ticket Ci nie straszny!").queue();
                        Finished = true;
                        break;
                    default:
                        if (!event.getAuthor().isBot()) {
                            event.getChannel().sendMessage("To chyba nie dzień tygodnia?").queue();

                        }

                }
            }
        }
    }


