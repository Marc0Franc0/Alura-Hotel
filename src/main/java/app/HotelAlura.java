package app;



import app.gui.MainMenu;

public class HotelAlura {

    public static void main(String[] args) {
        //Se instancia la clase Menu
       MainMenu mainMenu = new MainMenu();
       //Se establece que los componentes de la clase sean visibles 
       mainMenu.setVisible(true);
       //Se establece la localización en el centro
       mainMenu.setLocationRelativeTo(null);
    }
}
