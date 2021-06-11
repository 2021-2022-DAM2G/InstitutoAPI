package org.iesfm.instituto.services;

import org.iesfm.instituto.services.HighSchool;
import org.iesfm.instituto.services.db.MysqlHighSchool;
import org.iesfm.instituto.services.inmemory.InMemoryHighSchool;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HighSchoolConfiguration {

    @Bean
    public HighSchool getHighSchool() {
        return new MysqlHighSchool();
    }
}
