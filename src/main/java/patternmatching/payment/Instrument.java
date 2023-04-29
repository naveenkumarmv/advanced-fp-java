package patternmatching.payment;

public abstract sealed class Instrument permits Cash, CreditCard, UPI{
}
