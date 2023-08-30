package com.study.chapter4;

import com.study.chapter4.domain.Document;

import java.io.File;
import java.io.IOException;

public interface Importer {
    Document importFile(File file) throws IOException;
}