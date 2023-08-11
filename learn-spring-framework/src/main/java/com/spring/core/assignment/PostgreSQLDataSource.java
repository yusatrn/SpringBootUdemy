package com.spring.core.assignment;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class PostgreSQLDataSource implements DataSource{
    @Override
    public String[] getEmails() {
        String[] emails = {"deneme@gmail.com", "yusa.turan@iski.gov.tr"};
        return emails;
    }
}
