/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendaropanba;

import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import tiendaropanba.renderes.ListaProductosRenderer;
import tiendaropanba.renderes.PrecioRenderer;

/**
 *
 * @author Alvaro
 */
public class Main extends javax.swing.JFrame {

    Producto producto = new Producto();
    ListaProductos listaProductos = new ListaProductos();
    ListaVentas listaVentas = new ListaVentas();
    ListaTickets listaTicket = new ListaTickets();
    private InventarioTableModel inventarioTableModel;
    private VentasTableModel ventaTableModel;
    private TicketTableModel ticketTableModel;
    private static EntityManager entityManager;
    private Query consultaProductos;
    
    boolean modificado;

    /**
     * Creates new form Inventario
     */
    public Main() {
        initComponents();
        
        // Permitir sólo una fila seleccionada
        jTable1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Añadir un detector de cambio de selección en la tabla
        jTable1.getSelectionModel().addListSelectionListener(
            new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent event) {
                    mostrarDetalleProductoSeleccionado();
                }
            }
        );
             
        
        entityManager = Persistence.createEntityManagerFactory("TiendaRopaNbaPU").createEntityManager();
        consultaProductos = entityManager.createNamedQuery("Producto.findAll");
        listaProductos.setListaProductos(consultaProductos.getResultList());
                
        inventarioTableModel = new InventarioTableModel(listaProductos);
        jTable1.setModel(inventarioTableModel);
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new PrecioRenderer());
        
        ventaTableModel = new VentasTableModel(listaVentas);
        jTable2.setModel(ventaTableModel);
        jTable2.getColumnModel().getColumn(2).setCellRenderer(new PrecioRenderer());
        
        ticketTableModel = new TicketTableModel(listaTicket);
        jTable3.setModel(ticketTableModel);
        
        jComboBox1.setModel(new DefaultComboBoxModel(listaProductos.getListaProductos().toArray()));
        jComboBox1.setRenderer(new ListaProductosRenderer());
        
    }
      
    public void mostrarDetalleProductoSeleccionado() {
        int indexSelectedRow = jTable1.getSelectedRow();
        if(indexSelectedRow < 0) {
            jTextFieldNombreProducto.setText("");
            jTextFieldMarca.setText("");
            jTextFieldTalla.setText("");
            jTextFieldPrecio.setText("");
            jTextFieldCantdDisponibles.setText("");
            jTextAreaDescripcion.setText("");
            jLabelImagen.setText("");
        } else {
            jTextFieldNombreProducto.setText(listaProductos.getListaProductos().get(indexSelectedRow).getNombreProducto());
            jTextFieldMarca.setText(listaProductos.getListaProductos().get(indexSelectedRow).getMarca());
            jTextFieldTalla.setText(listaProductos.getListaProductos().get(indexSelectedRow).getTalla());
            jTextFieldPrecio.setText(String.valueOf(listaProductos.getListaProductos().get(indexSelectedRow).getPrecio()));
            jTextFieldCantdDisponibles.setText(String.valueOf(listaProductos.getListaProductos().get(indexSelectedRow).getCantidadesDisponibles()));
            jTextAreaDescripcion.setText(listaProductos.getListaProductos().get(indexSelectedRow).getDescripcion());
        }
        
    }
    
    public void insertProducto(){     
        entityManager.getTransaction().begin();
        entityManager.persist(producto);
        entityManager.getTransaction().commit();
        
        listaProductos.getListaProductos().add(producto);  
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jTextFieldPrecio = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaDescripcion = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldTalla = new javax.swing.JTextField();
        jButtonGuardar = new javax.swing.JButton();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldCantdDisponibles = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabelImagen = new javax.swing.JLabel();
        jButtonBorrar = new javax.swing.JButton();
        jButtonEditar = new javax.swing.JButton();
        jButtonNuevo = new javax.swing.JButton();
        jTextFieldNombreProducto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox1 = new javax.swing.JComboBox();
        jTextFieldCantidad = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButtonAñadir = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButtonNuevaVenta = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setToolTipText("");

        jTextFieldPrecio.setEditable(false);

        jLabel9.setText("Descripción:");

        jTextAreaDescripcion.setEditable(false);
        jTextAreaDescripcion.setColumns(20);
        jTextAreaDescripcion.setRows(5);
        jScrollPane2.setViewportView(jTextAreaDescripcion);

        jLabel7.setText("Precio:");

        jTextFieldTalla.setEditable(false);

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jTextFieldMarca.setEditable(false);

        jLabel4.setText("Talla:");

        jLabel3.setText("Marca:");

        jTextFieldCantdDisponibles.setEditable(false);

        jLabel8.setText("Cantd. Disponibles:");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jButtonBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiendaropanba/iconos/borrar.png"))); // NOI18N
        jButtonBorrar.setToolTipText("Borrar");
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiendaropanba/iconos/editar.png"))); // NOI18N
        jButtonEditar.setToolTipText("Editar");
        jButtonEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEditarActionPerformed(evt);
            }
        });

        jButtonNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tiendaropanba/iconos/nuevo.png"))); // NOI18N
        jButtonNuevo.setToolTipText("Nuevo");
        jButtonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoActionPerformed(evt);
            }
        });

        jTextFieldNombreProducto.setEditable(false);

        jLabel1.setText("Nombre del producto:");

        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonNuevo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBorrar))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(444, 444, 444))
                                .addComponent(jLabel7))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel9)
                                    .addComponent(jButtonGuardar)
                                    .addComponent(jButtonCancelar)
                                    .addComponent(jLabel3))
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldCantdDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldTalla, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(127, 127, 127)))
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonNuevo)
                        .addComponent(jButtonEditar))
                    .addComponent(jButtonBorrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelImagen, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextFieldNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextFieldTalla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(jTextFieldPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(jTextFieldCantdDisponibles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(30, 30, 30)
                                        .addComponent(jButtonGuardar)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButtonCancelar))
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Inventario", jPanel1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable2);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox1MouseClicked(evt);
            }
        });

        jLabel2.setText("Cantidad:");

        jButtonAñadir.setText("Añadir");

        jButton1.setText("Finalizar venta");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setText("TOTAL:");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jButtonNuevaVenta.setText("Nueva venta");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButtonAñadir))
                        .addGap(38, 38, 38)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jButton1))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButtonNuevaVenta))
                .addContainerGap(148, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNuevaVenta)
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAñadir))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(110, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Venta", jPanel2);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(304, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tickets", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 944, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoActionPerformed
        modificado = false;
        
        jTable1.setEnabled(false);
        jTextFieldNombreProducto.setEditable(true);
        jTextFieldMarca.setEditable(true);
        jTextFieldTalla.setEditable(true);
        jTextFieldPrecio.setEditable(true);
        jTextFieldCantdDisponibles.setEditable(true);
        jTextAreaDescripcion.setEditable(true);

        jTextFieldNombreProducto.setText("");
        jTextFieldMarca.setText("");
        jTextFieldTalla.setText("");
        jTextFieldPrecio.setText(String.valueOf(0));
        jTextFieldCantdDisponibles.setText("");
        jTextAreaDescripcion.setText("");

    }//GEN-LAST:event_jButtonNuevoActionPerformed

    private void jButtonEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEditarActionPerformed
        modificado = true;
        
        jTable1.setEnabled(false);
        jTextFieldNombreProducto.setEditable(true);
        jTextFieldMarca.setEditable(true);
        jTextFieldTalla.setEditable(true);
        jTextFieldPrecio.setEditable(true);
        jTextFieldCantdDisponibles.setEditable(true);
        jTextAreaDescripcion.setEditable(true);
    }//GEN-LAST:event_jButtonEditarActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed
          
        producto.setNombreProducto(jTextFieldNombreProducto.getText());
        producto.setMarca(jTextFieldMarca.getText());
        producto.setTalla(jTextFieldTalla.getText());
        producto.setColor(null);
        producto.setPrecio(BigDecimal.valueOf(Double.valueOf(jTextFieldPrecio.getText())));
        producto.setCantidadesDisponibles(Integer.valueOf(jTextFieldCantdDisponibles.getText()));
        producto.setDescripcion(jTextAreaDescripcion.getText());

        inventarioTableModel.fireTableRowsUpdated(jTable1.getSelectedRow(), jTable1.getSelectedRow());
        jTable1.setEnabled(true);

        jTextFieldNombreProducto.setEditable(false);
        jTextFieldMarca.setEditable(false);
        jTextFieldTalla.setEditable(false);
        jTextFieldPrecio.setEditable(false);
        jTextFieldCantdDisponibles.setEditable(false);
        jTextAreaDescripcion.setEditable(false);

        int indexSelectedRow = jTable1.getSelectedRow();
        
        if (!modificado) {
            insertProducto();
            inventarioTableModel.fireTableRowsInserted(listaProductos.getListaProductos().size()-1, listaProductos.getListaProductos().size()-1);
            
        } else{
            Producto producto = listaProductos.getListaProductos().get(indexSelectedRow);
            producto.setNombreProducto(jTextFieldNombreProducto.getText());
            producto.setMarca(jTextFieldMarca.getText());
            producto.setTalla(jTextFieldTalla.getText());
            producto.setColor(null);
            producto.setPrecio(BigDecimal.valueOf(Double.valueOf(jTextFieldPrecio.getText())));
            producto.setCantidadesDisponibles(Integer.valueOf(jTextFieldCantdDisponibles.getText()));
            producto.setDescripcion(jTextAreaDescripcion.getText());
            
            entityManager.getTransaction().begin(); 
            entityManager.merge(producto); 
            entityManager.getTransaction().commit();
        }   
        jComboBox1.setModel(new DefaultComboBoxModel(listaProductos.getListaProductos().toArray()));
        jComboBox1.setRenderer(new ListaProductosRenderer());
        
        jTable1.getColumnModel().getColumn(3).setCellRenderer(new PrecioRenderer());
        
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea borrar este producto?", "Atención", JOptionPane.OK_CANCEL_OPTION);
        
        if (JOptionPane.OK_OPTION == respuesta) {
            int indexSelectedRow = jTable1.getSelectedRow();
        
            entityManager.getTransaction().begin();
            entityManager.remove(listaProductos.getListaProductos().get(indexSelectedRow));
            entityManager.getTransaction().commit();

            listaProductos.getListaProductos().remove(indexSelectedRow);
            inventarioTableModel.fireTableRowsDeleted(indexSelectedRow, indexSelectedRow);
        }
        
        jComboBox1.setModel(new DefaultComboBoxModel(listaProductos.getListaProductos().toArray()));
        jComboBox1.setRenderer(new ListaProductosRenderer());
        
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jComboBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox1MouseClicked
        jTable2.setModel(ventaTableModel);
        jTable2.getColumnModel().getColumn(2).setCellRenderer(new PrecioRenderer());
    }//GEN-LAST:event_jComboBox1MouseClicked

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed
        jTable1.setEnabled(true);

        jTextFieldNombreProducto.setText("");
        jTextFieldMarca.setText("");
        jTextFieldTalla.setText("");
        jTextFieldPrecio.setText(String.valueOf(0));
        jTextFieldCantdDisponibles.setText("");
        jTextAreaDescripcion.setText("");
        
        jTextFieldNombreProducto.setEditable(false);
        jTextFieldMarca.setEditable(false);
        jTextFieldTalla.setEditable(false);
        jTextFieldPrecio.setEditable(false);
        jTextFieldCantdDisponibles.setEditable(false);
        jTextAreaDescripcion.setEditable(false);
    }//GEN-LAST:event_jButtonCancelarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonAñadir;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonEditar;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JButton jButtonNuevaVenta;
    private javax.swing.JButton jButtonNuevo;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextAreaDescripcion;
    private javax.swing.JTextField jTextFieldCantdDisponibles;
    private javax.swing.JTextField jTextFieldCantidad;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldNombreProducto;
    private javax.swing.JTextField jTextFieldPrecio;
    private javax.swing.JTextField jTextFieldTalla;
    // End of variables declaration//GEN-END:variables
}
