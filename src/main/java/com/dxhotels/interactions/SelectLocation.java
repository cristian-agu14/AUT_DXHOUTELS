package com.dxhotels.interactions;

import static com.dxhotels.pages.DxHotelsPage.LST_LOCATION;

import org.openqa.selenium.Keys;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;

public class SelectLocation implements Interaction {

	private static String location;

	public SelectLocation(String location) {
		SelectLocation.location = location;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {

		int end = 0;

		switch (location) {
		case "Los Angeles":
			end = 1;
			break;

		case "San Francisco":
			end = 2;
			break;
		case "Las Vegas":
			end = 3;
			break;
		case "Honolulu":
			end = 4;
			break;
		case "New York":
			end = 5;
			break;

		case "Nassau":
			end = 6;
			break;
		case "Paris":
			end = 7;
			break;
		case "London":
			end = 8;
			break;
		case "Rome":
			end = 9;
			break;
		case "Hamburg":
			end = 10;
			break;
		default:
			break;
		}
		actor.attemptsTo(Click.on(LST_LOCATION));
		for (int i = 0; i < end; i++) {
			actor.attemptsTo(Hit.the(Keys.DOWN).into(LST_LOCATION));
		}
		actor.attemptsTo(Hit.the(Keys.ENTER).into(LST_LOCATION));		

	}

	public static SelectLocation with(String location) {
		return Tasks.instrumented(SelectLocation.class, location);
	}
}
