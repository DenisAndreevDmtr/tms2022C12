package by.tms.seasons.module;

public enum Seasons {
    WINTER(-5),
    SPRING(10),
    SUMMER(20) {
        @Override
        public String getDiscription() {
            return "Теплое время года";
        }
    },
    AUTUMN(7);

    private int averageTemperature;

    @Override
    public String toString() {
        return "Seasons{" +
                "averageTemperature=" + averageTemperature +
                '}';
    }

    Seasons(int averageTemperature) {
        this.averageTemperature = averageTemperature;
    }

    public String getDiscription() {
        return "Холодное время года";
    }
}
