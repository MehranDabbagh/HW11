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
    public void create(Prof prof) {
        try {
            prof.setId(profs.size()+1L);
            profs.add(prof);
        }catch (NullPointerException e){

        }

    }

    @Override
    public Prof findById(Integer id) {
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
                .filter(student1 -> Objects.equals(student1.getId(), prof.getId())).forEach(x->x=prof);

    }

    @Override
    public void Delete(Prof prof) {
profs.remove(prof);
    }
}
