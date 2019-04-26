package robertmora.rivamvc.models.forms;

import robertmora.rivamvc.models.Apartment;
import robertmora.rivamvc.models.Offer;

import javax.validation.constraints.NotNull;

public class AddOfferItemForm {

    @NotNull
    private int offerId;
    @NotNull
    private int apartmentId;
    private Iterable<Apartment> apartments;
    private Offer offer;

    public AddOfferItemForm() {}

    public AddOfferItemForm(Iterable<Apartment> apartments, Offer offer) {
        this.apartments = apartments;
        this.offer = offer;
    }

    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    public int getApartmentId() {
        return apartmentId;
    }

    public void setApartmentId(int apartmentId) {
        this.apartmentId = apartmentId;
    }

    public Iterable<Apartment> getApartments() {
        return apartments;
    }

    public Offer getOffer() {
        return offer;
    }

}
