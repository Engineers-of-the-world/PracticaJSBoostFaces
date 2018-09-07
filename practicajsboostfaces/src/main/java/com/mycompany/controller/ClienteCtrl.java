/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controller;

import com.mycompany.controllerimpl.ClienteCtrlImpl;
import com.mycompany.modell.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import com.mycompany.dao.ClienteDAO;

/**
 *
 * @author ANDY
 */
@ManagedBean(name = "clienteCtrl")
@SessionScoped
public class ClienteCtrl implements Serializable {

    private Cliente selected;
    private boolean est;
    ClienteDAO catdao;
    private ArrayList<Cliente> list = new ArrayList<>();

    public ClienteCtrl() {
        this.selected = new Cliente();
        this.catdao = new ClienteCtrlImpl();
    }

    public void createCliente() {        
        if (catdao.createCliente(selected)) {
            System.out.println("Insertado");
        } else {
            System.out.println("Error al momento de insertar");
        }
    }

    public ArrayList<Cliente> getList() {
        list = catdao.readCliente();
        return list;
    }

    public void deleteCliente(String id){
        
        if (catdao.deleteCliente(id)) {
            System.out.println("Eliminado"+id);
        } else {
            System.out.println("Error al momento de eliminar");
        }
    }
    public Cliente getSelected() {
        return selected;
    }

    public void setSelected(Cliente selected) {
        this.selected = selected;
    }

}
