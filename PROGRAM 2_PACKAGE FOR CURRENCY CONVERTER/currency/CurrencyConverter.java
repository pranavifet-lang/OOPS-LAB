package currency;

public class CurrencyConverter {
    private static final double USD_TO_INR = 83.0;
    private static final double EUR_TO_INR = 90.0;
    private static final double GBP_TO_INR = 105.0;

    public static double dollarToRupee(double usd) { return usd * USD_TO_INR; }
    public static double rupeeToDollar(double inr)  { return inr / USD_TO_INR; }
    public static double euroToRupee(double eur)    { return eur * EUR_TO_INR; }
    public static double rupeeToEuro(double inr)    { return inr / EUR_TO_INR; }
    public static double poundToRupee(double gbp)   { return gbp * GBP_TO_INR; }
    public static double rupeeToPound(double inr)   { return inr / GBP_TO_INR; }
}
