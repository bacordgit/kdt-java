package avengers;

import java.util.ArrayList;

public class MissionService {
    private final MissionRepository repo;

    public MissionService(MissionRepository repo) {
        this.repo = repo;
    }
    public Mission register(String title){
        if(title==null ||title.isEmpty()){
            throw new IllegalArgumentException("미션 이름이 비었습니다.");
        }else{
            Mission mission=new Mission(repo.nextId(),title,"");
            repo.save(mission);
            return mission;
        }
    }
    public void assign(int id,String heroName){
        if(heroName==null|| heroName.isEmpty()){
            throw new IllegalArgumentException("배정할 히어로 이름이 없슴니다.");
        }else{
            Mission mission=repo.findById(id);
            repo.replace(id,new Mission(mission.getId(),mission.getTitle(),heroName));
        }
    }
    public Mission findById(int id){
        return repo.findById(id);
    }
    public ArrayList<Mission> findAll(){
        return repo.findAll();
    }
}
