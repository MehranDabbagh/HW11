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

            profs.add(prof);
        }catch (NullPointerException e){

        }

    }

    @Override
    public Prof findByUsername(String username) {
        return profs.stream().filter(x-> Objects.equals(x.getUsername(), username)).collect(Collectors.toList()).get(0);

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
    public void Delete(Prof prof) {
profs.remove(prof);
    }
}
