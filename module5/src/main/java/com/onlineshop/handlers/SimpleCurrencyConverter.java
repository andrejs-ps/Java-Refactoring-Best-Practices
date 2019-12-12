package com.onlineshop.handlers;

public class SimpleCurrencyConverter {

    private HttpHelper httpHelper = new HttpHelper();
    private String currencyTo;

    public SimpleCurrencyConverter(){}


    public SimpleCurrencyConverter(String currencyTo){
        this.currencyTo = currencyTo;
    }

    public double convert(double price){

        if(currencyTo.equalsIgnoreCase("EUR")){
            return price * 0.9;
        } else if (currencyTo.equalsIgnoreCase("CAD")){
            return price* 1.35;
        } else {
            throw new IllegalArgumentException("Unrecognized currency : " + currencyTo);
        }
    }


    public double convertWithWebService(double price){

        String rates = httpHelper.getCurrencyRate("USD");

        if(currencyTo.equalsIgnoreCase("EUR")){
            return price * getRate(rates, "EUR");

        } else if (currencyTo.equalsIgnoreCase("CAD")){
            return price * getRate(rates, "CAD");

        } else {
            throw new IllegalArgumentException("Unrecognized currency : " + currencyTo);
        }
    }

    public void printUsdRateFor(String currencyTo){

        String rates = httpHelper.getCurrencyRate("USD");
        System.out.println(getRate(rates, currencyTo));
    }



    private double getRate(String rates, String currencyTo) {
        return Double.valueOf(rates.substring(rates.lastIndexOf(currencyTo)).substring(5,9));
    }


}
