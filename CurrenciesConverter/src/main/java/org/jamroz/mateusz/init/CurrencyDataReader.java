package org.jamroz.mateusz.init;

import org.jamroz.mateusz.currency.ICurrency;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;

public class CurrencyDataReader implements DataReader<Set<ICurrency>, File> {

    @Override
    public Set<ICurrency> readFrom(File source) {

        Document doc = readDocument(source);

        return ;
    }

    private Document readDocument(final File source) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(source);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
