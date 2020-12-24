package com.dxhotels.pages;

import net.serenitybdd.screenplay.targets.Target;

public class ResultsPage {

	public static final Target LBL_NAME_HOTEL = Target.the("Hotel name in the results list")
			.locatedBy("(//span[@class='name-hotel'])[{0}]");

	public static final Target LBL_COUNT_HOTELS = Target.the("Count hotels of the finding")
			.locatedBy("//p[@class='count']");

	public static final Target LBL_VALUE_HOTEL = Target.the("Label Hotel value in dollars")
			.locatedBy("(//p[@class='rate-number'])[{0}]");

	public static final Target BTN_NEXT_PAGE = Target.the("Button for go to next page")
			.locatedBy("//div[@class='switch switch-right']");

}
