/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package postgres;

/**
 * Esta clase me permite poder establecer las Querys para el delete de elementos en la DB
 * @author luis
 */
public class Delete {

    /**
     * Delete de un inventario en la DB
     */
    public static final String deleteInventario = "DELETE FROM ControlSucursal.Inventario WHERE id_inventario = ?;";

    /**
     * Delete de un electrodomestico en la DB
     */
    public static final String deleteElectrodomestico = "DELETE FROM ControlSucursal.Electrodomestico WHERE id_electrodomestico = ?;";
}
