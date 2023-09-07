package app.service;

import app.dto.GuestCreateDTO;
import app.dto.GuestUpdateDTO;
import app.model.Guest;
import app.model.Reserve;
import app.persistence.GuestsJpaController;
import app.persistence.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GuestService implements CrudService {

    private GuestsJpaController guestJpaCOntroller = new GuestsJpaController();
    private ReserveService reserveService = new ReserveService();

    @Override
    public Object create(Object object) {
        Guest guestCreated = null;
        try {
            GuestCreateDTO guest = (GuestCreateDTO) object;
            guestCreated = new Guest(
                    guest.getFirstName(),
                    guest.getLastName(),
                    guest.getBirthdate(),
                    guest.getNacionalidad(),
                    guest.getPhoneNumber(),
                    //Se obtiene la reserva con el la clase de utilidad de reserva
                    (Reserve) reserveService.get(guest.getReserveId()));
            guestJpaCOntroller
                    .create(guestCreated);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return guestCreated;
    }

    @Override
    public Object get(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object update(Object object) {
        GuestUpdateDTO guest = (GuestUpdateDTO) object;
        Guest guestUpdated = new Guest(
                guest.getId(),
                guest.getFirstName(),
                guest.getLastName(),
                guest.getBirthdate(),
                guest.getNacionalidad(),
                guest.getPhoneNumber(),
                //Se obtiene la reserva con el la clase de utilidad de reserva
                (Reserve) reserveService.get(guest.getReserveId()));
        try {
            guestJpaCOntroller.edit(guestUpdated);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return guestUpdated;

    }

    @Override
    public boolean delete(Long id) {
        boolean rta = false;
        try {
            this.guestJpaCOntroller.destroy(id);
        } catch (NonexistentEntityException ex) {
        ex.printStackTrace();
        }
        return rta;
    }

    @Override
    public List<Guest> getAll() {
        return guestJpaCOntroller.findGuestsEntities();
    }

}
