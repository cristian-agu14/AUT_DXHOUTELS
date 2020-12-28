package com.dxhotels.interactions;

import static com.dxhotels.pages.DxHotelsPage.LST_ADULTS;
import static com.dxhotels.pages.DxHotelsPage.LST_CHILDREN;
import static com.dxhotels.pages.DxHotelsPage.LST_ROOMS;

import org.openqa.selenium.Keys;
import org.slf4j.LoggerFactory;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Hit;

public class SelectNumberOf implements Interaction {

	private String num;
	private static String type = "";

	public SelectNumberOf(String num) {
		this.num = num;

	}

	@Override
	public <T extends Actor> void performAs(T actor) {
		int end = Integer.parseInt(num);
		switch (type) {
		case "room":
			if (end > 1) {
				actor.attemptsTo(Click.on(LST_ROOMS));
				for (int i = 0; i < end-1; i++) {
					actor.attemptsTo(Hit.the(Keys.DOWN).into(LST_ROOMS));
				}
				actor.attemptsTo(Hit.the(Keys.ENTER).into(LST_ROOMS));
			}

			break;

		case "adults":
			if (end > 1) {
				actor.attemptsTo(Click.on(LST_ADULTS));
				for (int i = 0; i < end-1; i++) {
					actor.attemptsTo(Hit.the(Keys.DOWN).into(LST_ADULTS));
				}
				actor.attemptsTo(Hit.the(Keys.ENTER).into(LST_ADULTS));
			}
			break;

		case "children":
			if (end > 0) {
				actor.attemptsTo(Click.on(LST_CHILDREN));
				for (int i = 0; i < end; i++) {
					actor.attemptsTo(Hit.the(Keys.DOWN).into(LST_CHILDREN));
				}
				actor.attemptsTo(Hit.the(Keys.DOWN).into(LST_CHILDREN));
				
			}
			break;

		default:
			LoggerFactory.getLogger(SelectNumberOf.class).info("You do not entry a number between 1 and 4");
			break;
		}

	}

	public static SelectNumberOf rooms(String num) {
		type = "room";
		return Tasks.instrumented(SelectNumberOf.class, num);
	}

	public static SelectNumberOf adults(String num) {
		type = "adults";
		return Tasks.instrumented(SelectNumberOf.class, num);
	}

	public static SelectNumberOf children(String num) {
		type = "children";
		return Tasks.instrumented(SelectNumberOf.class, num);
	}

}
