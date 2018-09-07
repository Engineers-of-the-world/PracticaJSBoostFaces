
import com.mycompany.modell.Cliente;
import com.mycompany.controllerimpl.ClienteCtrlImpl;
import com.mycompany.dao.ClienteDAO;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ANDY
 */
public class TestCliente {
    static ArrayList<Cliente> list = new ArrayList<>();
    
    public static void main(String[] args) {
        ClienteDAO catdao;
        catdao = new ClienteCtrlImpl();
        /*list = catdao.readCategoria();
        for(Categoria item: list){
            System.out.println(""+item.getName_cat());
        }*/
        Cliente cat = new Cliente();
        cat.setId_cliente("3");
        cat.setNombres_razon_social("ttttt");
        cat.setTelefono("947502677");
        cat.setCorreo("izi@hotmail.com");
        cat.setDni_ruc("987654321");
        if(catdao.createCliente(cat)){
            System.out.println("insertado");
        }else{
            System.out.println("error al momento de insertar");
        }
    }
    
}