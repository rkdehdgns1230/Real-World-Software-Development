package com.study.chapter4;

import com.study.chapter4.domain.Document;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static com.study.chapter4.Attributes.*;
import static org.junit.jupiter.api.Assertions.*;

class DocumentManagementSystemTest {
    private static final String RESOURCES =
            "src" + File.separator + "test" + File.separator + "resources" + File.separator;
    private static final String LETTER = RESOURCES + "patient.letter";
    private static final String REPORT = RESOURCES + "patient.report";
    private static final String XRAY = RESOURCES + "xray.jpg";
    private static final String INVOICE = RESOURCES + "patient.invoice";
    private static final String JOE_BLOGGS = "Joe Bloggs";

    private final DocumentManagementSystem documentManagementSystem = new DocumentManagementSystem();

    @Test
    public void 파일_임포트_성공() throws Exception {
        //given
        //when
        documentManagementSystem.importFile(LETTER);
        Document document = onlyDocument();

        //then
        assertAttributeEquals(document, Attributes.PATH, LETTER);
    }

    @Test
    public void letter_type_파일_임포트_성공() throws Exception
    {
        //given
        //when
        documentManagementSystem.importFile(LETTER);
        Document document = onlyDocument();

        //then
        assertAttributeEquals(document, PATIENT, JOE_BLOGGS);
        assertAttributeEquals(document, ADDRESS,
                "123 Fake Street\n" +
                        "Westminster\n" +
                        "London\n" +
                        "United Kingdom");
        assertAttributeEquals(document, BODY,
                "We are writing to you to confirm the re-scheduling of your appointment\n" +
                        "with Dr. Avaj from 29th December 2016 to 5th January 2017.");
        assertTypeIs("LETTER", document);
    }

    private void assertTypeIs(String typeName, Document document){
        assertEquals(document.getAttribute(TYPE), typeName);
    }

    private void assertAttributeEquals(
            Document document,
            String attributeName,
            String expectedValue
    ){
        assertEquals(expectedValue, document.getAttribute(attributeName),
                "Document has the wrong value for = " + attributeName);
    }

    private Document onlyDocument(){
        List<Document> documents = documentManagementSystem.contents();
        Assertions.assertEquals(documents.size(), 1);
        return documents.get(0);
    }
}