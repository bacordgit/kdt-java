package Horse;

import java.util.ArrayList;

// 왜: 참가 등록은 이미 찾은 이름과 번호만 받는다. 말 저장소를 필드에 두지 않는다.
public class RaceService {
    private final RaceRepository repository;

    public RaceService(RaceRepository repository) {
        this.repository = repository;
    }

    public Race create(String title) {
        if (title.equals("")) {
            throw new IllegalArgumentException("경주 이름이 비어 있습니다.");
        }
        return repository.save(title);
    }

    public Race findById(int id) {
        return repository.findById(id);
    }

    public void enter(int raceId, String horseName, String jockeyName, int strategyChoice) {
        Race race = repository.findById(raceId);
        race.addEntry(horseName, jockeyName, strategyChoice);
    }

    public void clearRecords(int raceId) {
        repository.findById(raceId).clearRecords();
    }

    public void addRecord(int raceId, String line) {
        repository.findById(raceId).addRecord(line);
    }

    public ArrayList<String> recordsOf(int raceId) {
        return repository.findById(raceId).getRecords();
    }
}