
package app.service;

import app.dto.GuestDTO;
import app.model.Guest;
import app.model.Reserve;
import app.persistence.GuestsJpaController;

public class GuestService implements CrudService{
private GuestsJpaController guestJpaCOntroller = new GuestsJpaController();
private ReserveService reserveService = new ReserveService();
    @Override
    public Object create(Object object) {
           Guest guestCreated  = null;
        try {
            GuestDTO guest = (GuestDTO) object;
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
    public Object update(Long id, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
