/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.google;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.PhoneNumber;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author damien
 */
public class GoogleContacts {

    public List<Contact> getGoogleContacts(String email, String password) throws AuthenticationException,
            MalformedURLException, IOException, ServiceException {
        List<Contact> contacts = new ArrayList<Contact>();
        Random random = new Random();
        ContactsService myService = new ContactsService("securisation-site-gvi-web"+random.nextInt(1000000));
        myService.setUserCredentials(email, password);
        URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full/");
        Query myQuery = new Query(feedUrl);
        myQuery.setStartIndex(-1);
        myQuery.setMaxResults(100);
        ContactFeed resultFeed = myService.getFeed(myQuery, ContactFeed.class);
        resultFeed.setItemsPerPage(0);
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            ContactEntry entry = resultFeed.getEntries().get(i);
            String nompersonne = entry.getTitle().getPlainText();
            String emailpersonne = null;
            for (Email email2 : entry.getEmailAddresses()) {
                emailpersonne = email2.getAddress();
            }
            String telephone = null;
            for (PhoneNumber phone : entry.getPhoneNumbers()) {
                telephone = phone.getPhoneNumber();
            }
            String photoLink = entry.getContactPhotoLink().getHref();
            if (telephone != null) {
                Contact c = new Contact(nompersonne, telephone, emailpersonne);
                contacts.add(c);
            }
        }
        return contacts;
    }
}
