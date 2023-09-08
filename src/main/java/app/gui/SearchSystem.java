package app.gui;

import app.dto.GuestUpdateDTO;
import app.dto.ReserveUpdateDTO;
import app.model.Guest;
import app.model.Reserve;
import app.service.GuestService;
import app.service.ReserveService;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class SearchSystem extends javax.swing.JFrame {

    //Listas para cargas datos de ambos modelos de datos
    private List<Reserve> reserves = new ArrayList<>();
    private List<Guest> guests = new ArrayList<>();
    //Instancias de clases de utilidades
    private ReserveService reserveService = new ReserveService();
    private GuestService guestService = new GuestService();
    //Se utiliza para saber que se lista de datos se esta visualizando
    private int selectReserveOrGuest = 0;
    private GuestUpdateDTO guestUpdateDTO = new GuestUpdateDTO();
    private ReserveUpdateDTO reserveUpdateDTO = new ReserveUpdateDTO();

    public SearchSystem() {
        initComponents();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnGuests = new javax.swing.JButton();
        btnReserves = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/logoAluraMediano.png"))); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        btnGuests.setBackground(new java.awt.Color(17, 140, 198));
        btnGuests.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnGuests.setForeground(new java.awt.Color(255, 255, 255));
        btnGuests.setText("Húespedes");
        btnGuests.setFocusable(false);
        btnGuests.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuestsMouseClicked(evt);
            }
        });

        btnReserves.setBackground(new java.awt.Color(17, 140, 198));
        btnReserves.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnReserves.setForeground(new java.awt.Color(255, 255, 255));
        btnReserves.setText("Reservas");
        btnReserves.setFocusable(false);
        btnReserves.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnReservesMouseClicked(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(17, 140, 198));
        btnDelete.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setText("Eliminar");
        btnDelete.setFocusable(false);
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(17, 140, 198));
        btnUpdate.setFont(new java.awt.Font("Arial", 0, 20)); // NOI18N
        btnUpdate.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdate.setText("Editar");
        btnUpdate.setFocusable(false);
        btnUpdate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnUpdateMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(0, 473, Short.MAX_VALUE)
                            .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(20, 20, 20)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(45, 45, 45)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(btnGuests, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnReserves))))))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel3)
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuests)
                    .addComponent(btnReserves))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnDelete))
                        .addGap(15, 15, 15)))
                .addComponent(jLabel2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1MouseClicked

    private void btnGuestsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuestsMouseClicked
        this.selectReserveOrGuest = 0;
        this.setModelGuestsTable(table);
    }//GEN-LAST:event_btnGuestsMouseClicked

    private void btnReservesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReservesMouseClicked
        this.selectReserveOrGuest = 1;
        this.setModelReserveTable(table);
    }//GEN-LAST:event_btnReservesMouseClicked

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
       if(selectReserveOrGuest==0){
           this.guestService.delete(this.guestUpdateDTO.getId());
            JOptionPane.showMessageDialog(
                    null, "Húesped eliminado",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
       }else{
           this.reserveService.delete(this.reserveUpdateDTO.getId());
            JOptionPane.showMessageDialog(
                    null, "Reserva eliminada",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
       }
         //Se actualizan los datos de ambos modelos para la tabla
        setModelGuestsTable(table);
        setModelReserveTable(table);
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnUpdateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUpdateMouseClicked
        //Se cargan los datos de huespedes o reservas 
        if (this.selectReserveOrGuest == 0) {
            this.guestService.update(this.guestUpdateDTO);
             JOptionPane.showMessageDialog(
                    null, "Húesped actualizado",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } else {
            this.reserveService.update(this.reserveUpdateDTO);
             JOptionPane.showMessageDialog(
                    null, "Reserva actualizada",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
        //Se actualizan los datos de ambos modelos para la tabla
        setModelGuestsTable(table);
        setModelReserveTable(table);
    }//GEN-LAST:event_btnUpdateMouseClicked

    //Evento que ocurre al realizar click sobre la tabla
    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if (selectReserveOrGuest == 0) {
            selectGuest(table);
        } else {
            selectReserve(table);
        }


    }//GEN-LAST:event_tableMouseClicked
    //Método para cargar datos seleccionados y asi utilzarlos para su modificación

    private void selectGuest(JTable table) {
        try {
            //Fila sseleccionada
            int row = table.getSelectedRow();
            if (row >= 0) {
                //A cada input se les coloca como valor el del producto que se selecciona
                Long id = Long.valueOf(table.getValueAt(row, 0).toString());
                String name = table.getValueAt(row, 1).toString();
                String lastName = table.getValueAt(row, 2).toString();
                Date birthdate = (Date) table.getValueAt(row, 3);
                String nacionality = table.getValueAt(row, 4).toString();
                String phoneNumber = table.getValueAt(row, 5).toString();
                Long reserveId = Long.valueOf(table.getValueAt(row, 6).toString());
                this.guestUpdateDTO = new GuestUpdateDTO(
                        id,
                        name,
                        lastName,
                        birthdate,
                        nacionality,
                        phoneNumber,
                        reserveId);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Error en la seleción del húesped",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }

    }

    private void selectReserve(JTable table) {
        try {
            //Fila seleccionada
            int row = table.getSelectedRow();
            if (row >= 0) {
                //A cada input se les coloca como valor el del producto que se selecciona
                Long id = Long.valueOf(table.getValueAt(row, 0).toString());
                Date checkIn = (Date) table.getValueAt(row, 1);
                Date checkOut = (Date) table.getValueAt(row, 2);
                Double value = Double.parseDouble(table.getValueAt(row, 3).toString());
                String paymentMethod = table.getValueAt(row, 4).toString();
                this.reserveUpdateDTO = new ReserveUpdateDTO(
                        id,
                        checkIn,
                        checkOut,
                        value,
                        paymentMethod);

            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(
                    null, "Error en la seleción de la reserva",
                    "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnGuests;
    private javax.swing.JButton btnReserves;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

    //Método para deifnir el modelo de la tabla con los datos de todas la reservas
    private void setModelReserveTable(JTable table) {
        //Obtencion de reservas almacenadas en la base de datos
        reserves = this.reserveService.getAll();
        DefaultTableModel model = new DefaultTableModel();
        //Columnas de la tabla
        model.addColumn("Id");
        model.addColumn("Check In");
        model.addColumn("Check Out");
        model.addColumn("Valor(USD)");
        model.addColumn("Método de pago");
        //Se establece el modelo de la tabla
        table.setModel(model);

        //Mapeo de productos obtenidos
        for (Reserve reserve : reserves) {
            model.addRow(reserve.toArray());
        }
    }

    //Método para deifnir el modelo de la tabla con los datos de todas la húespedes
    private void setModelGuestsTable(JTable table) {
        //Obtencion de húespedes almacenados en la base de datos
        guests = this.guestService.getAll();
        DefaultTableModel model = new DefaultTableModel();
        //Columnas de la tabla
        model.addColumn("Id");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Fecha de nacimiento");
        model.addColumn("Nacionalidad");
        model.addColumn("Teléfono");
        model.addColumn("Id reserva");
        //Se establece el modelo de la tabla
        table.setModel(model);
        table.isCellEditable(guests.size(), 0);
        //Mapeo de productos obtenidos
        for (Guest guest : guests) {
            model.addRow(guest.toArray());
        }
    }

    //Método para obtener la primer columna(id) de la cual se selecciona
    private int selectIdRow() {
        try {
            //Otenecion del id
            //Fila seleccionada
            int row = this.table.getSelectedRow();
            //Id
            return (int) this.table.getValueAt(row, 0);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return -1;
    }

}
