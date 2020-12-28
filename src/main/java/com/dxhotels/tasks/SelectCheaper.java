package com.dxhotels.tasks;

import com.dxhotels.interactions.GetHotelCheaper;
import com.dxhotels.interactions.SelectCheaperHotel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class SelectCheaper implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		actor.attemptsTo(GetHotelCheaper.fromList());
		actor.attemptsTo(SelectCheaperHotel.rememberTheList());

	}

	public static SelectCheaper hotel() {
		return Tasks.instrumented(SelectCheaper.class);
	}

}
