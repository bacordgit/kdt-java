package Horse;

import java.util.ArrayList;

public class Race {
    private final int id;
    private final String title;
    private final ArrayList<String> horseName;
    private final ArrayList<String> jockeyName;
    private final ArrayList<Integer>strategy;
    private final ArrayList<String> records;
    public Race(int id, String title) {
        this.id = id;
        this.title = title;
        this.horseName = new ArrayList<>();
        this.jockeyName = new ArrayList<>();
        this.strategy = new ArrayList<>();
        this.records =new ArrayList<>();
    }

    public void addEntry(String horseName, String jockeyName, int strategy){
        this.horseName.add(horseName);
        this.jockeyName.add(jockeyName);
        this.strategy.add(strategy);

    }
    public int entryCount(){
        return horseName.size();
    }
    public String horseNameAt(int index){
        return horseName.get(index);
    }
    public String jockeyNameAt(int index){
        return jockeyName.get(index);
    }
    public int strategyChoiceAt(int index){
        return strategy.get(index);
    }
    public void clearRecords(int index){
        horseName.remove(index);
        jockeyName.remove(index);
        strategy.remove(index);
    }

}
