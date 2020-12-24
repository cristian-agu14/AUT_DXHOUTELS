package com.dxhotels.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.SelectFromOptions;

import static com.dxhotels.pages.DxHotelsPage.LST_ADULTS;
import static com.dxhotels.pages.DxHotelsPage.LST_CHILDREN;
import static com.dxhotels.pages.DxHotelsPage.LST_LOCATION;
import static com.dxhotels.pages.DxHotelsPage.LST_ROOMS;
import static com.dxhotels.pages.DxHotelsPage.TXT_CHECK_OUT;
import static com.dxhotels.pages.DxHotelsPage.BTN_SEARCH;

import org.openqa.selenium.Keys;

import com.dxhotels.interactions.SelectLocation;
import com.dxhotels.interactions.SelectNumberOf;

import static com.dxhotels.pages.DxHotelsPage.TXT_CHECK_IN;


public class FindAHotel implements Task {

	private String location;
	private String checkin;
	private String checkout;
	private String rooms;
	private String adults;
	private String children;

	public FindAHotel(String location, String checkin, String checkout, String rooms, String adults, String children) {
		this.location = location;
		this.checkin = checkin;
		this.checkout = checkout;
		this.rooms = rooms;
		this.adults = adults;
		this.children = children;
	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(SelectLocation.with(location));
		actor.attemptsTo(Enter.theValue(checkout).into(TXT_CHECK_OUT));
		actor.attemptsTo(Enter.theValue(checkin).into(TXT_CHECK_IN));
		actor.attemptsTo(SelectNumberOf.rooms(rooms));
		actor.attemptsTo(SelectNumberOf.adults(adults));
		actor.attemptsTo(SelectNumberOf.children(children));
		actor.attemptsTo(Click.on(BTN_SEARCH));
		
	}

	public static FindAHotel wihtThisFeatures(String location, String checkin, String checkout, String rooms,
			String adults, String children) {
		return Tasks.instrumented(FindAHotel.class, location, checkin, checkout, rooms, adults, children);
	}

}
