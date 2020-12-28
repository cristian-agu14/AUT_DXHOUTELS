package com.dxhotels.interactions;

import static com.dxhotels.pages.ResultsPage.BTN_NEXT_PAGE;
import static com.dxhotels.pages.ResultsPage.FINDING_INFO;
import static com.dxhotels.pages.ResultsPage.LBL_COUNT_HOTELS;
import static com.dxhotels.pages.ResultsPage.LBL_NAME_HOTEL;
import static com.dxhotels.pages.ResultsPage.LBL_VALUE_HOTEL;
import static com.dxhotels.utils.RemembersConstans.HOTELS_LIST;
import static com.dxhotels.utils.RemembersConstans.DAYS;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import com.dxhotels.models.HotelModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

public class ScanAllInfo implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		List<HotelModel> hotelsList = new ArrayList<HotelModel>();
		String countHotels = LBL_COUNT_HOTELS.resolveFor(actor).getText();
		double numHotels = Double.parseDouble(countHotels.charAt(0) + "");

		String info = FINDING_INFO.resolveFor(theActorInTheSpotlight()).getText();
		int days = Integer.parseInt(info.charAt(0) + "");

		actor.remember(DAYS, days);

		int numPages = (int) Math.ceil(numHotels / 3);

		int contHotelesAddedInThispage = 0;

		for (int j = 0; j < numPages; j++) {
			for (int i = 1; i <= 4; i++) {
				if (hotelsList.size() < numHotels) {
					if (contHotelesAddedInThispage < 3) {
						HotelModel hotel = new HotelModel(null, 0.0);
						String textValueHotel = (LBL_VALUE_HOTEL.of(i + "").resolveFor(actor).getText())
								.replaceAll("\\$", "");
						double valueHotel = Double.parseDouble(textValueHotel);
						hotel.setName(LBL_NAME_HOTEL.of(i + "").resolveFor(actor).getText());
						hotel.setValuePerNight(valueHotel);
						hotelsList.add(hotel);
						contHotelesAddedInThispage++;
					} else {
						break;
					}
				} else {
					break;
				}

			}
			contHotelesAddedInThispage = 0;
			if (hotelsList.size() < numHotels) {
				actor.attemptsTo(Click.on(BTN_NEXT_PAGE));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				actor.attemptsTo(Scroll.to(LBL_COUNT_HOTELS));
			}

		}

		actor.remember(HOTELS_LIST, hotelsList);

		hotelsList.forEach(x -> {
			LoggerFactory.getLogger(ScanAllInfo.class).info("Name Hotel: " + x.getName() + " $" + x.getValuePerNight());
		});
	}

	public static ScanAllInfo onThePage() {
		return Tasks.instrumented(ScanAllInfo.class);
	}

}
