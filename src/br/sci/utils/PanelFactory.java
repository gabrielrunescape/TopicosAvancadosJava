/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.sci.utils;

import br.sci.view.*;

/**
 *
 * @author Usuario
 */
public class PanelFactory {
    
    public static  javax.swing.JPanel getPanel(String titulo,javax.swing.JFrame parent) {
        if (titulo.contentEquals("Veiculos") ) 
           return new JFrmPesqVeiculo(parent);
        else
           return null;    
    };
};
