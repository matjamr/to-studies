package org.jamroz.mateusz.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jamroz.mateusz.Main;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.init.deserializers.CustomDoubleDeserializer;

import java.io.File;
import java.util.Set;
import java.util.function.Function;

public class CurrencyDataReader implements DataReader<Set<ICurrency>, String> {

    private final ObjectMapper xmlMapper;
    private final Function<XmlEntity, Set<ICurrency>> parser;

    public CurrencyDataReader(Function<XmlEntity, Set<ICurrency>> parser) {
        this.parser = parser;

        xmlMapper = new XmlMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Double.class, new CustomDoubleDeserializer());
        xmlMapper.registerModule(simpleModule);
    }

    @Override
    public Set<ICurrency> readFrom(String fileName) {
        File file = new File(Main.class.getResource(fileName).getFile());
        try {
            XmlEntity value = xmlMapper.readValue(file, XmlEntity.class);
            return parser.apply(value);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
