package app.service;

import java.util.Date;
import javax.swing.JOptionPane;

public class ReserveUtils {

    //Método encargado del calculo del valor de una reserva
    public Double calculateValue(Date checkIn, Date checkOut) {
        //Valor de un día de estadia
        Double dayValue = 80.0;
        //Diferencia de dias dentro del mes
        long diferenceDays = 
                this.calculateDaysBetweenTwoDates(checkIn, checkOut) + 1;
        //Calculo del valor final
        Double valor = dayValue * diferenceDays;
        return valor;
    }

    //Método encargado de las validaciones de entrada de datos
    //Se va a retornar true en los casos que la validacion permita calcular el valor
    //correctamente
    public boolean verifyData(Date dateCheckIn, Date dateCheckOut) {
        //Obtencion de tiempo de checkIn y checkOut
        long timeCheckIn = dateCheckIn.getTime();
        long timeCheckOut = dateCheckOut.getTime();
        //Verificación de fechas
        if(verifyTime(timeCheckIn, timeCheckOut)){
            return true;
        }else{
             showAlert("Verifique las fechas seleccionadas");
        }
        return false;
    }

    //Se verifica si el tiempo de entrada es menor o igual
    private boolean verifyTime(long timeCheckIn, long timeCheckOut) {
        if (timeCheckIn < timeCheckOut || timeCheckIn == timeCheckOut) {
            return true;
        }
        return false;
    }

    private void showAlert(String alert) {
        JOptionPane.showMessageDialog(null,
                alert
                        .concat(alert).concat("."),
                "Message",
                JOptionPane.WARNING_MESSAGE
        );
    }

    public static long calculateDaysBetweenTwoDates(Date checkIn, Date checkOut) {
        long startTime = checkIn.getTime();
        long endTime = checkOut.getTime();
        long diferenceDays = endTime - startTime;
        //Se devuelve el entero más grande 
        //que es menor o igual que el argumento.
        //Se divide por 1000 * 24 * 60 * 60, ya que el valor que se obtiene de getTime() 
        //es en milisegundos. Por consecuencia se debe obtener su equivalencia en días:
        long days = (long) Math.floor(diferenceDays / (1000 * 60 * 60 * 24));

        return days;
    }

}
