package family;

import java.util.ArrayList;

public class SongpyeonService {
    private final SongpyeonRepository repo;

    public SongpyeonService(SongpyeonRepository repo) {
        this.repo = repo;
    }
    public Songpyeon register(String name,String makerName,int styleChoice){
        if(name==null || name.equals("") || makerName==null ||makerName.equals("")){
            throw new IllegalArgumentException("송편 이름과 빚은 사람 이름이 필요합니다.");
        }
        SongpyeonPolicy policy;
        if(styleChoice==1)
            policy=new PrettyStylePolicy();
        else if(styleChoice==2)
            policy=new QuickStylePolicy();
        else throw new IllegalArgumentException("스타일은 1 또는 2입니다.");
        Songpyeon s=new Songpyeon(repo.nextId(),name,makerName,policy.label(),policy.pieceCount(), policy.shapeScore());
        repo.save(s);
        return s;
    }
    public Songpyeon findById(int id){
        return repo.findById(id);
    }
    public ArrayList<Songpyeon> findAll(){
        return repo.findAll();
    }
}
