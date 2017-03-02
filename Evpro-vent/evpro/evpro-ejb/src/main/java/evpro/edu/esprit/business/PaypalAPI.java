package evpro.edu.esprit.business;


import com.paypal.api.payments.CreditCard;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

public class PaypalAPI {

    public static void main(String[] args) {
        // Replace these values with your clientId and secret. You can use these to get started right now.
        String clientId = "AYSq3RDGsmBLJE-otTkBtM-jBRd1TCQwFf9RGfwddNXWz0uFU9ztymylOhRS";
        String clientSecret = "EGnHDxD_qRPdaLdZz8iCr8N7_MzF-YHPTkjs6NKYQvQSBngp4PTTVWkPZRbL";

        // Create a Credit Card
        CreditCard card = new CreditCard()
                .setType("visa")
                .setNumber("4417119669820331")
                .setExpireMonth(11)
                .setExpireYear(2019)
                .setCvv2(012)
                .setFirstName("Nasr")
                .setLastName("Med");

        try {
            APIContext context = new APIContext(clientId, clientSecret, "sandbox");
            card.create(context);
            System.out.println(card);
        } catch (PayPalRESTException e) {
            System.err.println(e.getDetails());
        }
    }
}