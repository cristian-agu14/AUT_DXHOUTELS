package com.dxhotels.interactions;

import static com.dxhotels.utils.RemembersConstans.CHEAPER_HOTEL;
import static com.dxhotels.utils.RemembersConstans.HOTELS_LIST;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.LoggerFactory;

import com.dxhotels.models.HotelModel;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;

public class GetHotelCheaper implements Interaction {

	@Override
	public <T extends Actor> void performAs(T actor) {
		List<HotelModel> hotelsList = new ArrayList<HotelModel>();
		hotelsList = actor.recall(HOTELS_LIST);
		HotelModel hotel = new HotelModel("", 0.0);

		if (!hotelsList.isEmpty()) {
			if (hotelsList.size() == 1) {
				hotel = hotelsList.get(0);
				LoggerFactory.getLogger(GetHotelCheaper.class)
						.info("The cheaper hotel is: " + hotel.getName() + " $" + hotel.getValuePerNight());
			} else {

				Optional<HotelModel> optionalHotel = hotelsList.stream().min((i, j) -> i.compareTo(j));
				HotelModel cheaperHotel = optionalHotel.get();
				actor.remember(CHEAPER_HOTEL, cheaperHotel);

				LoggerFactory.getLogger(GetHotelCheaper.class).info(
						"The cheaper hotel is: " + cheaperHotel.getName() + " $" + cheaperHotel.getValuePerNight());
			}

		}

	}

	public static GetHotelCheaper fromList() {
		return Tasks.instrumented(GetHotelCheaper.class);
	}

}
