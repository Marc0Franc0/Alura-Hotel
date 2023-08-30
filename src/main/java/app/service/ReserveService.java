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
    public boolean create(Object object) {
        boolean created  = false;
        try {
            ReserveDTO reserve = (ReserveDTO) object;
         reserveJpaController
                .create(new Reserve(
                        reserve.getEntryDate(), 
                        reserve.getDepartureDate(), 
                         Double.valueOf(reserve.getValue()), 
                        reserve.getPaymentMethod()));
         created = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return created;
    }
    
}
