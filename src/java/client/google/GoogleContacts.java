/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.google;

import com.google.gdata.client.Query;
import com.google.gdata.client.contacts.ContactsService;
import com.google.gdata.data.contacts.ContactEntry;
import com.google.gdata.data.contacts.ContactFeed;
import com.google.gdata.data.contacts.GroupMembershipInfo;
import com.google.gdata.data.extensions.Email;
import com.google.gdata.data.extensions.ExtendedProperty;
import com.google.gdata.data.extensions.Im;
import com.google.gdata.data.extensions.PhoneNumber;
import com.google.gdata.util.AuthenticationException;
import com.google.gdata.util.ServiceException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author damien
 */
public class GoogleContacts {
    public List<Contact> getGoogleContacts(String email, String password) throws AuthenticationException, MalformedURLException, IOException, ServiceException{
        List<Contact> contacts = new ArrayList<Contact>();
        ContactsService myService = new ContactsService("securisation-site-gvi-web");
        myService.setUserCredentials(email, password);
        URL feedUrl = new URL("https://www.google.com/m8/feeds/contacts/default/full/");//
        
        Query myQuery = new Query(feedUrl);
        myQuery.setStartIndex(-1);
        myQuery.setMaxResults(100);
        ContactFeed resultFeed = myService.getFeed(myQuery, ContactFeed.class);
        resultFeed.setItemsPerPage(0);
        System.out.println(resultFeed.getTitle().getPlainText());
        System.out.println(resultFeed.getEntries().size() + "NB RESUT TOTAL");
        for (int i = 0; i < resultFeed.getEntries().size(); i++) {
            ContactEntry entry = resultFeed.getEntries().get(i);
            System.out.println("\t" + entry.getTitle().getPlainText());
            String nompersonne = entry.getTitle().getPlainText();
            System.out.println("Email addresses:");
            String emailpersonne = null;
            for (Email email2 : entry.getEmailAddresses()) {
                emailpersonne = email2.getAddress();
                System.out.print(" " + email2.getAddress());
                if (email2.getRel() != null) {
                    System.out.print(" rel:" + email2.getRel());
                }
                if (email2.getLabel() != null) {
                    System.out.print(" label:" + email2.getLabel());
                }
                if (email2.getPrimary()) {
                    System.out.print(" (primary) ");
                }
                System.out.print("\n");
            }
             String telephone = null;
                    for (PhoneNumber phone : entry.getPhoneNumbers()) {
                        telephone = phone.getPhoneNumber();
                System.out.print(" " + phone.getPhoneNumber());
                if (phone.getRel() != null) {
                    System.out.print(" rel:" + phone.getRel());
                }
                if (phone.getLabel() != null) {
                    System.out.print(" label:" + phone.getLabel());
                }
                if (phone.getPrimary()) {
                    System.out.print(" (primary) ");
                }
                System.out.print("\n");
            }
            System.out.println("IM addresses:");
            for (Im im : entry.getImAddresses()) {
                System.out.print(" " + im.getAddress());
                if (im.getLabel() != null) {
                    System.out.print(" label:" + im.getLabel());
                }
                if (im.getRel() != null) {
                    System.out.print(" rel:" + im.getRel());
                }
                if (im.getProtocol() != null) {
                    System.out.print(" protocol:" + im.getProtocol());
                }
                if (im.getPrimary()) {
                    System.out.print(" (primary) ");
                }
                System.out.print("\n");
            }

            System.out.println("Groups:");
            for (GroupMembershipInfo group : entry.getGroupMembershipInfos()) {
                String groupHref = group.getHref();
                System.out.println("  Id: " + groupHref);
            }

            System.out.println("Extended Properties:");
            for (ExtendedProperty property : entry.getExtendedProperties()) {
                if (property.getValue() != null) {
                    System.out.println("  " + property.getName() + "(value) = "
                            + property.getValue());
                } else if (property.getXmlBlob() != null) {
                    System.out.println("  " + property.getName() + "(xmlBlob)= "
                            + property.getXmlBlob().getBlob());
                }
            }

            String photoLink = entry.getContactPhotoLink().getHref();
            System.out.println("Photo Link: " + photoLink);

            Contact c = new Contact(nompersonne, telephone,emailpersonne);
            System.out.println("Contact's ETag: " + entry.getEtag());
            contacts.add(c);
        }
        return contacts;
    }
}
