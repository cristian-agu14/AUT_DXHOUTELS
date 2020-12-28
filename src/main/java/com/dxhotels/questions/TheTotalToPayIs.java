package com.dxhotels.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import static com.dxhotels.pages.HotelReservation.LBL_TOTAL_PAY;
import static com.dxhotels.utils.RemembersConstans.CHEAPER_HOTEL;
import static com.dxhotels.utils.RemembersConstans.DAYS;

import com.dxhotels.models.HotelModel;

public class TheTotalToPayIs implements Question<Boolean> {

	@Override
	public Boolean answeredBy(Actor actor) {
		int days = actor.recall(DAYS);
		String stringTotal = LBL_TOTAL_PAY.resolveFor(actor).getText();
		double totalOnScreen = Double.parseDouble(stringTotal.replaceAll("\\$", ""));
		HotelModel cheaperHotel = actor.recall(CHEAPER_HOTEL);
		double totalTrue = cheaperHotel.getValuePerNight() * (days + 1);
		if (totalOnScreen == totalTrue) {
			return true;
		} else
			return false;
	}

	public static TheTotalToPayIs correct() {
		return new TheTotalToPayIs();
	}

}
