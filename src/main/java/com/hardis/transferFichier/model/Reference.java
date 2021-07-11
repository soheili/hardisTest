package com.hardis.transferFichier.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.hardis.transferFichier.exceptions.AllExceptions;



import java.util.Arrays;

@JacksonXmlRootElement(localName = "reference")
public class Reference {
    @JacksonXmlProperty(isAttribute = true)
    private String numReference;
    @JacksonXmlProperty(isAttribute = true)
    private int size;
    @JacksonXmlProperty(isAttribute = true)
    private double price;
    @JacksonXmlProperty(localName = "color", isAttribute = true)
    private ColorRGB color;

    public Reference (String line){
        String[] reference = line.split(";");
        gestionErrors(reference);
        this.numReference = reference[0];
        this. color = ColorRGB.valueOf(reference[1]);
        this.price = Double.parseDouble(reference[2]);
        this.size = Integer.parseInt(reference[3]);


    }

    private  void gestionErrors(String[] reference) {
        String colors = Arrays.asList(ColorRGB.values()).toString();
        if (reference.length!=4) {
            throw new AllExceptions("Incorrect number of arguments");
        }
        if (!colors.contains(reference[1])) {
            throw new AllExceptions("Incorrect value for color");
        }
        if (reference[0].length() != 10) {
            throw new AllExceptions("Incorrect value for numReference");
        }
    }

    public String getNumReference() {
        return numReference;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public ColorRGB getColor() {
        return color;
    }

}
