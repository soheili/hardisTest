package com.hardis.transferFichier.model;

import java.util.ArrayList;
import java.util.List;
public class Report {
    private String inputFile;
    private List<Reference> references;
    private List<AllErrors> errors;

    public Report(String inputFile) {
        this.inputFile = inputFile;
        this.references = new ArrayList<>();
        this.errors = new ArrayList<>();
    }

    public String getInputFile() {
        return inputFile;
    }

    public void setInputFile(String inputFile) {
        this.inputFile = inputFile;
    }

    public void addReference(Reference reference) {
        this.references.add(reference);
    }
    public List<Reference> getReferences() {
        return references;
    }
    public void addError(AllErrors error) {
        this.errors.add(error);
    }

    public List<AllErrors> getErrors() {
        return errors;
    }


}

