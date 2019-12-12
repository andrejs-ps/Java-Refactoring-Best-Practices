package com.onlineshop.entities;
import java.time.LocalDate;
import java.util.regex.Pattern;

import static org.testng.Assert.assertTrue;

public class Voucher {

    private String code;

    private LocalDate startDate;
    private LocalDate expiryDate;

    public Voucher(){}

    public Voucher(String code){
        // add validation here too
        this.code = code;
    }

    public String getCode() {
        return code;
    }


    public void setCode(String code){
        assertTrue(Pattern.compile("^[a-zA-Z0-9]+$").matcher(code).matches());
        this.code = code;
    }
}
