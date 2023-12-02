/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.imepac.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Matheus Carrasco
 */
public class Conversao {
    public Date StringToDate(String strData){
        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
        
        try{
            Date dtData = new Date(formatoData.parse(strData).getTime());
            return dtData;
        }catch(Exception erro){
            erro.printStackTrace();
            return null;
        }
    }
    
    public String dataConvertida(Date dtData){
        if(dtData != null){
            int intDia, intMes, intAno;
            String strData;
            Calendar calendario = Calendar.getInstance();
            
            calendario.setTime(dtData);
            intDia = calendario.get(Calendar.DAY_OF_MONTH);
            intMes = calendario.get(Calendar.MONTH) + 1;
            intAno = calendario.get(Calendar.YEAR);
            
            strData = intAno + "/" + intMes + "/" + intDia;
            return strData;    
        }else{
            return "null";
        }
    }
}
