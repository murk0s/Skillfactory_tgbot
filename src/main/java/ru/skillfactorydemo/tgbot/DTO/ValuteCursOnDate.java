package ru.skillfactorydemo.tgbot.DTO;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@XmlAccessorType(XmlAccessType.FIELD) //Указываем, как получить/указать значение поля
@XmlRootElement(name = "ValuteCursOnDate") //Корневой элемент
//@Data //Генерируем геттеры и сеттеры
public class ValuteCursOnDate {
    @XmlElement(name = "Vname") //Название XML тэга
    private String name;

    @XmlElement(name = "Vnom") //Название XML тэга
    private int nominal;

    @XmlElement(name = "Vcurs") //Название XML тэга
    private double course;

    @XmlElement(name = "Vcode") //Название XML тэга
    private String code;

    @XmlElement(name = "VchCode") //Название XML тэга
    private String chCode;

    public ValuteCursOnDate(String name, double course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getNominal() {
        return nominal;
    }

    public double getCourse() {
        return course;
    }

    public String getCode() {
        return code;
    }

    public String getChCode() {
        return chCode;
    }

    public ValuteCursOnDate setName(String name) {
        this.name = name;
        return this;
    }

    public ValuteCursOnDate setNominal(int nominal) {
        this.nominal = nominal;
        return this;
    }

    public ValuteCursOnDate setCourse(double course) {
        this.course = course;
        return this;
    }

    public ValuteCursOnDate setCode(String code) {
        this.code = code;
        return this;
    }

    public ValuteCursOnDate setChCode(String chCode) {
        this.chCode = chCode;
        return this;
    }
}
