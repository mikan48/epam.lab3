package concert;

import java.util.ArrayList;

public class Concert {
    private String identity;
    private String danceType;
    private String scene;
    private Integer numberOfDancers;
    private Integer numberInLine;
    private Boolean isLiveMusic;
    private ArrayList<Dancer> dancers = new ArrayList<Dancer>();
    private Collective collectives;

    public String getIdentity() {
        return identity;
    }

    public void setIdentity(String identity) {
        this.identity = identity;
    }

    public String getDanceType() {
        return danceType;
    }

    public void setDanceType(String danceType) {
        this.danceType = danceType;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Integer getNumberOfDancers() {
        return numberOfDancers;
    }

    public void setNumberOfDancers(Integer numberOfDancers) {
        this.numberOfDancers = numberOfDancers;
    }

    public Integer getNumberInLine() {
        return numberInLine;
    }

    public void setNumberInLine(Integer numberInLine) {
        this.numberInLine = numberInLine;
    }

    public boolean getLiveMusic() {
        return isLiveMusic;
    }

    public void setLiveMusic(Boolean isLiveMusic) {
        this.isLiveMusic = isLiveMusic;
    }

    public ArrayList<Dancer> getDancers() {
        return dancers;
    }

    public void setDancers(ArrayList<Dancer> dancers) {
        this.dancers = dancers;
    }

    public Collective getCollectives() {
        return collectives;
    }

    public void setCollectives(Collective collectives) {
        this.collectives = collectives;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ID: ").append(getIdentity()).append('\n');
        builder.append("Направление танца: ").append(getDanceType()).append('\n');
        builder.append("Место выступления: ").append(getScene()).append('\n');
        builder.append("Количество танцоров: ").append(getNumberOfDancers()).append('\n');
        builder.append("Живая музыка: ").append(getLiveMusic()).append('\n');
        builder.append("Танцоры\n");
        builder.append("Название коллектива: ").append(collectives.getTitle()).append('\n').
                append("дата образования коллектива: ").append(collectives.getYearOfFormation()).append('\n').
                append("Имя лидера коллектива: ").append(collectives.getLeaderName()).append('\n');
        for (Dancer dancer : getDancers()) {
            builder.append('\t').append(dancer.getName()).append("\n ").append(dancer.getAge()).append("лет\n").
                    append("Стаж работы ").append(dancer.getSeniority()).append("лет\n");
        }
        builder.append("Место в очереди: ").append(getNumberInLine()).append('\n');
        return builder.toString();
    }
}
