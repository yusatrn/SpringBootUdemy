package com.spring.core.assignment.javaconfig;

public class MySQLDataSource implements DataSource {

    @Override
    public String[] getEmails() {
        String[] emails = {"deneme@gmail.com", "yusa.turan@iski.gov.tr"};
        return emails;
    }
}
