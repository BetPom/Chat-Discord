package trololo.commands;

import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Luck extends ListenerAdapter {
    public static Boolean WasLuck = false;
    public static Boolean Finished = false;
    public static String LastQuestion = "";

    public void onMessageReceived(MessageReceivedEvent event) {
        if (Finished == true) {
            return;
        }
        String messageSent = event.getMessage().getContentRaw();
            if (messageSent.equalsIgnoreCase("next")) {
                WasLuck = true;
                event.getChannel().sendMessage("Zaraz dostaniesz interaktywne życzenia, " +
                        "proszę staraj się pisać bez literówek i polskich znaków, bo mimo iż " +
                        "Twoja dziewczyna się bardzo starała, to nie jest jeszcze na tak wysokim " +
                        "poziomie (ale kiedyś Cie dogoni). Wybierz proszę liczbę w zakresie od 0-10 ile w " +
                        "tym momencie potrzebujesz szczęścia.").queue();
                LastQuestion = "lucky";
                return;
            }

            if (LastQuestion == "lucky") {
                switch (messageSent.toLowerCase()) {
                    case "0":
                        event.getChannel().sendMessage("Prawidłowo! Lubię takie pozytywne podejście " +
                                "do życia.").queue();
                        Finished = true;
                        break;
                    case "1":
                        event.getChannel().sendMessage("Tyle da się jeszcze załatwić, szczęście " +
                                "wędruje do Pana.").queue();
                        Finished = true;
                        break;
                    case "2":
                        event.getChannel().sendMessage("Ok, w takim razie życzę Ci szczęścia 2/10").queue();
                        Finished = true;
                        break;
                    case "3":
                        event.getChannel().sendMessage("Not bad. Z tym sobie poradzimy," +
                                " w takim razie życzę szczęścia.").queue();
                        Finished = true;
                        break;
                    case "4":
                        event.getChannel().sendMessage("Szczęście w ilości 4/10 wędruje do Pana.").queue();
                        Finished = true;
                        break;
                    case "5":
                        event.getChannel().sendMessage("Dobrze, przekazuję szczęście w ilości 5/10.").queue();
                        Finished = true;
                        break;
                    case "6":
                        event.getChannel().sendMessage("Wysyłam szczęście w ilości 6/10.").queue();
                        Finished = true;
                        break;
                    case "7":
                        event.getChannel().sendMessage("Uuu tu same życzenia nie wystarczą, proszę zgłosić " +
                                "się do Bej po buziaka.").queue();
                        Finished = true;
                        break;
                    case "8":
                        event.getChannel().sendMessage("Tutaj przyda się mizianko po plecach, " +
                                "proszę zgłosić się do Bej, szczęście po tym się pojawi.").queue();
                        Finished = true;
                        break;
                    case "9":
                        event.getChannel().sendMessage("To już sporo, proszę przytulić się do " +
                                "Bej i odebrać nagrodę w postaci szczęścia.").queue();
                        Finished = true;
                        break;
                    case "10":
                        event.getChannel().sendMessage("Widzę trudna sytuacja. W takim wypadku proszę " +
                                "przytulić się do Bej i odebrać nagrodę w postaci szczęścia.").queue();
                        Finished = true;
                        break;
                    default:
                        if (!event.getAuthor().isBot()) {
                            event.getChannel().sendMessage("Ziomek, to nie liczba od 0 do 10, " +
                                    "proszę czytaj ze zrozumieniem.. Dawaj jeszcze raz.").queue();
                        }

                }
            }
        }
    }