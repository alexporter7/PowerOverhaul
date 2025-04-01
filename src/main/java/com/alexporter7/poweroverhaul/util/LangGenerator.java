package com.alexporter7.poweroverhaul.util;

public class LangGenerator {

    public enum Language {
        ENGLISH("en_US.lang");

        private final String fileName;

        Language(String fileName) {
            this.fileName = fileName;
        }

        public String getFileName() {
            return fileName;
        }
    }

    public LangGenerator(Language language) {

    }
}
