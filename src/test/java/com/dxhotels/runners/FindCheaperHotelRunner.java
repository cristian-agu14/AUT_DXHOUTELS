package com.dxhotels.runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/hotels.feature", glue = "com.dxhotels.definitions",
snippets = SnippetType.CAMELCASE)
public class FindCheaperHotelRunner {

}
