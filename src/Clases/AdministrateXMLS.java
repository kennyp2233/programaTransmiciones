/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author kenny
 */
public class AdministrateXMLS {

    String[][] xmls;
    BigInteger secuencial;
    Map<String, String> datos;
    String fechaEmbarque, pais;

    public AdministrateXMLS(String[][] xmls, BigInteger secuencial, String fechaEmbarque, String pais) {
        this.xmls = xmls;
        this.secuencial = secuencial;
        this.fechaEmbarque = fechaEmbarque;
        this.pais = pais;
    }

    public String crearArchivos(String path) throws IOException {
        BigInteger filename = secuencial;
        for (String[] xml : xmls) {
            this.setData(xml);

            CodigoManifiesto cm = new CodigoManifiesto(
                    this.datos.get("Aerolinea"),
                    this.datos.get("Aduana"),
                    this.datos.get("Year"),
                    this.datos.get("Numero"),
                    this.datos.get("MSN")
            );

            (new Conexion()).insertarGuiaHija(
                    cm.TraderAssignedReferenceID(),
                    Integer.parseInt(this.datos.get("MSN"))
            );

//            String[] formattedXml = {
//                cm.TraderAssignedReferenceID(),
//                secFormat(xml[36]),
//                secFormat(xml[37]),
//                "23902040",
//                String.valueOf((int) Double.parseDouble(xml[19])),
//                String.valueOf((int) Double.parseDouble(xml[20])),
//                "2022-10-28T07:00:00Z", //cambiar
//                xml[18],
//                xml[9],
//                "0" + hwbFormat(xml[5]),
//                xml[21],//10
//                xml[22],
//                xml[26],
//                xml[27],
//                xml[32],
//                xml[35],
//                xml[33],
//                "ALA",
//                hwbFormat(xml[31]),
//                secFormat(xml[37])
//            };
            String[] formattedXml = {
                cm.TraderAssignedReferenceID(),
                secFormat(this.datos.get("MSN")),
                secFormat(this.datos.get("HSN")),
                "23902040",
                String.valueOf((int) Double.parseDouble(this.datos.get("PCS"))),
                String.valueOf((int) Double.parseDouble(this.datos.get("KGS"))),
                this.datos.get("FechaEmbarque"),
                this.datos.get("HAWB"),
                this.datos.get("DestinoAWB"),
                "0" + hwbFormat(this.datos.get("AWB")),
                this.datos.get("NombreC"),
                this.datos.get("DireccionC"),
                this.datos.get("NombreN"),
                this.datos.get("DireccionN"),
                this.datos.get("NombreE"),
                this.datos.get("NumDocum"),
                this.datos.get("DireccionE"),
                this.datos.get("Pais"),
                hwbFormat(this.datos.get("DAE")),
                secFormat(this.datos.get("HSN"))
            };

            GenerarXML generatedXML = new GenerarXML(formattedXml, filename.toString() + "S");

            File file = new File(path + "\\" + filename + "S.xml");
            System.out.println(file.getPath());
            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(generatedXML.retornarArchivoString());
            bw.close();
            filename = filename.add(new BigInteger("1"));
        }
        return filename.toString();
    }

    public String secFormat(String sec) {
        String r = sec;
        while (r.length() < 4) {
            r = "0" + r;
        }
        return r;
    }

    public String hwbFormat(String hwb) {
        String r = hwb;

        r = r.replaceAll("\\s+", "");
        r = r.replaceAll("-", "");
        return r;
    }

    private void setData(String[] xml) {

        datos = new HashMap<>();
        this.datos.put("Aduana", xml[0]);
        this.datos.put("Year", xml[1]);
        this.datos.put("Aerolinea", xml[2]);
        this.datos.put("Numero", xml[3]);
        this.datos.put("AWB", xml[5]);
        this.datos.put("DestinoAWB", xml[9]);
        this.datos.put("HAWB", xml[18]);
        this.datos.put("PCS", xml[19]);
        this.datos.put("KGS", xml[20]);
        this.datos.put("NombreC", xml[21]);
        this.datos.put("DireccionC", xml[22]);
        this.datos.put("NombreN", xml[26]);
        this.datos.put("DireccionN", xml[27]);
        this.datos.put("DAE", xml[31]);
        this.datos.put("NombreE", xml[32]);
        this.datos.put("DireccionE", xml[33]);
        this.datos.put("NumDocum", xml[35]);
        this.datos.put("MSN", xml[36]);
        this.datos.put("HSN", xml[37]);

        this.datos.put("FechaEmbarque", fechaEmbarque);
        this.datos.put("Pais", pais);
    }
}
