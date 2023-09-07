package app.service;

import app.dto.ReserveDTO;
import app.dto.ReserveUpdateDTO;
import app.model.Reserve;
import app.persistence.ReserveJpaController;
import app.persistence.exceptions.NonexistentEntityException;
import java.util.List;

//Clase utilizada para recibir los datos para transacciones de una entidad
//Y luego realizar las mismas con la clase controller correspondiente
public class ReserveService extends ReserveUtils implements CrudService{
 private ReserveJpaController reserveJpaController = new ReserveJpaController();
    @Override
    public Object create(Object object) {
        Reserve reserveCreated  = null;
        try {
            ReserveDTO reserve = (ReserveDTO) object;
            reserveCreated = new Reserve(
                        reserve.getEntryDate(), 
                        reserve.getDepartureDate(), 
                         Double.valueOf(reserve.getValue()), 
                        reserve.getPaymentMethod());
         reserveJpaController
                .create(reserveCreated);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return reserveCreated;
    }

    @Override
    public Object get(Long id) {
        return reserveJpaController.findReserve(id);
    }

    @Override
    public Object update(Object object) {
        ReserveUpdateDTO reserve = (ReserveUpdateDTO)object;
        Reserve reserveUpdated = new Reserve(
                reserve.getId(), 
                reserve.getEntryDate(), 
                reserve.getDepartureDate(), 
                reserve.getValue(), 
                reserve.getPaymentMethod());
     try {
         reserveJpaController.edit(reserveUpdated);
     } catch (Exception ex) {
         ex.printStackTrace();
     }
         return reserveUpdated;
    }

    @Override
    public boolean delete(Long id) {
        boolean rta= false;
     try {
         this.reserveJpaController.destroy(id);
         rta = true;
     } catch (NonexistentEntityException ex) {
         ex.printStackTrace();
     }
     return rta;
    }
    
    
    @Override
    public List<Reserve> getAll() {
        return reserveJpaController.findReserveEntities();
    }
    
}
