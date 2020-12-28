package com.dxhotels.interactions;

import static com.dxhotels.pages.HotelReservation.LBL_DESCRIPTION;
import static com.dxhotels.pages.ResultsPage.BTN_LAST_PAGE;
import static com.dxhotels.pages.ResultsPage.NAME_CHEAPER_HOTEL;
import static com.dxhotels.utils.RemembersConstans.CHEAPER_HOTEL;

import com.dxhotels.models.HotelModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class SelectCheaperHotel implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		HotelModel cheaperHotel = actor.recall(CHEAPER_HOTEL);

		while (!(NAME_CHEAPER_HOTEL.of(cheaperHotel.getName()).resolveFor(actor).isPresent())) {
			actor.attemptsTo(Click.on(BTN_LAST_PAGE));
		}
		actor.attemptsTo(Click.on(NAME_CHEAPER_HOTEL.of(cheaperHotel.getName())));
		actor.attemptsTo(Scroll.to(LBL_DESCRIPTION));
	}

	public static SelectCheaperHotel rememberTheList() {
		return Tasks.instrumented(SelectCheaperHotel.class);
	}

}
