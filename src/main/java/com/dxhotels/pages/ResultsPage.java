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

	public static final Target FINDING_INFO = Target.the("Finding info hotel").locatedBy("//p[@class='days-adults']");

	public static final Target NAME_CHEAPER_HOTEL = Target.the("Button cheaper hotel").locatedBy(
			"//span[@class='name-hotel' and contains(text(), '{0}')]//ancestor::div[@class='name-address']//following-sibling::div[@class='night-button']//div[@data-bind]");

	public static final Target BTN_LAST_PAGE = Target.the("Button for go to LAST page")
			.locatedBy("//div[@class='switch switch-left']");
	
}
