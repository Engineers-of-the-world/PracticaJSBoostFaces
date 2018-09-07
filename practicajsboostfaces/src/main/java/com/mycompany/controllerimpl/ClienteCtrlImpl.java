/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.controllerimpl;

import com.mycompany.modell.Cliente;
import com.mycompany.configbd.Conexionbd;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mycompany.dao.ClienteDAO;

/**
 *
 * @author ANDY
 */
public class ClienteCtrlImpl implements ClienteDAO {

    Conexionbd cx;
    String sql;
    ResultSet rs;
    ArrayList<Cliente> listDatos;

    public ClienteCtrlImpl() {
        cx = new Conexionbd();
    }

    @Override
    public boolean createCliente(Cliente cat) {
        sql = "INSERT INTO public.cliente(id_cliente, nombres_razon_social, telefono, correo, dni_ruc) "
                + "VALUES("+cat.getId_cliente()+",'"+cat.getNombres_razon_social()+"','"+cat.getTelefono()+"','"+cat.getCorreo()+"','"+cat.getDni_ruc()+"')";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public ArrayList<Cliente> readCliente() {
        listDatos = new ArrayList<>();
        sql = "SELECT id_cliente, nombres_razon_social, telefono, correo, dni_ruc "
                + "    FROM public.cliente";
        rs = cx.executeQuery(sql);
        try {
            while (rs.next()) {
                listDatos.add(new Cliente(rs.getString("id_cliente"),rs.getString("nombres_razon_social"), rs.getString("telefono"), rs.getString("correo"), rs.getString("dni_ruc")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ClienteCtrlImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listDatos;
    }

    @Override
    public boolean updateCliente(Cliente cat) {
        sql = "UPDATE public.cliente SET "
                + " nombres_razon_social = '"+cat.getNombres_razon_social()+"', telefono = '"+cat.getTelefono()+"', correo = '"+cat.getCorreo()+"', dni_ruc = '"+cat.getDni_ruc()+"' "
                + "WHERE id_cliente = "+cat.getId_cliente()+" ";
        return cx.executeInsertUpdate(sql);
    }

    @Override
    public boolean deleteCliente(String id) {
        sql = "DELETE FROM public.cliente "
                + "WHERE id_cliente = "+id+" ";
        return cx.executeInsertUpdate(sql);
    }

}
