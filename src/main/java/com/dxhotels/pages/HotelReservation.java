package com.dxhotels.pages;

import net.serenitybdd.screenplay.targets.Target;

public class HotelReservation {
	public static final Target LBL_TOTAL_TO_PAY_NOW = Target.the("Label pay")
			.locatedBy("//p[@class='text' and contains(text(),'TOTAL TO PAY NOW')]");

	public static final Target LBL_DESCRIPTION = Target.the("Label pay")
			.locatedBy("//h4[contains(text(),'Your Reservation Summary')]");

	public static final Target LBL_TOTAL_PAY = Target.the("Label tota to pay for night")
			.locatedBy("(//h4[contains(.,'$')])[3]");
}
