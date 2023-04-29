package patternmatching.payment;

public class PaymentProcessor {
    public void process(Instrument instrument){
        switch (instrument){
            case Cash cash: System.out.println("cash"); break;
            case CreditCard card : System.out.println("credit card");break;
            case UPI upi : System.out.println("upi");
                break;
        }
    }
}
