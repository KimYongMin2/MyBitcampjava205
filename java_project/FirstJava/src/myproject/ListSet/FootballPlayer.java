package myproject.ListSet;

public class FootballPlayer implements Comparable<FootballPlayer>{
    private String name;
    private int number;
    private String team;
    private int age;

    public FootballPlayer(String name, int number, String team, int age) {
        this.name = name;
        this.number = number;
        this.team = team;
        this.age = age;
    }

    @Override
    public String toString() {
        return "FootballPlayer{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", team='" + team + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int hashCode() {
        return name.hashCode()+age+number;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if((obj instanceof FootballPlayer)&& obj != null){
            FootballPlayer temp = (FootballPlayer) obj;
            if(name.equals(temp.name)&&number == temp.number &&team.equals(temp.team)&&age == temp.age){
                result = true;
            }
        }
        return result;

    }

    @Override
    public int compareTo(FootballPlayer o) {
        int result = team.compareTo(o.team);
        if(result == 0){
            result = name.compareTo(o.name);
            if(result == 0){
                if (number > o.number){
                    result = 1;
                }else {
                    result = -1;
                }
            }

        }
        return result;
    }
}

