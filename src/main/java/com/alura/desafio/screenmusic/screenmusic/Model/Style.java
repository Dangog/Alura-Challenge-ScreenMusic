package com.alura.desafio.screenmusic.screenmusic.Model;

public enum Style {
    SOLO("solo"),
    DUPLA("dupla"),
    BANDA("banda");

    private String style;

    Style(String style) {
        this.style = style;
    }
    public static Style fromPortugues(String text) {
        for (Style style : Style.values()) {
            if (style.style.equalsIgnoreCase(text)) {
                return style;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada para a string fornecida: " + text);
    }

}
