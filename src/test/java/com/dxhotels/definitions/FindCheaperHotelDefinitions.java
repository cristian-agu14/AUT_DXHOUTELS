package com.dxhotels.definitions;


import java.io.FileNotFoundException;
import java.io.IOException;

import com.dxhotels.utils.WebDriverFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class FindCheaperHotelDefinitions {

	@Before
	public void configuracionInicial() {
		OnStage.setTheStage(new OnlineCast());
	}
	
	@Given("I want to open (.*) page")
	public void iWantToOpenDxhoutelsPage(String page) throws FileNotFoundException, IOException {
		OnStage.theActorCalled("Carolina").whoCan(BrowseTheWeb.with(WebDriverFactory.web().onPage(page)));

	}

	@Given("^I into the location:San Francisco check in:(\\d+)/(\\d+)/(\\d+) check out:(\\d+)/(\\d+)/(\\d+) rooms:(\\d+) adults:(\\d+) and children:$")
	public void iIntoTheLocationSanFranciscoCheckInCheckOutRoomsAdultsAndChildren(int arg1, int arg2, int arg3,
			int arg4, int arg5, int arg6, int arg7, int arg8) {

	}

	@When("^The robot saves the data finded$")
	public void theRobotSavesTheDataFinded() {

	}

	@When("^The robot finds the cheaper hotel$")
	public void theRobotFindsTheCheaperHotel() {

	}

	@Then("^The robot shows the cheaper hotel$")
	public void theRobotShowsTheCheaperHotel() {

	}

	@Then("^check more outcomes$")
	public void checkMoreOutcomes() {

	}

}
