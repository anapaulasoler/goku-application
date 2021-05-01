package br.com.solertech.goku.application.enums;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.Map;

public enum State {

    AC("Acre"),
    AL("Alagoas"),
    AP("Amapá"),
    AM("Amazonas"),
    BA("Bahia"),
    CE("Ceará"),
    DF("Distrito Federal"),
    ES("Espírito Santo"),
    GO("Goiás"),
    MA("Maranhão"),
    MT("Mato Grosso"),
    MS("Mato Grosso do Sul"),
    MG("Minas Gerais"),
    PA("Pará"),
    PB("Paraíba"),
    PR("Paraná"),
    PE("Pernambuco"),
    PI("Piauí"),
    RJ("Rio de Janeiro"),
    RN("Rio Grande do Norte"),
    RS("Rio Grande do Sul"),
    RO("Rondônia"),
    RR("Roraima"),
    SC("Santa Catarina"),
    SP("São Paulo"),
    SE("Sergipe"),
    TO("Tocantins");

    private String description;

    private State(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Map<String, State> typeMapping = Maps.newHashMap();
    static {
        Arrays.asList(State.values()).forEach(enumItem -> {
            typeMapping.put(enumItem.toString(), enumItem);
        });
    }

    public static State getEnum(String enumItem) {
        if (StringUtils.isBlank(enumItem) || typeMapping.get(enumItem.toUpperCase()) == null) {
            throw new RuntimeException(String.format("There is no State with name (%s)", enumItem));
        }
        return typeMapping.get(enumItem.toUpperCase());
    }
}