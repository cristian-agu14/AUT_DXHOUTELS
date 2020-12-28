package com.dxhotels.tasks;

import com.dxhotels.interactions.ScanAllInfo;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

public class GetInfoHotels implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(ScanAllInfo.onThePage());
	}

	public static GetInfoHotels inPage() {
		return Tasks.instrumented(GetInfoHotels.class);
	}

}
