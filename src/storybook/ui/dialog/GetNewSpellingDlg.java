/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package storybook.ui.dialog;

import java.io.File;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

import storybook.SbConstants;
import storybook.SbConstants.SpellingToGet;
import storybook.toolkit.net.HttpFileDownloader;
import storybook.toolkit.swing.SwingUtil;

/**
 *
 * @author favdb
 */
public class GetNewSpellingDlg extends javax.swing.JDialog {
	private String resultSpelling="";
	private boolean ok=false;
	private String curLang;

	/**
	 * Creates new form GetNewSpellingDialog
	 */
	public GetNewSpellingDlg(java.awt.Frame parent, boolean modal) {
		super(parent, modal);
		initComponents();
	}

	GetNewSpellingDlg() {
		super(new javax.swing.JFrame(),true);
		initComponents();
		createSpellingToGet();
		txInput.setText("");
		txOutput.setText("");
		txSizeExpected.setText("");
		txSizeDownloaded.setText("");
		txResult.setText("");
	}

	/**
	 * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of
	 * this method is always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btDownload = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();
        cbSpelling = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        txInput = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txOutput = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txSizeExpected = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txSizeDownloaded = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txResult = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("storybook/msg/messages"); // NOI18N
        setTitle(bundle.getString("msg.spelling.title")); // NOI18N
        setName("newSpellingDlg"); // NOI18N

        btDownload.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/arrowdown.png"))); // NOI18N
        btDownload.setText(bundle.getString("msg.common.download")); // NOI18N
        btDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDownloadActionPerformed(evt);
            }
        });

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/storybook/resources/icons/16x16/cancel.png"))); // NOI18N
        btCancel.setText(bundle.getString("msg.common.cancel")); // NOI18N
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        cbSpelling.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbSpelling.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbSpellingItemStateChanged(evt);
            }
        });

        jLabel1.setText(bundle.getString("msg.spelling.input")); // NOI18N

        txInput.setEditable(false);
        txInput.setText("jTextField1");

        jLabel2.setText(bundle.getString("msg.spelling.output")); // NOI18N

        txOutput.setEditable(false);
        txOutput.setText("jTextField2");

        jLabel3.setText(bundle.getString("msg.spelling.size.expected")); // NOI18N

        txSizeExpected.setEditable(false);
        txSizeExpected.setText("jTextField3");

        jLabel4.setText(bundle.getString("msg.spelling.size.downloaded")); // NOI18N

        txSizeDownloaded.setEditable(false);
        txSizeDownloaded.setText("jTextField4");

        jLabel5.setText(bundle.getString("msg.spelling.result")); // NOI18N

        txResult.setText("jTextField5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txInput)
                    .addComponent(txOutput)
                    .addComponent(txSizeExpected)
                    .addComponent(txResult)
                    .addComponent(txSizeDownloaded)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbSpelling, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btDownload)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btCancel)))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btCancel, btDownload});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbSpelling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btDownload))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txOutput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSizeExpected, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txSizeDownloaded, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txResult, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btCancel)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        dispose();
    }//GEN-LAST:event_btCancelActionPerformed

    private void btDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDownloadActionPerformed
		if ("".equals(txInputSet())) return;
		txInput.setText(txInputSet());
		if (getFileList()==false) return;
		resultSpelling=(String)cbSpelling.getSelectedItem();
		ok=true;
		dispose();
    }//GEN-LAST:event_btDownloadActionPerformed

    private void cbSpellingItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbSpellingItemStateChanged
		//txInputSet();
    }//GEN-LAST:event_cbSpellingItemStateChanged

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
		} catch (ClassNotFoundException | InstantiationException 
				| IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(GetNewSpellingDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
        //</editor-fold>

		/* Create and display the dialog */
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				GetNewSpellingDlg dialog = new GetNewSpellingDlg(new javax.swing.JFrame(), true);
				dialog.addWindowListener(new java.awt.event.WindowAdapter() {
					@Override
					public void windowClosing(java.awt.event.WindowEvent e) {
						System.exit(0);
					}
				});
				dialog.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btDownload;
    private javax.swing.JComboBox cbSpelling;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField txInput;
    private javax.swing.JTextField txOutput;
    private javax.swing.JTextField txResult;
    private javax.swing.JTextField txSizeDownloaded;
    private javax.swing.JTextField txSizeExpected;
    // End of variables declaration//GEN-END:variables

	public String result() {
		return(resultSpelling);
	}

	private String txInputSet() {
		String ix = (String) cbSpelling.getSelectedItem();
		String f = "";
        if (ix==null) return("");
		for (SpellingToGet spelling : SpellingToGet.values()) {
			if (spelling.getI18N().equals(ix)) {
				String z=spelling.name();
				curLang=z.substring(0, z.indexOf("_"));
				f = ("languagetool/list/" + z.substring(0, z.indexOf("_"))+".lst");
				break;
			}
		}
		return(f);
	}
	
	private boolean getFileList() {
		System.out.println(curLang);
		String inFile=SbConstants.URL.WEB.toString()+"languagetool/list.lst";
		boolean dirOK=false;
		String currentDir="";
		HttpFileDownloader loader = new HttpFileDownloader(inFile);
        try {
            loader.setUserAgent("oStorybook HttpFileDownloader");
			txInput.setText(inFile);
            ArrayList<String> files=loader.asListString(txSizeExpected,txSizeDownloaded);
			if (files.isEmpty()) {
				txResult.setText("No list find");
				return(false);
			}
			for (String file : files) {
				if (file.isEmpty()) continue;
				if (file.indexOf(":")!=-1) {
					if (file.indexOf(curLang)!=-1) {
						dirOK=true;
						currentDir=file.substring(0,file.indexOf(":"));
					} else dirOK=false;
					
				}
				else if (dirOK==true) {
					inFile=SbConstants.URL.WEB.toString()+"languagetool/"+currentDir+"/"+file;
					File f = new File("languagetool" + File.separator + currentDir+File.separator+file);
					String f2=f.getAbsolutePath();
					File dir=new File(f2.substring(0,f2.lastIndexOf("/")));
					if (!dir.exists()) dir.mkdirs();
					String outFile=f.getAbsolutePath();
					if (getOneFile(inFile,outFile)==false) return(false);
				}
			}
            txResult.setText(loader.getResponseCode()+" - 200 signifie tout est nickel");
        } catch (IOException | KeyManagementException | NoSuchAlgorithmException ex) {
            txResult.setText("Download exception "+loader.getResponseCode());
			btDownload.setEnabled(false);
			return(false);
        }
		return(true);		
	}
	
	private boolean getOneFile(String inFile, String outFile) {
		txInput.setText(inFile);
		txOutput.setText(outFile);
		HttpFileDownloader loader = new HttpFileDownloader(inFile);
        try {
            loader.setUserAgent("oStorybook HttpFileDownloader");
            loader.savetoFile(outFile,txSizeExpected,txSizeDownloaded);
            txResult.setText(loader.getResponseCode()+" - 200 signifie tout est nickel");
        } catch (Exception ex) {
            txResult.setText("La requete a generée une exception "+loader.getResponseCode());
			btDownload.setEnabled(false);
			return(false);
        }
		return(true);
	}

	@SuppressWarnings("unchecked")
	private void createSpellingToGet() {
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		for (SpellingToGet spelling : SpellingToGet.values()) {
			if (!SwingUtil.isLanguageOK(spelling.name())) {
				model.addElement(spelling.getI18N());
			}
		}
		cbSpelling.setModel(model);
	}
}