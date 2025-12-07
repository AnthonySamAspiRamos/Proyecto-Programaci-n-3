/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package INTERFAZ;

/**
 *
 * @author YOSHUA
 */


import PER_de_cada_clase.*;
import proyectoprogra3.*;
import javax.swing.table.DefaultTableModel;//
import java.util.*;//
import javax.swing.*;//

import javax.swing.JOptionPane;
import java.awt.event.*;//
public class Registo_Visitantes extends javax.swing.JFrame {
    //visitantes
    private DefaultTableModel modeloTabla;
    private List<Visitante> listaVisitantes=new ArrayList<>();
    private VisitanteDAO dao=new VisitanteDAO();
    private CSimpleV CSVis=new CSimpleV();
    
    //personal
    private DefaultTableModel modeloTabla2;
    private List<Personal> listaPersonal=new ArrayList<>();
    private PersonalDAO daoP=new PersonalDAO();
    private CSimpleRP CSPer=new CSimpleRP();
    
    //personal informativo 
    private DefaultTableModel modeloTabla3;
    private List<NodoPI> listaPI = new ArrayList<>();
    private Personal_informacionDAO daoPI=new Personal_informacionDAO();
    private LSimplePI LsPI=new LSimplePI();
    
    //personal atencion
    private DefaultTableModel modeloTabla4;
    private List<NodoPA> listaPA = new ArrayList<>();
    private Personal_atencionDAO daoPA=new Personal_atencionDAO();
    private LSimplePA LsPA=new LSimplePA();
    
    //personal recreacion
    private DefaultTableModel modeloTabla5;
    private List<NodoPR> listaPR = new ArrayList<>();
    private Personal_RecreacionDAO daoPR=new Personal_RecreacionDAO();
    private LSimplePR LsPR=new LSimplePR();
    /**
     * Creates new form Registo_Visitantes
     */
    public Registo_Visitantes() {
        initComponents();
        modeloTabla =(DefaultTableModel)TABLA_VISITANTES.getModel();
        cargarVisitantes();
        
        TABLA_VISITANTES.getSelectionModel().addListSelectionListener(e -> {
            int fila = TABLA_VISITANTES.getSelectedRow();
            if(fila !=-1){
                Visitante v=listaVisitantes.get(fila);
                TFci_visitante.setText(String.valueOf(v.getCi()));
                TFnombre_visitante.setText(v.getNombre());
                TFpaterno_visitante.setText(v.getPaterno());
                TFmaterno_visitante.setText(v.getMaterno());
                TFedad_visitante.setText(String.valueOf(v.getEdad()));
                TFsexo_visitante.setText(v.getSexo());
                TFcontacto_visitante.setText(String.valueOf(v.getContacto()));
                TF_id_visitante.setText(String.valueOf(v.getId_Visitante()));
                TF_id_fecha_medica_vis.setText(String.valueOf(v.getId_FichasMedicas()));
                TF_id_informaciones_vis.setText(String.valueOf(v.getId_Informaciones()));
               
            }
        });
        
        
        //PERSONAL
        modeloTabla2 =(DefaultTableModel)TABLA_PERSONAL.getModel();
        cargarPersonal();
        
        TABLA_PERSONAL.getSelectionModel().addListSelectionListener(e -> {
            int fila = TABLA_PERSONAL.getSelectedRow();
            if(fila !=-1){
                Personal p=listaPersonal.get(fila);
                TFci_visitante.setText(String.valueOf(p.getCi()));
                TFnombre_visitante.setText(p.getNombre());
                TFpaterno_visitante.setText(p.getPaterno());
                TFmaterno_visitante.setText(p.getMaterno());
                TFedad_visitante.setText(String.valueOf(p.getEdad()));
                TFsexo_visitante.setText(p.getSexo());
                TFcontacto_visitante.setText(String.valueOf(p.getContacto()));
                TF_id_visitante.setText(String.valueOf(p.getId_Personal()));
                TF_id_fecha_medica_vis.setText(p.getTipo());
                TF_id_informaciones_vis.setText(p.getCategoria());
               
            }
        });
        //PERSONAL DE INFORMACION
        modeloTabla3 = (DefaultTableModel) TABLA_PERSONAL_INFORMACION.getModel();
        cargarInformadores();

        TABLA_PERSONAL_INFORMACION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_PERSONAL_INFORMACION.getSelectedRow();
        if(fila != -1){
            NodoPI n = listaPI.get(fila);
            TF_ID_INFORMADOR_PI.setText(String.valueOf(n.getId_Informador()));
            TF_HORARIO_PI.setText(n.getHorario());
            TF_NRO_PUESTO_PI.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_PI.setText(String.valueOf(n.getId_feria()));
        }
        });
        
        //PERSONAL DE ATENCION
        modeloTabla4 = (DefaultTableModel) TABLA_PERSONAL_ATENCION.getModel();
        cargarAtencion();

        TABLA_PERSONAL_ATENCION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_PERSONAL_ATENCION.getSelectedRow();
        if(fila != -1){
            NodoPA n = listaPA.get(fila);
            TF_ID_MEDICO_PA.setText(String.valueOf(n.getId_Medico()));
            TF_HORARIO_PA.setText(n.getHorario());
            TF_NROPUESTO_PA.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_PA.setText(String.valueOf(n.getId_feria()));
        }
        });
        
        //PERSONAL DE RECREACION
        modeloTabla5 = (DefaultTableModel) TABLA_PERSONAL_RECREACION.getModel();
        cargarRecreacion();

        TABLA_PERSONAL_RECREACION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_PERSONAL_RECREACION.getSelectedRow();
        if(fila != -1){
            NodoPR n = listaPR.get(fila);
            TF_ID_RECREACIONISTA_PR.setText(String.valueOf(n.getId_recreacionista()));
            TF_HORARIO_PR.setText(n.getHorario());
            TF_NRO_PUESTO_PR.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_PR.setText(String.valueOf(n.getId_feria()));
        }
    });
    }
    
    public void cargarVisitantes(){
        listaVisitantes=dao.cargaVisitantes();
        modeloTabla.setRowCount(0);
        for(Visitante v: listaVisitantes){
            if(v.getCi()>0){
                modeloTabla.addRow(new Object[]{
                v.getCi(),
                v.getNombre(),
                v.getPaterno(),
                v.getMaterno(),
                v.getEdad(),
                v.getSexo(),
                v.getContacto(),
                v.getId_Visitante(),
                v.getId_FichasMedicas(),
                v.getId_Informaciones()
                });
            }
                
            
        }
    }
    
    public void cargarPersonal(){
    listaPersonal = daoP.cargaPersonal();
    modeloTabla2.setRowCount(0);
    CSPer = new proyectoprogra3.CSimpleRP();
    for (proyectoprogra3.Personal p : listaPersonal) {
        if (p != null && p.getCi() > 0) {
            modeloTabla2.addRow(new Object[]{
                p.getCi(), p.getNombre(), p.getPaterno(), p.getMaterno(),
                p.getEdad(), p.getSexo(), p.getContacto(),
                p.getId_Personal(), p.getTipo(), p.getCategoria()
            });
            CSPer.adicionar(p);
        }
    }
}
    //PEWRSONAL DE INFORMACION
    public void cargarInformadores() {
    listaPI = daoPI.cargaInformadores();
    modeloTabla3.setRowCount(0);
    LsPI = new LSimplePI();
    for (NodoPI n : listaPI) {
        modeloTabla3.addRow(new Object[]{n.getId_Informador(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        LsPI.adicionar(n.getId_Informador(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
        }
    }
    //PERSONAL ATENCION
    public void cargarAtencion() {
    listaPA = daoPA.cargaPA();
    modeloTabla4.setRowCount(0);
    LsPA = new LSimplePA();
    for (NodoPA n : listaPA) {
        modeloTabla4.addRow(new Object[]{n.getId_Medico(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        LsPA.adicionar(n.getId_Medico(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
        }
    }
    //PERSONAL DE RECREACION
    public void cargarRecreacion() {
    listaPR = daoPR.cargaPR();
    modeloTabla5.setRowCount(0);
    LsPR = new LSimplePR();
    for (NodoPR n : listaPR) {
        modeloTabla5.addRow(new Object[]{n.getId_recreacionista(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        LsPR.adicionar(n.getId_recreacionista(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JF_REGISTRO_PERSONAL = new javax.swing.JFrame();
        jPanel2 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        TF_CI_PER = new javax.swing.JTextField();
        TF_NOM_PER = new javax.swing.JTextField();
        TF_PAT_PER = new javax.swing.JTextField();
        TF_MAT_PER = new javax.swing.JTextField();
        TF_EDAD_PER = new javax.swing.JTextField();
        TF_SEXO_PER = new javax.swing.JTextField();
        TF_CONT_PER = new javax.swing.JTextField();
        TF_ID_PERSONAL = new javax.swing.JTextField();
        TF_TIPO_PER = new javax.swing.JTextField();
        TF_CATE_PER = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        BTN_IR_A_VISITANTES_DE_PERSONAL = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TABLA_PERSONAL = new javax.swing.JTable();
        BTN_AGREGAR_PERSONAL = new javax.swing.JButton();
        Fondo1 = new javax.swing.JLabel();
        JF_FICHAS_MEDICAS = new javax.swing.JFrame();
        jPanel5 = new javax.swing.JPanel();
        BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        Fondo2 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        JF_STAND_INFORMATIVO = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITAS_DE_SI = new javax.swing.JButton();
        BTN_IR_INFORMADORES_DE_SI = new javax.swing.JButton();
        BTN_IR_COMPONENTES_DE_SI = new javax.swing.JButton();
        Fondo3 = new javax.swing.JLabel();
        JF_STAND_ATENCION = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITANTE_DE_SA = new javax.swing.JButton();
        BTN_IR_DOC_ATENCION_DE_SA = new javax.swing.JButton();
        Fondo4 = new javax.swing.JLabel();
        JF_STAND_RECREACION = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITANTES_DE_SR = new javax.swing.JButton();
        BTN_IR_REG_RECREACIONISTAS_DE_SR = new javax.swing.JButton();
        BTN_IR_COMPONENTES_DE_SR = new javax.swing.JButton();
        Fondo5 = new javax.swing.JLabel();
        JF_COMPONENTES = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        BTN_IR_SI_DE_COMPONENTES = new javax.swing.JButton();
        BTN_IR_SR_DE_COMPONENTES = new javax.swing.JButton();
        Fondo6 = new javax.swing.JLabel();
        JF_INFORMADORES = new javax.swing.JFrame();
        jPanel11 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        BTN_IR_SI_DE_REG_INFORMADORES = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        TF_ID_INFORMADOR_PI = new javax.swing.JTextField();
        TF_HORARIO_PI = new javax.swing.JTextField();
        TF_NRO_PUESTO_PI = new javax.swing.JTextField();
        TF_ID_FERIA_PI = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        TABLA_PERSONAL_INFORMACION = new javax.swing.JTable();
        BTN_AGREGAR_PERSONAL_INFORMACION = new javax.swing.JButton();
        Fondo7 = new javax.swing.JLabel();
        JF_DOC_ATENCION = new javax.swing.JFrame();
        jPanel12 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        BTN_IR_SA_DE_REG_DOC_ATENCION = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        TF_ID_MEDICO_PA = new javax.swing.JTextField();
        TF_HORARIO_PA = new javax.swing.JTextField();
        TF_NROPUESTO_PA = new javax.swing.JTextField();
        TF_ID_FERIA_PA = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        TABLA_PERSONAL_ATENCION = new javax.swing.JTable();
        BTN_AGREGAR_PERSONAL_ATENCION = new javax.swing.JButton();
        Fondo8 = new javax.swing.JLabel();
        JF_RECREACIONISTAS = new javax.swing.JFrame();
        jPanel13 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        BTN_IR_SR_DE_RECREACIONISTAS = new javax.swing.JButton();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TABLA_PERSONAL_RECREACION = new javax.swing.JTable();
        TF_ID_RECREACIONISTA_PR = new javax.swing.JTextField();
        TF_HORARIO_PR = new javax.swing.JTextField();
        TF_NRO_PUESTO_PR = new javax.swing.JTextField();
        TF_ID_FERIA_PR = new javax.swing.JTextField();
        Fondo9 = new javax.swing.JLabel();
        EJERCICIOS = new javax.swing.JFrame();
        BTN_IR_VIST_DE_EJERCICIOS = new javax.swing.JButton();
        Fondo10 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        TFci_visitante = new javax.swing.JTextField();
        TFnombre_visitante = new javax.swing.JTextField();
        TFpaterno_visitante = new javax.swing.JTextField();
        TFmaterno_visitante = new javax.swing.JTextField();
        TFedad_visitante = new javax.swing.JTextField();
        TFsexo_visitante = new javax.swing.JTextField();
        TFcontacto_visitante = new javax.swing.JTextField();
        TF_id_visitante = new javax.swing.JTextField();
        TF_id_fecha_medica_vis = new javax.swing.JTextField();
        TF_id_informaciones_vis = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TABLA_VISITANTES = new javax.swing.JTable();
        BTNAgregar_visitante = new javax.swing.JButton();
        BTNEditar_visitante = new javax.swing.JButton();
        Eliminar_visitante = new javax.swing.JButton();
        BTNLlenar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        BTN_IR_PERSONAL_DE_VISIT = new javax.swing.JButton();
        BTN_IR_FICHAMEDICA_DE_VISIT = new javax.swing.JButton();
        BTN_IR_STAND_INFORMACION_DE_VISIT = new javax.swing.JButton();
        BTN_IR_STAND_ATENCION_DE_VISIT = new javax.swing.JButton();
        BTN_IR_STAND_RECRACION_DE_VISIT = new javax.swing.JButton();
        BTN_IR_FERIAS_DE_VIST = new javax.swing.JButton();
        BTN_IR_EJERCICIOS_DE_VIST = new javax.swing.JButton();
        Fondo = new javax.swing.JLabel();

        JF_REGISTRO_PERSONAL.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 2, 60)); // NOI18N
        jLabel12.setText("REGISTRAR PERSONAL");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(134, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(123, 123, 123))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JF_REGISTRO_PERSONAL.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 100));

        TF_CI_PER.setToolTipText("");
        TF_CI_PER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_CI_PERActionPerformed(evt);
            }
        });
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_CI_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 150, -1));
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_NOM_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 150, -1));

        TF_PAT_PER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_PAT_PERActionPerformed(evt);
            }
        });
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_PAT_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 150, -1));

        TF_MAT_PER.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_MAT_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 230, 150, -1));

        TF_EDAD_PER.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_EDAD_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, 150, -1));

        TF_SEXO_PER.setToolTipText("");
        TF_SEXO_PER.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_SEXO_PERActionPerformed(evt);
            }
        });
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_SEXO_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 150, -1));

        TF_CONT_PER.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_CONT_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 150, -1));

        TF_ID_PERSONAL.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_ID_PERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 350, 150, -1));

        TF_TIPO_PER.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_TIPO_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 150, -1));

        TF_CATE_PER.setToolTipText("");
        JF_REGISTRO_PERSONAL.getContentPane().add(TF_CATE_PER, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 410, 150, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("CI");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, -1, -1));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("NOMBRE");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("PATERNO");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("MATERNO");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("EDAD");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, -1, -1));

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("SEXO");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("CONTACTO");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));

        jLabel20.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("ID PERSONAL");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, -1, -1));

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("tipo");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 30, -1));

        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("CATEGORIA");
        JF_REGISTRO_PERSONAL.getContentPane().add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 410, 70, 30));

        jPanel4.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_A_VISITANTES_DE_PERSONAL.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_A_VISITANTES_DE_PERSONAL.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_A_VISITANTES_DE_PERSONAL.setText("REGISTRAR VISITANTES");
        BTN_IR_A_VISITANTES_DE_PERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_A_VISITANTES_DE_PERSONALActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_A_VISITANTES_DE_PERSONAL, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_A_VISITANTES_DE_PERSONAL)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JF_REGISTRO_PERSONAL.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 130, 210, 40));

        TABLA_PERSONAL.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CI", "NOMBRE", "PATERNO", "MATERNO", "EDAD", "SEXO", "CONTACTO", "ID PERSONAL", "TIPO", "CATEGORIA"
            }
        ));
        jScrollPane3.setViewportView(TABLA_PERSONAL);

        JF_REGISTRO_PERSONAL.getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 830, 110));

        BTN_AGREGAR_PERSONAL.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_PERSONAL.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_PERSONAL.setText("AGREGAR");
        BTN_AGREGAR_PERSONAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_PERSONALActionPerformed(evt);
            }
        });
        JF_REGISTRO_PERSONAL.getContentPane().add(BTN_AGREGAR_PERSONAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 420, -1, -1));

        Fondo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_REGISTRO_PERSONAL.getContentPane().add(Fondo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 590));

        JF_FICHAS_MEDICAS.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS.setText("REGISTRAR VISITANTES");
        BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICASActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JF_FICHAS_MEDICAS.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 230, 40));

        jLabel23.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel23.setText("FICHAS MEDICAS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jLabel23)
                .addGap(241, 241, 241))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel23)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        JF_FICHAS_MEDICAS.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 70));

        Fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_FICHAS_MEDICAS.getContentPane().add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        jLabel31.setText("jLabel31");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        jLabel32.setText("jLabel32");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        JF_STAND_INFORMATIVO.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel24.setText("STAND INFORMATIVO");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(197, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(179, 179, 179))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel24)
                .addGap(40, 40, 40))
        );

        JF_STAND_INFORMATIVO.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 80));

        jPanel15.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_REGISTRO_VISITAS_DE_SI.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_REGISTRO_VISITAS_DE_SI.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_REGISTRO_VISITAS_DE_SI.setText("REGISTRO VISITAS");
        BTN_IR_REGISTRO_VISITAS_DE_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_REGISTRO_VISITAS_DE_SIActionPerformed(evt);
            }
        });

        BTN_IR_INFORMADORES_DE_SI.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_INFORMADORES_DE_SI.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_INFORMADORES_DE_SI.setText("INFORMADORES");
        BTN_IR_INFORMADORES_DE_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_INFORMADORES_DE_SIActionPerformed(evt);
            }
        });

        BTN_IR_COMPONENTES_DE_SI.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_COMPONENTES_DE_SI.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_COMPONENTES_DE_SI.setText("COMPONENTES");
        BTN_IR_COMPONENTES_DE_SI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_COMPONENTES_DE_SIActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addComponent(BTN_IR_REGISTRO_VISITAS_DE_SI)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(BTN_IR_COMPONENTES_DE_SI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_INFORMADORES_DE_SI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_REGISTRO_VISITAS_DE_SI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_INFORMADORES_DE_SI)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_COMPONENTES_DE_SI)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        JF_STAND_INFORMATIVO.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, -1, 110));

        Fondo3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_STAND_INFORMATIVO.getContentPane().add(Fondo3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_STAND_ATENCION.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel25.setText("STAND ATENCION");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(233, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(222, 222, 222))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel25)
                .addGap(40, 40, 40))
        );

        JF_STAND_ATENCION.getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 90));

        jPanel14.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_REGISTRO_VISITANTE_DE_SA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_REGISTRO_VISITANTE_DE_SA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_REGISTRO_VISITANTE_DE_SA.setText("REGISTRO VISITANTES");
        BTN_IR_REGISTRO_VISITANTE_DE_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_REGISTRO_VISITANTE_DE_SAActionPerformed(evt);
            }
        });

        BTN_IR_DOC_ATENCION_DE_SA.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_DOC_ATENCION_DE_SA.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_DOC_ATENCION_DE_SA.setText("DOCTORES");
        BTN_IR_DOC_ATENCION_DE_SA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_DOC_ATENCION_DE_SAActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_IR_REGISTRO_VISITANTE_DE_SA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_DOC_ATENCION_DE_SA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_REGISTRO_VISITANTE_DE_SA)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_DOC_ATENCION_DE_SA, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JF_STAND_ATENCION.getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 170, 70));

        Fondo4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_STAND_ATENCION.getContentPane().add(Fondo4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_STAND_RECREACION.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel26.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel26.setText("STAND RECREATIVO");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(192, 192, 192)
                .addComponent(jLabel26)
                .addContainerGap(224, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        JF_STAND_RECREACION.getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 90));

        jPanel16.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_REGISTRO_VISITANTES_DE_SR.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_REGISTRO_VISITANTES_DE_SR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_REGISTRO_VISITANTES_DE_SR.setText("REGISTRO VISITAS");
        BTN_IR_REGISTRO_VISITANTES_DE_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_REGISTRO_VISITANTES_DE_SRActionPerformed(evt);
            }
        });

        BTN_IR_REG_RECREACIONISTAS_DE_SR.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_REG_RECREACIONISTAS_DE_SR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_REG_RECREACIONISTAS_DE_SR.setText("RECREACIONISTAS");
        BTN_IR_REG_RECREACIONISTAS_DE_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_REG_RECREACIONISTAS_DE_SRActionPerformed(evt);
            }
        });

        BTN_IR_COMPONENTES_DE_SR.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_COMPONENTES_DE_SR.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_COMPONENTES_DE_SR.setText("COMPONENTES");
        BTN_IR_COMPONENTES_DE_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_COMPONENTES_DE_SRActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_IR_COMPONENTES_DE_SR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_REG_RECREACIONISTAS_DE_SR, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                    .addComponent(BTN_IR_REGISTRO_VISITANTES_DE_SR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_REGISTRO_VISITANTES_DE_SR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_REG_RECREACIONISTAS_DE_SR)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_COMPONENTES_DE_SR)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        JF_STAND_RECREACION.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, 110));

        Fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_STAND_RECREACION.getContentPane().add(Fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_COMPONENTES.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel27.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel27.setText("COMPONENTES");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(257, Short.MAX_VALUE)
                .addComponent(jLabel27)
                .addGap(254, 254, 254))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel27)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        JF_COMPONENTES.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 70));

        jPanel17.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_SI_DE_COMPONENTES.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_SI_DE_COMPONENTES.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_SI_DE_COMPONENTES.setText("STAND INFORMACION");
        BTN_IR_SI_DE_COMPONENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_SI_DE_COMPONENTESActionPerformed(evt);
            }
        });

        BTN_IR_SR_DE_COMPONENTES.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_SR_DE_COMPONENTES.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_SR_DE_COMPONENTES.setText("STAND RECREACION");
        BTN_IR_SR_DE_COMPONENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_SR_DE_COMPONENTESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(BTN_IR_SI_DE_COMPONENTES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_SR_DE_COMPONENTES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SI_DE_COMPONENTES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_SR_DE_COMPONENTES)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JF_COMPONENTES.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, 170, 70));

        Fondo6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_COMPONENTES.getContentPane().add(Fondo6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_INFORMADORES.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel28.setText("REGISTRO DE INFORMADORES");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(104, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(97, 97, 97))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JF_INFORMADORES.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 90));

        jPanel18.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_SI_DE_REG_INFORMADORES.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_SI_DE_REG_INFORMADORES.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_SI_DE_REG_INFORMADORES.setText("STAND INFORMACION");
        BTN_IR_SI_DE_REG_INFORMADORES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_SI_DE_REG_INFORMADORESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SI_DE_REG_INFORMADORES)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SI_DE_REG_INFORMADORES)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JF_INFORMADORES.getContentPane().add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 170, 50));

        jLabel33.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("ID INFORMADOR");
        JF_INFORMADORES.getContentPane().add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel34.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("HORARIO");
        JF_INFORMADORES.getContentPane().add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel35.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("NRO PUESTO");
        JF_INFORMADORES.getContentPane().add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel36.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("ID FERIA");
        JF_INFORMADORES.getContentPane().add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));
        JF_INFORMADORES.getContentPane().add(TF_ID_INFORMADOR_PI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 130, -1));
        JF_INFORMADORES.getContentPane().add(TF_HORARIO_PI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 130, -1));
        JF_INFORMADORES.getContentPane().add(TF_NRO_PUESTO_PI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 130, -1));
        JF_INFORMADORES.getContentPane().add(TF_ID_FERIA_PI, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 130, -1));

        TABLA_PERSONAL_INFORMACION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID INFORMADOR", "HORARIO", "NRO PUESTO", "ID FERIA"
            }
        ));
        jScrollPane2.setViewportView(TABLA_PERSONAL_INFORMACION);

        JF_INFORMADORES.getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 810, 150));

        BTN_AGREGAR_PERSONAL_INFORMACION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_PERSONAL_INFORMACION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_PERSONAL_INFORMACION.setText("AGREGAR");
        BTN_AGREGAR_PERSONAL_INFORMACION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_PERSONAL_INFORMACIONActionPerformed(evt);
            }
        });
        JF_INFORMADORES.getContentPane().add(BTN_AGREGAR_PERSONAL_INFORMACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 350, 140, 40));

        Fondo7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_INFORMADORES.getContentPane().add(Fondo7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_DOC_ATENCION.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel29.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel29.setText("REGISTRO DE DOC. ATENCION");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(67, 67, 67))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel29)
                .addContainerGap(8, Short.MAX_VALUE))
        );

        JF_DOC_ATENCION.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 90));

        jPanel19.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_SA_DE_REG_DOC_ATENCION.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_SA_DE_REG_DOC_ATENCION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_SA_DE_REG_DOC_ATENCION.setText("STAND ATENCION");
        BTN_IR_SA_DE_REG_DOC_ATENCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_SA_DE_REG_DOC_ATENCIONActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(BTN_IR_SA_DE_REG_DOC_ATENCION)
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SA_DE_REG_DOC_ATENCION)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JF_DOC_ATENCION.getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(685, 130, 150, 40));

        jLabel37.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("ID MEDICO");
        JF_DOC_ATENCION.getContentPane().add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 180, -1, -1));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("HORARIO");
        JF_DOC_ATENCION.getContentPane().add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 210, -1, -1));

        jLabel39.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("NRO PUESTO");
        JF_DOC_ATENCION.getContentPane().add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 240, -1, -1));

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("ID FERIA");
        JF_DOC_ATENCION.getContentPane().add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, -1));

        TF_ID_MEDICO_PA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_ID_MEDICO_PAActionPerformed(evt);
            }
        });
        JF_DOC_ATENCION.getContentPane().add(TF_ID_MEDICO_PA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 120, -1));
        JF_DOC_ATENCION.getContentPane().add(TF_HORARIO_PA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 200, 120, -1));
        JF_DOC_ATENCION.getContentPane().add(TF_NROPUESTO_PA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 120, -1));
        JF_DOC_ATENCION.getContentPane().add(TF_ID_FERIA_PA, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 270, 120, -1));

        TABLA_PERSONAL_ATENCION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID MEDICO", "HORARIO", "NRO PUESTO", "IS FERIA"
            }
        ));
        jScrollPane4.setViewportView(TABLA_PERSONAL_ATENCION);

        JF_DOC_ATENCION.getContentPane().add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 441, 790, 150));

        BTN_AGREGAR_PERSONAL_ATENCION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_PERSONAL_ATENCION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_PERSONAL_ATENCION.setText("AGREGAR");
        BTN_AGREGAR_PERSONAL_ATENCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_PERSONAL_ATENCIONActionPerformed(evt);
            }
        });
        JF_DOC_ATENCION.getContentPane().add(BTN_AGREGAR_PERSONAL_ATENCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 387, 100, 40));

        Fondo8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_DOC_ATENCION.getContentPane().add(Fondo8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_RECREACIONISTAS.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Segoe UI", 2, 48)); // NOI18N
        jLabel30.setText("REGISTRO DE RECREACIONISTAS");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel13Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel30)
                .addGap(93, 93, 93))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel30)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        JF_RECREACIONISTAS.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 90));

        BTN_IR_SR_DE_RECREACIONISTAS.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_SR_DE_RECREACIONISTAS.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_SR_DE_RECREACIONISTAS.setText("STAND RECREATIVO");
        BTN_IR_SR_DE_RECREACIONISTAS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_SR_DE_RECREACIONISTASActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SR_DE_RECREACIONISTAS)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_SR_DE_RECREACIONISTAS)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JF_RECREACIONISTAS.getContentPane().add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 130, -1, 40));

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("ID RECREACINISTA");
        JF_RECREACIONISTAS.getContentPane().add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("HORARIO");
        JF_RECREACIONISTAS.getContentPane().add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 210, -1, -1));

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("NRO PUESTO");
        JF_RECREACIONISTAS.getContentPane().add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, -1, -1));

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("ID FERIA");
        JF_RECREACIONISTAS.getContentPane().add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        jButton1.setBackground(new java.awt.Color(0, 0, 255));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("AGREGAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        JF_RECREACIONISTAS.getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 357, 100, 40));

        TABLA_PERSONAL_RECREACION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID RECREACIONISTA", "HORARIO", "NRO PUESTO", "ID FERIA"
            }
        ));
        jScrollPane5.setViewportView(TABLA_PERSONAL_RECREACION);

        JF_RECREACIONISTAS.getContentPane().add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 430, 810, 150));

        TF_ID_RECREACIONISTA_PR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_ID_RECREACIONISTA_PRActionPerformed(evt);
            }
        });
        JF_RECREACIONISTAS.getContentPane().add(TF_ID_RECREACIONISTA_PR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, 130, -1));
        JF_RECREACIONISTAS.getContentPane().add(TF_HORARIO_PR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, 130, -1));
        JF_RECREACIONISTAS.getContentPane().add(TF_NRO_PUESTO_PR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 240, 130, -1));
        JF_RECREACIONISTAS.getContentPane().add(TF_ID_FERIA_PR, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 130, -1));

        Fondo9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_RECREACIONISTAS.getContentPane().add(Fondo9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        EJERCICIOS.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTN_IR_VIST_DE_EJERCICIOS.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_VIST_DE_EJERCICIOS.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_VIST_DE_EJERCICIOS.setText("REGISTRO VISITANTES");
        BTN_IR_VIST_DE_EJERCICIOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_VIST_DE_EJERCICIOSActionPerformed(evt);
            }
        });
        EJERCICIOS.getContentPane().add(BTN_IR_VIST_DE_EJERCICIOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 530, 160, -1));

        Fondo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        EJERCICIOS.getContentPane().add(Fondo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 2, 60)); // NOI18N
        jLabel11.setText("REGISTRAR VISITANTE");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(145, 145, 145)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 100));
        getContentPane().add(TFci_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 130, 140, -1));
        getContentPane().add(TFnombre_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 160, 140, -1));

        TFpaterno_visitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFpaterno_visitanteActionPerformed(evt);
            }
        });
        getContentPane().add(TFpaterno_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, 140, -1));
        getContentPane().add(TFmaterno_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 140, -1));
        getContentPane().add(TFedad_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 140, -1));
        getContentPane().add(TFsexo_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 280, 140, -1));
        getContentPane().add(TFcontacto_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 140, -1));
        getContentPane().add(TF_id_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 140, -1));
        getContentPane().add(TF_id_fecha_medica_vis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 140, -1));

        TF_id_informaciones_vis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_id_informaciones_visActionPerformed(evt);
            }
        });
        getContentPane().add(TF_id_informaciones_vis, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 140, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("CI");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, 50, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NOMBRE");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PATERNO");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MATERNO");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("EDAD");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 260, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("sexo");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("contacto");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("id_vistantes");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("id_fechaMedica");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 90, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("id_informaciones");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, 100, 30));

        TABLA_VISITANTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "CI", "NOMBRE", "PATERNO", "MATERNO", "EDAD", "SEXO", "CONTACTO", "ID VISITANTE", "ID FICHA MEDICA", "ID FECHA_MEDIDA"
            }
        ));
        jScrollPane1.setViewportView(TABLA_VISITANTES);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 460, 820, 130));

        BTNAgregar_visitante.setBackground(new java.awt.Color(0, 0, 255));
        BTNAgregar_visitante.setForeground(new java.awt.Color(255, 255, 255));
        BTNAgregar_visitante.setText("Agregar");
        BTNAgregar_visitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNAgregar_visitanteActionPerformed(evt);
            }
        });
        getContentPane().add(BTNAgregar_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 130, 30));

        BTNEditar_visitante.setBackground(new java.awt.Color(255, 255, 0));
        BTNEditar_visitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        BTNEditar_visitante.setText("Editar");
        BTNEditar_visitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNEditar_visitanteActionPerformed(evt);
            }
        });
        getContentPane().add(BTNEditar_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 430, 130, -1));

        Eliminar_visitante.setBackground(new java.awt.Color(255, 0, 0));
        Eliminar_visitante.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        Eliminar_visitante.setForeground(new java.awt.Color(255, 255, 255));
        Eliminar_visitante.setText("Eliminar");
        Eliminar_visitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Eliminar_visitanteActionPerformed(evt);
            }
        });
        getContentPane().add(Eliminar_visitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, 130, -1));

        BTNLlenar.setBackground(new java.awt.Color(0, 204, 204));
        BTNLlenar.setText("LLENAR");
        BTNLlenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTNLlenarActionPerformed(evt);
            }
        });
        getContentPane().add(BTNLlenar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 430, 130, -1));

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        BTN_IR_PERSONAL_DE_VISIT.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_PERSONAL_DE_VISIT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_PERSONAL_DE_VISIT.setText("AGREGAR PERSONAL");
        BTN_IR_PERSONAL_DE_VISIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_PERSONAL_DE_VISITActionPerformed(evt);
            }
        });

        BTN_IR_FICHAMEDICA_DE_VISIT.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_FICHAMEDICA_DE_VISIT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_FICHAMEDICA_DE_VISIT.setText("AGREGAR FICHA MEDICA");
        BTN_IR_FICHAMEDICA_DE_VISIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_FICHAMEDICA_DE_VISITActionPerformed(evt);
            }
        });

        BTN_IR_STAND_INFORMACION_DE_VISIT.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_STAND_INFORMACION_DE_VISIT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_STAND_INFORMACION_DE_VISIT.setText("STAND INFORMACION");
        BTN_IR_STAND_INFORMACION_DE_VISIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_STAND_INFORMACION_DE_VISITActionPerformed(evt);
            }
        });

        BTN_IR_STAND_ATENCION_DE_VISIT.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_STAND_ATENCION_DE_VISIT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_STAND_ATENCION_DE_VISIT.setText("STAND ATENCION");
        BTN_IR_STAND_ATENCION_DE_VISIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_STAND_ATENCION_DE_VISITActionPerformed(evt);
            }
        });

        BTN_IR_STAND_RECRACION_DE_VISIT.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_STAND_RECRACION_DE_VISIT.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_STAND_RECRACION_DE_VISIT.setText("STAND DE RECREACION");
        BTN_IR_STAND_RECRACION_DE_VISIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_STAND_RECRACION_DE_VISITActionPerformed(evt);
            }
        });

        BTN_IR_FERIAS_DE_VIST.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_FERIAS_DE_VIST.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_FERIAS_DE_VIST.setText("FERIAS");
        BTN_IR_FERIAS_DE_VIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_FERIAS_DE_VISTActionPerformed(evt);
            }
        });

        BTN_IR_EJERCICIOS_DE_VIST.setBackground(new java.awt.Color(51, 51, 51));
        BTN_IR_EJERCICIOS_DE_VIST.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_EJERCICIOS_DE_VIST.setText("EJERCICIOS");
        BTN_IR_EJERCICIOS_DE_VIST.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_EJERCICIOS_DE_VISTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BTN_IR_STAND_ATENCION_DE_VISIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_STAND_INFORMACION_DE_VISIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_FICHAMEDICA_DE_VISIT, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(BTN_IR_PERSONAL_DE_VISIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_STAND_RECRACION_DE_VISIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_FERIAS_DE_VIST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BTN_IR_EJERCICIOS_DE_VIST, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BTN_IR_PERSONAL_DE_VISIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_FICHAMEDICA_DE_VISIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_STAND_INFORMACION_DE_VISIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_STAND_ATENCION_DE_VISIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_STAND_RECRACION_DE_VISIT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_FERIAS_DE_VIST)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BTN_IR_EJERCICIOS_DE_VIST)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 120, 190, 250));

        Fondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        getContentPane().add(Fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BTNAgregar_visitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNAgregar_visitanteActionPerformed
        Visitante v=new Visitante(
            Integer.parseInt(TFci_visitante.getText()),
            TFnombre_visitante.getText(),
            TFpaterno_visitante.getText(),
            TFmaterno_visitante.getText(),
            Integer.parseInt(TFedad_visitante.getText()),
            TFsexo_visitante.getText(),
            Integer.parseInt(TFcontacto_visitante.getText()),
            Integer.parseInt(TF_id_visitante.getText()),
            Integer.parseInt(TF_id_fecha_medica_vis.getText()),
            Integer.parseInt(TF_id_informaciones_vis.getText())
        );
        listaVisitantes.add(v);
        CSVis.adicionar(v);
        modeloTabla.addRow(new Object[]{v.getCi(), v.getNombre(),v.getPaterno(),v.getMaterno(),v.getEdad(),v.getSexo(),v.getContacto(),v.getId_Visitante(),v.getId_FichasMedicas(),v.getId_Informaciones()});
        dao.guardarVisitantes(listaVisitantes);
        LimpiarCampos_Visitantes();
        JOptionPane.showMessageDialog(null, "Visitante agregado correctamente");
    }//GEN-LAST:event_BTNAgregar_visitanteActionPerformed

    
    
    
    
    private void TF_id_informaciones_visActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_id_informaciones_visActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_id_informaciones_visActionPerformed

    private void TFpaterno_visitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFpaterno_visitanteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFpaterno_visitanteActionPerformed

    private void BTNEditar_visitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNEditar_visitanteActionPerformed
        int fila =TABLA_VISITANTES.getSelectedRow();
        if(fila!=-1){
            Visitante v=listaVisitantes.get(fila);
            v.setCi(Integer.parseInt(TFci_visitante.getText()));
            v.setNombre(TFnombre_visitante.getText());
            v.setPaterno(TFpaterno_visitante.getText());
            v.setMaterno(TFmaterno_visitante.getText());
            v.setEdad(Integer.parseInt(TFedad_visitante.getText()));
            v.setSexo(TFsexo_visitante.getText());
            v.setContacto(Integer.parseInt(TFcontacto_visitante.getText()));
            v.setId_Visitante(Integer.parseInt(TF_id_visitante.getText()));
            v.setId_FichasMedicas(Integer.parseInt(TF_id_fecha_medica_vis.getText()));
            v.setId_Informaciones(Integer.parseInt(TF_id_informaciones_vis.getText()));
        }
    }//GEN-LAST:event_BTNEditar_visitanteActionPerformed

    private void Eliminar_visitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Eliminar_visitanteActionPerformed
        int fila=TABLA_VISITANTES.getSelectedRow();
        if(fila!=-1){
            listaVisitantes.remove(fila);
            modeloTabla.removeRow(fila);
        }
    }//GEN-LAST:event_Eliminar_visitanteActionPerformed

    
    
    
    
    
    
    private void BTNLlenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTNLlenarActionPerformed
        //visitante
        listaVisitantes = dao.cargaVisitantes();
        modeloTabla.setRowCount(0);
        CSVis = new CSimpleV();
        
        for(Visitante v : listaVisitantes){
            if(v.getCi() > 0){
                modeloTabla.addRow(new Object[]{
                    v.getCi(), v.getNombre(), v.getPaterno(),
                    v.getMaterno(), v.getEdad(), v.getSexo(),
                    v.getContacto(), v.getId_Visitante(),
                    v.getId_FichasMedicas(), v.getId_Informaciones()
                });

                CSVis.adicionar(v);
            }
        
        }
        CSVis.mostrar();
        
        
        
        //personal
        listaPersonal = daoP.cargaPersonal();
        modeloTabla2.setRowCount(0);
        CSPer = new CSimpleRP();
        
        for(Personal p : listaPersonal){
            if(p.getCi() > 0){
                modeloTabla2.addRow(new Object[]{
                    p.getCi(), p.getNombre(), p.getPaterno(),
                    p.getMaterno(), p.getEdad(), p.getSexo(),
                    p.getContacto(), p.getId_Personal(),
                    p.getTipo(), p.getCategoria()
                });

                CSPer.adicionar(p);
            }
        
        }
        CSPer.mostrar();
        
       //informadores
       listaPI = daoPI.cargaInformadores();
        modeloTabla3.setRowCount(0);
        LsPI = new LSimplePI();

        for (NodoPI n : listaPI) {
            if (n != null) {
                modeloTabla3.addRow(new Object[]{
                    n.getId_Informador(),
                    n.getHorario(),
                    n.getNroPuesto(),
                    n.getId_feria()
                });

                LsPI.adicionar(n.getId_Informador(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
            }
        }
        LsPI.mostrar();
        
        //DOCTORES
        listaPA = daoPA.cargaPA();
        modeloTabla4.setRowCount(0);
        LsPA = new LSimplePA();

        for (NodoPA n : listaPA) {
            if (n != null) {
                modeloTabla4.addRow(new Object[]{
                    n.getId_Medico(),
                    n.getHorario(),
                    n.getNroPuesto(),
                    n.getId_feria()
                });

                LsPA.adicionar(n.getId_Medico(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
            }
        }
        LsPA.mostrar();
        
        //RECREACIONISTAS
        listaPR = daoPR.cargaPR();
        modeloTabla5.setRowCount(0);
        LsPR = new LSimplePR();

        for (NodoPR n : listaPR) {
            if (n != null) {
                modeloTabla5.addRow(new Object[]{
                    n.getId_recreacionista(),
                    n.getHorario(),
                    n.getNroPuesto(),
                    n.getId_feria()
                });

                LsPR.adicionar(n.getId_recreacionista(), n.getHorario(), n.getNroPuesto(), n.getId_feria());
            }
        }
        LsPR.mostrar();
    }//GEN-LAST:event_BTNLlenarActionPerformed

    
    
    
    
    
    
    private void BTN_IR_PERSONAL_DE_VISITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_PERSONAL_DE_VISITActionPerformed
        this.JF_REGISTRO_PERSONAL.setSize(865,620);
        this.JF_REGISTRO_PERSONAL.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_PERSONAL_DE_VISITActionPerformed

   
    private void BTN_IR_A_VISITANTES_DE_PERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_A_VISITANTES_DE_PERSONALActionPerformed
        this.JF_REGISTRO_PERSONAL.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_A_VISITANTES_DE_PERSONALActionPerformed

    private void TF_CI_PERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_CI_PERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_CI_PERActionPerformed

    private void TF_SEXO_PERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_SEXO_PERActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_SEXO_PERActionPerformed

    private void TF_PAT_PERActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_PAT_PERActionPerformed


        // TODO add your handling code here:
    }//GEN-LAST:event_TF_PAT_PERActionPerformed

    private void BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICASActionPerformed
        this.JF_FICHAS_MEDICAS.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICASActionPerformed

    private void BTN_IR_FICHAMEDICA_DE_VISITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_FICHAMEDICA_DE_VISITActionPerformed
        this.JF_FICHAS_MEDICAS.setSize(865,620);
        this.JF_FICHAS_MEDICAS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_FICHAMEDICA_DE_VISITActionPerformed

    private void BTN_IR_FERIAS_DE_VISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_FERIAS_DE_VISTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTN_IR_FERIAS_DE_VISTActionPerformed

    private void BTN_IR_EJERCICIOS_DE_VISTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_EJERCICIOS_DE_VISTActionPerformed
        this.EJERCICIOS.setSize(865,620);
        this.EJERCICIOS.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_EJERCICIOS_DE_VISTActionPerformed

    private void BTN_IR_REGISTRO_VISITANTE_DE_SAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_REGISTRO_VISITANTE_DE_SAActionPerformed
        this.JF_STAND_ATENCION.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_REGISTRO_VISITANTE_DE_SAActionPerformed

    private void BTN_IR_REGISTRO_VISITAS_DE_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_REGISTRO_VISITAS_DE_SIActionPerformed
        this.JF_STAND_INFORMATIVO.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_REGISTRO_VISITAS_DE_SIActionPerformed

    private void BTN_IR_REGISTRO_VISITANTES_DE_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_REGISTRO_VISITANTES_DE_SRActionPerformed
        this.JF_STAND_RECREACION.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_REGISTRO_VISITANTES_DE_SRActionPerformed

    private void BTN_IR_DOC_ATENCION_DE_SAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_DOC_ATENCION_DE_SAActionPerformed
        this.JF_DOC_ATENCION.setSize(865,620);
        this.JF_DOC_ATENCION.setVisible(true);
        this.JF_STAND_ATENCION.setVisible(false);
    }//GEN-LAST:event_BTN_IR_DOC_ATENCION_DE_SAActionPerformed

    private void BTN_IR_INFORMADORES_DE_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_INFORMADORES_DE_SIActionPerformed
        this.JF_INFORMADORES.setSize(865,620);
        this.JF_INFORMADORES.setVisible(true);
        this.JF_STAND_INFORMATIVO.setVisible(false);
    }//GEN-LAST:event_BTN_IR_INFORMADORES_DE_SIActionPerformed

    private void BTN_IR_COMPONENTES_DE_SIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_COMPONENTES_DE_SIActionPerformed
        this.JF_COMPONENTES.setSize(865,620);
        this.JF_COMPONENTES.setVisible(true);
        this.JF_STAND_INFORMATIVO.setVisible(false);
    }//GEN-LAST:event_BTN_IR_COMPONENTES_DE_SIActionPerformed

    private void BTN_IR_REG_RECREACIONISTAS_DE_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_REG_RECREACIONISTAS_DE_SRActionPerformed
        this.JF_RECREACIONISTAS.setSize(865,620);
        this.JF_RECREACIONISTAS.setVisible(true);
        this.JF_STAND_RECREACION.setVisible(false);
    }//GEN-LAST:event_BTN_IR_REG_RECREACIONISTAS_DE_SRActionPerformed

    private void BTN_IR_COMPONENTES_DE_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_COMPONENTES_DE_SRActionPerformed
        this.JF_COMPONENTES.setSize(865,620);
        this.JF_COMPONENTES.setVisible(true);
        this.JF_STAND_RECREACION.setVisible(false);
    }//GEN-LAST:event_BTN_IR_COMPONENTES_DE_SRActionPerformed

    private void BTN_IR_SI_DE_COMPONENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_SI_DE_COMPONENTESActionPerformed
        this.JF_STAND_INFORMATIVO.setSize(865,620);
        this.JF_STAND_INFORMATIVO.setVisible(true);
        this.JF_COMPONENTES.setVisible(false);
    }//GEN-LAST:event_BTN_IR_SI_DE_COMPONENTESActionPerformed

    private void BTN_IR_SR_DE_COMPONENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_SR_DE_COMPONENTESActionPerformed
        this.JF_STAND_RECREACION.setSize(865,620);
        this.JF_STAND_RECREACION.setVisible(true);
        this.JF_COMPONENTES.setVisible(false);
    }//GEN-LAST:event_BTN_IR_SR_DE_COMPONENTESActionPerformed

    private void BTN_IR_SI_DE_REG_INFORMADORESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_SI_DE_REG_INFORMADORESActionPerformed
        this.JF_STAND_INFORMATIVO.setSize(865,620);
        this.JF_STAND_INFORMATIVO.setVisible(true);
        this.JF_INFORMADORES.setVisible(false);
    }//GEN-LAST:event_BTN_IR_SI_DE_REG_INFORMADORESActionPerformed

    private void BTN_IR_SA_DE_REG_DOC_ATENCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_SA_DE_REG_DOC_ATENCIONActionPerformed
        this.JF_STAND_ATENCION.setSize(865,620);
        this.JF_STAND_ATENCION.setVisible(true);
        this.JF_DOC_ATENCION.setVisible(false);
    }//GEN-LAST:event_BTN_IR_SA_DE_REG_DOC_ATENCIONActionPerformed

    private void BTN_IR_SR_DE_RECREACIONISTASActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_SR_DE_RECREACIONISTASActionPerformed
        this.JF_STAND_RECREACION.setSize(865,620);
        this.JF_STAND_RECREACION.setVisible(true);
        this.JF_RECREACIONISTAS.setVisible(false);
    }//GEN-LAST:event_BTN_IR_SR_DE_RECREACIONISTASActionPerformed

    private void BTN_IR_STAND_INFORMACION_DE_VISITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_STAND_INFORMACION_DE_VISITActionPerformed
        this.JF_STAND_INFORMATIVO.setSize(865,620);
        this.JF_STAND_INFORMATIVO.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_STAND_INFORMACION_DE_VISITActionPerformed

    private void BTN_IR_STAND_ATENCION_DE_VISITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_STAND_ATENCION_DE_VISITActionPerformed
        this.JF_STAND_ATENCION.setSize(865,620);
        this.JF_STAND_ATENCION.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_STAND_ATENCION_DE_VISITActionPerformed

    private void BTN_IR_STAND_RECRACION_DE_VISITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_STAND_RECRACION_DE_VISITActionPerformed
        this.JF_STAND_RECREACION.setSize(865,620);
        this.JF_STAND_RECREACION.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_STAND_RECRACION_DE_VISITActionPerformed

    private void BTN_IR_VIST_DE_EJERCICIOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_VIST_DE_EJERCICIOSActionPerformed
        this.EJERCICIOS.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_BTN_IR_VIST_DE_EJERCICIOSActionPerformed

    private void BTN_AGREGAR_PERSONALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_PERSONALActionPerformed
        try {
        
        proyectoprogra3.Personal p = new proyectoprogra3.Personal(
            Integer.parseInt(TF_CI_PER.getText()),
            TF_NOM_PER.getText(),
            TF_PAT_PER.getText(),
            TF_MAT_PER.getText(),
            Integer.parseInt(TF_EDAD_PER.getText()),
            TF_SEXO_PER.getText(),
            Integer.parseInt(TF_CONT_PER.getText()),
            Integer.parseInt(TF_ID_PERSONAL.getText()),
            TF_TIPO_PER.getText(),
            TF_CATE_PER.getText()
        );

        listaPersonal.add(p);
        CSPer.adicionar(p);
        modeloTabla2.addRow(new Object[]{p.getCi(), p.getNombre(), p.getPaterno(), p.getMaterno(), p.getEdad(), p.getSexo(), p.getContacto(), p.getId_Personal(), p.getTipo(), p.getCategoria()});
        daoP.guardarPersonal(listaPersonal);
        LimpiarCampos_Personal();
        JOptionPane.showMessageDialog(this, "Personal agregado correctamente");
        } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(this, "Revisa los campos numéricos. No deben estar vacíos ni contener texto.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_BTN_AGREGAR_PERSONALActionPerformed

    private void BTN_AGREGAR_PERSONAL_INFORMACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_PERSONAL_INFORMACIONActionPerformed
        NodoPI n = new NodoPI();
        n.setId_Informador(Integer.parseInt(TF_ID_INFORMADOR_PI.getText()));
        n.setHorario(TF_HORARIO_PI.getText());
        n.setNroPuesto(Integer.parseInt(TF_NRO_PUESTO_PI.getText()));
        n.setId_feria(Integer.parseInt(TF_ID_FERIA_PI.getText()));

        listaPI.add(n);           
        LsPI.adicionar(n.getId_Informador(), n.getHorario(), n.getNroPuesto(), n.getId_feria()); // para la lista enlazada
        modeloTabla3.addRow(new Object[]{n.getId_Informador(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        daoPI.guardarInformadores(listaPI); // guardar archivo
        LimpiarCampos_Informadores();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LsPI.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_PERSONAL_INFORMACIONActionPerformed

    private void TF_ID_MEDICO_PAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_ID_MEDICO_PAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_ID_MEDICO_PAActionPerformed

    private void BTN_AGREGAR_PERSONAL_ATENCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_PERSONAL_ATENCIONActionPerformed
        NodoPA n = new NodoPA();
        n.setId_Medico(Integer.parseInt(TF_ID_MEDICO_PA.getText()));
        n.setHorario(TF_HORARIO_PA.getText());
        n.setNroPuesto(Integer.parseInt(TF_NROPUESTO_PA.getText()));
        n.setId_feria(Integer.parseInt(TF_ID_FERIA_PA.getText()));

        listaPA.add(n);          
        LsPA.adicionar(n.getId_Medico(), n.getHorario(), n.getNroPuesto(), n.getId_feria()); 
        modeloTabla4.addRow(new Object[]{n.getId_Medico(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        daoPA.guardarPA(listaPA); // guardar archivo
        LimpiarCampos_Personal_Atencion();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LsPA.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_PERSONAL_ATENCIONActionPerformed

    private void TF_ID_RECREACIONISTA_PRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_ID_RECREACIONISTA_PRActionPerformed
        NodoPR n = new NodoPR();
        n.setId_recreacionista(Integer.parseInt(TF_ID_RECREACIONISTA_PR.getText()));
        n.setHorario(TF_HORARIO_PR.getText());
        n.setNroPuesto(Integer.parseInt(TF_NRO_PUESTO_PR.getText()));
        n.setId_feria(Integer.parseInt(TF_ID_FERIA_PR.getText()));

        listaPR.add(n);          
        LsPR.adicionar(n.getId_recreacionista(), n.getHorario(), n.getNroPuesto(), n.getId_feria()); 
        modeloTabla5.addRow(new Object[]{n.getId_recreacionista(), n.getHorario(), n.getNroPuesto(), n.getId_feria()});
        daoPR.guardarPR(listaPR); // guardar archivo
        LimpiarCampos_Personal_Recreacion();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LsPR.mostrar();
    }//GEN-LAST:event_TF_ID_RECREACIONISTA_PRActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed
    
    
    
    
    public void LimpiarCampos_Visitantes(){
        TFci_visitante.setText("");
        TFnombre_visitante.setText("");
        TFpaterno_visitante.setText("");
        TFmaterno_visitante.setText("");
        TFedad_visitante.setText("");
        TFsexo_visitante.setText("");
        TFcontacto_visitante.setText("");
        TF_id_visitante.setText("");
        TF_id_fecha_medica_vis.setText("");
        TF_id_informaciones_vis.setText("");
    }
    
    
    public void LimpiarCampos_Personal(){
        TF_CI_PER.setText("");
        TF_NOM_PER.setText("");
        TF_PAT_PER.setText("");
        TF_MAT_PER.setText("");
        TF_EDAD_PER.setText("");
        TF_SEXO_PER.setText("");
        TF_CONT_PER.setText("");
        TF_ID_PERSONAL.setText("");
        TF_TIPO_PER.setText("");
        TF_CATE_PER.setText("");
    }
    
    public void LimpiarCampos_Informadores(){
        TF_ID_INFORMADOR_PI.setText("");
        TF_HORARIO_PI.setText("");
        TF_NRO_PUESTO_PI.setText("");
        TF_ID_FERIA_PI.setText("");
    }
    
    public void LimpiarCampos_Personal_Atencion(){
        TF_ID_MEDICO_PA.setText("");
        TF_HORARIO_PA.setText("");
        TF_NROPUESTO_PA.setText("");
        TF_ID_FERIA_PA.setText("");
    }
    
    public void LimpiarCampos_Personal_Recreacion(){
        TF_ID_RECREACIONISTA_PR.setText("");
        TF_HORARIO_PR.setText("");
        TF_NRO_PUESTO_PR.setText("");
        TF_ID_FERIA_PR.setText("");
    }
    
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
            java.util.logging.Logger.getLogger(Registo_Visitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registo_Visitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registo_Visitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registo_Visitantes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registo_Visitantes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTNAgregar_visitante;
    private javax.swing.JButton BTNEditar_visitante;
    private javax.swing.JButton BTNLlenar;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL_ATENCION;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL_INFORMACION;
    private javax.swing.JButton BTN_IR_A_VISITANTES_DE_PERSONAL;
    private javax.swing.JButton BTN_IR_COMPONENTES_DE_SI;
    private javax.swing.JButton BTN_IR_COMPONENTES_DE_SR;
    private javax.swing.JButton BTN_IR_DOC_ATENCION_DE_SA;
    private javax.swing.JButton BTN_IR_EJERCICIOS_DE_VIST;
    private javax.swing.JButton BTN_IR_FERIAS_DE_VIST;
    private javax.swing.JButton BTN_IR_FICHAMEDICA_DE_VISIT;
    private javax.swing.JButton BTN_IR_INFORMADORES_DE_SI;
    private javax.swing.JButton BTN_IR_PERSONAL_DE_VISIT;
    private javax.swing.JButton BTN_IR_REGISTRO_VISITANTES_DE_SR;
    private javax.swing.JButton BTN_IR_REGISTRO_VISITANTE_DE_SA;
    private javax.swing.JButton BTN_IR_REGISTRO_VISITAS_DE_SI;
    private javax.swing.JButton BTN_IR_REGISTR_VISITANTES_DE_FICHASMEDICAS;
    private javax.swing.JButton BTN_IR_REG_RECREACIONISTAS_DE_SR;
    private javax.swing.JButton BTN_IR_SA_DE_REG_DOC_ATENCION;
    private javax.swing.JButton BTN_IR_SI_DE_COMPONENTES;
    private javax.swing.JButton BTN_IR_SI_DE_REG_INFORMADORES;
    private javax.swing.JButton BTN_IR_SR_DE_COMPONENTES;
    private javax.swing.JButton BTN_IR_SR_DE_RECREACIONISTAS;
    private javax.swing.JButton BTN_IR_STAND_ATENCION_DE_VISIT;
    private javax.swing.JButton BTN_IR_STAND_INFORMACION_DE_VISIT;
    private javax.swing.JButton BTN_IR_STAND_RECRACION_DE_VISIT;
    private javax.swing.JButton BTN_IR_VIST_DE_EJERCICIOS;
    private javax.swing.JFrame EJERCICIOS;
    private javax.swing.JButton Eliminar_visitante;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Fondo1;
    private javax.swing.JLabel Fondo10;
    private javax.swing.JLabel Fondo2;
    private javax.swing.JLabel Fondo3;
    private javax.swing.JLabel Fondo4;
    private javax.swing.JLabel Fondo5;
    private javax.swing.JLabel Fondo6;
    private javax.swing.JLabel Fondo7;
    private javax.swing.JLabel Fondo8;
    private javax.swing.JLabel Fondo9;
    private javax.swing.JFrame JF_COMPONENTES;
    private javax.swing.JFrame JF_DOC_ATENCION;
    private javax.swing.JFrame JF_FICHAS_MEDICAS;
    private javax.swing.JFrame JF_INFORMADORES;
    private javax.swing.JFrame JF_RECREACIONISTAS;
    private javax.swing.JFrame JF_REGISTRO_PERSONAL;
    private javax.swing.JFrame JF_STAND_ATENCION;
    private javax.swing.JFrame JF_STAND_INFORMATIVO;
    private javax.swing.JFrame JF_STAND_RECREACION;
    private javax.swing.JTable TABLA_PERSONAL;
    private javax.swing.JTable TABLA_PERSONAL_ATENCION;
    private javax.swing.JTable TABLA_PERSONAL_INFORMACION;
    private javax.swing.JTable TABLA_PERSONAL_RECREACION;
    private javax.swing.JTable TABLA_VISITANTES;
    private javax.swing.JTextField TF_CATE_PER;
    private javax.swing.JTextField TF_CI_PER;
    private javax.swing.JTextField TF_CONT_PER;
    private javax.swing.JTextField TF_EDAD_PER;
    private javax.swing.JTextField TF_HORARIO_PA;
    private javax.swing.JTextField TF_HORARIO_PI;
    private javax.swing.JTextField TF_HORARIO_PR;
    private javax.swing.JTextField TF_ID_FERIA_PA;
    private javax.swing.JTextField TF_ID_FERIA_PI;
    private javax.swing.JTextField TF_ID_FERIA_PR;
    private javax.swing.JTextField TF_ID_INFORMADOR_PI;
    private javax.swing.JTextField TF_ID_MEDICO_PA;
    private javax.swing.JTextField TF_ID_PERSONAL;
    private javax.swing.JTextField TF_ID_RECREACIONISTA_PR;
    private javax.swing.JTextField TF_MAT_PER;
    private javax.swing.JTextField TF_NOM_PER;
    private javax.swing.JTextField TF_NROPUESTO_PA;
    private javax.swing.JTextField TF_NRO_PUESTO_PI;
    private javax.swing.JTextField TF_NRO_PUESTO_PR;
    private javax.swing.JTextField TF_PAT_PER;
    private javax.swing.JTextField TF_SEXO_PER;
    private javax.swing.JTextField TF_TIPO_PER;
    private javax.swing.JTextField TF_id_fecha_medica_vis;
    private javax.swing.JTextField TF_id_informaciones_vis;
    private javax.swing.JTextField TF_id_visitante;
    private javax.swing.JTextField TFci_visitante;
    private javax.swing.JTextField TFcontacto_visitante;
    private javax.swing.JTextField TFedad_visitante;
    private javax.swing.JTextField TFmaterno_visitante;
    private javax.swing.JTextField TFnombre_visitante;
    private javax.swing.JTextField TFpaterno_visitante;
    private javax.swing.JTextField TFsexo_visitante;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    // End of variables declaration//GEN-END:variables

    
}
