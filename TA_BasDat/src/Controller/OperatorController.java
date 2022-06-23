
package Controller;

import Entity.*;
import java.util.ArrayList;

public class OperatorController {
    
    
    public void insertDataOperator(int id_operator, String nama_operator, String alamat_operator){
        ObjectModelController.operator.insertData(new OperatorEntity(id_operator,nama_operator,alamat_operator));
    }
    public int login(int id_operator, String nama){
       return ObjectModelController.operator.cekData(id_operator, nama);
    }
     public ArrayList <OperatorEntity>  showDataOperatorEntity(int id_operator){
        return ObjectModelController.operator.showOperator(id_operator);
    }
     public ArrayList <OperatorEntity> getOperatorEntity()
    {
        return ObjectModelController.operator.getOperatorEntity();
    }
     public void deleteOperator(int id_operator)
    {
        ObjectModelController.operator.deleteOperator(id_operator);
    }
     
     public void insertTransaksi(int id_pem, int id_op, int banyak, int harga, String id_film)
     {
         try{
             ObjectModelController.operator.saveTransaksi(id_pem, id_op, banyak, harga, id_film);
         }catch(Exception e){
             System.out.println(e);
         }
         
     }
}
