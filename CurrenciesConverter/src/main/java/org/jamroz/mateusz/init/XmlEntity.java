package org.jamroz.mateusz.init;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XmlEntity {
    @JsonProperty("numer_tabeli")
    private String tableNumber;

    @JsonProperty("data_publikacji")
    private String publishDate;

    public XmlEntity() {
    }

    public XmlEntity(String tableNumber, String publishDate, List<Currency> currencyList) {
        this.tableNumber = tableNumber;
        this.publishDate = publishDate;
        this.currencyList = currencyList;
    }

    public String getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public List<Currency> getCurrencyList() {
        return currencyList;
    }

    public void setCurrencyList(List<Currency> currencyList) {
        this.currencyList = currencyList;
    }

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonProperty("pozycja")
    private List<Currency> currencyList = new ArrayList<>();

    public static class Currency {
        @JsonProperty("nazwa_waluty")
        private String name;
        @JsonProperty("kod_waluty")
        private String code;
        @JsonProperty("przelicznik")
        private Double rate;
        @JsonProperty("kurs_sredni")
        private Double factorRate;

        public Currency() {
        }

        public Currency(String name, String code, Double rate, Double factorRate) {
            this.name = name;
            this.code = code;
            this.rate = rate;
            this.factorRate = factorRate;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public Double getRate() {
            return rate;
        }

        public void setRate(Double rate) {
            this.rate = rate;
        }

        public Double getFactorRate() {
            return factorRate;
        }

        public void setFactorRate(Double factorRate) {
            this.factorRate = factorRate;
        }
    }
}
