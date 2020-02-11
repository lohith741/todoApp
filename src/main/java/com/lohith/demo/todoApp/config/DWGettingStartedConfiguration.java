package com.lohith.demo.todoApp.config;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.Configuration;


public class DWGettingStartedConfiguration extends Configuration{

	@NotNull
    @Valid
    private DataSourceFactory dataSourceFactory = new DataSourceFactory();
	
    @JsonProperty("database")
    public DataSourceFactory getDataSourceFactory() {
        return dataSourceFactory;
    }

}
