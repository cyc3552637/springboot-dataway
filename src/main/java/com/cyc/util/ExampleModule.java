package com.cyc.util;

import net.hasor.core.ApiBinder;
import net.hasor.core.DimModule;
import net.hasor.db.JdbcModule;
import net.hasor.db.Level;
import net.hasor.spring.SpringModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@DimModule
@Component
public class ExampleModule implements SpringModule {
    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource = null;

    @Override
    public void loadModule(ApiBinder apiBinder) throws Throwable {
        // .DataSource form Spring boot into Hasor
        apiBinder.installModule(new JdbcModule(Level.Full, this.dataSource));
    }
}
