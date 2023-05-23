/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

public class CodigoManifiesto {

    String aerolinea, dae;
    String aduana, year, numero, secuencialMadre, regimen;

    public CodigoManifiesto(String aerolinea, String aduana, String year, String numero, String secuencialMadre) {
        this.aerolinea = aerolinea;
        this.aduana = aduana;
        this.year = year;
        this.numero = numero;
        this.secuencialMadre = secuencialMadre;
    }

    public CodigoManifiesto(String dae) {
        this.dae = dae;
    }

    public String TraderAssignedReferenceID() {
        return "CEC" + year + aerolinea + numero;
    }

    public String DAE() {
        return String.join("", dae.split("-"));
    }

}
