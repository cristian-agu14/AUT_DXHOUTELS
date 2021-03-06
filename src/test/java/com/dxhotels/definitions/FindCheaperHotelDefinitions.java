package com.dxhotels.definitions;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.dxhotels.exceptions.Exceptions;
import com.dxhotels.questions.TheTotalToPayIs;
import com.dxhotels.tasks.FindAHotel;
import com.dxhotels.tasks.GetInfoHotels;
import com.dxhotels.tasks.SelectCheaper;
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

	@Given("I into the location:(.*) check in:(.*) check out:(.*) rooms:(.*) adults:(.*) and children:(.*)")
	public void intoTheInfo(String location, String checkin, String checkout, String rooms, String adults,
			String children) {

		theActorInTheSpotlight()
				.attemptsTo(FindAHotel.wihtThisFeatures(location, checkin, checkout, rooms, adults, children));

	}

	@When("^The robot saves the data finded$")
	public void theRobotSavesTheDataFinded() {
		theActorInTheSpotlight().attemptsTo(GetInfoHotels.inPage());
	}

	@When("^The robot finds the cheaper hotel$")
	public void theRobotFindsTheCheaperHotel() {
		theActorInTheSpotlight().attemptsTo(SelectCheaper.hotel());
	}

	@Then("^The total to pay is correct$")
	public void theRobotShowsTheCheaperHotel() {

		theActorInTheSpotlight().should(
				seeThat(TheTotalToPayIs.correct()).orComplainWith(Exceptions.class, Exceptions.VALUE_TOTAL_ERROR));
	}

}
