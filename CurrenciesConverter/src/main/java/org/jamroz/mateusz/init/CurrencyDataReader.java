package org.jamroz.mateusz.init;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.jamroz.mateusz.currency.ICurrency;
import org.jamroz.mateusz.init.deserializers.CustomDoubleDeserializer;

import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

public class CurrencyDataReader implements DataReader<Set<ICurrency>, String> {

    private final ObjectMapper xmlMapper;
    private final Function<XmlEntity, Set<ICurrency>> parser;
    private final DataReader<String, String> remoteDataReader;
    private final List<Consumer<Set<ICurrency>>> postProcessConsumerList;

    public CurrencyDataReader(Function<XmlEntity, Set<ICurrency>> parser, DataReader<String, String> remoteDataReader, List<Consumer<Set<ICurrency>>> postProcessConsumerList) {
        this.parser = parser;
        this.remoteDataReader = remoteDataReader;
        this.postProcessConsumerList = postProcessConsumerList;

        xmlMapper = new XmlMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addDeserializer(Double.class, new CustomDoubleDeserializer());
        xmlMapper.registerModule(simpleModule);
    }

    @Override
    public Set<ICurrency> readFrom(String URL) {
        final String stringXmlResult = remoteDataReader.readFrom(URL);
        try {
            XmlEntity value = xmlMapper.readValue(stringXmlResult, XmlEntity.class);
            var ret = parser.apply(value);
            postProcessConsumerList.forEach(consumer -> consumer.accept(ret));
            return ret;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
