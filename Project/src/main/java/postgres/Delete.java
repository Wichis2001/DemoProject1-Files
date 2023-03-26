/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 *
 * @author luis
 */
public class Delete {
    public static final String deleteInventario = "DELETE FROM ControlSucursal.Inventario WHERE id_inventario = ?;";
    public static final String deleteElectrodomestico = "DELETE FROM ControlSucursal.Electrodomestico WHERE id_electrodomestico = ?;";
}
