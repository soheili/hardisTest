package com.hardis.transferFichier;

import com.hardis.transferFichier.service.ReferenceService;

import java.io.IOException;

public class AppMain {
    public static  final ReferenceService referenceService=new ReferenceService();
    public static void main(String args[]) throws IOException {
        String inputFile = "/Users/sohei/OneDrive/Bureau/textFile.txt";
        String outPutJSON = "/Users/sohei/OneDrive/Bureau/textJsonFile.txt";
        String outPutXML="/Users/sohei/OneDrive/Bureau/textXMLFile.txt";;

        referenceService.outPutFiles(inputFile,outPutJSON, outPutXML);

    }

}
