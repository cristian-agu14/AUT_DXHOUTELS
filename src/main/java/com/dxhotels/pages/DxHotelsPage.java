package com.dxhotels.pages;

import net.serenitybdd.screenplay.targets.Target;

public class DxHotelsPage {

	public static final Target LST_LOCATION = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[1]");

	public static final Target TXT_CHECK_IN = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[2]");

	public static final Target TXT_CHECK_OUT = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[3]");

	public static final Target LST_ROOMS = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[4]");

	public static final Target LST_ADULTS = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[5]");

	public static final Target LST_CHILDREN = Target.the("Locations list")
			.locatedBy("(//input[@class='dx-texteditor-input'])[6]");

	public static final Target BTN_SEARCH = Target.the("Button for do searh")
			.locatedBy("//div[@class='dx-button-content']//span[contains(text(), 'SEARCH')]//parent::div");

}
