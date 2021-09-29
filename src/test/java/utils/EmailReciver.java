package utils;

import java.util.Properties;
import java.io.IOException;
import java.util.Properties;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import com.sun.mail.pop3.POP3Store;

public class EmailReciver {
    public static String receiveEmail(String pop3Host, String storeType,
                                    String user, String password) {
        String result = "";
        try {
            //1) get the session object
            Properties properties = new Properties();
            properties.put("mail.pop3.host", pop3Host);
            properties.put("mail.pop3.ssl.enable", true);
            properties.put("mail.pop3.ssl.trust", "*");
            properties.put("mail.pop3.port", 995);
            Session emailSession = Session.getDefaultInstance(properties);

            //2) create the POP3 store object and connect with the pop server
            POP3Store emailStore = (POP3Store) emailSession.getStore(storeType);
            emailStore.connect(user, password);

            //3) create the folder object and open it
            Folder emailFolder = emailStore.getFolder("INBOX");
            emailFolder.open(Folder.READ_ONLY);

            //4) retrieve the messages from the folder in an array and print it
            Message[] messages = emailFolder.getMessages();
            for (int i = messages.length-1; i<messages.length; i++) {
                Message message = messages[i];
                System.out.println("---------------------------------");
                System.out.println("Email Number " + (i + 1));
                System.out.println("Subject: " + message.getSubject());
                System.out.println("From: " + message.getFrom()[0]);
                System.out.println("Text: " + message.getContent().toString());
                result = result.concat(message.getSubject());
            }
            //5) close the store and folder objects
            emailFolder.close(false);
            emailStore.close();

            return result;
        } catch (NoSuchProviderException e) {e.printStackTrace(); return "";}
        catch (MessagingException e) {e.printStackTrace(); return "";}
        catch (IOException e) {e.printStackTrace(); return "";}
    }
    public static String readEmail(){
        String host = "pop.gmail.com";//change accordingly
        String mailStoreType = "pop3";
        String username= "shalyap3211@gmail.com";
        String password= "Qwerty228";//change accordingly

        return receiveEmail(host, mailStoreType, username, password);
    }
}
