package com.dxhotels.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.dxhotels.pages.ResultsPage.LBL_COUNT_HOTELS;
import static com.dxhotels.pages.ResultsPage.LBL_NAME_HOTEL;
import static com.dxhotels.pages.ResultsPage.LBL_VALUE_HOTEL;
import static com.dxhotels.pages.ResultsPage.BTN_NEXT_PAGE;

import java.util.ArrayList;
import java.util.List;

import com.dxhotels.models.HotelModel;

public class GetInfoHotels implements Task {

	@Override
	public <T extends Actor> void performAs(T actor) {

		List<HotelModel> hotelsList = new ArrayList<HotelModel>();
		String countHotels = LBL_COUNT_HOTELS.resolveFor(actor).getText();
		int numHotels = Integer.parseInt(countHotels.charAt(0) + "");

//		for (int i = 1; i < 6; i++) {
//			System.out.println("isPresent: " + LBL_NAME_HOTEL.of(i + "").resolveFor(actor).isPresent());
//			System.out.println("isDisplayed: " + LBL_NAME_HOTEL.of(i + "").resolveFor(actor).isDisplayed());
//			System.out
//					.println("isCurrentlyVisible: " + LBL_NAME_HOTEL.of(i + "").resolveFor(actor).isCurrentlyVisible());
//			System.out.println("isVisible: " + LBL_NAME_HOTEL.of(i + "").resolveFor(actor).isVisible());
//
//			System.out.println(LBL_NAME_HOTEL.getCssOrXPathSelector());
//			System.out.println("===============================" + i);
//		}

		System.out.println(hotelsList.size());
		boolean areThereMorePages = true;
		while (areThereMorePages) {
			for (int i = 1; i <= numHotels; i++) {
				HotelModel hotel = new HotelModel(null, 0.0);
				String textValueHotel = (LBL_VALUE_HOTEL.of(i + "").resolveFor(actor).getText()).replaceAll("\\$", "");
				double valueHotel = Double.parseDouble(textValueHotel);
				hotel.setName(LBL_NAME_HOTEL.of(i + "").resolveFor(actor).getText());
				hotel.setValuePerNight(valueHotel);
				hotelsList.add(hotel);

			}
			if (hotelsList.size() < numHotels) {
				actor.attemptsTo(Click.on(BTN_NEXT_PAGE));
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if (hotelsList.size() == numHotels) {
				areThereMorePages = false;
			}
		}

		for (int i = 0; i < hotelsList.size(); i++) {

			System.out.println(hotelsList.get(i).getName());
			System.out.println(hotelsList.get(i).getValuePerNight());
		}
	}

	public static GetInfoHotels inPage() {
		return Tasks.instrumented(GetInfoHotels.class);
	}

}
