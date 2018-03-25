/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.sci.utils;


import br.sca.view.*;


/**
 *
 * @author Usuario
 */
public class PanelFactory {
    
    public static  javax.swing.JPanel getPanel(String titulo,javax.swing.JFrame parent) 
    {
        if (titulo.contentEquals("Cursos") ) 
           return new JFrmPesqCurso(parent);
        else
           if (titulo.contentEquals("Disciplinas") ) 
               return new JFrmPesqDisciplina(parent);
           else
               if (titulo.contentEquals("Alunos") ) 
                  return new JFrmPesqAluno(parent);
               else
                   if (titulo.contentEquals("Professores") ) 
                      return new JFrmPesqProfessor(parent);
                   else
                      if (titulo.contentEquals("Turmas") ) 
                         return new JFrmPesqTurma(parent);
                      else
                         if (titulo.contentEquals("Matrícula") ) 
                            return new JFrmPesqMatricula(parent);
                         else
                            return null;            
        
    };
};
