package com.study.chapter4;

import com.study.chapter4.domain.Document;
import com.study.chapter4.exception.UnknownFileTypeException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class DocumentManagementSystem {
    private final List<Document> documents = new ArrayList<>();
    private final List<Document> documentsView = Collections.unmodifiableList(documents);
    // tag::importer_lookup[]
    private final Map<String, Importer> extensionToImporter = new HashMap<>();

    public DocumentManagementSystem() {
        extensionToImporter.put("letter", new LetterImporter());
        extensionToImporter.put("report", new ReportImporter());
        extensionToImporter.put("jpg", new ImageImporter());
        extensionToImporter.put("invoice", new InvoiceImporter());
    }

    public void importFile(String path) throws IOException {
        final File file = new File(path);
        if(!file.exists()){
            throw new FileNotFoundException(path);
        }

        final int separatorIdx = path.lastIndexOf('.');

        if(separatorIdx == -1)
            throw new UnknownFileTypeException("No extension found for file: " + path);

        if(separatorIdx == path.length() - 1){
            throw new UnknownFileTypeException("No extension found for file: " + path);
        }

        final String extension = path.substring(separatorIdx + 1);
        final Importer importer = extensionToImporter.get(extension);

        if(importer == null){
            throw new UnknownFileTypeException("For file: " + path);
        }

        final Document document = importer.importFile(file);
        documents.add(document);
    }
    public List<Document> contents(){
        return documents;
    }

    public List<Document> search(final String query){
        return documents.stream()
                .filter(Query.parse(query))
                .collect(Collectors.toList());
    }
}
