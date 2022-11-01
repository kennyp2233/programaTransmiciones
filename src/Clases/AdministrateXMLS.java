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

/**
 *
 * @author kenny
 */
public class AdministrateXMLS {

    String[][] xmls;
    BigInteger secuencial;

    public AdministrateXMLS(String[][] xmls, BigInteger secuencial) {
        this.xmls = xmls;
        this.secuencial = secuencial;
    }

    public String crearArchivos(String path) throws IOException {
        BigInteger filename = secuencial;
        for (String[] xml : xmls) {
            for (String string : xml) {
                System.out.print(string + " ");
            }
            System.out.println(filename.toString());
            CodigoManifiesto cm = new CodigoManifiesto(xml[2], xml[0], xml[1], xml[3], xml[36]);
            System.out.println(cm.TraderAssignedReferenceID());

            String[] formattedXml = {
                cm.TraderAssignedReferenceID(),
                secFormat(xml[36]),
                secFormat(xml[37]),
                "23902040",
                xml[19],
                xml[20],
                "2022-10-28T07:00:00Z", //cambiar
                xml[18],
                xml[9],
                "0" + hwbFormat(xml[5]),
                xml[21],//10
                xml[22],
                xml[26],
                xml[27],
                xml[32],
                xml[35],
                xml[33],
                "ALA",
                hwbFormat(xml[31]),
                secFormat(xml[37])
            };
            System.out.println("asdasd");

            GenerarXML generatedXML = new GenerarXML(formattedXml, filename.toString() + "S.xml");

            File file = new File(path + filename);

            FileWriter fw = new FileWriter(file);

            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(generatedXML.retornarArchivoString());
            bw.close();
            filename = filename.add(new BigInteger("1"));
        }
        return filename.toString();
    }

    public String secFormat(String sec) {
        String r = "";
        while (sec.length() != 4) {
            r += "0" + sec;
        }
        return r;
    }

    public String hwbFormat(String hwb) {
        String r = hwb;

        r = r.replaceAll("\\s+", "");
        r = r.replaceAll("-", "");
        return r;
    }
}
