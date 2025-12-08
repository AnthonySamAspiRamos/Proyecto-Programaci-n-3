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
    
    //componentes
    private DefaultTableModel modeloTabla6;
    private List<NodoC> listaC = new ArrayList<>();
    private ComponentesDAO daoC=new ComponentesDAO();
    private LSimpleC LsC=new LSimpleC();
    
    
    //STAND DE INFORMACION
    private DefaultTableModel modeloTabla7;
    private List<NodoSI> listaSI = new ArrayList<>();
    private Stand_InformacionDAO daoSI=new Stand_InformacionDAO();
    private LDobleSI LdSI=new LDobleSI();
    
    //STAND ATENCION
    private DefaultTableModel modeloTabla8;
    private List<NodoSA> listaSA = new ArrayList<>();
    private Stand_AtencionDAO daoSA=new Stand_AtencionDAO();
    private LDobleSA LdSA=new LDobleSA();
    
    //STAND RECREACION
    private DefaultTableModel modeloTabla9;
    private List<NodoSR> listaSR = new ArrayList<>();
    private Stand_RecreacionDAO daoSR=new Stand_RecreacionDAO();
    private LDobleSR LdSR=new LDobleSR();
    
    //DIAGNOSTICO
    private DefaultTableModel modeloTabla10;
    private List<NodoDi> listaDi = new ArrayList<>();
    private DiagnosticoDAO daoDi=new DiagnosticoDAO();
    private LDobleCirDi LdDi=new LDobleCirDi();
    
    //instrumentosDOc
    private DefaultTableModel modeloTabla11;
    private List<InstrumentosDoc> listaPIDOC=new ArrayList<>();
    private InstrumentosDAO daoPIDOC=new InstrumentosDAO();
    private PilaInsD PInsD=new PilaInsD();
    
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
        
        //componentes
        modeloTabla6 = (DefaultTableModel) TABLA_COMPONENTES.getModel();
        cargarComponente();

        TABLA_COMPONENTES.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_COMPONENTES.getSelectedRow();
        if(fila != -1){
            NodoC n = listaC.get(fila);
            TF_ID_COMP.setText(String.valueOf(n.getId_componente()));
            TF_ID_GRUPOCOMP.setText(String.valueOf(n.getId_GrupoComponente()));
            TF_NOMBRE_COMP.setText(n.getNombre());
            TF_UTILIDAD_COMP.setText(n.getUtilidad());
            TF_OBSERVACIONES_COMP.setText(n.getUtilidad());
        }
        });
        
        //STAND INFORMACION
        modeloTabla7 = (DefaultTableModel) TABLA_STAND_INFORMACION.getModel();
        cargarSI();

        TABLA_STAND_INFORMACION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_STAND_INFORMACION.getSelectedRow();
        if(fila != -1){
            NodoSI n = listaSI.get(fila);
            TF_NRO_PUESTO_SI.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_SI.setText(String.valueOf(n.getIdFeria()));
            TF_ID_COMP_SI.setText(String.valueOf(n.getId_Componentes()));
        }
        });
        
        //STAND ATENCION
        modeloTabla8 = (DefaultTableModel) TABLA_STAND_ATENCION.getModel();
        cargarSA();

        TABLA_STAND_ATENCION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_STAND_ATENCION.getSelectedRow();
        if(fila != -1){
            NodoSA n = listaSA.get(fila);
            TF_NROPUESTO_SA.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_SA.setText(String.valueOf(n.getIdFeria()));
            TF_INSTRUMENTOS_SA.setText(String.valueOf(n.getIdInstrumentosDoc()));
        }
        });
        
        //STAND RECREACION
        modeloTabla9 = (DefaultTableModel) TABLA_STAND_RECREACION.getModel();
        cargarSR();

        TABLA_STAND_RECREACION.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_STAND_RECREACION.getSelectedRow();
        if(fila != -1){
            NodoSR n = listaSR.get(fila);
            TF_NRO_PUESTO_SR.setText(String.valueOf(n.getNroPuesto()));
            TF_ID_FERIA_SR.setText(String.valueOf(n.getIdFeria()));
            TF_ID_COMP_SR.setText(String.valueOf(n.getId_Componentes()));
        }
        });
        
        //DIAGNOSTICO
        modeloTabla10 = (DefaultTableModel) TABLA_DIAGNOSTICO.getModel();
        cargarSR();

        TABLA_DIAGNOSTICO.getSelectionModel().addListSelectionListener(e -> {
        int fila = TABLA_DIAGNOSTICO.getSelectedRow();
        if(fila != -1){
            NodoDi n = listaDi.get(fila);
            TF_ID_VISIT_DI.setText(String.valueOf(n.getId_Visitante()));
            TF_ID_MEDICO_DI.setText(String.valueOf(n.getId_Medico()));
            TF_ID_COMP_SR.setText(n.getAntesedentes());
            TF_MOTIVOS_DI.setText(n.getAntesedentes());
            TF_HALLAZGOS_DI.setText(n.getAntesedentes());
            TF_DECISIONES_DI.setText(n.getAntesedentes());
            TF_TRATAMIENTO_DI.setText(n.getAntesedentes());
            TF_EVALUACION_DI.setText(n.getAntesedentes());
            TF_ID_FERIA_DI.setText(String.valueOf(n.getId_Feria()));
            TF_FECHA_DI.setText(n.getFecha());
        }
        });
        
        
        //instrumento 
        modeloTabla11 =(DefaultTableModel)TABLA_INSTRUMENTO.getModel();
        cargarVisitantes();
        
        TABLA_INSTRUMENTO.getSelectionModel().addListSelectionListener(e -> {
            int fila = TABLA_INSTRUMENTO.getSelectedRow();
            if(fila !=-1){
                InstrumentosDoc v=listaPIDOC.get(fila);
                TF_ID_INST.setText(String.valueOf(v.getId_instrumento()));
                TF_GRUPO_INSTRUMENTO.setText(String.valueOf(v.getGrupo_instrumentos()));
                TF_NRO_PUESTO_INST.setText(String.valueOf(v.getNropuesto()));
                TF_NOMBRE_INST.setText(v.getTipo());
                TF_TIPO_INST.setText(String.valueOf(v.getTipo()));
                TF_OBS_INST.setText(v.getObservacion());
               
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
    
    //componentes
    public void cargarComponente() {
    listaC = daoC.cargaComponente();
    modeloTabla6.setRowCount(0);
    LsC = new LSimpleC();
    for (NodoC n : listaC) {
        modeloTabla6.addRow(new Object[]{n.getId_componente(), n.getId_GrupoComponente(), n.getNombre(), n.getUtilidad(),n.getObservaciones()});
        LsC.adiFinal(n.getId_componente(), n.getId_GrupoComponente(), n.getNombre(), n.getUtilidad(),n.getObservaciones());
        }
    }
    
    //STAND INFORMACION
    public void cargarSI() {
    listaSI = daoSI.cargaSI();
    modeloTabla7.setRowCount(0);
    LdSI = new LDobleSI();
    for (NodoSI n : listaSI) {
        modeloTabla7.addRow(new Object[]{n.getNroPuesto(), n.getIdFeria(), n.getId_Componentes()});
        LdSI.adicionar(n.getNroPuesto(), n.getIdFeria(), n.getId_Componentes());
        }
    }
    
    //STAND ATENCION
    public void cargarSA() {
    listaSA = daoSA.cargaSA();
    modeloTabla8.setRowCount(0);
    LdSA = new LDobleSA();
    for (NodoSA n : listaSA) {
        modeloTabla8.addRow(new Object[]{n.getNroPuesto(), n.getIdFeria(), n.getIdInstrumentosDoc()});
        LdSA.adicionar(n.getNroPuesto(), n.getIdFeria(), n.getIdInstrumentosDoc());
        }
    }
    
    //STAND RECREACION
    public void cargarSR() {
    listaSR = daoSR.cargaSR();
    modeloTabla9.setRowCount(0);
    LdSR = new LDobleSR();
    for (NodoSR n : listaSR) {
        modeloTabla9.addRow(new Object[]{n.getNroPuesto(), n.getIdFeria(), n.getId_Componentes()});
        LdSR.adicionar(n.getNroPuesto(), n.getIdFeria(), n.getId_Componentes());
        }
    }
    
    //DIAGNOSTICO
    public void cargarDi() {
    listaDi = daoDi.cargaDi();
    modeloTabla10.setRowCount(0);
    LdDi = new LDobleCirDi();
    for (NodoDi n : listaDi) {
        modeloTabla10.addRow(new Object[]{n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha()});
        LdDi.adiprincipio(n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha());
        }
    }
    
    //instruemntos
    public void cargarInstrumentos(){
        listaPIDOC=daoPIDOC.cargarInst();
        modeloTabla11.setRowCount(0);
        for(InstrumentosDoc v: listaPIDOC){
            if(v.getId_instrumento()>0){
                modeloTabla11.addRow(new Object[]{
                v.getId_instrumento(),
                v.getGrupo_instrumentos(),
                v.getNropuesto(),
                v.getNombre(),
                v.getTipo(),
                v.getObservacion()
                });
            }
                
            
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
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        TF_ID_VISIT_DI = new javax.swing.JTextField();
        TF_ID_MEDICO_DI = new javax.swing.JTextField();
        TF_ANTECEDENTES_DI = new javax.swing.JTextField();
        TF_MOTIVOS_DI = new javax.swing.JTextField();
        TF_HALLAZGOS_DI = new javax.swing.JTextField();
        TF_DECISIONES_DI = new javax.swing.JTextField();
        TF_TRATAMIENTO_DI = new javax.swing.JTextField();
        TF_EVALUACION_DI = new javax.swing.JTextField();
        TF_ID_FERIA_DI = new javax.swing.JTextField();
        TF_FECHA_DI = new javax.swing.JTextField();
        BTN_AGREGAR_DIAGNOSTICO = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        TABLA_DIAGNOSTICO = new javax.swing.JTable();
        Fondo2 = new javax.swing.JLabel();
        JF_FICHAS_INFORMATIVAS = new javax.swing.JFrame();
        Fondo11 = new javax.swing.JLabel();
        JF_STAND_INFORMATIVO = new javax.swing.JFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jPanel15 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITAS_DE_SI = new javax.swing.JButton();
        BTN_IR_INFORMADORES_DE_SI = new javax.swing.JButton();
        BTN_IR_COMPONENTES_DE_SI = new javax.swing.JButton();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        TF_NRO_PUESTO_SI = new javax.swing.JTextField();
        TF_ID_FERIA_SI = new javax.swing.JTextField();
        TF_ID_COMP_SI = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        TABLA_STAND_INFORMACION = new javax.swing.JTable();
        BTN_AGREGAR_STAND_INFORMACION = new javax.swing.JButton();
        Fondo3 = new javax.swing.JLabel();
        JF_STAND_ATENCION = new javax.swing.JFrame();
        jPanel8 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITANTE_DE_SA = new javax.swing.JButton();
        BTN_IR_DOC_ATENCION_DE_SA = new javax.swing.JButton();
        jLabel53 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        TF_NROPUESTO_SA = new javax.swing.JTextField();
        TF_ID_FERIA_SA = new javax.swing.JTextField();
        TF_INSTRUMENTOS_SA = new javax.swing.JTextField();
        BTN_AGREGAR_STAND_ATENCION = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        TABLA_STAND_ATENCION = new javax.swing.JTable();
        Fondo4 = new javax.swing.JLabel();
        JF_STAND_RECREACION = new javax.swing.JFrame();
        jPanel9 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        BTN_IR_REGISTRO_VISITANTES_DE_SR = new javax.swing.JButton();
        BTN_IR_REG_RECREACIONISTAS_DE_SR = new javax.swing.JButton();
        BTN_IR_COMPONENTES_DE_SR = new javax.swing.JButton();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        TF_NRO_PUESTO_SR = new javax.swing.JTextField();
        TF_ID_FERIA_SR = new javax.swing.JTextField();
        TF_ID_COMP_SR = new javax.swing.JTextField();
        BTN_AGREGAR_STAND_RECREACION = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        TABLA_STAND_RECREACION = new javax.swing.JTable();
        Fondo5 = new javax.swing.JLabel();
        JF_COMPONENTES = new javax.swing.JFrame();
        jPanel10 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        BTN_IR_SI_DE_COMPONENTES = new javax.swing.JButton();
        BTN_IR_SR_DE_COMPONENTES = new javax.swing.JButton();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        TF_ID_COMP = new javax.swing.JTextField();
        TF_ID_GRUPOCOMP = new javax.swing.JTextField();
        TF_NOMBRE_COMP = new javax.swing.JTextField();
        TF_UTILIDAD_COMP = new javax.swing.JTextField();
        TF_OBSERVACIONES_COMP = new javax.swing.JTextField();
        BTN_AGREGAR_COMPONENTES = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        TABLA_COMPONENTES = new javax.swing.JTable();
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
        BTN_AGREGAR_PERSONAL_RECREACION = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TABLA_PERSONAL_RECREACION = new javax.swing.JTable();
        TF_ID_RECREACIONISTA_PR = new javax.swing.JTextField();
        TF_HORARIO_PR = new javax.swing.JTextField();
        TF_NRO_PUESTO_PR = new javax.swing.JTextField();
        TF_ID_FERIA_PR = new javax.swing.JTextField();
        Fondo9 = new javax.swing.JLabel();
        EJERCICIOS = new javax.swing.JFrame();
        BTN_IR_VIST_DE_EJERCICIOS = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        jLabel59 = new javax.swing.JLabel();
        BTN_MOSTRAR_VASITANTES_DE_CADA_STAND = new javax.swing.JButton();
        jScrollPane10 = new javax.swing.JScrollPane();
        TXTA_RESULTADOS = new javax.swing.JTextArea();
        jPanel22 = new javax.swing.JPanel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        BTN_BUSCAR_DOC_X = new javax.swing.JButton();
        Fondo10 = new javax.swing.JLabel();
        JF_INSTRUMENTO = new javax.swing.JFrame();
        jPanel23 = new javax.swing.JPanel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        TF_ID_INST = new javax.swing.JTextField();
        TF_GRUPO_INSTRUMENTO = new javax.swing.JTextField();
        TF_NRO_PUESTO_INST = new javax.swing.JTextField();
        TF_NOMBRE_INST = new javax.swing.JTextField();
        TF_TIPO_INST = new javax.swing.JTextField();
        TF_OBS_INST = new javax.swing.JTextField();
        BTN_AGREGAR_INSTRUEMNTO = new javax.swing.JButton();
        jPanel25 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane13 = new javax.swing.JScrollPane();
        TABLA_INSTRUMENTO = new javax.swing.JTable();
        Fondo12 = new javax.swing.JLabel();
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
        BTN_IR_INSTRUMENTO_DE_VISITANTES = new javax.swing.JButton();
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(0, 0, Short.MAX_VALUE))
        );

        JF_FICHAS_MEDICAS.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 70));

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("ID VISITANTE");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, -1, -1));

        jLabel32.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("ID MEDICO");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, -1, -1));

        jLabel62.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel62.setForeground(new java.awt.Color(255, 255, 255));
        jLabel62.setText("MOTIVO");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, -1, 30));

        jLabel63.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel63.setForeground(new java.awt.Color(255, 255, 255));
        jLabel63.setText("ID FERIA");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, -1, 30));

        jLabel64.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel64.setForeground(new java.awt.Color(255, 255, 255));
        jLabel64.setText("ANTECEDENTES");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 120, 30));

        jLabel65.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel65.setForeground(new java.awt.Color(255, 255, 255));
        jLabel65.setText("FECHA");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, -1, 30));

        jLabel66.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel66.setForeground(new java.awt.Color(255, 255, 255));
        jLabel66.setText("EVALUACION");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 320, -1, 30));

        jLabel67.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel67.setForeground(new java.awt.Color(255, 255, 255));
        jLabel67.setText("HALLAZGO");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, 30));

        jLabel68.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel68.setForeground(new java.awt.Color(255, 255, 255));
        jLabel68.setText("DESICIONES");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 260, -1, 30));

        jLabel69.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel69.setForeground(new java.awt.Color(255, 255, 255));
        jLabel69.setText("TRATAMIENTO");
        JF_FICHAS_MEDICAS.getContentPane().add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, 30));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_ID_VISIT_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 110, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_ID_MEDICO_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_ANTECEDENTES_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 170, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_MOTIVOS_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_HALLAZGOS_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_DECISIONES_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 260, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_TRATAMIENTO_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_EVALUACION_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 320, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_ID_FERIA_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 140, -1));
        JF_FICHAS_MEDICAS.getContentPane().add(TF_FECHA_DI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 380, 140, -1));

        BTN_AGREGAR_DIAGNOSTICO.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_DIAGNOSTICO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_DIAGNOSTICO.setText("AGREGAR");
        BTN_AGREGAR_DIAGNOSTICO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_DIAGNOSTICOActionPerformed(evt);
            }
        });
        JF_FICHAS_MEDICAS.getContentPane().add(BTN_AGREGAR_DIAGNOSTICO, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 397, 110, 40));

        TABLA_DIAGNOSTICO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID VISITANTE", "ID MEDICO", "ANTECEDENTES", "MOTIVO", "HALLAZGO", "DESICIONES", "TRATAMIENTO", "EVALUACION", "ID FERIA", "FECHA"
            }
        ));
        jScrollPane11.setViewportView(TABLA_DIAGNOSTICO);

        JF_FICHAS_MEDICAS.getContentPane().add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(26, 441, 810, 150));

        Fondo2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_FICHAS_MEDICAS.getContentPane().add(Fondo2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_FICHAS_INFORMATIVAS.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Fondo11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_FICHAS_INFORMATIVAS.getContentPane().add(Fondo11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

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

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("NRO PUESTO");
        JF_STAND_INFORMATIVO.getContentPane().add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 100, 30));

        jLabel51.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("ID FERIA");
        JF_STAND_INFORMATIVO.getContentPane().add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 60, 30));

        jLabel52.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel52.setForeground(new java.awt.Color(255, 255, 255));
        jLabel52.setText("ID COMPONENTES");
        JF_STAND_INFORMATIVO.getContentPane().add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 290, 130, 30));
        JF_STAND_INFORMATIVO.getContentPane().add(TF_NRO_PUESTO_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, 130, 30));
        JF_STAND_INFORMATIVO.getContentPane().add(TF_ID_FERIA_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 250, 130, 30));
        JF_STAND_INFORMATIVO.getContentPane().add(TF_ID_COMP_SI, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 130, 30));

        TABLA_STAND_INFORMACION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NRO PUESTO", "ID FERIA", "ID COMPONENTES"
            }
        ));
        jScrollPane7.setViewportView(TABLA_STAND_INFORMACION);

        JF_STAND_INFORMATIVO.getContentPane().add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 800, 130));

        BTN_AGREGAR_STAND_INFORMACION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_STAND_INFORMACION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_STAND_INFORMACION.setText("AGREGAR");
        BTN_AGREGAR_STAND_INFORMACION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_STAND_INFORMACIONActionPerformed(evt);
            }
        });
        JF_STAND_INFORMATIVO.getContentPane().add(BTN_AGREGAR_STAND_INFORMACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 400, 120, 40));

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

        jLabel53.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel53.setForeground(new java.awt.Color(255, 255, 255));
        jLabel53.setText("NRO PUESTO");
        JF_STAND_ATENCION.getContentPane().add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, -1, -1));

        jLabel54.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel54.setForeground(new java.awt.Color(255, 255, 255));
        jLabel54.setText("ID FERIA");
        JF_STAND_ATENCION.getContentPane().add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, -1, -1));

        jLabel55.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel55.setForeground(new java.awt.Color(255, 255, 255));
        jLabel55.setText("ID INSTRUMENTOS");
        JF_STAND_ATENCION.getContentPane().add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, -1, -1));
        JF_STAND_ATENCION.getContentPane().add(TF_NROPUESTO_SA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 150, -1));
        JF_STAND_ATENCION.getContentPane().add(TF_ID_FERIA_SA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, 150, -1));
        JF_STAND_ATENCION.getContentPane().add(TF_INSTRUMENTOS_SA, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 150, -1));

        BTN_AGREGAR_STAND_ATENCION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_STAND_ATENCION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_STAND_ATENCION.setText("AGREGAR");
        BTN_AGREGAR_STAND_ATENCION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_STAND_ATENCIONActionPerformed(evt);
            }
        });
        JF_STAND_ATENCION.getContentPane().add(BTN_AGREGAR_STAND_ATENCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 387, 100, 30));

        TABLA_STAND_ATENCION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NRO PUESTO", "ID FERIA", "ID INSTRUMENTO"
            }
        ));
        jScrollPane8.setViewportView(TABLA_STAND_ATENCION);

        JF_STAND_ATENCION.getContentPane().add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 770, 130));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        JF_STAND_RECREACION.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, -1, 110));

        jLabel56.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel56.setForeground(new java.awt.Color(255, 255, 255));
        jLabel56.setText("NRO PUESTO");
        JF_STAND_RECREACION.getContentPane().add(jLabel56, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 190, -1, -1));

        jLabel57.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel57.setForeground(new java.awt.Color(255, 255, 255));
        jLabel57.setText("ID FERIA");
        JF_STAND_RECREACION.getContentPane().add(jLabel57, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, -1, -1));

        jLabel58.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel58.setForeground(new java.awt.Color(255, 255, 255));
        jLabel58.setText("ID COMPONENTE");
        JF_STAND_RECREACION.getContentPane().add(jLabel58, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, -1, -1));

        TF_NRO_PUESTO_SR.setToolTipText("");
        TF_NRO_PUESTO_SR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_NRO_PUESTO_SRActionPerformed(evt);
            }
        });
        JF_STAND_RECREACION.getContentPane().add(TF_NRO_PUESTO_SR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 180, 120, -1));

        TF_ID_FERIA_SR.setToolTipText("");
        JF_STAND_RECREACION.getContentPane().add(TF_ID_FERIA_SR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 120, -1));

        TF_ID_COMP_SR.setToolTipText("");
        JF_STAND_RECREACION.getContentPane().add(TF_ID_COMP_SR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 260, 120, -1));

        BTN_AGREGAR_STAND_RECREACION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_STAND_RECREACION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_STAND_RECREACION.setText("AGREGAR");
        BTN_AGREGAR_STAND_RECREACION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_STAND_RECREACIONActionPerformed(evt);
            }
        });
        JF_STAND_RECREACION.getContentPane().add(BTN_AGREGAR_STAND_RECREACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 100, 60));

        TABLA_STAND_RECREACION.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "NRO PUESTO", "ID FERIA", "ID COMPONENTE"
            }
        ));
        jScrollPane9.setViewportView(TABLA_STAND_RECREACION);

        JF_STAND_RECREACION.getContentPane().add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 760, 110));

        Fondo5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        Fondo5.setToolTipText("");
        JF_STAND_RECREACION.getContentPane().add(Fondo5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 850, 600));

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

        JF_COMPONENTES.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 120, 180, 70));

        jLabel45.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setText("ID COMPONENTE");
        JF_COMPONENTES.getContentPane().add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("ID GRUPO COMPONENTE");
        JF_COMPONENTES.getContentPane().add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("NOMBRE");
        JF_COMPONENTES.getContentPane().add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, -1, -1));

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("UTILIDAD");
        JF_COMPONENTES.getContentPane().add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, -1, -1));

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("OBSERVACIONES");
        JF_COMPONENTES.getContentPane().add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, -1, -1));

        TF_ID_COMP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_ID_COMPActionPerformed(evt);
            }
        });
        JF_COMPONENTES.getContentPane().add(TF_ID_COMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 170, 160, -1));
        JF_COMPONENTES.getContentPane().add(TF_ID_GRUPOCOMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 160, -1));
        JF_COMPONENTES.getContentPane().add(TF_NOMBRE_COMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 160, -1));
        JF_COMPONENTES.getContentPane().add(TF_UTILIDAD_COMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 260, 160, -1));
        JF_COMPONENTES.getContentPane().add(TF_OBSERVACIONES_COMP, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 290, 160, -1));

        BTN_AGREGAR_COMPONENTES.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_COMPONENTES.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_COMPONENTES.setText("AGREGAR");
        BTN_AGREGAR_COMPONENTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_COMPONENTESActionPerformed(evt);
            }
        });
        JF_COMPONENTES.getContentPane().add(BTN_AGREGAR_COMPONENTES, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 370, 100, 50));

        TABLA_COMPONENTES.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID COMPONENTE", "ID GRUPO COMPONENTE", "NOMBRE", "UTILIDAD", "OBSERVACIONES"
            }
        ));
        jScrollPane6.setViewportView(TABLA_COMPONENTES);

        JF_COMPONENTES.getContentPane().add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 780, 130));

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

        BTN_AGREGAR_PERSONAL_RECREACION.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_PERSONAL_RECREACION.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_PERSONAL_RECREACION.setText("AGREGAR");
        BTN_AGREGAR_PERSONAL_RECREACION.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_PERSONAL_RECREACIONActionPerformed(evt);
            }
        });
        JF_RECREACIONISTAS.getContentPane().add(BTN_AGREGAR_PERSONAL_RECREACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 357, 100, 40));

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

        jPanel21.setBackground(new java.awt.Color(102, 102, 102));
        jPanel21.setForeground(new java.awt.Color(102, 102, 102));

        jLabel59.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel59.setForeground(new java.awt.Color(255, 255, 255));
        jLabel59.setText("- mostrar cuantos visitantes tubo cada stand  ");

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel59)
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel21Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel59, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        EJERCICIOS.getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 340, 30));

        BTN_MOSTRAR_VASITANTES_DE_CADA_STAND.setBackground(new java.awt.Color(102, 153, 255));
        BTN_MOSTRAR_VASITANTES_DE_CADA_STAND.setForeground(new java.awt.Color(51, 51, 51));
        BTN_MOSTRAR_VASITANTES_DE_CADA_STAND.setText("MOSTRAR");
        BTN_MOSTRAR_VASITANTES_DE_CADA_STAND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_MOSTRAR_VASITANTES_DE_CADA_STANDActionPerformed(evt);
            }
        });
        EJERCICIOS.getContentPane().add(BTN_MOSTRAR_VASITANTES_DE_CADA_STAND, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 120, 40));

        TXTA_RESULTADOS.setColumns(20);
        TXTA_RESULTADOS.setRows(5);
        jScrollPane10.setViewportView(TXTA_RESULTADOS);

        EJERCICIOS.getContentPane().add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(498, 40, 330, 370));

        jPanel22.setBackground(new java.awt.Color(102, 102, 102));

        jLabel60.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel60.setForeground(new java.awt.Color(255, 255, 255));
        jLabel60.setText("Verificar que doctor x exita, y mostrar su informacion");

        jLabel61.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel61.setForeground(new java.awt.Color(255, 255, 255));
        jLabel61.setText("y en donde se encuentra  ");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel60, javax.swing.GroupLayout.PREFERRED_SIZE, 396, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addComponent(jLabel60)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel61)
                .addContainerGap())
        );

        EJERCICIOS.getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 390, 50));

        BTN_BUSCAR_DOC_X.setBackground(new java.awt.Color(255, 153, 0));
        BTN_BUSCAR_DOC_X.setForeground(new java.awt.Color(0, 0, 0));
        BTN_BUSCAR_DOC_X.setText("BUSCAR");
        BTN_BUSCAR_DOC_X.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_BUSCAR_DOC_XActionPerformed(evt);
            }
        });
        EJERCICIOS.getContentPane().add(BTN_BUSCAR_DOC_X, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 150, 160, -1));

        Fondo10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        EJERCICIOS.getContentPane().add(Fondo10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 600));

        JF_INSTRUMENTO.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setBackground(new java.awt.Color(255, 255, 255));

        jLabel70.setFont(new java.awt.Font("Segoe UI", 2, 60)); // NOI18N
        jLabel70.setText("INSTRUMENTOS");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jLabel70)
                .addContainerGap(213, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel70)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        JF_INSTRUMENTO.getContentPane().add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 850, 100));

        jLabel71.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel71.setForeground(new java.awt.Color(255, 255, 255));
        jLabel71.setText("ID INSTRUMENTO");
        JF_INSTRUMENTO.getContentPane().add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, -1, -1));

        jLabel72.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel72.setForeground(new java.awt.Color(255, 255, 255));
        jLabel72.setText("GRUPO INSTRUMENTO");
        JF_INSTRUMENTO.getContentPane().add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, -1));

        jLabel73.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(255, 255, 255));
        jLabel73.setText("NRO PUESTO");
        JF_INSTRUMENTO.getContentPane().add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        jLabel74.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(255, 255, 255));
        jLabel74.setText("NOMBRE");
        JF_INSTRUMENTO.getContentPane().add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, -1, -1));

        jLabel75.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel75.setForeground(new java.awt.Color(255, 255, 255));
        jLabel75.setText("TIPO");
        JF_INSTRUMENTO.getContentPane().add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, -1, -1));

        jLabel76.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel76.setForeground(new java.awt.Color(255, 255, 255));
        jLabel76.setText("OBSERVACIONES");
        JF_INSTRUMENTO.getContentPane().add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, -1, -1));
        JF_INSTRUMENTO.getContentPane().add(TF_ID_INST, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 150, -1));

        TF_GRUPO_INSTRUMENTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TF_GRUPO_INSTRUMENTOActionPerformed(evt);
            }
        });
        JF_INSTRUMENTO.getContentPane().add(TF_GRUPO_INSTRUMENTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 150, -1));
        JF_INSTRUMENTO.getContentPane().add(TF_NRO_PUESTO_INST, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 150, -1));
        JF_INSTRUMENTO.getContentPane().add(TF_NOMBRE_INST, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 150, -1));
        JF_INSTRUMENTO.getContentPane().add(TF_TIPO_INST, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 320, 150, -1));
        JF_INSTRUMENTO.getContentPane().add(TF_OBS_INST, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, 150, -1));

        BTN_AGREGAR_INSTRUEMNTO.setBackground(new java.awt.Color(0, 0, 255));
        BTN_AGREGAR_INSTRUEMNTO.setForeground(new java.awt.Color(255, 255, 255));
        BTN_AGREGAR_INSTRUEMNTO.setText("AGREGAR");
        BTN_AGREGAR_INSTRUEMNTO.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_AGREGAR_INSTRUEMNTOActionPerformed(evt);
            }
        });
        JF_INSTRUMENTO.getContentPane().add(BTN_AGREGAR_INSTRUEMNTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 380, -1, -1));

        jPanel25.setBackground(new java.awt.Color(153, 153, 153));

        jButton1.setBackground(new java.awt.Color(102, 102, 102));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("REGISTRO VISITANTES");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        JF_INSTRUMENTO.getContentPane().add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 140, -1, 40));

        TABLA_INSTRUMENTO.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID INSTRUMENTO", "GRUPO INSTRUMENTO", "NRO PUESTO", "TIPO", "OBSERVACIONES"
            }
        ));
        jScrollPane13.setViewportView(TABLA_INSTRUMENTO);

        JF_INSTRUMENTO.getContentPane().add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 770, 140));

        Fondo12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/fondo.png"))); // NOI18N
        JF_INSTRUMENTO.getContentPane().add(Fondo12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 590));

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

        BTN_IR_INSTRUMENTO_DE_VISITANTES.setBackground(new java.awt.Color(102, 102, 102));
        BTN_IR_INSTRUMENTO_DE_VISITANTES.setForeground(new java.awt.Color(255, 255, 255));
        BTN_IR_INSTRUMENTO_DE_VISITANTES.setText("INSTRUMENTOS");
        BTN_IR_INSTRUMENTO_DE_VISITANTES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTN_IR_INSTRUMENTO_DE_VISITANTESActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BTN_IR_INSTRUMENTO_DE_VISITANTES, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BTN_IR_STAND_RECRACION_DE_VISIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(BTN_IR_EJERCICIOS_DE_VIST, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(BTN_IR_STAND_ATENCION_DE_VISIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BTN_IR_FICHAMEDICA_DE_VISIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_IR_STAND_INFORMACION_DE_VISIT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BTN_IR_FERIAS_DE_VIST, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(BTN_IR_PERSONAL_DE_VISIT, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_INSTRUMENTO_DE_VISITANTES)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BTN_IR_EJERCICIOS_DE_VIST)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 130, 200, 270));

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
        
        //componentes
        listaC = daoC.cargaComponente();
        modeloTabla6.setRowCount(0);
        LsC = new LSimpleC();

        for (NodoC n : listaC) {
            if (n != null) {
                modeloTabla6.addRow(new Object[]{
                    n.getId_componente(),
                    n.getId_GrupoComponente(),
                    n.getNombre(),
                    n.getUtilidad(),
                    n.getObservaciones()
                });

                LsC.adiFinal(n.getId_componente(), n.getId_GrupoComponente(), n.getNombre(), n.getUtilidad(),n.getObservaciones());
            }
        }
        LsC.mostrar();
        
        //STAND INFORMACION     
        listaSI = daoSI.cargaSI();
        modeloTabla7.setRowCount(0);
        LdSI = new LDobleSI();

        for (NodoSI n : listaSI) {
            if (n != null) {
                modeloTabla7.addRow(new Object[]{
                    n.getNroPuesto(),
                    n.getIdFeria(),
                    n.getId_Componentes()
                });

                LdSI.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes());
            }
        }
        LdSI.mostrar();
        
        //STAND ATENCION     
        listaSA = daoSA.cargaSA();
        modeloTabla8.setRowCount(0);
        LdSA = new LDobleSA();

        for (NodoSA n : listaSA) {
            if (n != null) {
                modeloTabla8.addRow(new Object[]{
                    n.getNroPuesto(),
                    n.getIdFeria(),
                    n.getIdInstrumentosDoc()
                });

                LdSA.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getIdInstrumentosDoc());
            }
        }
        LdSA.mostrar();
        
        
        //STAND RECREACION     
        listaSR = daoSR.cargaSR();
        modeloTabla9.setRowCount(0);
        LdSR = new LDobleSR();

        for (NodoSR n : listaSR) {
            if (n != null) {
                modeloTabla9.addRow(new Object[]{
                    n.getNroPuesto(),
                    n.getIdFeria(),
                    n.getId_Componentes()
                });

                LdSR.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes());
            }
        }
        LdSR.mostrar();
        
        //DIAGNOSTICO 
        listaDi = daoDi.cargaDi();
        modeloTabla10.setRowCount(0);
        LdDi = new LDobleCirDi();

        for (NodoDi n : listaDi) {
            if (n != null) {
                modeloTabla10.addRow(new Object[]{
                    n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha()
                });

                LdDi.adiprincipio(n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha());
            }
        }
        LdDi.mostrar();
        JOptionPane.showMessageDialog(this, "ESTRUCTURAS LLENAS xD");
        
        // INSTRUMENTO
        listaPIDOC = daoPIDOC.cargarInst();
        modeloTabla11.setRowCount(0);
        PInsD = new PilaInsD();
        
        for(InstrumentosDoc v : listaPIDOC){
            if(v.getId_instrumento()> 0){
                modeloTabla11.addRow(new Object[]{
                    v.getId_instrumento(), v.getGrupo_instrumentos(), v.getNropuesto(),
                    v.getNombre(), v.getTipo(), v.getObservacion()
                });

                PInsD.adicionar(v);
            }
        
        }
        PInsD.mostrar();
        JOptionPane.showMessageDialog(this, "ESTRUCTURAS LLENAS xD");
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
        
    }//GEN-LAST:event_TF_ID_RECREACIONISTA_PRActionPerformed

    private void BTN_AGREGAR_PERSONAL_RECREACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_PERSONAL_RECREACIONActionPerformed
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
    }//GEN-LAST:event_BTN_AGREGAR_PERSONAL_RECREACIONActionPerformed

    private void TF_ID_COMPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_ID_COMPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_ID_COMPActionPerformed

    private void BTN_AGREGAR_COMPONENTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_COMPONENTESActionPerformed
        NodoC n = new NodoC();
        n.setId_componente(Integer.parseInt(TF_ID_COMP.getText()));
        n.setId_GrupoComponente(Integer.parseInt(TF_ID_GRUPOCOMP.getText()));
        n.setNombre(TF_NOMBRE_COMP.getText());
        n.setUtilidad(TF_UTILIDAD_COMP.getText());
        n.setObservaciones(TF_OBSERVACIONES_COMP.getText());

        listaC.add(n);          
        LsC.adiFinal(n.getId_componente(), n.getId_GrupoComponente(), n.getNombre(), n.getUtilidad(),n.getObservaciones()); 
        modeloTabla6.addRow(new Object[]{n.getId_componente(), n.getId_GrupoComponente(), n.getNombre(), n.getUtilidad(),n.getObservaciones()});
        daoC.guardarComponente(listaC); // guardar archivo
        LimpiarCampos_Componentes();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LsC.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_COMPONENTESActionPerformed

    private void BTN_AGREGAR_STAND_INFORMACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_STAND_INFORMACIONActionPerformed
        NodoSI n = new NodoSI();
        n.setNroPuesto(Integer.parseInt(TF_NRO_PUESTO_SI.getText()));
        n.setIdFeria(Integer.parseInt(TF_ID_FERIA_SI.getText()));
        n.setId_Componentes(Integer.parseInt(TF_ID_COMP_SI.getText()));
        

        listaSI.add(n);          
        LdSI.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes()); 
        modeloTabla7.addRow(new Object[]{n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes()});
        daoSI.guardarSI(listaSI); 
        LimpiarCampos_SI();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LdSI.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_STAND_INFORMACIONActionPerformed

    private void BTN_AGREGAR_STAND_ATENCIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_STAND_ATENCIONActionPerformed
         NodoSA n = new NodoSA();
        n.setNroPuesto(Integer.parseInt(TF_NROPUESTO_SA.getText()));
        n.setIdFeria(Integer.parseInt(TF_ID_FERIA_SA.getText()));
        n.setIdInstrumentosDoc(Integer.parseInt(TF_INSTRUMENTOS_SA.getText()));
        

        listaSA.add(n);          
        LdSA.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getIdInstrumentosDoc()); 
        modeloTabla8.addRow(new Object[]{n.getNroPuesto(),n.getIdFeria(),n.getIdInstrumentosDoc()});
        daoSA.guardarSA(listaSA); 
        LimpiarCampos_SA();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LdSA.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_STAND_ATENCIONActionPerformed

    private void TF_NRO_PUESTO_SRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_NRO_PUESTO_SRActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_NRO_PUESTO_SRActionPerformed

    private void BTN_AGREGAR_STAND_RECREACIONActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_STAND_RECREACIONActionPerformed
         NodoSR n = new NodoSR();
        n.setNroPuesto(Integer.parseInt(TF_NRO_PUESTO_SR.getText()));
        n.setIdFeria(Integer.parseInt(TF_ID_FERIA_SR.getText()));
        n.setId_Componentes(Integer.parseInt(TF_ID_COMP_SR.getText()));
        

        listaSR.add(n);          
        LdSR.adicionar(n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes()); 
        modeloTabla9.addRow(new Object[]{n.getNroPuesto(),n.getIdFeria(),n.getId_Componentes()});
        daoSR.guardarSR(listaSR); 
        LimpiarCampos_SR();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LdSR.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_STAND_RECREACIONActionPerformed

    private void BTN_MOSTRAR_VASITANTES_DE_CADA_STANDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_MOSTRAR_VASITANTES_DE_CADA_STANDActionPerformed
        String ciStr = JOptionPane.showInputDialog(this, "Ingrese CI del visitante a buscar:");
        int ci;
        try {
            ci = Integer.parseInt(ciStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "CI inválido", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        CSVis.mostrarVisitantePorCI(ci);
    }//GEN-LAST:event_BTN_MOSTRAR_VASITANTES_DE_CADA_STANDActionPerformed

    private void BTN_BUSCAR_DOC_XActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_BUSCAR_DOC_XActionPerformed
        buscarDoctor();
    }//GEN-LAST:event_BTN_BUSCAR_DOC_XActionPerformed

    private void BTN_AGREGAR_DIAGNOSTICOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_DIAGNOSTICOActionPerformed
        NodoDi n = new NodoDi();
        n.setId_Visitante(Integer.parseInt(TF_ID_VISIT_DI.getText()));
        n.setId_Medico(Integer.parseInt(TF_ID_MEDICO_DI.getText()));
        n.setAntesedentes(TF_ANTECEDENTES_DI.getText());
        n.setMotivo(TF_MOTIVOS_DI.getText());
        n.setHallazgo(TF_HALLAZGOS_DI.getText());
        n.setDesiciones(TF_DECISIONES_DI.getText());
        n.setTratamiento(TF_TRATAMIENTO_DI.getText());
        n.setEvaluacion(TF_EVALUACION_DI.getText());
        n.setId_Feria(Integer.parseInt(TF_ID_FERIA_DI.getText()));
        n.setFecha(TF_FECHA_DI.getText());
        
        
        listaDi.add(n);          
        LdDi.adiprincipio(n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha()); 
        modeloTabla10.addRow(new Object[]{n.getId_Visitante(), n.getId_Medico(), n.getAntesedentes(),n.getMotivo(),n.getHallazgo(),n.getDesiciones(),n.getTratamiento(),n.getEvaluacion(),n.getId_Feria(),n.getFecha()});
        daoDi.guardarDi(listaDi); 
        LimpiarCampos_DI();
        JOptionPane.showMessageDialog(this, "Informador agregado correctamente");
        LdDi.mostrar();
    }//GEN-LAST:event_BTN_AGREGAR_DIAGNOSTICOActionPerformed

    private void TF_GRUPO_INSTRUMENTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TF_GRUPO_INSTRUMENTOActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TF_GRUPO_INSTRUMENTOActionPerformed

    private void BTN_IR_INSTRUMENTO_DE_VISITANTESActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_IR_INSTRUMENTO_DE_VISITANTESActionPerformed
        this.JF_INSTRUMENTO.setSize(865,620);
        this.JF_INSTRUMENTO.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BTN_IR_INSTRUMENTO_DE_VISITANTESActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.JF_INSTRUMENTO.setVisible(false);
        this.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void BTN_AGREGAR_INSTRUEMNTOActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTN_AGREGAR_INSTRUEMNTOActionPerformed
        InstrumentosDoc v=new InstrumentosDoc(
            Integer.parseInt(TF_ID_INST.getText()),
            Integer.parseInt(TF_GRUPO_INSTRUMENTO.getText()),
            Integer.parseInt(TF_NRO_PUESTO_INST.getText()),
            TF_NOMBRE_INST.getText(),
            TF_TIPO_INST.getText(),
            TF_OBS_INST.getText()
        );
        listaPIDOC.add(v);
        PInsD.adicionar(v);
        modeloTabla11.addRow(new Object[]{v.getId_instrumento(), v.getGrupo_instrumentos(),v.getNropuesto(),v.getNombre(),v.getTipo(),v.getObservacion()});
        daoPIDOC.guardarInst(listaPIDOC);
        LimpiarCampos_PICO();
        JOptionPane.showMessageDialog(null, "Visitante agregado correctamente");
    }//GEN-LAST:event_BTN_AGREGAR_INSTRUEMNTOActionPerformed
    
    
    
    
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
    
    
    public void LimpiarCampos_Componentes(){
        TF_ID_COMP.setText("");
        TF_ID_GRUPOCOMP.setText("");
        TF_NOMBRE_COMP.setText("");
        TF_UTILIDAD_COMP.setText("");
        TF_OBSERVACIONES_COMP.setText("");
    }
    
    public void LimpiarCampos_SI(){
        TF_NRO_PUESTO_SI.setText("");
        TF_ID_FERIA_SI.setText("");
        TF_ID_COMP_SI.setText("");
    }
    
    public void LimpiarCampos_SA(){
        TF_NROPUESTO_SA.setText("");
        TF_ID_FERIA_SA.setText("");
        TF_INSTRUMENTOS_SA.setText("");
    }
    
    public void LimpiarCampos_SR(){
        TF_NROPUESTO_SA.setText("");
        TF_ID_FERIA_SA.setText("");
        TF_ID_COMP_SR.setText("");
    }
    
    public void LimpiarCampos_DI(){
        TF_ID_VISIT_DI.setText("");
        TF_ID_MEDICO_DI.setText("");
        TF_ANTECEDENTES_DI.setText("");
        TF_MOTIVOS_DI.setText("");
        TF_HALLAZGOS_DI.setText("");
        TF_DECISIONES_DI.setText("");
        TF_TRATAMIENTO_DI.setText("");
        TF_EVALUACION_DI.setText("");
        TF_ID_FERIA_DI.setText("");
        TF_FECHA_DI.setText("");
    }
    public void LimpiarCampos_PICO(){
        TF_ID_INST.setText("");
        TF_GRUPO_INSTRUMENTO.setText("");
        TF_ANTECEDENTES_DI.setText("");
        TF_MOTIVOS_DI.setText("");
        TF_HALLAZGOS_DI.setText("");
        TF_DECISIONES_DI.setText("");
        TF_TRATAMIENTO_DI.setText("");
        TF_EVALUACION_DI.setText("");
        TF_ID_FERIA_DI.setText("");
        TF_FECHA_DI.setText("");
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
    private javax.swing.JButton BTN_AGREGAR_COMPONENTES;
    private javax.swing.JButton BTN_AGREGAR_DIAGNOSTICO;
    private javax.swing.JButton BTN_AGREGAR_INSTRUEMNTO;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL_ATENCION;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL_INFORMACION;
    private javax.swing.JButton BTN_AGREGAR_PERSONAL_RECREACION;
    private javax.swing.JButton BTN_AGREGAR_STAND_ATENCION;
    private javax.swing.JButton BTN_AGREGAR_STAND_INFORMACION;
    private javax.swing.JButton BTN_AGREGAR_STAND_RECREACION;
    private javax.swing.JButton BTN_BUSCAR_DOC_X;
    private javax.swing.JButton BTN_IR_A_VISITANTES_DE_PERSONAL;
    private javax.swing.JButton BTN_IR_COMPONENTES_DE_SI;
    private javax.swing.JButton BTN_IR_COMPONENTES_DE_SR;
    private javax.swing.JButton BTN_IR_DOC_ATENCION_DE_SA;
    private javax.swing.JButton BTN_IR_EJERCICIOS_DE_VIST;
    private javax.swing.JButton BTN_IR_FERIAS_DE_VIST;
    private javax.swing.JButton BTN_IR_FICHAMEDICA_DE_VISIT;
    private javax.swing.JButton BTN_IR_INFORMADORES_DE_SI;
    private javax.swing.JButton BTN_IR_INSTRUMENTO_DE_VISITANTES;
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
    private javax.swing.JButton BTN_MOSTRAR_VASITANTES_DE_CADA_STAND;
    private javax.swing.JFrame EJERCICIOS;
    private javax.swing.JButton Eliminar_visitante;
    private javax.swing.JLabel Fondo;
    private javax.swing.JLabel Fondo1;
    private javax.swing.JLabel Fondo10;
    private javax.swing.JLabel Fondo11;
    private javax.swing.JLabel Fondo12;
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
    private javax.swing.JFrame JF_FICHAS_INFORMATIVAS;
    private javax.swing.JFrame JF_FICHAS_MEDICAS;
    private javax.swing.JFrame JF_INFORMADORES;
    private javax.swing.JFrame JF_INSTRUMENTO;
    private javax.swing.JFrame JF_RECREACIONISTAS;
    private javax.swing.JFrame JF_REGISTRO_PERSONAL;
    private javax.swing.JFrame JF_STAND_ATENCION;
    private javax.swing.JFrame JF_STAND_INFORMATIVO;
    private javax.swing.JFrame JF_STAND_RECREACION;
    private javax.swing.JTable TABLA_COMPONENTES;
    private javax.swing.JTable TABLA_DIAGNOSTICO;
    private javax.swing.JTable TABLA_INSTRUMENTO;
    private javax.swing.JTable TABLA_PERSONAL;
    private javax.swing.JTable TABLA_PERSONAL_ATENCION;
    private javax.swing.JTable TABLA_PERSONAL_INFORMACION;
    private javax.swing.JTable TABLA_PERSONAL_RECREACION;
    private javax.swing.JTable TABLA_STAND_ATENCION;
    private javax.swing.JTable TABLA_STAND_INFORMACION;
    private javax.swing.JTable TABLA_STAND_RECREACION;
    private javax.swing.JTable TABLA_VISITANTES;
    private javax.swing.JTextField TF_ANTECEDENTES_DI;
    private javax.swing.JTextField TF_CATE_PER;
    private javax.swing.JTextField TF_CI_PER;
    private javax.swing.JTextField TF_CONT_PER;
    private javax.swing.JTextField TF_DECISIONES_DI;
    private javax.swing.JTextField TF_EDAD_PER;
    private javax.swing.JTextField TF_EVALUACION_DI;
    private javax.swing.JTextField TF_FECHA_DI;
    private javax.swing.JTextField TF_GRUPO_INSTRUMENTO;
    private javax.swing.JTextField TF_HALLAZGOS_DI;
    private javax.swing.JTextField TF_HORARIO_PA;
    private javax.swing.JTextField TF_HORARIO_PI;
    private javax.swing.JTextField TF_HORARIO_PR;
    private javax.swing.JTextField TF_ID_COMP;
    private javax.swing.JTextField TF_ID_COMP_SI;
    private javax.swing.JTextField TF_ID_COMP_SR;
    private javax.swing.JTextField TF_ID_FERIA_DI;
    private javax.swing.JTextField TF_ID_FERIA_PA;
    private javax.swing.JTextField TF_ID_FERIA_PI;
    private javax.swing.JTextField TF_ID_FERIA_PR;
    private javax.swing.JTextField TF_ID_FERIA_SA;
    private javax.swing.JTextField TF_ID_FERIA_SI;
    private javax.swing.JTextField TF_ID_FERIA_SR;
    private javax.swing.JTextField TF_ID_GRUPOCOMP;
    private javax.swing.JTextField TF_ID_INFORMADOR_PI;
    private javax.swing.JTextField TF_ID_INST;
    private javax.swing.JTextField TF_ID_MEDICO_DI;
    private javax.swing.JTextField TF_ID_MEDICO_PA;
    private javax.swing.JTextField TF_ID_PERSONAL;
    private javax.swing.JTextField TF_ID_RECREACIONISTA_PR;
    private javax.swing.JTextField TF_ID_VISIT_DI;
    private javax.swing.JTextField TF_INSTRUMENTOS_SA;
    private javax.swing.JTextField TF_MAT_PER;
    private javax.swing.JTextField TF_MOTIVOS_DI;
    private javax.swing.JTextField TF_NOMBRE_COMP;
    private javax.swing.JTextField TF_NOMBRE_INST;
    private javax.swing.JTextField TF_NOM_PER;
    private javax.swing.JTextField TF_NROPUESTO_PA;
    private javax.swing.JTextField TF_NROPUESTO_SA;
    private javax.swing.JTextField TF_NRO_PUESTO_INST;
    private javax.swing.JTextField TF_NRO_PUESTO_PI;
    private javax.swing.JTextField TF_NRO_PUESTO_PR;
    private javax.swing.JTextField TF_NRO_PUESTO_SI;
    private javax.swing.JTextField TF_NRO_PUESTO_SR;
    private javax.swing.JTextField TF_OBSERVACIONES_COMP;
    private javax.swing.JTextField TF_OBS_INST;
    private javax.swing.JTextField TF_PAT_PER;
    private javax.swing.JTextField TF_SEXO_PER;
    private javax.swing.JTextField TF_TIPO_INST;
    private javax.swing.JTextField TF_TIPO_PER;
    private javax.swing.JTextField TF_TRATAMIENTO_DI;
    private javax.swing.JTextField TF_UTILIDAD_COMP;
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
    private javax.swing.JTextArea TXTA_RESULTADOS;
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
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
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
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    // End of variables declaration//GEN-END:variables

    public void buscarDoctor() {
        String ciBuscar = JOptionPane.showInputDialog("Ingrese CI del doctor:");
        if (ciBuscar == null || ciBuscar.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar un CI.");
            return;
        }

        int CI = Integer.parseInt(ciBuscar);
        Personal encontrado = null;

        CSimpleRP aux = new CSimpleRP();
        while (!CSPer.esVacia()) {
            Personal p = CSPer.eliminar();
            if (p.getCi() == CI) {
                encontrado = p;
            }
            aux.adicionar(p);
        }
        CSPer.vaciar(aux);

        if (encontrado == null) {
            JOptionPane.showMessageDialog(null, "No existe CI.");
            return;
        }

        String info = "--- DATOS DEL DOCTOR ---\n" +
                      "CI: " + encontrado.getCi() + "\n" +
                      "Nombre: " + encontrado.getNombre() + " " +
                        encontrado.getPaterno() + " " + encontrado.getMaterno() + "\n" +
                      "Edad: " + encontrado.getEdad() + "\n" +
                      "Sexo: " + encontrado.getSexo() + "\n" +
                      "Tipo: " + encontrado.getTipo() + "\n" +
                      "Categoría: " + encontrado.getCategoria() + "\n\n";

        info += "--- UBICACIÓN EN LA FERIA ---\n";

        boolean encontradoStand = false;

        // INFORMADORES
        NodoPI z = LsPI.getP();
        while (z != null) {
            if (z.getId_Informador() == encontrado.getId_Personal()) {
                info += "Stand de INFORMACIÓN\n" +
                        "Horario: " + z.getHorario() + "\n" +
                        "Puesto: " + z.getNroPuesto() + "\n" +
                        "Feria: " + z.getId_feria() + "\n";
                encontradoStand = true;
            }
            z = z.getSig();
        }

        // ATENCION
        NodoPA q = LsPA.getP();
        while (q != null) {
            if (q.getId_Medico() == encontrado.getId_Personal()) {
                info += "Stand de ATENCIÓN\n" +
                        "Horario: " + q.getHorario() + "\n" +
                        "Puesto: " + q.getNroPuesto() + "\n" +
                        "Feria: " + q.getId_feria() + "\n";
                encontradoStand = true;
            }
            q = q.getSig();
        }

        // RECREACIÓN
        NodoPR w = LsPR.getP();
        while (w != null) {
            if (w.getId_recreacionista() == encontrado.getId_Personal()) {
                info += "Stand de RECREACIÓN\n" +
                        "Horario: " + w.getHorario() + "\n" +
                        "Puesto: " + w.getNroPuesto() + "\n" +
                        "Feria: " + w.getId_feria() + "\n";
                encontradoStand = true;
            }
            w = w.getSig();
        }

        if (!encontradoStand) {
            info += "El personal NO está asignado a ningún stand.";
        }

        JOptionPane.showMessageDialog(null, info);
    }
    

    
    
    
    public void mostrarTodosLosInstrumentos() {
    List<InstrumentosDoc> lista = daoPIDOC.cargarInst();

    if (lista.isEmpty()) {
        JOptionPane.showMessageDialog(this, "No existen instrumentos registrados.");
        return;
    }

    PilaInsD pila = new PilaInsD();
    for (InstrumentosDoc inst : lista) {
        pila.adicionar(inst);
    }

    StringBuilder sb = new StringBuilder();
    sb.append("INSTRUMENTOS REGISTRADOS:\n\n");

    while (!pila.esVacia()) {
        InstrumentosDoc x = pila.eliminar();
        sb.append("ID: ").append(x.getId_instrumento())
          .append(" | Grupo: ").append(x.getGrupo_instrumentos())
          .append(" | Puesto: ").append(x.getNropuesto())
          .append(" | Nombre: ").append(x.getNombre())
          .append(" | Tipo: ").append(x.getTipo())
          .append(" | Obs: ").append(x.getObservacion())
          .append("\n");
    }

    JOptionPane.showMessageDialog(this, sb.toString());
}

    
}
