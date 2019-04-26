package robertmora.rivamvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import robertmora.rivamvc.models.Offer;
import robertmora.rivamvc.models.data.ApartmentDao;
import robertmora.rivamvc.models.data.OfferDao;
import robertmora.rivamvc.models.forms.AddOfferItemForm;

import java.util.Optional;

@Controller
@RequestMapping(value = "offer")
public class OfferController {

    @Autowired
    OfferDao offerDao;

    @Autowired
    ApartmentDao apartmentDao;

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Offers");
        model.addAttribute("offers", offerDao.findAll());
        return "offer/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String add(Model model) {
        model.addAttribute("title", "Add Offer");
        model.addAttribute(new Offer());
        return "offer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(Model model, @ModelAttribute Offer offer) {
        offerDao.save(offer);
        return "redirect:view/" + offer.getId();
    }

    @RequestMapping(value = "view/{offerId}", method = RequestMethod.GET)
    public String viewOffer(Model model, @PathVariable int offerId) {


        Optional<Offer> result = offerDao.findById(offerId);
        if (result.isPresent()) {
            Offer offer = result.get();
            model.addAttribute("title", offer.getName());
            model.addAttribute("apartments", offer.getApartments());
            model.addAttribute("offerId", offer.getId());
        }

        return "offer/view";
    }

    public String addItem(Model model, @PathVariable int offerId) {

        Optional<Offer> result = offerDao.findById(offerId);
        if (result.isPresent()) {
            Offer offer = result.get();

            AddOfferItemForm form = new AddOfferItemForm(
                    apartmentDao.findAll(),
                    offer);
            model.addAttribute("title", "Add apt to offer: " + offer.getName());
            model.addAttribute("form", form);

        }
        return "offer/add-item";
    }

//    public String addItem(Model model, @ModelAttribute AddOfferItemForm form) {
//        Apartment theApartment = apartmentDao.findOne(form.getApartmentId());
//        Offer theOffer = offerDao.findOne(form.getOfferId());
//        theOffer.addItem(theApartment);
//        offerDao.save(theOffer);
//
//        return "redirect:/offer/view/" + theOffer.getId();
//    }


}























