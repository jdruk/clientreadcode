
import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;

import java.awt.SystemTray;
import java.awt.TrayIcon;

import java.net.Inet4Address;

import java.net.URL;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

import javax.swing.JOptionPane;


/**
 *
 * @author josafa
 */
public class WindowMain extends javax.swing.JFrame {

    public void showIcon(){
        if(SystemTray.isSupported()){
            icon = new TrayIcon(createIcon("/task.png", "Icone"));
            final SystemTray tray = SystemTray.getSystemTray();
            try {
                final PopupMenu menu = new PopupMenu();
                MenuItem item = new MenuItem("Sair");

                item.addActionListener( e ->  System.exit(1));
                menu.add(item);
                menu.addSeparator();
                icon.setPopupMenu(menu);
                tray.add(icon);
            } catch (AWTException ex) {
                Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else{
            JOptionPane.showMessageDialog(this, "não trayIcon suporta!");
        }
    }

    private Image createIcon(String url, String description){
        URL location = this.getClass().getResource(url);
        return new ImageIcon(location, description).getImage();
    }

    private void showAddressIp(){
        try {
            String address = Inet4Address.getLocalHost().getHostAddress();
            addressTextField.setText(address);
        } catch (UnknownHostException ex) {
            JOptionPane.showConfirmDialog(this, "Ocorreu um problema ao obter o endereço ip\n"
                    + "verifique se você estar conectado a alguma rede (switch, routeador, ap e etc)");
            Logger.getLogger(WindowMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public WindowMain() {
        initComponents();
    }


    private void initComponents() {

        groupKey = new javax.swing.ButtonGroup();
        paneConfiguration = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        enterRadioButton = new javax.swing.JRadioButton();
        noneRadioButton = new javax.swing.JRadioButton();
        tabRadioButton = new javax.swing.JRadioButton();
        startService = new javax.swing.JToggleButton();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        addressTextField = new javax.swing.JTextField();
        paneStatus = new javax.swing.JPanel();
        statusConnection = new javax.swing.JLabel();
        iconStatusConnection = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        service = new Service();
        process = new Thread(service);

        enterRadioButton.setActionCommand(String.valueOf(Keyboard.KEY_ENTER));
        tabRadioButton.setActionCommand(String.valueOf(Keyboard.KEY_TAB));
        noneRadioButton.setActionCommand(String.valueOf(Keyboard.KEY_NONE));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(220, 231, 235));
        setBounds(new java.awt.Rectangle(2, 2, 2, 2));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("window"); // NOI18N
        setUndecorated(true);
        setOpacity(0.93F);
        this.setLocationRelativeTo(null);
        setResizable(false);

        paneConfiguration.setBackground(new java.awt.Color(226, 238, 238));
        paneConfiguration.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Zekton", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PRESSIONAR TECLA APÓS CÓDIGO:");
        jLabel1.setToolTipText("Escolha uma tecla para ser pressionada automáticamente logo após o código lido.");

        groupKey.add(enterRadioButton);
        enterRadioButton.setFont(new java.awt.Font("Zekton", 0, 16)); // NOI18N
        enterRadioButton.setText("ENTER");

        groupKey.add(noneRadioButton);
        noneRadioButton.setFont(new java.awt.Font("Zekton", 0, 16)); // NOI18N
        noneRadioButton.setSelected(true);
        noneRadioButton.setText("NENHUM");
        noneRadioButton.setBorderPainted(true);

        groupKey.add(tabRadioButton);
        tabRadioButton.setFont(new java.awt.Font("Zekton", 0, 16)); // NOI18N
        tabRadioButton.setText("TAB");


        startService.setIcon(new javax.swing.ImageIcon(getClass().getResource("/start.png"))); // NOI18N
        startService.setToolTipText("Iniciar servidor");
        startService.addItemListener(evt -> startServiceItemStateChanged(evt));

        jLabel2.setText("CONEXÃO:");

        addressTextField.setEditable(false);
        addressTextField.setBackground(new java.awt.Color(168, 183, 188));
        addressTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        addressTextField.setToolTipText("Endereço de conexão");
        addressTextField.setCursor(new java.awt.Cursor(java.awt.Cursor.E_RESIZE_CURSOR));

        javax.swing.GroupLayout paneConfigurationLayout = new javax.swing.GroupLayout(paneConfiguration);
        paneConfiguration.setLayout(paneConfigurationLayout);
        paneConfigurationLayout.setHorizontalGroup(
                paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneConfigurationLayout.createSequentialGroup()
                                .addGroup(paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(paneConfigurationLayout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(paneConfigurationLayout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addGroup(paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(enterRadioButton)
                                                        .addComponent(noneRadioButton)
                                                        .addComponent(tabRadioButton)
                                                        .addComponent(jLabel2))
                                                .addGap(5, 5, 5)
                                                .addGroup(paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(startService)
                                                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(17, Short.MAX_VALUE))
        );
        paneConfigurationLayout.setVerticalGroup(
                paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneConfigurationLayout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(noneRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(enterRadioButton)
                                .addGap(18, 18, 18)
                                .addComponent(tabRadioButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(startService)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(paneConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(addressTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(37, 37, 37))
        );

        paneStatus.setBackground(new java.awt.Color(0, 153, 153));

        statusConnection.setFont(new java.awt.Font("Zekton", 0, 18)); // NOI18N
        statusConnection.setText("STATUS ");
        statusConnection.setToolTipText("Serviço status");
        statusConnection.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        statusConnection.setForeground(new java.awt.Color(238, 238, 236));

        iconStatusConnection.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        iconStatusConnection.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sad.png"))); // NOI18N

        javax.swing.GroupLayout paneStatusLayout = new javax.swing.GroupLayout(paneStatus);
        paneStatus.setLayout(paneStatusLayout);
        paneStatusLayout.setHorizontalGroup(
                paneStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneStatusLayout.createSequentialGroup()
                                .addGap(138, 138, 138)
                                .addGroup(paneStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(iconStatusConnection)
                                        .addGroup(paneStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(statusConnection)))
                                .addContainerGap(157, Short.MAX_VALUE))
        );
        paneStatusLayout.setVerticalGroup(
                paneStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(paneStatusLayout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(statusConnection)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(90, 90, 90)
                                .addComponent(iconStatusConnection)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(paneConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(paneStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(paneConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(paneStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        showIcon();
        showAddressIp();
        pack();
    }


    private void startServiceItemStateChanged(java.awt.event.ItemEvent evt) {

        if(startService.isSelected() && !process.isAlive()){
            int key = Integer.parseInt(groupKey.getSelection().getActionCommand());
            service.setKey(key);
            process.start();
        } else {
            int dialogButton = JOptionPane.showConfirmDialog (null, "Fechar programa?","WARNING",JOptionPane.YES_NO_OPTION);

            if(dialogButton == JOptionPane.YES_OPTION)
                System.exit(0);
        }

    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WindowMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(() -> new WindowMain().setVisible(true));
    }

    private javax.swing.JTextField addressTextField;
    private javax.swing.JRadioButton enterRadioButton;
    private javax.swing.ButtonGroup groupKey;
    private javax.swing.JLabel iconStatusConnection;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JRadioButton noneRadioButton;
    private javax.swing.JPanel paneConfiguration;
    private javax.swing.JPanel paneStatus;
    private javax.swing.JToggleButton startService;
    private javax.swing.JLabel statusConnection;
    private javax.swing.JRadioButton tabRadioButton;
    private Service service;
    private TrayIcon icon;
    private Thread process;
}
