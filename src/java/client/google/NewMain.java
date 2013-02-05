package client.google;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.Name;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author damien
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, AuthenticationException, IOException, ServiceException {
        // Request the feed
        ContactsService myService = new ContactsService("google-contacts");
        myService.setUserCredentials("ches.damien@gmail.com", "mdp"); // Request the feed
        URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full");
        Query myQuery = new Query(feedUrl);
        myQuery.setStartIndex(-1);
        myQuery.setMaxResults(100);
        ContactFeed resultFeed = myService.getFeed(myQuery, ContactFeed.class);
        resultFeed.setStartIndex(0);
        resultFeed.setItemsPerPage(50);

        System.out.println("ITEM PAR PAGE :" + resultFeed.getItemsPerPage());
        System.out.println(resultFeed.getTitle().getPlainText());
        System.out.println("NB RESULT : " + resultFeed.getItemsPerPage());
        int i = 0;
        for (ContactEntry entry : resultFeed.getEntries()) {

            if (entry.hasName()) {
                Name name = entry.getName();
                if (name.hasFullName()) {
                    String fullNameToDisplay = name.getFullName().getValue();
                    if (name.getFullName().hasYomi()) {
                        fullNameToDisplay += " (" + name.getFullName().getYomi() + ")";
                    }
                    System.out.println("\\\t\\\t" + fullNameToDisplay);
                } else {
                    System.out.println("\\\t\\\t (no full name found)");
                }


            } else {
                System.out.println("\t (no name found)");
            }





            System.out.println("TOTAL : " + i);
            i++;
        }
    }
}
