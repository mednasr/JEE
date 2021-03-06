// #SaleRefund Sample
// This sample code demonstrate how you can 
// process a refund on a sale transaction created 
// using the Payments API.
// API used: /v1/payments/sale/{sale-id}/refund
package java.com.paypal.api.payments.servlet;

import static java.com.paypal.api.payments.util.SampleConstants.clientID;
import static java.com.paypal.api.payments.util.SampleConstants.clientSecret;
import static java.com.paypal.api.payments.util.SampleConstants.mode;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.paypal.api.payments.Amount;
import com.paypal.api.payments.Refund;
import com.paypal.api.payments.Sale;
import java.com.paypal.api.payments.util.ResultPrinter;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;


public class SaleRefundServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}

	// ##RefundSale
	// Sample showing how to refund
	// a sale
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// ###Sale
		// A sale transaction.
		// Create a Sale object with the
		// given sale transaction id.
		Sale sale = new Sale();
		sale.setId("03W403310B593121A");

		// ###Refund
		// A refund transaction.
		// Use the amount to create
		// a refund object
		 Refund refund = new Refund();
		// ###Amount
		// Create an Amount object to
		// represent the amount to be
		// refunded. Create the refund object, if the refund is partial
		 Amount amount = new Amount();
		 amount.setCurrency("USD");
		 amount.setTotal("0.01");
		 refund.setAmount(amount);
		try {
			// ### Api Context
			// Pass in a `ApiContext` object to authenticate
			// the call and to send a unique request id
			// (that ensures idempotency). The SDK generates
			// a request id if you do not pass one explicitly.
			APIContext apiContext = new APIContext(clientID, clientSecret, mode);
			
			// Refund by posting to the APIService
			// using a valid AccessToken
			sale.refund(apiContext, refund);
			ResultPrinter.addResult(req, resp, "Sale Refunded", Sale.getLastRequest(), Sale.getLastResponse(), null);
		} catch (PayPalRESTException e) {
			ResultPrinter.addResult(req, resp, "Sale Refunded", Sale.getLastRequest(), null, e.getMessage());
		}

		req.getRequestDispatcher("response.jsp").forward(req, resp);
	}

}
