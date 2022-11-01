/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class GenerarXML {

    LinkedList<String> generateXML;
    Map<String, String> datosAgencia, datosDocumento;
    String fileName;
    String[] datos;

    public GenerarXML(String[] datos, String fileName) {
        this.generateXML = new LinkedList<>();
        datosAgencia = new HashMap<>();
        datosDocumento = new HashMap<>();
        this.fileName = fileName;
        this.datos = datos;
        setearDatosAgencia();
        setearDatosDocuento();
        llenarLista();
    }

    private void setearDatosDocuento() {

        datosAgencia.put("TypeCode", "034");
        datosAgencia.put("ID", fileName);
        datosAgencia.put("IssueDateTime", Instant.now().truncatedTo(ChronoUnit.SECONDS).minus(Duration.ofMinutes(4)).toString());
        datosAgencia.put("DeclarationOfficeID", "055");
        datosAgencia.put("AcceptanceDateTime", Instant.now().truncatedTo(ChronoUnit.SECONDS).minus(Duration.ofMinutes(4)).toString());
        datosAgencia.put("VersionID", "1.0");
        datosAgencia.put("CargaCorrectionTypeCode", "D");
        datosAgencia.put("DegreeNumberNumeric", "1");
        datosAgencia.put("DocumentTypeCode", "AE");
        datosAgencia.put("TraderAssignedReferenceID", datos[0]);
        datosAgencia.put("MasterLandingBillSequenceNumeric", datos[1]);
        datosAgencia.put("HouseLandingBillSequenceNumeric", datos[2]);
        datosAgencia.put("ID2", datos[3]);
        datosAgencia.put("ChangeReasonCode", "A");
        datosAgencia.put("ChangeReason", "ENVIO DESPUES DE 48 HORAS");
        datosAgencia.put("AssociatedGovernmentProcedureCode", "I");
        datosAgencia.put("BoardedQuantity", datos[4]);
        datosAgencia.put("TotalGrossMassMeasure", datos[5]);
        datosAgencia.put("LoadingDateTime", datos[6]);
        datosAgencia.put("ID3", datos[7]);
        datosAgencia.put("ID4", datos[8]);
        datosAgencia.put("ID5", "03905645");
        datosAgencia.put("ID6", datos[9]);
        datosAgencia.put("TypeCode1", "HWB");
        datosAgencia.put("ID7", "23902040");
        datosAgencia.put("Name", datos[10]);//
        datosAgencia.put("Line", datos[11]);
        datosAgencia.put("Name1", datos[12]);
        datosAgencia.put("Line1", datos[13]);
        datosAgencia.put("Name2", datos[14]);
        datosAgencia.put("PartyDocumentIdentificationType", "001");
        datosAgencia.put("PartyDocumentID", datos[15]);
        datosAgencia.put("CountryCode", "EC");
        datosAgencia.put("Line2", datos[16]);
        datosAgencia.put("ID8", datos[17]);
        datosAgencia.put("Instructions", "Ninguna");
        datosAgencia.put("ID9", datos[18]);
        datosAgencia.put("SequenceNumeric", datos[19]);
        datosAgencia.put("NetNetWeightMeasure", datos[5]);
        datosAgencia.put("QuantityQuantity", datos[4]);
        datosAgencia.put("TypeCode2", "035");
        datosAgencia.put("CargoDescription", "FRESH FLOWERS");
    }

    private void setearDatosAgencia() {
        datosAgencia.put("DclrCd", "23902040");
        datosAgencia.put("DclrRuc", "1792169704001");
        datosAgencia.put("DclrSeCd", "23");
        datosAgencia.put("DclrSeId", "23902040");
        datosAgencia.put("DocPrcsType", "O");
        datosAgencia.put("RcsdEdocAfrCd", "004");
        datosAgencia.put("RcsdEdocAfrId", "002");
        datosAgencia.put("RcsdEdocTypeCd", "034");
        datosAgencia.put("SmtNo", fileName);
        datosAgencia.put("UserId", "MPINCHAO");
    }

    private void llenarLista() {
        // INFO AGENCIA
        //1
        this.generateXML.add("<SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "<SOAP-ENV:Header>\n"
                + "<ns0:Header xmlns:ns0=\"http://soapinterop.org/xsd\">\n"
                + "<ns0:DclrCd>");
        this.generateXML.add(datosAgencia.get("DclrCd"));

        //2
        this.generateXML.add("</ns0:DclrCd>\n"
                + "<ns0:DclrRuc>");
        this.generateXML.add(datosAgencia.get("DclrRuc"));

        //3
        this.generateXML.add("</ns0:DclrRuc>\n"
                + "<ns0:DclrSeCd>");
        this.generateXML.add(datosAgencia.get("DclrSeCd"));

        //4
        this.generateXML.add("</ns0:DclrSeCd>\n"
                + "<ns0:DclrSeId>");
        this.generateXML.add(datosAgencia.get("DclrSeId"));

        //5
        this.generateXML.add("</ns0:DclrSeId>\n"
                + "<ns0:DocPrcsType>");
        this.generateXML.add(datosAgencia.get("DocPrcsType"));

        //6
        this.generateXML.add("</ns0:DocPrcsType>\n"
                + "<ns0:RcsdEdocAfrCd>");
        this.generateXML.add(datosAgencia.get("RcsdEdocAfrCd"));

        //7
        this.generateXML.add("</ns0:RcsdEdocAfrCd>\n"
                + "<ns0:RcsdEdocAfrId>");
        this.generateXML.add(datosAgencia.get("RcsdEdocAfrId"));

        //8
        this.generateXML.add("</ns0:RcsdEdocAfrId>\n"
                + "<ns0:RcsdEdocTypeCd>");
        this.generateXML.add(datosAgencia.get("RcsdEdocTypeCd"));

        //9
        this.generateXML.add("</ns0:RcsdEdocTypeCd>\n"
                + "<ns0:SmtNo>");
        this.generateXML.add(datosAgencia.get("SmtNo"));

        //10
        this.generateXML.add("</ns0:SmtNo>\n"
                + "<ns0:UserId>");
        this.generateXML.add(datosAgencia.get("UserId"));
        this.generateXML.add("</ns0:UserId>\n"
                + "</ns0:Header>\n"
                + "</SOAP-ENV:Header>\n"
                + "<SOAP-ENV:Body>\n"
                + "<tns:sendExportCargaCME xmlns:tns=\"http://webservice.ecg.ecuapass.aduana.gob.ec/\">\n"
                + "<arg0>\n"
                + "<DocumentMetadata xsi:schemaLocation=\"urn:wco:datamodel:EC:CME:1:0:0 EC_CME_0p1.02.xsd\" xmlns=\"urn:wco:datamodel:EC:CME:1:0:0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">\n"
                + "<WCODataModelVersion />\n"
                + "<WCODocumentName />\n"
                + "<CountryCode />\n"
                + "<AgencyName />\n"
                + "<AgencyAssignedCountrySubEntityID />\n"
                + "<AgencyAssignedCustomizedDocumentName />\n"
                + "<AgencyAssignedCustomizedDocumentVersion />\n"
                + "<Declaration>\n"
                + "<TypeCode>");
        //resto hasta llegar a TypeCode
        //1
        this.generateXML.add(datosDocumento.get("TypeCode"));

        //2
        this.generateXML.add("</TypeCode>\n"
                + "                        <ID>");
        this.generateXML.add(datosDocumento.get("ID"));
        //3
        this.generateXML.add("</ID>\n"
                + "<IssueDateTime>");
        this.generateXML.add(datosDocumento.get("IssueDateTime"));
        //4
        this.generateXML.add("</IssueDateTime>\n"
                + "<DeclarationOfficeID>");
        this.generateXML.add(datosDocumento.get("DeclarationOfficeID"));
        //5
        this.generateXML.add("</DeclarationOfficeID>\n"
                + "<AcceptanceDateTime>");
        this.generateXML.add(datosDocumento.get("AcceptanceDateTime"));
        //6
        this.generateXML.add("</AcceptanceDateTime>\n"
                + "<VersionID>");
        this.generateXML.add(datosDocumento.get("VersionID"));
        //7
        this.generateXML.add("</VersionID>\n"
                + "<CargaCorrectionTypeCode>");
        this.generateXML.add(datosDocumento.get("CargaCorrectionTypeCode"));
        //8
        this.generateXML.add("</CargaCorrectionTypeCode>\n"
                + "<DegreeNumberNumeric>");
        this.generateXML.add(datosDocumento.get("DegreeNumberNumeric"));
        //9
        this.generateXML.add("</DegreeNumberNumeric>\n"
                + "<DocumentTypeCode>");
        this.generateXML.add(datosDocumento.get("DocumentTypeCode"));
        //10
        this.generateXML.add("</DocumentTypeCode>\n"
                + "<UCR>\n"
                + "<TraderAssignedReferenceID>");
        this.generateXML.add(datosDocumento.get("TraderAssignedReferenceID"));
        //11
        this.generateXML.add("</TraderAssignedReferenceID>\n"
                + "<MasterLandingBillSequenceNumeric>");
        this.generateXML.add(datosDocumento.get("MasterLandingBillSequenceNumeric"));
        //12
        this.generateXML.add("</MasterLandingBillSequenceNumeric>\n"
                + "<HouseLandingBillSequenceNumeric>");
        this.generateXML.add(datosDocumento.get("HouseLandingBillSequenceNumeric"));
        //12
        this.generateXML.add("</HouseLandingBillSequenceNumeric>\n"
                + "</UCR>\n"
                + "<Agent>\n"
                + "<ID>");
        this.generateXML.add(datosDocumento.get("ID2"));
        //13
        this.generateXML.add("</ID>\n"
                + "                        </Agent>\n"
                + "                        <Amendment>\n"
                + "                            <ChangeReasonCode>");
        this.generateXML.add(datosDocumento.get("ChangeReasonCode"));
        //14
        this.generateXML.add("</ChangeReasonCode>\n"
                + "                            <ChangeReason>");
        this.generateXML.add(datosDocumento.get("ChangeReason"));
        //15
        this.generateXML.add("</ChangeReason>\n"
                + "                        </Amendment>\n"
                + "                        <BorderTransportMeans>\n"
                + "                            <TransportMeansOwner />\n"
                + "                            <TransportMeansOperator />\n"
                + "                        </BorderTransportMeans>\n"
                + "                        <UnloadingLocation />\n"
                + "                        <GovernmentProcedure />\n"
                + "                        <Consignment>\n"
                + "                            <AssociatedGovernmentProcedureCode>");
        this.generateXML.add(datosDocumento.get("AssociatedGovernmentProcedureCode"));
        //16
        this.generateXML.add("</AssociatedGovernmentProcedureCode>\n"
                + "                            <BoardedQuantity>");
        this.generateXML.add(datosDocumento.get("BoardedQuantity"));
        //17
        this.generateXML.add("</BoardedQuantity>\n"
                + "                            <TotalGrossMassMeasure>");
        this.generateXML.add(datosDocumento.get("TotalGrossMassMeasure"));
        //18
        this.generateXML.add("</TotalGrossMassMeasure>\n"
                + "                            <BorderTransportMeans />\n"
                + "                            <LoadingLocation>\n"
                + "                                <LoadingDateTime>");
        this.generateXML.add(datosDocumento.get("LoadingDateTime"));
        //19
        this.generateXML.add("</LoadingDateTime>\n"
                + "                            </LoadingLocation>\n"
                + "                            <AssociatedTransportDocument>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID3"));
        //20
        this.generateXML.add("</ID>\n"
                + "                            </AssociatedTransportDocument>\n"
                + "                            <UnloadingLocation>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID4"));
        //21
        this.generateXML.add("</ID>\n"
                + "                            </UnloadingLocation>\n"
                + "                            <Carrier>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID5"));
        //22
        this.generateXML.add("</ID>\n"
                + "                            </Carrier>\n"
                + "                            <IntermediateCarrier />\n"
                + "                            <TransportContractDocument>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID6"));

        //23
        this.generateXML.add("</ID>\n"
                + "                                <TypeCode>");
        this.generateXML.add(datosDocumento.get("TypeCode1"));
        //23
        this.generateXML.add("</TypeCode>\n"
                + "                                <Consolidator>\n"
                + "                                    <ID>");
        this.generateXML.add(datosDocumento.get("ID7"));
        //24
        this.generateXML.add("</ID>\n"
                + "                                </Consolidator>\n"
                + "                            </TransportContractDocument>\n"
                + "                            <Consignee>\n"
                + "                                <Name>");
        this.generateXML.add(datosDocumento.get("Name"));
        //25
        this.generateXML.add("</Name>\n"
                + "                                <Address>\n"
                + "                                    <Line>");
        this.generateXML.add(datosDocumento.get("Line"));

        //26
        this.generateXML.add("</Line>\n"
                + "                                </Address>\n"
                + "                            </Consignee>\n"
                + "                            <NotifyParty>\n"
                + "                                <Name>");
        this.generateXML.add(datosDocumento.get("Name1"));

        //27
        this.generateXML.add("</Name>\n"
                + "                                <Address>\n"
                + "                                    <Line>");
        this.generateXML.add(datosDocumento.get("Line1"));
        //28
        this.generateXML.add("</Line>\n"
                + "                                </Address>\n"
                + "                            </NotifyParty>\n"
                + "                            <Consignor>\n"
                + "                                <Name>");
        this.generateXML.add(datosDocumento.get("Name2"));
        //29
        this.generateXML.add("</Name>\n"
                + "                                <PartyDocumentIdentificationType>");
        this.generateXML.add(datosDocumento.get("PartyDocumentIdentificationType"));
        //30
        this.generateXML.add("</PartyDocumentIdentificationType>\n"
                + "                                <PartyDocumentID>");
        this.generateXML.add(datosDocumento.get("PartyDocumentID"));
        //31
        this.generateXML.add("</PartyDocumentID>\n"
                + "                                <Address>\n"
                + "                                    <CountryCode>");
        this.generateXML.add(datosDocumento.get("CountryCode"));
        //32
        this.generateXML.add("</CountryCode>\n"
                + "                                    <Line>");
        this.generateXML.add(datosDocumento.get("Line2"));
        //33
        this.generateXML.add("</Line>\n"
                + "                                </Address>\n"
                + "                            </Consignor>\n"
                + "                            <GoodsReceiptPlace>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID8"));
        //34
        this.generateXML.add("</ID>\n"
                + "                            </GoodsReceiptPlace>\n"
                + "                            <Handling>\n"
                + "                                <Instructions>");
        this.generateXML.add(datosDocumento.get("Instructions"));
        //35
        this.generateXML.add("</Instructions>\n"
                + "                            </Handling>\n"
                + "                            <PreviousDocument>\n"
                + "                                <ID>");
        this.generateXML.add(datosDocumento.get("ID9"));
        //36
        this.generateXML.add("</ID>\n"
                + "                                <TotalPackageQuantity>0</TotalPackageQuantity>\n"
                + "                                <TotalGrossMassMeasure>0</TotalGrossMassMeasure>\n"
                + "                                <TransportSplitIndicator>false</TransportSplitIndicator>\n"
                + "                                <SplitNumberNumeric>0</SplitNumberNumeric>\n"
                + "                            </PreviousDocument>\n"
                + "                            <ConsignmentItem>\n"
                + "                                <SequenceNumeric>");
        this.generateXML.add(datosDocumento.get("SequenceNumeric"));
        //37
        this.generateXML.add("</SequenceNumeric>\n"
                + "                                <GoodsStatusCode>CG</GoodsStatusCode>\n"
                + "                                <GoodsMeasure>\n"
                + "                                    <NetNetWeightMeasure>");
        this.generateXML.add(datosDocumento.get("NetNetWeightMeasure"));
        //38
        this.generateXML.add("</NetNetWeightMeasure>\n"
                + "                                </GoodsMeasure>\n"
                + "                                <Packaging>\n"
                + "                                    <QuantityQuantity>");
        this.generateXML.add(datosDocumento.get("QuantityQuantity"));
        //39
        this.generateXML.add("</QuantityQuantity>\n"
                + "                                    <TypeCode>");
        this.generateXML.add(datosDocumento.get("TypeCode2"));

        //40
        this.generateXML.add("</TypeCode>\n"
                + "                                </Packaging>\n"
                + "                                <Commodity>\n"
                + "                                    <CargoDescription>");
        this.generateXML.add(datosDocumento.get("CargoDescription"));
        //ebnd
        this.generateXML.add("</CargoDescription>\n"
                + "                                    <CommodityRelatedPackaging />\n"
                + "                                </Commodity>\n"
                + "                            </ConsignmentItem>\n"
                + "                        </Consignment>\n"
                + "                    </Declaration>\n"
                + "                </DocumentMetadata>\n"
                + "            </arg0>\n"
                + "        </tns:sendExportCargaCME>\n"
                + "    </SOAP-ENV:Body>\n"
                + "</SOAP-ENV:Envelope>");

    }

    public String retornarArchivoString() {
        String r = "";
        for (String string : this.generateXML) {
            r += string;
        }
        return r;
        // return String.join("", generateXML);
    }

}
