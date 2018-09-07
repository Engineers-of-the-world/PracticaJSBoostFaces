/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao;

import com.mycompany.modell.Cliente;
import java.util.ArrayList;


/**
 *
 * @author ANDY
 */

public interface ClienteDAO {
    public boolean createCliente(Cliente cat);
    public ArrayList<Cliente> readCliente();
    public boolean updateCliente(Cliente cat);
    public boolean deleteCliente(String id);
    
}