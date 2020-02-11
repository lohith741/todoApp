package com.lohith.demo.todoApp;

import com.lohith.demo.todoApp.config.DWGettingStartedConfiguration;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class App extends Application<DWGettingStartedConfiguration>
{
    public static void main( String[] args ) throws Exception
    {
    	 new App().run(args);
    }
    
    @Override
    public String getName() {
        return "main";
    }

	@Override
	public void run(DWGettingStartedConfiguration arg0, Environment arg1) throws Exception {
		// TODO Auto-generated method stub
		
	}
}
