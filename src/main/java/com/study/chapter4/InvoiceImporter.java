package com.study.chapter4;

import com.study.chapter4.domain.Document;
import com.study.chapter4.domain.TextFile;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class InvoiceImporter implements Importer{
    private static final String NAME_PREFIX = "Dear ";
    private static final String AMOUNT_PREFIX = "Amount: ";

    @Override
    public Document importFile(File file) throws IOException {
        final TextFile textFile = new TextFile(file);

        textFile.addLineSuffix(NAME_PREFIX, Attributes.PATIENT);
        textFile.addLineSuffix(AMOUNT_PREFIX, Attributes.AMOUNT);

        final Map<String, String> attributes = textFile.getAttributes();
        attributes.put(Attributes.TYPE, "INVOICE");

        return new Document(attributes);
    }
}
