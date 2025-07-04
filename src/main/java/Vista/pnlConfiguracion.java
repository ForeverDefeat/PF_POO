package Vista;

import DAO.ComputadoraDAO;
import DAO.ProductoDAO;
import Modelo.Computadora;
import Modelo.Producto;
import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class pnlConfiguracion extends javax.swing.JPanel {

    private DefaultTableModel modeloTabla;
    private DefaultTableModel modeloProducto;
    private List<Computadora> listaComputadoras;

    public pnlConfiguracion() {
        initComponents();
        cargarComputadorasDesdeBD();
        personalizarTabla();
        cargarProductosDesdeBD();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        pnlGestComp = new javax.swing.JPanel();
        scrollComputadoras = new javax.swing.JScrollPane();
        tblComputadoras = new javax.swing.JTable();
        lblNumeroPc = new javax.swing.JLabel();
        txtNumeroPc = new javax.swing.JTextField();
        lblEstado = new javax.swing.JLabel();
        cmbEstadoComputadora = new javax.swing.JComboBox<>();
        btnAgregar = new javax.swing.JButton();
        btnActualizarEstado = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        pnlGestPro = new javax.swing.JPanel();
        scrollComputadoras1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        lblNombre = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        btnAgregarProducto = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminarProducto = new javax.swing.JButton();
        btnLimpiarProducto = new javax.swing.JButton();
        txtPrecioProducto = new javax.swing.JTextField();
        lblStock = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        cmbCategoria = new javax.swing.JComboBox<>();

        setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(204, 255, 204));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Mongolian Baiti", 1, 24)); // NOI18N
        jLabel1.setText("CONFIGURACIONES GENERALES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(41, 388, 43, 516);
        jPanel4.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        gridBagConstraints.weightx = 1.0;
        add(jPanel4, gridBagConstraints);

        jTabbedPane2.setBackground(new java.awt.Color(0, 204, 204));
        jTabbedPane2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        pnlGestComp.setLayout(new java.awt.GridBagLayout());

        tblComputadoras.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblComputadoras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Numero", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollComputadoras.setViewportView(tblComputadoras);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlGestComp.add(scrollComputadoras, gridBagConstraints);

        lblNumeroPc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNumeroPc.setText("Numero PC :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestComp.add(lblNumeroPc, gridBagConstraints);

        txtNumeroPc.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNumeroPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNumeroPcActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestComp.add(txtNumeroPc, gridBagConstraints);

        lblEstado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblEstado.setText("Estado :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestComp.add(lblEstado, gridBagConstraints);

        cmbEstadoComputadora.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbEstadoComputadora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "LIBRE", "OCUPADA", "MANTIMIENTO" }));
        cmbEstadoComputadora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbEstadoComputadoraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestComp.add(cmbEstadoComputadora, gridBagConstraints);

        btnAgregar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestComp.add(btnAgregar, gridBagConstraints);

        btnActualizarEstado.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnActualizarEstado.setText("Actualizar Estado");
        btnActualizarEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarEstadoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestComp.add(btnActualizarEstado, gridBagConstraints);

        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestComp.add(btnEliminar, gridBagConstraints);

        btnLimpiar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestComp.add(btnLimpiar, gridBagConstraints);

        jTabbedPane2.addTab("Gestion Computadoras", pnlGestComp);

        pnlGestPro.setLayout(new java.awt.GridBagLayout());

        tblProductos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Precio", "Stock", "Categoria"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollComputadoras1.setViewportView(tblProductos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        pnlGestPro.add(scrollComputadoras1, gridBagConstraints);

        lblNombre.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombre.setText("Nombre Producto");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(lblNombre, gridBagConstraints);

        txtNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(txtNombreProducto, gridBagConstraints);

        lblPrecio.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblPrecio.setText("Precio");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(lblPrecio, gridBagConstraints);

        btnAgregarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAgregarProducto.setText("Agregar");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestPro.add(btnAgregarProducto, gridBagConstraints);

        btnActualizar.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnActualizar.setText("Actualizar Estado");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestPro.add(btnActualizar, gridBagConstraints);

        btnEliminarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnEliminarProducto.setText("Eliminar");
        btnEliminarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestPro.add(btnEliminarProducto, gridBagConstraints);

        btnLimpiarProducto.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnLimpiarProducto.setText("Limpiar");
        btnLimpiarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestPro.add(btnLimpiarProducto, gridBagConstraints);

        txtPrecioProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtPrecioProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioProductoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(txtPrecioProducto, gridBagConstraints);

        lblStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblStock.setText("Stock");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(lblStock, gridBagConstraints);

        txtStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtStockActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        pnlGestPro.add(txtStock, gridBagConstraints);

        cmbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebida", "Snack" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(10, 5, 10, 5);
        pnlGestPro.add(cmbCategoria, gridBagConstraints);

        jTabbedPane2.addTab("Gestion Productos", pnlGestPro);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(jTabbedPane2, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    private void personalizarTabla() {
        // Establecer fuente general
        tblComputadoras.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblComputadoras.setRowHeight(28);
        tblProductos.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        tblProductos.setRowHeight(28);

        // Estilo para encabezado
        JTableHeader header = tblComputadoras.getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(230, 230, 230));
        header.setForeground(Color.BLACK);
        JTableHeader headerProd = tblProductos.getTableHeader();
        headerProd.setFont(new Font("Segoe UI", Font.BOLD, 14));
        headerProd.setBackground(new Color(230, 230, 230));
        headerProd.setForeground(Color.BLACK);

        // Renderizadores para alinear columnas
        DefaultTableCellRenderer centrado = new DefaultTableCellRenderer();
        centrado.setHorizontalAlignment(SwingConstants.CENTER);

        DefaultTableCellRenderer izquierda = new DefaultTableCellRenderer();
        izquierda.setHorizontalAlignment(SwingConstants.LEFT);

        // Aplicar alineación por columnas
        if (tblComputadoras.getColumnModel().getColumnCount() >= 3) {
            tblComputadoras.getColumnModel().getColumn(0).setCellRenderer(centrado);
            tblComputadoras.getColumnModel().getColumn(1).setCellRenderer(izquierda);
            tblComputadoras.getColumnModel().getColumn(2).setCellRenderer(centrado);
        }
        if (tblComputadoras.getColumnModel().getColumnCount() >= 4) {
            tblComputadoras.getColumnModel().getColumn(0).setCellRenderer(centrado);
            tblComputadoras.getColumnModel().getColumn(1).setCellRenderer(izquierda);
            tblComputadoras.getColumnModel().getColumn(2).setCellRenderer(centrado);
            tblComputadoras.getColumnModel().getColumn(2).setCellRenderer(centrado);
        }
    }

    private void cargarComputadorasDesdeBD() {
        String[] columnas = {"ID", "Número", "Estado"};
        modeloTabla = new DefaultTableModel(columnas, 0);
        tblComputadoras.setModel(modeloTabla);

        List<Computadora> lista = ComputadoraDAO.obtenerTodas();

        DefaultTableModel modelo = (DefaultTableModel) tblComputadoras.getModel();
        modelo.setRowCount(0); // Limpiar tabla

        for (Computadora pc : lista) {
            modelo.addRow(new Object[]{pc.getId(), pc.getNumero(), pc.getEstado()});
        }
        tblComputadoras.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tblComputadoras.getSelectedRow();
                if (fila != -1) {
                    String numero = modeloTabla.getValueAt(fila, 1).toString();
                    String estado = modeloTabla.getValueAt(fila, 2).toString();

                    txtNumeroPc.setText(numero);
                    cmbEstadoComputadora.setSelectedItem(estado);
                }
            }
        });
    }

    private void cargarProductosDesdeBD() {
        String[] columnas = {"ID", "Nombre", "Precio", "Stock"};
        modeloProducto = new DefaultTableModel(columnas, 0);
        tblProductos.setModel(modeloProducto);

        List<Producto> lista = ProductoDAO.obtenerTodos();
        modeloProducto.setRowCount(0);

        for (Producto p : lista) {
            modeloProducto.addRow(new Object[]{
                p.getId(),
                p.getNombre(),
                p.getPrecio(),
                p.getStock(),
                p.getCategoria()
            });
        }

        // Listener para selección
        tblProductos.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int fila = tblProductos.getSelectedRow();
                if (fila != -1) {
                    txtNombreProducto.setText(modeloProducto.getValueAt(fila, 1).toString());
                    txtPrecioProducto.setText(modeloProducto.getValueAt(fila, 2).toString());
                    txtStock.setText(modeloProducto.getValueAt(fila, 3).toString());
                    cmbCategoria.setSelectedItem(modeloProducto.getValueAt(fila, 4).toString());
                }
            }
        });
    }

    private void limpiarCamposProducto() {
        txtNombreProducto.setText("");
        txtPrecioProducto.setText("");
        txtStock.setText("");
        cmbCategoria.setSelectedIndex(0);
        tblProductos.clearSelection();
    }
    
    private void btnActualizarEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarEstadoActionPerformed
        // TODO add your handling code here:
        int fila = tblComputadoras.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una computadora.");
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        String nuevoEstado = (String) cmbEstadoComputadora.getSelectedItem();

        if (ComputadoraDAO.actualizarEstado(id, nuevoEstado)) {
            JOptionPane.showMessageDialog(this, "Estado actualizado.");
            cargarComputadorasDesdeBD();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btnActualizarEstadoActionPerformed

    private void txtNumeroPcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNumeroPcActionPerformed
        // TODO add your handling code here:
        String numero = txtNumeroPc.getText().trim();
        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de la computadora.");
        }
    }//GEN-LAST:event_txtNumeroPcActionPerformed

    private void cmbEstadoComputadoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbEstadoComputadoraActionPerformed
        // TODO add your handling code here:
        cmbEstadoComputadora.addActionListener(e -> {
            int fila = tblComputadoras.getSelectedRow();
            if (fila != -1) {
                int id = (int) modeloTabla.getValueAt(fila, 0);
                String nuevoEstado = (String) cmbEstadoComputadora.getSelectedItem();

                boolean ok = ComputadoraDAO.actualizarEstado(id, nuevoEstado);
                if (ok) {
                    modeloTabla.setValueAt(nuevoEstado, fila, 2); // actualiza la tabla directamente
                } else {
                    JOptionPane.showMessageDialog(this, "Error al actualizar estado.");
                }
            }
        });
    }//GEN-LAST:event_cmbEstadoComputadoraActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        String numero = txtNumeroPc.getText();
        String estado = (String) cmbEstadoComputadora.getSelectedItem();

        if (numero.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese el número de la computadora.");
            return;
        }

        Computadora nueva = new Computadora();
        nueva.setNumero(numero);
        nueva.setEstado(estado);

        if (ComputadoraDAO.insertar(nueva)) {
            JOptionPane.showMessageDialog(this, "Computadora registrada.");
            cargarComputadorasDesdeBD();
            txtNumeroPc.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Error al registrar.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        int fila = tblComputadoras.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una computadora.");
            return;
        }

        int id = (int) modeloTabla.getValueAt(fila, 0);
        if (ComputadoraDAO.eliminar(id)) {
            JOptionPane.showMessageDialog(this, "Computadora eliminada.");
            cargarComputadorasDesdeBD();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar.");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        txtNumeroPc.setText("");
        cmbEstadoComputadora.setSelectedIndex(0);

        tblComputadoras.clearSelection();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreProductoActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        // TODO add your handling code here:
        try {
            String nombre = txtNombreProducto.getText();
            String categoria = cmbCategoria.getSelectedItem().toString();
            double precio = Double.parseDouble(txtPrecioProducto.getText());
            int stock = Integer.parseInt(txtStock.getText());

            if (nombre.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el nombre del producto.");
                return;
            }

            Producto nuevo = new Producto();
            nuevo.setNombre(nombre);
            nuevo.setCategoria(categoria);
            nuevo.setPrecio(precio);
            nuevo.setStock(stock);

            if (ProductoDAO.insertar(nuevo)) {
                JOptionPane.showMessageDialog(this, "Producto agregado correctamente.");
                cargarProductosDesdeBD();
                limpiarCamposProducto();
            } else {
                JOptionPane.showMessageDialog(this, "Error al agregar el producto.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Ingrese valores válidos para precio y stock.");
        }
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        // TODO add your handling code here:
        int fila = tblProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para actualizar.");
            return;
        }

        try {
            int id = Integer.parseInt(modeloProducto.getValueAt(fila, 0).toString());
            String nombre = txtNombreProducto.getText();
            String categoria = cmbCategoria.getSelectedItem().toString();
            double precio = Double.parseDouble(txtPrecioProducto.getText());
            int stock = Integer.parseInt(txtStock.getText());

            Producto producto = new Producto(id, nombre, categoria, precio, stock);

            if (ProductoDAO.actualizar(producto)) {
                JOptionPane.showMessageDialog(this, "Producto actualizado.");
                cargarProductosDesdeBD();
                limpiarCamposProducto();
            } else {
                JOptionPane.showMessageDialog(this, "Error al actualizar.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Verifique los valores ingresados.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarProductoActionPerformed
        // TODO add your handling code here:
        int fila = tblProductos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto para eliminar.");
            return;
        }

        int id = Integer.parseInt(modeloProducto.getValueAt(fila, 0).toString());

        int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de eliminar este producto?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            if (ProductoDAO.eliminar(id)) {
                JOptionPane.showMessageDialog(this, "Producto eliminado.");
                cargarProductosDesdeBD();
                limpiarCamposProducto();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }//GEN-LAST:event_btnEliminarProductoActionPerformed

    private void btnLimpiarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarProductoActionPerformed
        // TODO add your handling code here:
        limpiarCamposProducto();
    }//GEN-LAST:event_btnLimpiarProductoActionPerformed

    private void txtPrecioProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioProductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioProductoActionPerformed

    private void txtStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtStockActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnActualizarEstado;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarProducto;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnLimpiarProducto;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstadoComputadora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumeroPc;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblStock;
    private javax.swing.JPanel pnlGestComp;
    private javax.swing.JPanel pnlGestPro;
    private javax.swing.JScrollPane scrollComputadoras;
    private javax.swing.JScrollPane scrollComputadoras1;
    private javax.swing.JTable tblComputadoras;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtNumeroPc;
    private javax.swing.JTextField txtPrecioProducto;
    private javax.swing.JTextField txtStock;
    // End of variables declaration//GEN-END:variables
}
