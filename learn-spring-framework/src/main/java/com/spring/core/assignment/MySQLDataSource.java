package com.spring.core.assignment;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataSource implements DataSource{

    @Override
    public String[] getEmails() {
        String[] emails = {"deneme@gmail.com", "yusa.turan@iski.gov.tr"};
        return emails;
    }
}
