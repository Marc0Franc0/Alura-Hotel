package app.service;

import app.dto.ReserveDTO;
import app.model.Reserve;
import app.persistence.ReserveJpaController;
import java.util.Date;

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
    public Object update(Long id, Object object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object delete(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
