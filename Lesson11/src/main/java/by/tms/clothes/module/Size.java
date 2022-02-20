package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Size {
    XXS(32) {
        @Override
        public String toString() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int euroSize;


    public static String getDescription() {
        return "Взрослый размер";
    }
}


