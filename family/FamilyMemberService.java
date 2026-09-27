package family;

import java.util.ArrayList;

public class FamilyMemberService {
    private final FamilyMemberRepository repo;

    public FamilyMemberService(FamilyMemberRepository repo) {
        this.repo = repo;
    }
    public FamilyMember register(String name){
        if (name == null || name.equals(""))
            throw new IllegalArgumentException("가족 이름이 비어 있습니다.");
         else {
            FamilyMember mem = new FamilyMember(repo.nextId(), name);
            repo.save(mem);
            return mem;
        }
    }
    public FamilyMember findById(int id){
        return repo.findById(id);
    }
    public ArrayList<FamilyMember> findAll(){
        return repo.findAll();
    }
}
