package dao;

import model.*;

import java.util.List;

public interface AdminDao {
    public List<User> getAllUsers();
    public List<Agent> getAllAgents();
    public List<House> getAllHouses();
    public List<Plot> getAllPlots();
    public List<District> getAllDistricts();
    public List<City> getAllCities();
}
