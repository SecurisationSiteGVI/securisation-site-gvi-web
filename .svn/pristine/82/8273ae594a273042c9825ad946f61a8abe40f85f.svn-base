/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package client.validators;

import client.BoiteAOutils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author damien
 */
@FacesValidator(value = "phoneNumberValidator")
public class PhoneNumberValidator implements Validator {

    private static final String PHONE_PATTERN = "^0[0-68]([-. ]?\\d{2}){4}[-. ]?$";
    private Pattern pattern;
    private Matcher matcher;

    public PhoneNumberValidator() {
        pattern = Pattern.compile(PHONE_PATTERN);
    }

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object value) throws ValidatorException {
        System.out.println(value);
        matcher = pattern.matcher(value.toString());
        if (!matcher.matches()) {
            FacesMessage msg = BoiteAOutils.addMessage("Impossible de valider le numéro", " le format n'est pas correct", "phone");
            throw new ValidatorException(msg);

        }
    }
}
