package com.hardis.transferFichier.service;



import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;


import com.hardis.transferFichier.model.Reference;
import com.hardis.transferFichier.model.Report;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ReferenceService {

    public Report readFichier(String inputFile)throws IOException {
        List<String> data= Files.lines(Paths.get(inputFile)).collect(Collectors.toList());
        Report report = new Report(inputFile);
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            Reference reference = new Reference(line);
            report.addReference(reference);
        }
        return report;
    }

    /**
     * @param inputFile
     * @param outPutJSON
     * @param outPutXML
     * @throws IOException
     */
    public void outPutFiles(String inputFile, String outPutJSON, String outPutXML ) throws JsonGenerationException, JsonMappingException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File(outPutJSON), readFichier(inputFile));
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.writeValue(new File(outPutXML), readFichier(inputFile));
    }

    }



