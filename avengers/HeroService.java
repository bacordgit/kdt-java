package avengers;

import java.util.ArrayList;

public class HeroService {
    private final HeroRepository repo;

    public HeroService(HeroRepository repo) {
        this.repo = repo;
    }
    public Hero register(String name){
        if(name==null ||name.isEmpty()){
            throw new HeroNotFoundException("이름이 비었습니다.");
        }else{
            Hero hero=new Hero(repo.nextId(),name);
            repo.save(hero);
            return hero;
        }
    }
    public Hero findById(int id){
        return repo.findById(id);
    }
    public ArrayList<Hero> findAll(){
        return repo.findAll();
    }
}
