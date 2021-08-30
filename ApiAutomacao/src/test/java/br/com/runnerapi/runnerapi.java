package br.com.runnerapi;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		
	features = "classpath:feature/",
	plugin = "pretty",
	monochrome = true,
	tags = "@Cenario1,@Cenario2,@Cenario3,@Cenario4,@Cenario5,@Cenario6,@Cenario7,@Cenario8,@Cenario9,@Cenario10,@Cenario11,@Cenario12,@Cenario13",
	glue = {"br.com.stepsapi"})

public class runnerapi {
	
	
}
