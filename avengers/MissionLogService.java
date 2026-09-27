package avengers;

import java.util.ArrayList;

public class MissionLogService {
    private final MissionLogRepository repo;

    public MissionLogService(MissionLogRepository repo) {
        this.repo = repo;
    }
    public MissionLog record(String title,String heroName,String strategyLabel,int damage,int teamScore){
        if(title==null ||title.equals("") || heroName==null ||heroName.equals("")){
            throw new IllegalArgumentException("미션과 히어로 이름이 필요합니다.");
        }else {
            MissionLog log=new MissionLog(repo.nextId(),title,heroName,strategyLabel,damage,teamScore);
            repo.save(log);
            return log;
        }
    }
    public MissionLog findById(int id){
        return repo.findById(id);
    }
    public ArrayList<MissionLog> findAll(){
        return repo.findAll();
    }
}
