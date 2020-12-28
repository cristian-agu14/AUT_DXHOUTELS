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
		location = location.toUpperCase();
		switch (location) {
		case "LOS ANGELES":
			end = 1;
			break;

		case "SAN FRANCISCO":
			end = 2;
			break;
		case "LAS VEGAS":
			end = 3;
			break;
		case "HONOLULU":
			end = 4;
			break;
		case "NEW YORK":
			end = 5;
			break;

		case "NASSAU":
			end = 6;
			break;
		case "PARIS":
			end = 7;
			break;
		case "LONDON":
			end = 8;
			break;
		case "ROME":
			end = 9;
			break;
		case "HAMBURG":
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
