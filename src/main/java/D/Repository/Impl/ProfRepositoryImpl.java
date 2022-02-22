package D.Repository.Impl;

import D.Entities.Prof;
import D.Repository.ProfRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProfRepositoryImpl implements ProfRepository {
    private List<Prof> profs;

    public ProfRepositoryImpl() {
        profs=new ArrayList<>();
    }

    @Override
    public Long create(Prof prof) {
        try {
            prof.setId(profs.size()+1L);
            profs.add(prof);
        }catch (NullPointerException e){

        }
        return prof.getId();

    }

    @Override
    public Prof findById(Long id) {
        return profs.stream().filter(x-> Objects.equals(x.getId(), id)).collect(Collectors.toList()).get(0);

    }

    @Override
    public List<Prof> findAll() {
        return profs;
    }

    @Override
    public void Update(Prof prof) {
        profs
                .stream()
                .filter(student1 -> Objects.equals(student1.getUsername(), prof.getUsername())).forEach(x->x=prof);

    }

    @Override
    public void Delete(Long id) {
        profs.remove(id);
        profs
                .stream()
                .filter(student1 -> Objects.equals(student1.getId(),id) && student1.getId()>id).forEach(x->x.setId(x.getId()-1));
    }
}
