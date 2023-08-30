package com.study.chapter4;

import com.study.chapter4.domain.Document;

import java.util.List;

public interface DocumentManagementSystem {

    void importFile(String path);
    List<Document> contents();
}
