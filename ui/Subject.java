
import database.SubjectDatabase;
import database.SemesterDatabase;
import database.CourseDatabase;
import java.util.Vector;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author S Wadhwani
 */
public class Subject extends javax.swing.JPanel {

    /**
     * Creates new form Subject
     */
    CourseDatabase courseDatabase;
    SemesterDatabase semesterDatabase;
    SubjectDatabase subjectDatabase;
    DashboardPanel dashboardPanel=null;
    public SubjectDatabase getSubjectDatabase(){
        return subjectDatabase;
    }
    public Subject(CourseDatabase cdb,SemesterDatabase sdb) {
        initComponents();
        new AlphaJTextfield(txtSubjectName, lblCheck);
        courseDatabase=cdb;
        semesterDatabase=sdb;
        subjectDatabase=new SubjectDatabase();
        addCourseInJCBCourse();
        addSemInJCBSem();
        CustomJTable.insertInJtable(jtbSubject,"subject");
        
    }
    public void addCourseInJCBCourse(){
        jcbCourseName.removeAllItems();
        String courses[]=courseDatabase.getAllCourses();
        for (String course : courses) {
            jcbCourseName.addItem(course);
        }
    }
    public void addSemInJCBSem(){
        jcbSem.removeAllItems();
        int years[]=semesterDatabase.getSems();
        for(int i=0;i<years.length;i++){
            jcbSem.addItem(years[i]+"");
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

        mainPanel = new javax.swing.JPanel();
        txtSubjectName = new javax.swing.JTextField();
        jcheckboxTheory = new javax.swing.JCheckBox();
        jcheckboxPractical = new javax.swing.JCheckBox();
        lblSubjectName = new javax.swing.JLabel();
        lblCourseName = new javax.swing.JLabel();
        jcbCourseName = new javax.swing.JComboBox<>();
        btnAdd = new javax.swing.JButton();
        jcbSem = new javax.swing.JComboBox<>();
        lblSem = new javax.swing.JLabel();
        lblCheck = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbSubject = new javax.swing.JTable();

        setBackground(new java.awt.Color(26, 27, 65));

        mainPanel.setBackground(new java.awt.Color(26, 27, 65));
        mainPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(247, 212, 136)));
        mainPanel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        txtSubjectName.setBackground(new java.awt.Color(26, 27, 65));
        txtSubjectName.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        txtSubjectName.setForeground(new java.awt.Color(247, 212, 136));
        txtSubjectName.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(247, 212, 136)));
        txtSubjectName.setCaretColor(new java.awt.Color(255, 255, 255));

        jcheckboxTheory.setBackground(new java.awt.Color(26, 27, 65));
        jcheckboxTheory.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        jcheckboxTheory.setForeground(new java.awt.Color(247, 212, 136));
        jcheckboxTheory.setText("Theory");

        jcheckboxPractical.setBackground(new java.awt.Color(26, 27, 65));
        jcheckboxPractical.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        jcheckboxPractical.setForeground(new java.awt.Color(247, 212, 136));
        jcheckboxPractical.setText("Practical");

        lblSubjectName.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        lblSubjectName.setForeground(new java.awt.Color(247, 212, 136));
        lblSubjectName.setText("Subject Name");

        lblCourseName.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lblCourseName.setForeground(new java.awt.Color(247, 212, 136));
        lblCourseName.setText("Course Name");

        jcbCourseName.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        jcbCourseName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jcbCourseName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbCourseNameActionPerformed(evt);
            }
        });

        btnAdd.setBackground(new java.awt.Color(0, 0, 0));
        btnAdd.setFont(new java.awt.Font("Malgun Gothic Semilight", 1, 14)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(26, 27, 65));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/yellow.png"))); // NOI18N
        btnAdd.setBorder(null);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setLabel("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jcbSem.setBackground(new java.awt.Color(0, 0, 204));
        jcbSem.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        jcbSem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblSem.setFont(new java.awt.Font("Malgun Gothic", 1, 14)); // NOI18N
        lblSem.setForeground(new java.awt.Color(247, 212, 136));
        lblSem.setText("Semester");

        lblCheck.setBackground(new java.awt.Color(26, 27, 65));
        lblCheck.setForeground(new java.awt.Color(26, 27, 65));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(jcheckboxTheory)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jcheckboxPractical))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblCourseName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSubjectName, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                            .addComponent(lblSem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(39, 39, 39)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbSem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtSubjectName)
                                .addComponent(jcbCourseName, 0, 134, Short.MAX_VALUE)))))
                .addGap(31, 31, 31))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSubjectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCourseName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSem)
                    .addComponent(jcbSem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jcheckboxPractical)
                    .addComponent(jcheckboxTheory))
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblCheck, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jtbSubject.setBackground(new java.awt.Color(26, 27, 65));
        jtbSubject.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jtbSubject.setForeground(new java.awt.Color(247, 212, 136));
        jtbSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtbSubject.setEnabled(false);
        jtbSubject.setGridColor(new java.awt.Color(247, 212, 136));
        jtbSubject.setRowHeight(22);
        jScrollPane1.setViewportView(jtbSubject);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbCourseNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbCourseNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jcbCourseNameActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        if(lblCheck.getText().equals("n") || txtSubjectName.getText().equals(""))
            JOptionPane.showMessageDialog(null, "Please insert proper subject name","Subject",JOptionPane.WARNING_MESSAGE);
        else if(lblCheck.getText().equals("y")){

            Vector<String> subjects=new Vector();
            if(jcheckboxPractical.isSelected() && jcheckboxTheory.isSelected()){

                subjects.add(txtSubjectName.getText());
                subjects.add(txtSubjectName.getText()+"_PR");
            }else if(jcheckboxPractical.isSelected())
                subjects.add(txtSubjectName.getText()+"_PR");
            else if(jcheckboxTheory.isSelected())
                subjects.add(txtSubjectName.getText());

            else
                JOptionPane.showMessageDialog(null, "Please select theory or practical","Subject",JOptionPane.ERROR_MESSAGE);
            
            for(int i=0;i<subjects.size();i++){
            String pk=subjects.elementAt(i)+(String)jcbCourseName.getSelectedItem()+(String)jcbSem.getSelectedItem();
                if(subjectDatabase.insert(pk,subjects.elementAt(i), (String)jcbCourseName.getSelectedItem(),Integer.parseInt((String)jcbSem.getSelectedItem())))
                {
                    JOptionPane.showMessageDialog(null, "Record inserted", "Subject",JOptionPane.INFORMATION_MESSAGE);
                    dashboardPanel=DashBoardMain.getDashboardPanel();
                    dashboardPanel.addSubjectInJCBSubject();
                    dashboardPanel.p.addSubjectInListSubject();
                    CustomJTable.insertInJtable(jtbSubject,"subject");
                }
                else
                    JOptionPane.showMessageDialog(null, "Cannot insert record", "Subject",JOptionPane.ERROR_MESSAGE);
            }
        }
            
        
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbCourseName;
    private javax.swing.JComboBox<String> jcbSem;
    private javax.swing.JCheckBox jcheckboxPractical;
    private javax.swing.JCheckBox jcheckboxTheory;
    private javax.swing.JTable jtbSubject;
    private javax.swing.JLabel lblCheck;
    private javax.swing.JLabel lblCourseName;
    private javax.swing.JLabel lblSem;
    private javax.swing.JLabel lblSubjectName;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField txtSubjectName;
    // End of variables declaration//GEN-END:variables
}